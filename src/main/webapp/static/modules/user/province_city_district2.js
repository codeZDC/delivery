/**
 * codeZ
 * 省市县相关js   汇交区域delivery 行政区域administration
 */
//省级下拉变更,更新市级(县级)
$('.province').change(function(){
	//清空市级城市信息
	var citySelect = $(this).next();
	citySelect.show().next().show().find('option:not(.no)').remove();//区县信息
	citySelect.find('option:not(.no)').remove();
	//省外单位和没有选择的情况下不需要请求后台
	if(this.value.length==1){//说明是省外,隐藏后面的选择框
		citySelect.hide().next().hide();
	}else if(this.value.length==2){//说明选择了贵州省
		//请求市级信息
		$.ajax({
			url:contextPath + 'zone/getCitys/'+this.value,
			type:'get',
			dataType :'json',
			async:false,
			success:function(res){
				if(res.success){
					$.each(res.data,function(index,per){
						//给市下拉框赋值
						citySelect.append($('<option>')
								.val(per.rank).text(per.name));
					});
				}else{
					alert('网络异常,请联系管理员!');
				}
			},
			error:function(){
				alert('网络异常,请联系管理员!');
			}
		});
	}
});
$('.city').change(function(){
	var districtSelect = $(this).next();
	districtSelect.find('option:not(.no)').remove();
	if(this.value.length==2){
		//请求市级信息
		$.ajax({
			url:contextPath + 'zone/getDistricts/'+this.value,
			type:'get',
			dataType :'json',
			async:false,
			success:function(res){
				if(res.success){
					$.each(res.data,function(index,per){
						//给市下拉框赋值
						districtSelect.append($('<option>')
								.val(per.rank).text(per.name));
					});
				}else{
					alert('网络异常,请联系管理员!');
				}
			},
			error:function(){
				alert('网络异常,请联系管理员!');
			}
		});
	}
});

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
/*$('.pcd').change(function(){
	var div = $(this).parent();
	var province = div.find('.province').val();
	var city = div.find('.city').val();
	var district = div.find('.district').val();
	
	div.find(':input:hidden').val(province+''+city+district);
});*/

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
