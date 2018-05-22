$(function(){
	//console.log(top.allZone);
	//初始化下拉框
	$(".province").each(function(){
		var province = $(this);//省级
		var selectCity = province.next();	//	市级
		var selectDistrict = selectCity.next();//县级
		province.empty();//清空所有内容
		//初始化省级菜单
		province.append('<option value="">请选择</option>"');
		for(var pro in top.allZone.province){
			province.append('<option value="'+ pro +'">' + top.allZone[pro]+'</option>"');
		}
		province.on('change',function(){
			//根据省code 初始化市级下拉菜单

			selectCity.empty();//清空市级下拉单
			selectDistrict.empty();//清空县级下拉单
			selectCity.append('<option value="">请选择</option>"');
			selectDistrict.append('<option value="">请选择</option>"');
			var cities = top.getCityByProvince(this.value);
			for(var city in cities){
				selectCity.append('<option value="'+ city.substr(2) +'">' + cities[city]+'</option>"');
			}
			
			//根据市code 初始化县级下拉菜单
			
			selectCity.on('change',function(){
				
				selectDistrict.empty();//清空所有内容
				
				var districts = top.getDistrictByCity(province.val() + selectCity.val());
				selectDistrict.append('<option value="">请选择</option>"');
				for(var district in districts){
					selectDistrict.append('<option value="'+ district.substr(4) +'">' + districts[district]+'</option>"');
				}
				
			});
		});
	});
	
	//添加修改汇交区域时  显示审核人的信息
	$("#deliverProvenceSelect,#provinceEditSelect").each(function(){
		var province = $(this);//省级
		var selectCity = province.next();	//	市级
		var selectDistrict = selectCity.next();//县级
		province.on('change' , function(){showExaminer(province.val())});
		selectCity.on('change' ,function(){showExaminer(province.val() + selectCity.val())});
		selectDistrict.on('change' , function(){showExaminer(province.val() + selectCity.val() + selectDistrict.val())});
	});

	
	
	
});

//显示审核人账号
function showExaminer(zoneCode){

	$.ajax({
		url:contextPath + 'user/getExaminerByzone?zoneCode=' + zoneCode,
		dataType :'json',
		asyn :false,
		success:function(res){
			if(res.length > 0){
				var examinierName  = "";
				var examinierUsername  = "";
				for(var i in res){
					examinierName += res[i].unitName + ' | ';
					examinierUsername += res[i].username + ','; 
				}
				$("#examinerAdd").attr('data-content','审核人:' + examinierName);
				$("#examinerEdit").attr('data-content','审核人:' + examinierName);
			}else{
				$("#examinerAdd").attr('data-content','暂无审核人').attr('data-original-title','');
				$("#examinerEdit").attr('data-content','暂无审核人').attr('data-original-title','');
			}
		}
	});
	
	$("#examinerAdd").attr('data-content','暂无审核人').attr('data-original-title','');
	$("#examinerEdit").attr('data-content','暂无审核人').attr('data-original-title','');
}

//提交的时候,把省市县信息写隐藏框中...
function setPCD(ele){
	$(ele).find('.administration,.delivery').each(function(index,per){
		var div = $(this);
		var province = div.find('.province').val();
		var city = div.find('.city').val();
		var district = div.find('.district').val();
		
		div.find(':input:hidden').val(province+''+city+district);
	});
}
//编辑的时候初始化省市县信息
function setProvinceCityDisrtict(admZone,deliveryZone){
	try{
		//行政
		var admLength = admZone.length ;
		var deliveryLength = deliveryZone.length ;
		
		if(admLength == 4){//市级
			//分割出省 和 市
			$('#user-edit-form .administration .province').val(52).trigger('change');
			$('#user-edit-form .administration .city').val(admZone.substr(2,2)).trigger('change');
		}else if(admLength == 6){//区县
			$('#user-edit-form .administration .province').val(52).trigger('change');
			$('#user-edit-form .administration .city').val(admZone.substr(2,2)).trigger('change');
			$('#user-edit-form .administration .district').val(admZone.substr(4,2)).trigger('change');
		}else{//省级
			$('#user-edit-form .administration .province').val(admZone).trigger('change');
		}
		if(deliveryLength == 4){//市级
			//分割出省 和 市
			$('#user-edit-form .delivery .province').val(52).trigger('change');
			$('#user-edit-form .delivery .city').val(deliveryZone.substr(2,2)).trigger('change');
		}else if(deliveryLength == 6){//区县
			$('#user-edit-form .delivery .province').val(52).trigger('change');
			$('#user-edit-form .delivery .city').val(deliveryZone.substr(2,2)).trigger('change');
			$('#user-edit-form .delivery .district').val(deliveryZone.substr(4,2)).trigger('change');
		}else{//省级
			$('#user-edit-form .delivery .province').val(deliveryZone).trigger('change');
		}
	}catch(e){
		console.log('没有填写省市县信息...');
	}
}