var mapArea;//地图的坐标信息
var mapType;//地图的类型

/* 实现静态功能 */		
$(function(){
	//将打开的页面显示到导航条guider.jsp中,并且点击样式不知道怎么没有了,我们手工加上
	$('#sidebar>.nav-list a').click(function(){
		$('#sidebar>.nav-list .active').removeClass('active');
		if(!$(this).hasClass('dropdown-toggle')){
			$(this).parent().addClass('active');
			$('#breadcrumbs li.active').html('<a href="'+this.href+'">'+this.text+'<a>');
		}
	});
	/* $('#sidebar>.nav-list a').attr('target','iframe_body').click(function(){
					}); */
	//修改页面排版样式
	$('.footer').css({'padding-top':'0px'});
	$('[name=iframe_body]').height($(document).height()-10-$('#navbar').height()-$('#breadcrumbs').height());
	//为页面改变风格,,改动失败
	//alert();
	/* var style = "skin-1" ; 
				$(document.body).addClass(style);
				$(".ace-nav > li.grey").addClass("dark") ; */


	//查询 省市县的所有信息 放到全局变量
	$.ajax({
		url:  $('#contextPath').val()+ "/zone/getAllZone",
		dataType:'json',
		success : function(data){
			//console.log(data);
			$(data).each(function(){
				//console.log(this);
				if(this.zoneCode.length == 4){
					allZone.city[this.zoneCode] = this.zoneName;//把长度=4的拿出放入city
				}else if(this.zoneCode.length == 6){//县级
					allZone.district[this.zoneCode] = this.zoneName;
				}else if( this.zoneCode.length == 2){//省级
					allZone.province[this.zoneCode] = this.zoneName;
				}
				allZone[this.zoneCode] = this.zoneName;
				allZone[this.zoneName] = this.zoneCode;
			});
			//console.log(allZone.city);
			//console.log(getCityByProvince(52));
			//console.log(getDistrictByCity(5201));
		}
	});

	//默认打开第一个菜单
	$('.nav.nav-list').find('a').click();
	$('#mainIframe').attr('src',$('.submenu').find("a:last").attr('href'));
});
//全局变量  储存所有的区域信息
var allZone = {city:{},district:{},province:{}};






//根据省编码 获取下属城市
function getCityByProvince(proCode){
	var json = {};
	for(var i in allZone.city){
		if(i.substr(0,2) == proCode){
			json[i] = allZone.city[i];
		}
	}
	return json;
}
//根据城市编码 获取下属区县
function getDistrictByCity(cityCode){
	var json = {};
	for(var i in allZone.district){
		if(i.substr(0,4) == cityCode){
			json[i] = allZone.district[i];
		}
	}
	return json;
}



/**
 *
			实现全屏弹窗功能
 */
//弹出查看地图层
function viewMap(type,area){
	//弹出地图界面
	//刷新地图页面  传入参数
	mapArea = area;
	mapType = type;
	$("#mapIframe")[0].contentWindow.location.reload(true);//刷新
	$( "#map-modal" ).removeClass('hide').dialog({
		width: '80%',
		height : 400,
		resizable: true,
		modal: true
	});

	//showMsgCenter('查看地图','是多少速度是是上')
}
//弹出查看图片层
function viewImg(){
	$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
	//弹出查看图片
	$( "#imgs-modal" ).removeClass('hide').dialog({
		width: '50%',
		height : 400,
		resizable: true,
		modal: true
	});

	//showMsgCenter('查看图片','是多少速度是是上');
}

//弹出查看汇交清单
function viewDeliverList(deliverStatus,examinLevel){//0县级审批  1市级审批 2省级审批   默认县级审批
	hideExaminieMark();
	$("#printButton").hide();
	$("#agreeButton").hide();
	$("#declineButton").hide();
	if(deliverStatus == 8 ){//省级审核通过
		showExaminieMark('examinie-pass.png');
	}
	if(examinLevel == 0 || examinLevel == 1){//县级审批 市级审批
		if(deliverStatus == 3 || deliverStatus == 4){//市级或者县级  省级不通过
			showExaminieMark('examinie-decline.png');
		}else if(deliverStatus == 2){//市级或者县级  通过
			showExaminieMark('examinie-pass.png');
		}else if(deliverStatus == 1){//已汇交
			$("#agreeButton").show();
			$("#declineButton").show();
		}
	}else{//省级审批
		if(deliverStatus == 2){//市级或者县级  通过
			$("#agreeButton").show();
			$("#declineButton").show();
		}
	}
	
	$( "#deliverList" ).removeClass('hide').dialog({
		width: '80%',
		resizable: true,
		modal: true
	});
}

//显示审核结果标签
function showExaminieMark(mark){
	
	var examinieMark = $("#examinieMark");
	examinieMark.show();
	examinieMark.attr('src',examinieMark.attr('src-rooPath') + mark);
}

//显示审核结果标签
function hideExaminieMark(mark){
$("#examinieMark").hide();
}

//关闭汇交清单
function closeDeliverList(){
	$( "#deliverList" ).dialog( "close" );
}

//提示窗的属性设置
/**
 */
$.gritter.options.time = 3 * 1000;//3 秒后消失

//提示窗
function showMsgCenter(title,content){
	$.gritter.add({
		title: title,
		text: content,
		class_name: 'gritter-info gritter-center gritter-light' 
	});

	return false;

}

function showMsgRight(title,content){
	$.gritter.add({
		title: title,
		text: content,
		class_name: 'gritter-info gritter-light' 
	});

	return false;
}

/**
 *初始化 显示图片控件  开始 
 */

var $overflow = '';
var colorbox_params = {
		rel: 'colorbox',
		reposition:true,
		scalePhotos:true,
		scrolling:true,
		previous:'<i class="ace-icon fa fa-arrow-left"></i>',
		next:'<i class="ace-icon fa fa-arrow-right"></i>',
		close:'&times;',
		current:'{current} / {total}',
		maxWidth:'100%',
		maxHeight:'100%',
		onOpen:function(){
			$overflow = document.body.style.overflow;
			document.body.style.overflow = 'hidden';
		},
		onClosed:function(){
			document.body.style.overflow = $overflow;
		},
		onComplete:function(){
			$.colorbox.resize();
		}
};

$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
$("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
/**
 *初始化 显示图片控件 结束
 */


function view12templates(type,deliveryId){
	//修改iframe的地址
	$("#view12TempIframe").get(0).src = $('#contextPath').val() + 'page/12templatesView/mainView?type=' + type +'&deliveryId=' + deliveryId;
	$("#view12TempIframe").get(0).height = document.body.scrollHeight;
	//显示iframe
	$( "#view12templates" ).removeClass('hide').dialog({
		width: '80%',
		resizable: true,
		modal: true
	});
}

function printDeliveryList(){
	alert('开发小哥正在加油干呢,请期待');
	//window.print();
}

