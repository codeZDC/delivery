var deliveryStatus ;//汇交状态
var deliverListId;//汇交清单id
jQuery(function($){
	$('#declineRow').hide();
	// 获取用户汇交信息
	getDeliveries();
	//设置时间
	$('.dateSpan').text(formatDate(new Date()));
});

function getDeliveries(){
	// 获取汇交清单
	$.getJSON(contextPath+'delivery/getDeliveries',{},function(res){
		console.log(res);
		if(res.map.hasOwnProperty('remarks') && res.map.remarks !=null){//有汇交清单
			deliverListId = res.map.remarks.id;//把汇交清单号保存 ,用于再次提交、
			//设置时间
			$('.dateSpan').text(formatDate(new Date(res.map.remarks.deliverTime)));
		}
		showResult(res);
	});
}

// 根据状态来显示审核结果
function showResult(res){//状态  +200
	deliveryStatus = res.msg;
	if(deliveryStatus == 250){
		$('#noDelivery').show();
	}else{
		$('#deliverList2').show();
		buildTable(res);
	}
	if(deliveryStatus == 199){// 草稿
		//有可能是退回的清单
		if(res.map.hasOwnProperty('remarks') && res.map.remarks !=null){//有汇交清单
			//显示汇交说明
			$('#deliverRemark').text(res.map.remarks.deliverRemarks);
			$('#declineRow').show();
			$('#declineRemarkText').text(res.map.remarks.declineRemarks).attr('readonly','readonly');
		}
		//显示添加tab
		$('#addTanContent').removeClass('hide');

	}else if(deliveryStatus == 250){
		//显示添加tab
		$('#addTanContent').removeClass('hide');
		// 空汇交项目,相应模块的显示
		// $('#noDelivery').toggle();
	}else if(deliveryStatus == 208){// 审核通过
		showExaminieMark('examinie-pass.png');
		//设置操作栏显示的内容
		$('#deliveries_table tbody td:last-child').text('已通过');
		$('.submitDelivery').hide();
		//显示汇交说明
		$('#deliverRemark').text(res.map.remarks.deliverRemarks).attr('readonly','readonly');
	}else if(deliveryStatus == 204 || deliveryStatus == 203){// 审核不通过
		//显示添加tab
		$('#addTanContent').removeClass('hide');
		$('#declineRow').show();
		$('#declineRemarkText').text(res.map.remarks.declineRemarks).attr('readonly','readonly');
		showExaminieMark('examinie-decline.png');
		//显示汇交说明
		$('#deliverRemark').text(res.map.remarks.deliverRemarks);
	}else if(deliveryStatus == 251){//零汇交
		//显示添加tab
		showExaminieMark('examining.png');
		//设置操作栏显示的内容
		$('#deliveries_table tbody td:last-child').text('零汇交');
		$('.submitDelivery').hide();
	}else{// 审核中
		
		showExaminieMark('examining.png');
		//设置操作栏显示的内容
		$('#deliveries_table tbody td:last-child').text('审核中');
		$('.submitDelivery').hide();
		//显示汇交说明
		$('#deliverRemark').text(res.map.remarks.deliverRemarks).attr('readonly','readonly');
	}
	
}

function buildTable(res){
	var rows = res.map.rows;
	//设置项目个数显示框
	$('#deliveryCount,.badge-danger').text(rows.length);
	var index,xmmc,type,iscopy,remarks,
	handle = $('<td>\
				<div class="hidden-sm hidden-xs action-buttons">\
				<a class="green editData" href="#"> <i\
					class="ace-icon fa fa-pencil bigger-130"></i></a> <a\
					class="red removeData" href="#"> <i\
					class="ace-icon fa fa-trash-o bigger-130"></i></a>\
				</div>\
				</td>'),
	table = $('#deliveries_table tbody').empty();
	$.each(rows,function(ind,per){
		index = $('<td>').append(ind+1);
		xmmc = $('<td>').append($('<a href="#">').text(per.xmmc));
		type = $('<td>').text(templateName[per.type]);
		iscopy = $('<td>').text(per.iscopy==0?'是':'否');
		remarks = $('<td>').text(per.remarks);
		$('<tr>').attr('id',per.id).attr('status',per.status).attr('type',per.type).append(index).append(xmmc).append(type)
			.append(iscopy).append(remarks).append(handle.clone()).appendTo(table);
	});
	//显示汇交说明
	//$('.deliveryRemarks').text(res.map.remarks.declineRemarks||res.map.remarks.deliverRemarks);
}

$('#deliveries_table').on('click','.editData',function(){
	var id = $(this).parents('tr').attr('id');
	var type = $(this).parents('tr').attr('type');
	location = contextPath + 'page/12templatesEdit/mainView?id='+id+'&type='+type;
});
$('#deliveries_table').on('click','.removeData',function(){
	var id = $(this).parents('tr').attr('id');
	var type = $(this).parents('tr').attr('type');
	showConfirm(function(){
		$.post(contextPath + type+'/del',{ids:[id]},function(res){
			if(res.success)
				location.reload();
			else
				alert('网络错误,请联系管理员!');
		},'json');
	});
});
//提交审核审批
$('.submitDelivery').click(function(){
	//就不需要校验汇交个数,因为没有汇交项目就不会显示提交按钮
	//校验表单,,
	var remarks = $('.deliveryRemarks').val();
	var ids=[],types=[];
	if(remarks.replace(/\s/g,'').length==0){
		alert('请填写汇交说明');
		$('.deliveryRemarks').focus();
		return;
	}
	$('#deliveries_table tbody tr').each(function(){
		ids.push($(this).attr('id'));
		types.push($(this).attr('type'));
	});
	showConfirm(function(){
		//alert(deliverListId);return;
		$.post(contextPath+'delivery/toExamine',{ids:ids,types:types,remarks:remarks,deliverListId:deliverListId},function(res){
			//获取tr的id 和 type 属性传到后天进行更新
			if(res.success){
				alert(res.msg);
				location.reload();//刷新页面
				//getDeliveries();
				
			}else{
				alert('网络错误,请联系管理员!');
			}
		},'json');
	});
});

$('#zeroDeliver').on('click',function(){
	showConfirm(function(){
		$.post(contextPath+'delivery/zeroDelivery',function(res){
			//获取tr的id 和 type 属性传到后天进行更新
			if(res.success){
				alert(res.msg);
				location.reload();//刷新页面
			}else{
				alert('网络错误,请联系管理员!');
			}
		},'json');
	});
});

// 显示审核结果标签
function showExaminieMark(mark){
	
	var examinieMark = $("#examinieMark");
	examinieMark.show();
	examinieMark.attr('src',examinieMark.attr('src-rooPath') + mark);
}
$("#toAdd").on('click',function(){
	$("#listTabContent").removeClass('active');// 关闭清单tab
	$("#addTanContent").addClass('active');// 打开添加tab
});
