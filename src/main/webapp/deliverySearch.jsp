<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>
<!-- 读取配置文件 -->
<fmt:setBundle basename="config" var="config" />
<fmt:message key="arcgis.api.ip" var="arcgisApiIp" bundle="${config}" />
<!-- arcgis 依赖库 ip-->
<fmt:message key="arcgis.server.ip" var="arcgisServerIp"
	bundle="${config}" />
<!-- arcgis 服务器 ip -->

<!DOCTYPE html>
<html lang="en">
<head>
<!-- arcgis styles  arcgis styles -->

<!-- arcgis styles  arcgis styles -->

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>成果查询</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="static/ace/assets/css/bootstrap.css" />
<link rel="stylesheet" href="static/ace/assets/css/font-awesome.css" />



<!-- text fonts -->
<link rel="stylesheet" href="static/ace/assets/css/ace-fonts.css" />
<!-- ace styles -->
<link rel="stylesheet" href="static/ace/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<style>
</style>

</head>

<body class="no-skin">
	<div class="main-container">

		<div id="navbar"
			class="navbar navbar-default    navbar-collapse       h-navbar">
			<script type="text/javascript">
				try {
					ace.settings.check('navbar', 'fixed')
				} catch (e) {
				}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand"> <small> <i
							class="fa fa-leaf"></i> 贵州测绘成果目录汇交系统
					</small>
					</a>
				</div>



				<!-- /section:basics/navbar.dropdown -->
				<nav role="navigation"
					class="navbar-menu pull-left collapse navbar-collapse">
					<!-- #section:basics/navbar.nav -->
					<ul class="nav navbar-nav">
						<li><a href="homePage.jsp" class="dropdown-toggle"> <i
								class="ace-icon fa fa-home"></i> 首页
						</a></li>

						<li><a href="statistics.jsp"> <i
								class="ace-icon fa fa-signal"></i> 图形统计
						</a></li>
						<li><a href="javascript:;"> <i
								class="ace-icon fa fa-map-marker"></i> 成果查询
						</a></li>
					</ul>

				</nav>
				<div class="pull-right">
					<ul class="nav navbar-nav">
						<li><a href="login.jsp" class="dropdown-toggle"> <i
								class="ace-icon fa fa-sign-in"></i> 登录
						</a></li>

					</ul>
				</div>

			</div>
			<!-- /.navbar-container -->
		</div>

		<div class="page-content" style="width: 1300px; margin: 0px auto">
			<div class="row">
				<div class="col-sm-12 center">
					<h4 class="header smaller lighter blue">成果查询</h4>
					<p>
					
							区域
						<select class="" id="citySelect">
							<option value="">贵阳</option>
							<option value="">市</option>
						</select>
						<select class="hide" id="districtSelect">
							<option value="">贵阳</option>
							<option value="">市</option>
						</select>
						
						类型
						<select class="" id="typeSelect">
							<option value="0">十二类</option>
							<option value="1">市</option>
						</select> <select class="" id="yearSelect">
							<option value="2018">2018</option>
							<option value="2019">2019</option>
						</select>
						<button class="btn btn-white btn-default btn-round"
							id="searchButton">
							<i class="ace-icon fa fa-search red2"></i> 查看
						</button>
					</p>

					<!-- tab切换页 -->
					<div class="tabbable">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active"><a data-toggle="tab" href="#list"> <i
									class="green ace-icon fa fa-list-ol bigger-120"></i> 列表
							</a></li>

							<li id="mapTab"><a data-toggle="tab" href="#map" > <i
									class="red ace-icon fa fa-map-marker bigger-120"></i> 地图
							</a></li>

						</ul>

						<div class="tab-content">
							<div id="map" class="tab-pane fade">
								<!-- 地图 iframe	 -->
								<iframe id="mapIframe" src="mapView.jsp" width="100%"
									height="700" frameborder="no" scrolling="no"></iframe>
							</div>

							<div id="list" class="tab-pane fade in active">
								<div >
									<table class="table table-bordered table-striped">
										<thead class="thin-border-bottom">
											<tr >
												<th class="center">申请单位</th>

												<th class="center">项目名称</th>

												<th class="center">项目类型</th>
												<th class="center">完成年代</th>
												<th class="center">查看地图</th>
											</tr>
										</thead>

										<tbody id="deliveriesTable">
											<tr>
												<td>贵州省第一测绘院</td>
												<td>甲</td>
												<td>甲测资字5200068</td>
												<td><span
													class="label label-success label-white middle">审核通过</span></td>
												<td>2018-04-15 09:58:26</td>
											</tr>
											<tr>
												<td>遵义焜炜测绘有限公司</td>
												<td>丙</td>
												<td>丙测资字5221099</td>
												<td><span class="label label-info label-white middle">审核中</span></td>
												<td>2018-04-14 19:01:59</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

						</div>
					</div>

				</div>


			</div>

		</div>




	</div>


	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/ace/assets/js/jquery.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<script src="static/jquery/1.9.1/jquery.min.js"></script>

	<script src="static/ace/assets/js/bootstrap.js"></script>


	<!-- ace scripts -->
	<script src="static/ace/assets/js/ace/ace.js"></script>


	<script type="text/javascript">
		$(function() {
			//初始化选择框
			initOptions();
			//初始化城市信息
			initZone()
			//查询数据
			getMapDeliveries(2018);
		});
		$('#searchButton').on('click', function() {
			getMapDeliveries();
		});
		
		function initOptions(){
			$("#typeSelect").empty();
			var optionStr = "<option value=''>全部</option>";
			for(var i in templateName){
				optionStr +="<option value='"+ i +"'>" + templateName[i] +"</option>";
			}
			$("#typeSelect").append(optionStr);
		}

		function getMapDeliveries(year) {
			var year = $("#yearSelect").val();
			var zoneCode = getZoneCode();//取得汇交区域编号
		//	var unitName = $("#yearSelect").val();
			var deliveryType = $("#typeSelect").val() == '' ? null : $("#typeSelect").val();
		//	alert(zoneCode);
			$.getJSON('${contextPath}home/selectMapDeliveries', {
				year : year,
				deliveryType : deliveryType,
				zoneCode : zoneCode
			//	unitName : unitName
			}, function(res) {
				if (res.success) {
					buildTable(res);
				} else {
					alert("网络错误,请联系管理员");
				}
			});
		}
		
		//获得汇交区域code
		function getZoneCode(){
			//清空选项
			var citySelect = $('#citySelect').val();
			var districtSelect = $('#districtSelect').val();
			return districtSelect == '' ? citySelect : districtSelect ;
		}

		//构建结果表格
		function buildTable(res) {
			var table = $('#deliveriesTable').empty();
			var data = res.data;
			for(var i in data){ 
				//构建表格
				var tr = $('<tr>').appendTo(table);
				$('<td>').text(data[i].unitName).appendTo(tr)//公司名称
				$('<td>').text(data[i].xmmc).appendTo(tr)//项目名称
				$('<td>').text(templateName[data[i].type]).appendTo(tr)//项目类型
				$('<td>').text(data[i].endTime).appendTo(tr)//完成年代
				var ico = data[i].area == '' ? '' : '<a class="red menu-edit" data-toggle="tab" href="#map" onclick="changeTabToMap(this)"> <i class="ace-icon fa fa-map-marker bigger-130"></i></a>';
				$('<td>').attr('area',data[i].area).attr('xmmc',data[i].xmmc).attr('type',data[i].type)
				.attr('unitName',data[i].unitName).attr('endTime',data[i].endTime).append(ico).appendTo(tr);
			}
		}
		
		//修改打开的tab页面  
		function changeTabToMap(obj){
			$("#myTab").children("li").each(function(){
				$(this).removeClass("active");
			});
			$("#mapTab").addClass("active");
			var td = $(obj).parent()[0];
			if(td){
				//在地图上画图形//把参数传到地图
				$('#mapIframe')[0].contentWindow.showDeliveries(td);
			}
		}
		

		var templateName = {
			gps : '天文、三角、GPS、导线锁网成果',
			szw : '水准网',
			wxyx : '卫星影像',
			hsyx : '航摄影像',
			mndt : '模拟地图',
			szdt : '数字地图',
			zych : '专业测绘类',
			gccl : '工程测量类',
			ptdt : '普通地图编制类',
			zytz : '专业与特种地图编制类',
			dlxx : '地理信息类',
			yqjy : '仪器检校类'
		};
		
		var allZone = {city:{},district:{},province:{}};
		
		/**
		*初始化城市信息
		*/
		function initZone(){
			//查询 省市县的所有信息 放到全局变量
			$.ajax({
				url:   "${contextPath}/zone/getAllZone",
				dataType:'json',
				success : function(data){
					$(data).each(function(){
						if(this.zoneCode.length == 4){
							allZone.city[this.zoneCode] = this.zoneName;//把长度=4的拿出放入city
						}else if(this.zoneCode.length == 6){//县级
							allZone.district[this.zoneCode] = this.zoneName;
						}else if( this.zoneCode.length == 2){//省级
							allZone.province[this.zoneCode] = this.zoneName;
						}
					});
					//初始化城市列表
					initCitySelect();
				}
			});
		}
		
		function initCitySelect(){
			//清空选项
			var citySelect = $('#citySelect').empty();
			var districtSelect = $('#districtSelect').empty();
			var optionStr = "<option value=''>全部</option>";
			for(var i in allZone.city){
				optionStr +="<option value='"+ i +"'>" + allZone.city[i] +"</option>";
			}
			citySelect.append(optionStr);
			//绑定点击改变事件
			citySelect.on('change',function(){
				districtSelect.empty();//清空县级下拉
				var optionDisStr = "<option value=''>全部</option>";
				var districts = getDistrictByCity(citySelect.val())
				for(var i in districts){
					optionDisStr +="<option value='"+ i +"'>" + districts[i] +"</option>";
				}
				districtSelect.append(optionDisStr);
			});
			
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
		
	
	</script>





</body>
</html>
