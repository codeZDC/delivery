package com.tuzhi.delivery.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.service.IDeliveryService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;
import com.tuzhi.delivery.util.ShpUtil;
import com.tuzhi.delivery.util.Tz;

/**
 * 汇交相关处理
 * @author codeZ
 * @date 2018年3月28日 下午3:35:09
 * 
 */
@RestController
@RequestMapping("delivery")
public class DeliveryController extends BaseController {

	@Autowired
	private IDeliveryService deliveryService;

	@RequestMapping("getDeliveries") 
	public Tz getDeliveries(){
		//通过userID获取汇交项目,//status : 200+相关状态
		Map<String , Object> map =  deliveryService.getDeliveries(getUserId());
		return Tz.success(map.get("status").toString()).map(map);
	}
	
	/**
	 * 根据参数查询汇交项目
	 * @return
	 */
	@RequestMapping("getDeliveryByParam") 
	public Object getDeliveriesByParam(Integer type,Integer year) {
		return  deliveryService.getDeliveriesByParam(year, type);
	}

	///提交审核
	@RequestMapping("toExamine")
	public Tz toExamine(@RequestParam(value="ids[]")List<Integer> ids,
			@RequestParam(value="types[]")List<String> types,String remarks,Integer deliverListId){
		try {
			deliveryService.toExamine(ids,types,remarks,getUserId(),deliverListId,getUserQualification(),getDeliveryZone());
			return Tz.success("提交成功!");
		} catch (Exception e) {
			logger.error("提交审批出错!");
			logger.error(e.getMessage());
			return Tz.fail("提交失败!");
		}
	}

	//零汇交
	@RequestMapping("zeroDelivery")
	public Tz zeroDelivery() {
		try {
			deliveryService.zeroDelivery(getUserId());
			return Tz.success("提交成功!");
		} catch (Exception e) {
			logger.error("提交审批出错!");
			logger.error(e.getMessage());
			return Tz.fail("提交失败!");
		}
	}


	/**
	 * 保存图片
	 * @return
	 */
	@RequestMapping("saveImgs")
	@ResponseBody
	public Object saveImgs(@RequestParam("imgs")MultipartFile[] imgs,String type) {
		String imgsPath;
		try {
			imgsPath = saveUploadedImgs(imgs,type);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return Tz.fail("上传文件失败,请联系管理员");
		} 
		return Tz.success(imgsPath);
	}


	/**
	 * 保存上传的图片
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private String saveUploadedImgs(MultipartFile[] imgs,String type) throws IllegalStateException, IOException {
		String path = getProjectPath() + "uploaded" +  File.separator;
		String imgNames = "";
		if(imgs.length <= 0) {
			return "";
		}
		//保存上传的img
		for(MultipartFile img : imgs) {
			File imgType = new File(path + type);
			if(!imgType.exists()) {
				imgType.mkdir();
			}
			String imgExtends = img.getOriginalFilename();
			imgExtends = imgExtends.substring(imgExtends.lastIndexOf("."));//截取后缀名
			String imgName = DateUtils.getDateString() + new Random().nextInt(999) + imgExtends;
			imgNames +=imgName + ",";
			File imgUploaded = new File(path + type + File.separator +  imgName);
			if(!imgUploaded.exists()) {
				imgUploaded.mkdir();
				img.transferTo(imgUploaded);
			}
		}

		return imgNames.substring(0, (imgNames.length() - 1) );//返回拼接好的图片名

	}

	/**
	 * 解析shp文件  写到客户端
	 * @param file
	 */
	@RequestMapping("parseShp")
	public void parseShp(@RequestParam("file")MultipartFile file) {

		try {
			String json = readShp(file);
			writeJSON(json);
		} catch (Exception e) {
			if(e.getMessage().indexOf(".shx") > 0) {
				return;
			}
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private String readShp(MultipartFile file) {
		String path = getProjectPath();
		File f = new File(path +  "shp" +File.separator + DateUtils.getDateString() + new Random().nextInt(999) +"shpTemp.shp");//临时shp文件
		f.deleteOnExit();//删除文件
		f.mkdir();
		try {
			file.transferTo(f);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ShpUtil.readShpJson(f.getAbsolutePath());
	}

	//零汇交
	/*	@RequestMapping("zeroDelivery")
	public Tz zeroDeliver() {
		try {
			deliveryService.toExamine(ids,types,remarks,getUserId());
			return Tz.success("提交成功!");
		} catch (Exception e) {
			logger.error("提交审批出错!");
			logger.error(e.getMessage());
			return Tz.fail("提交失败!");
		}
	}*/

	//code汇交编码,type = 0 表示初始化,,需要模糊查询或left(..,4)
	@RequestMapping("getCompanies")
	public BootstrapTable getCompanies(Delivery delivery){
		System.out.println("status----" + delivery.getStatus());    
		System.out.println("deliveryStatus-----" + delivery.getDeliveryStatus());
		PageInfo<User> page =  deliveryService.getCompanies(delivery);
		return bootstrapTable(page);
	}


	//根据用户名id查找公司与其提交的项目
	@RequestMapping("getDeliveriesById")
	public Object getCompanyById(int userId) {
		Map<String , Object> map =  deliveryService.getDeliveries(userId);
		return Tz.success(map.get("status").toString()).map(map);
	}


}
