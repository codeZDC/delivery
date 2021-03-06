<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>贵州测绘成果目录汇交系统</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="static/ace/assets/css/bootstrap.css" />
<link rel="stylesheet" href="static/ace/assets/css/font-awesome.css" />


<!-- page specific plugin styles -->
<link rel="stylesheet" href="static/ace/assets/css/colorbox.css" />

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
					<a href="javascript:;" class="navbar-brand"> <small> <i
							class="fa fa-leaf"></i> 贵州测绘成果目录汇交系统
					</small>
					</a>
				</div>



				<!-- /section:basics/navbar.dropdown -->
				<nav role="navigation"
					class="navbar-menu pull-left collapse navbar-collapse"> <!-- #section:basics/navbar.nav -->
				<ul class="nav navbar-nav">
						<li><a href="javascript:;" class="dropdown-toggle"> <i
								class="ace-icon fa fa-home"></i> 首页
						</a></li>

						<li><a href="statistics.jsp"> <i
								class="ace-icon fa fa-signal"></i> 图形统计
						</a></li>
						<li><a href="deliverySearch.jsp"> <i
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

		<div class="page-content" style="width: 1200px; margin: 0px auto">

			<div class="row">
				<div class="col-sm-8">
					<h4 class="header smaller lighter blue">测绘成果申请审批受理公告</h4>
					<table class="table table-bordered table-striped">
						<thead class="thin-border-bottom">
							<tr>
								<th>申请单位</th>

								<th>资质等级</th>

								<th>申请表编号</th>
								<th>审批状态</th>
								<th>最后审核时间</th> 
							</tr>
						</thead>

						<tbody id="examinieTable">
							<tr>
								<td>贵州勤智富勘测有限公司</td>

								<td><b class="blue">甲</b></td>

								<td>丙测资字5222022</td>
								<td><span class="label label-info label-white middle">审核中</span>
									<span class="label label-success label-white middle">审核通过</span>
								</td>
								<td>2018.2.2</td>
							</tr>

							<tr>
								<td>贵州遵义怡海测绘有限责任公司</td>

								<td>乙/丙/丁</td>

								<td>丙测资字5222022</td>
								<td><span class="label label-info label-white middle">审核中</span>
									<span class="label label-success label-white middle">审核通过</span>
								</td>
								<td>2018.2.2</td>
							</tr>

							<tr>
								<td>贵州遵义怡海测绘有限责任公司</td>

								<td><b class="blue">$15.00</b></td>

								<td>丙测资字5222022</td>
								<td><span class="label label-info label-white middle">审核中</span>
									<span class="label label-success label-white middle">审核通过</span>
								</td>
								<td>2018.2.2</td>
							</tr>


						</tbody>
					</table>
				</div>
				<!-- /.col -->

				<div class="col-sm-4 center">
					<h4 class="header smaller lighter blue">联系我们</h4>
					<address style="padding-left: 10px">
						<strong class="blue">行政许可受理咨询</strong> <br>
						<ul class="list-unstyled spaced">

							<li><i class="ace-icon fa fa-phone bigger-110 green"></i> <span
								class="grey">审批处</span> : 0851-6858250</li>

							<li><i class="ace-icon fa fa-phone bigger-110 red"></i> <span
								class="grey"> 成果处 </span>: 0851-6858250</li>
						</ul>

						<strong class="blue">成果咨询</strong> <br>
						<ul class="list-unstyled spaced">

							<li><i class="ace-icon fa fa-phone bigger-110 green"></i>
								0851-6858250</li>

						</ul>



						<strong class="blue">意见建议反馈</strong> <br>
						<ul class="list-unstyled spaced">

							<li><i class="ace-icon fa fa-phone bigger-110 green"></i>
								0851-6858250</li>

						</ul>
					</address>
				</div>
				<!-- /.col -->





			</div>

			<hr>

			<div class="row">

				<div class="col-sm-12">
					<h4 class="header smaller lighter blue">我们的成果</h4>
					<!-- PAGE CONTENT BEGINS -->
					<div>
						<ul class="ace-thumbnails clearfix">
							<!-- #section:pages/gallery -->

							<li><a href="${contextPath}static/imgs/demo/1W_DEM.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/1W_DEM.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>
							<li><a href="${contextPath}static/imgs/demo/D_1WDEM.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/D_1WDEM.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>
							<li><a href="${contextPath}static/imgs/demo/D_5WMap.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/D_5WMap.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>
							<li><a href="${contextPath}static/imgs/demo/D_1WDOM.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/D_1WDOM.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>
							<li><a href="${contextPath}static/imgs/demo/1W_PAGEMAP.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/1W_PAGEMAP.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>
							<li><a href="${contextPath}static/imgs/demo/1W_PAGEMAP.jpg"
								data-rel="colorbox" class="cboxElement"> <img width="150"
									height="150" alt="150x150"
									src="${contextPath}static/imgs/demo/1W_PAGEMAP.jpg">
									<div class="text">
										<div class="inner">点击看大图</div>
									</div>
							</a></li>



						</ul>
					</div>
					<!-- PAGE CONTENT ENDS -->
				</div>
			</div>

			<div class="row">
				<div class="col-sm-8">
					<h4 class="header smaller lighter blue">汇交测绘成果目录</h4>
					<table id="achievement" class="table table-bordered table-striped">
						<thead class="thin-border-bottom">
							<tr>
								<th>测绘项目名称</th>

								<th>类型</th>

								<th>项目所在行政区</th>
								<th>施测完成时间</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>数字地图</td>

								<td><b class="blue">数字地图</b></td>

								<td>遵义市</td>
								<td>2018年2月2日</td>
							</tr>
							<tr>
								<td>数字地图</td>

								<td><b class="blue">数字地图</b></td>

								<td>遵义市</td>
								<td>2018年2月2日</td>
							</tr>
							<tr>
								<td>数字地图</td>

								<td><b class="blue">数字地图</b></td>

								<td>遵义市</td>
								<td>2018年2月2日</td>
							</tr>
							<tr>
								<td>数字地图</td>

								<td><b class="blue">数字地图</b></td>

								<td>遵义市</td>
								<td>2018年2月2日</td>
							</tr>



						</tbody>
					</table>
				</div>
				<!-- /.col -->

				<div class="col-sm-4 center">
					<h4 class="header smaller lighter blue">工作时间</h4>
					<address style="padding-left: 10px">
						<strong class="blue">上午</strong> <br>
						<ul class="list-unstyled spaced">

							<li><i class="ace-icon fa fa-clock-o bigger-110 green"></i>
								<span class="grey">8:30 - 11:30</span></li>

						</ul>
						<hr>
						<strong class="blue">下午</strong> <br>
						<ul class="list-unstyled spaced">

							<li><i class="ace-icon fa fa-clock-o bigger-110 green"></i>
								<span class="grey">13:00 - 17:00</span></li>

						</ul>

					</address>
				</div>
				<!-- /.col -->





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

	<!-- page specific plugin scripts -->
	<!-- page specific plugin scripts -->
	<script src="static/ace/assets/js/jquery.colorbox.js"></script>

	<!-- ace scripts -->
	<script src="static/ace/assets/js/ace/ace.js"></script>

	<script type="text/javascript">
		jQuery(function($) {
			var $overflow = '';
			var colorbox_params = {
				rel : 'colorbox',
				reposition : true,
				scalePhotos : true,
				scrolling : false,
				previous : '<i class="ace-icon fa fa-arrow-left"></i>',
				next : '<i class="ace-icon fa fa-arrow-right"></i>',
				close : '&times;',
				current : '{current} of {total}',
				maxWidth : '100%',
				maxHeight : '100%',
				onOpen : function() {
					$overflow = document.body.style.overflow;
					document.body.style.overflow = 'hidden';
				},
				onClosed : function() {
					document.body.style.overflow = $overflow;
				},
				onComplete : function() {
					$.colorbox.resize();
				}
			};

			$('.ace-thumbnails [data-rel="colorbox"]')
					.colorbox(colorbox_params);
			$("#cboxLoadingGraphic").html(
					"<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon
			getExaminieInfo();
					
			buildAchievementTable();
		});

		//查询公司审核信息
		function getExaminieInfo() {
			$.getJSON('${contextPath}home/getExaminieInfo', {
				pageSize : 5
			}, function(res) {
				if (res.success) {
					buildExaminieTable(res.data);
				}
			});
		}

		function buildExaminieTable(data) {
			var examinieTable = $('#examinieTable').empty();
			var certificateCode, lastExaminieTime, qualification, status, unitName;
			for ( var i in data) {
				var tr = $('<tr>');
				unitName = $('<td>').text(data[i].unitName);
				qualification = $('<td>').text(getQualification(data[i].qualification));
				certificateCode = $('<td>').text(data[i].certificateCode);
				var span = $('<span>');
				if(data[i].status == 8){//审核通过
					span.addClass("label label-success label-white middle").text('审核通过');
				}else if(data[i].status == 0){//零汇交
					span.addClass("label label-warning label-white middle").text('零汇交');
				}else{//审核中 
					span.addClass("label label-info label-white middle").text('审核中');;
				}
				status = $('<td>').append(span);
				lastExaminieTime = $('<td>').text(getMyDate(data[i].lastExaminieTime));
				tr.append(unitName).append(qualification).append(certificateCode).append(status).append(lastExaminieTime).appendTo(examinieTable)
				
			}
		}

		function getMyDate(str) {
			if(str == null){
				return "--,--";
			}
			var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
					.getMonth() + 1, oDay = oDate.getDate(), oHour = oDate
					.getHours(), oMin = oDate.getMinutes(), oSen = oDate
					.getSeconds(), oTime = oYear + '-' + getzf(oMonth) + '-'
					+ getzf(oDay) + ' ' + getzf(oHour) + ':' + getzf(oMin)
					+ ':' + getzf(oSen);//最后拼接时间  
			return oTime;
		};
		//补0操作
		function getzf(num) {
			if (parseInt(num) < 10) {
				num = '0' + num;
			}
			return num;
		}
		
		//获取甲乙丙丁
		function getQualification(qualification){
			switch(qualification){
				case '1':return '甲';
				case '2':return '乙';
				case '3':return '丙';
				case '4':return '丁';
			}
		}
		
		
		//汇交成果展示
		function buildAchievementTable(){
			//获取省市县代码信息
			var typeJSON={
					gps:'天文、三角、GPS、导线锁网成果',
					szw:'水准网',
					wxyx:'卫星影像',
					hsyx:'航摄影像',
					mndt:'模拟地图',
					szdt:'数字地图',
					zych:'专业测绘类',
					gccl:'工程测量类',
					ptdt:'普通地图编制类',
					zytz:'专业与特种地图编制类',
					dlxx:'地理信息类',
					yqjy:'仪器检校类'
					},
			pcd ={};//省市县信息
			$.ajax({
				url:'${contextPath}/zone/getAllZone',
				dataType:'json',
				async:false,
				data:{},
				type:'get',
				success:function(res){
					 for ( var i in res) {
						pcd[res[i].zoneCode] = res[i].zoneName;
					 } 
				},
				error:function(){alert('网络异常,请联系管理员!')}
			});
			
			$.getJSON('${contextPath}/home/getCompletedDeliveries',{pageSize:5},function(res){
				//开始构建表格  achievement
				var container = $('#achievement tbody').empty();
				if(res.data.length==0)container.append($('<h1>').text('暂无数据'));
				var xmmc,type,remarks,endTime;
				$.each(res.data,function(){
					xmmc = $('<td>').text(this.xmmc);
					type = $('<td>').text(typeJSON[this.type]);
					remarks = $('<td>').text(pcd[this.remarks]);
					endTime = $('<td>').text(this.endTime);
					$('<tr>').append(xmmc).append(type).append(remarks)
							 .append(endTime).appendTo(container);
				})
			});
		}
	</script>


</body>
</html>
