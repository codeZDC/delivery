//审批账号等级
var examinLevel = 0;//0县级审批  1市级审批 2省级审批   默认县级审批


jQuery(function($){
	//当文档加载完成,获取省市县信息,,
	getPcd();//获取用户下的省市县
	$('#myTab').on('click','.dropdown-info>li',function(){
		//更换tab激活
		$('.dropdown.active').removeClass('active');
		$(this).parents('.dropdown').addClass('active');
		//改变title
		$('#cityName').text($(this).text());
		//刷新表格
		var zoneCode = $(this).attr('zoneCode');
		
		if(zoneCode.length < 6){//省级 或者市级审批
			loadTable($(this).attr('zoneCode'),0,1);
		}else{//县级审批
			loadTable($(this).attr('zoneCode'),1,1);
		}
	});
	
	$("#searchButton").on('click',function(){
		reloadTable();
	});
});

function getPcd(){
	$.getJSON(contextPath+'zone/getPcd',function(res){
		var data = res.data;

		if(!data){
			alert('网络错误,请联系管理员');return;
		}
		if(data[0].zoneCode.length==6){//县级审批员
			buildDistrct(data);
			//精确查询加载表格
			loadTable(data[0].zoneCode);
		}else{//省级市级审批
			buildCitys(data);
			if(data.length==1){
				$('#grade').text('市级审批');
				examinLevel = 1;//市级审批
			}
			else{ 
				examinLevel = 2;//省级审批
				$('#grade').text('省级审批');
			}
			//模糊查询加载表格
			loadTable(data[0].zoneCode,0);
		}
	});
}
function buildDistrct(data){
	var li = $('<li>').addClass('dropdown active'); 
	var a  =  $('<a aria-expanded="false"> '+ data[0].zoneName+' </a>');
	li.append(a).appendTo($('#myTab').empty());
	$('#cityName').text(data[0].zoneName);
	$('#grade').text('县级审批');
}
function buildCitys(data){
	var a , 
	ul,
	li = $('<li>').addClass('dropdown'), 
	myTab = $('#myTab').empty();
	$.each(data,function(index,per){
		a =  $('<a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="true"> '+
				per.zoneName+' &nbsp; <i class="ace-icon fa fa-caret-down bigger-110 width-auto"></i></a>');
		ul = $('<ul>').addClass('dropdown-menu dropdown-info');
		$.each(per.citys,function(ind,pe){
			$('<li>').attr('zoneCode',pe.zoneCode).append($('<a>').text(pe.zoneName)).appendTo(ul);
		});
		li.clone().addClass(index==0?'active':'').append(a).append(ul).appendTo(myTab);
	});
	
}

//获取管辖类的用户信息构建表格
//type=0表示初始化表格,后端采用模糊查询,,不为0精确查找
function loadTable(code,type,pageNum){	
	zoneCodeRefresh = code;//记住code  用于刷新
	typeRefresh = type;//记住code  用于刷新
	pageNumRefresh = pageNum;//记住code  用于刷新
//	var zdc = "zzzzdddccc";
	var companyName = $('#companyName').val() == ''? '' : $('#companyName').val(); //公司名称
	var deliveryStatus = $('#deliveryStatus').val() == ''? '' : $('#deliveryStatus').val(); //汇交状态
	var qualification = $('#qualification').val() == ''? '' : $('#qualification').val(); //单位资质
	console.log(' sssssssssssss    ' +companyName + status);
	var pageSize = 8;
	$.getJSON(contextPath + "delivery/getCompanies",{
		pageNum:pageNum,
		pageSize:pageSize,
		deliveryCode:code,//汇交区域编码
		deliveryStatus:deliveryStatus,//汇交状态
		companyName:companyName,//公司名称
		qualification:qualification,//用户资质
		examineType:type//查询方式0 模糊查找 1精确查找
		},function(res){
		buildTable(res.rows);
		initPaginationBar(res.total,pageSize,pageNum,function(currentPage){loadTable(code,type,currentPage);});
	});
}

var zoneCodeRefresh,typeRefresh,pageNumRefresh;//用于刷新纪录code
function reloadTable(){
	loadTable(zoneCodeRefresh,typeRefresh,pageNumRefresh);
}

function buildTable(data){
	//console.log(data);
	var index,year,unitName,span,deliveryStatus,remarks,qualification,
	handle,
	table = $('.table-striped.table-bordered tbody').empty();
	console.log(data);
	$.each(data,function(ind,per){
		index = $('<td>').text(ind+1);
		year = $('<td>').text(per.examineYear);
		unitName = $('<td>').text(per.unitName);
		qualification = $('<td>').text(getQulification(per.qualification));
		span = $('<span class="label">');
		handle = $('<td>').append('<div class="hidden-sm hidden-xs action-buttons">\
					<a class="purple viewData" href="#" data-rel="tooltip"  title="查看" onclick="top.viewDeliverList(\''+ per.deliveryStatus +'\',\''+ examinLevel +'\')"> <i\
					class="ace-icon fa fa-eye bigger-130"></i></a></div>');
		if(per.deliveryStatus==0){
				span.addClass('label-yellow').text('零汇交');
		}
		else if(per.deliveryStatus==1){//已汇交
			if(examinLevel == 0 || examinLevel == 1){//县级审批
				span.addClass('label-purple').text('已汇交');
			}else{//省级审批
				
				span.addClass('label-info').text('下级审核中');
				handle = $('<td>');//不添加操作按钮
			}
			
		}else if(per.deliveryStatus==2){//1级通过
			if(examinLevel == 0 || examinLevel == 1){//县级审批 市级审批
				span.addClass('label-success').text('已通过');
			}else{//省级审批
				span.addClass('label-purple').text('下级通过');
			}
			
			if(per.qualification == 1){//判断用户资质  甲级资质
				span.addClass('label-purple').text('甲级已汇交');
			}
			
		}else if(per.deliveryStatus==3){//1级不通过
			if(examinLevel == 0 || examinLevel == 1){//县级审批 市级审批
				span.addClass('label-danger').text('不通过');
			}else{//省级审批
				span.addClass('label-info').text('下级审核中');
			}
		}else if(per.deliveryStatus==4){//2级不通过
			span.addClass('label-danger').text('不通过');
		}else if(per.deliveryStatus==8){//审核通过
			span.addClass('label-success').text('省级审核通过');
		}else {//未汇交
			span =  $('<span class="label">').text('未汇交');
			handle = $('<td>');//不添加操作按钮
		}
		deliveryStatus = $('<td>').append(span);
		remarks = $('<td>').text(per.remarks);
		$('<tr>').append(index).append(year).append(unitName).append(deliveryStatus)
		.append(remarks).attr('companyId',per.id).attr('deliveryStatus',per.deliveryStatus).attr('unitName',per.unitName).append(qualification).append(handle).appendTo(table);
	});
	//添加点击事件
	table.unbind();//移除绑定事件
	table.on('click','.viewData',function(){//查看
		var tr = $(this).parents('tr');
		var companyId = tr.attr('companyId');//用户id
		var unitName = tr.attr('unitName');//用户名称
		//显示公司信息
		showCompany(companyId,unitName);

	});
}

function getQulification(obj){
	var qulification;
	switch(obj){
		case 1 : qulification = '甲';break;
		case 2 : qulification = '乙';break;
		case 3 : qulification = '丙';break;
		case 4 : qulification = '丁';
	}
	return qulification;
}


function showCompany(companyId,unitName){
	//清空界面信息
	$('#compnayName',top.document).text(unitName);
	$.getJSON(contextPath + "delivery/getDeliveriesById",{userId:companyId},function(res){
		console.log(res);
		if(res.msg == 251){//零汇交
			$('#totalCount',top.document).html(res.map.rows.length);
			$('#deliverListTable',top.document).hide();//隐藏表格
			$('#zeroDeliverSpan',top.document).show();//显示零汇交提示
		}else{
			$('#deliverListTable',top.document).show();//隐藏表格
			$('#zeroDeliverSpan',top.document).hide();//显示零汇交提示
			$('#totalCount',top.document).html(res.map.rows.length);
		}
		var date = new Date(res.map.remarks.deliverTime);
		$('#dateSpan',top.document).text(date.getFullYear() + '-' +(date.getMonth() + 1) + '-' +date.getDate() + " " +date.getHours() + ":"+date.getMinutes()+":"+date.getSeconds());
		$('#deliverRemark',top.document).val(res.map.remarks.deliverRemarks == null? '' : res.map.remarks.deliverRemarks);//设置汇交信息
		$('#declineRemarks',top.document).val(res.map.remarks.declineRemarks == null? '' : res.map.remarks.declineRemarks);//设置不同意意见
		//修改审核页面的信息
		modifyExaminieInfo(res.map.remarks.id);
		
		buildCompanyTable(res.map.rows);
	});
}

//准备审核信息
function modifyExaminieInfo(deliverListId,year){
	var deliverListId = $('#deliverListId',top.document).val(deliverListId);
	var year = $('#year',top.document).val(year);
	$('#agreeButton',top.document).unbind();//解绑事件
	$('#declineButton',top.document).unbind();//解绑事件
	$('#agreeButton',top.document).on('click',function(){
		 if(confirm("确定要做此操作吗？")){
			 var status;
				if(examinLevel == 0 || examinLevel == 1){//县级审批 市级审批
					status = 2;
				}else{//省级审批
					status = 8;
				}
				examinieDeliveryList(deliverListId.val(),status);//status 2-1级同意   3-1级不同意  4 4-2级不同意
		 }
			
		 
	});
	$('#declineButton',top.document).on('click',function(){
		var declineRemarks = $('#declineRemarks',top.document).val();
		if(declineRemarks == ''){
			alert('请输入不同意意见');
			return;
		}
		if(confirm("确定要做此操作吗？")){
			var status;
			if(examinLevel == 0 || examinLevel == 1){//县级审批 市级审批
				status = 3;
			}else{//省级审批
				status = 4;
			}
			examinieDeliveryList(deliverListId.val(),status,declineRemarks);//declineRemarks 不同意意见
		}
		
	});
}

//提交审核
function examinieDeliveryList(deliverListId,status,declineRemarks){
	$.post(contextPath + "examinie/examinieById",{
		id:deliverListId,
		status:status,
		declineRemarks:declineRemarks
		},function(res){
			if(res.success){
				alert('审核成功');
				reloadTable();//刷新table
				//关闭弹窗
				top.closeDeliverList();
			}
	},'json');
}

//构建审核表格
function buildCompanyTable(rows){
	var table = $('#deliverListTable',top.document).empty();//清空表格
	var index,xmmc,type,isCopy,remark,handle;
	for(var i in rows){
		index = $('<td>').text(i);
		xmmc = $('<td>').text(rows[i].xmmc);
		type = $('<td>').text(templateName[rows[i].type]);
		isCopy = $('<td>').text(rows[i].iscopy == 0 ? '是':'否');
		remark = $('<td>').text(rows[i].remarks == '' ? '无': rows[i].remarks);
		handle = $('<td>').append('<div class="hidden-sm hidden-xs action-buttons">\
				<a class="purple viewData" href="javascript:;" data-rel="tooltip"  title="查看" onclick="view12templates(\''+ rows[i].type +'\',\''+ rows[i].id +'\')"> <i\
		class="ace-icon fa fa-eye bigger-130"></i></a></div>');
		
		$('<tr>').append(index).append(xmmc).append(type).append(isCopy).append(remark).append(handle).appendTo(table);
	}
	
}
