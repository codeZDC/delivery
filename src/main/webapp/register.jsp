<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>注册</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="static/ace/assets/css/bootstrap.css" />
<link rel="stylesheet" href="static/ace/assets/css/font-awesome.css" />

 <!-- datepicker styles -->
 <link href="static/ace/assets/css/datepicker.css" rel="stylesheet">



<!-- text fonts -->
<link rel="stylesheet" href="static/ace/assets/css/ace-fonts.css" />
<!-- ace styles -->
<link rel="stylesheet" href="static/ace/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<style>
	.innerDiv{
		padding-left: 10px;
		padding-right: 10px
	}
	
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
  
		<div class="page-content" style="width: 1000px; margin: 0px auto">
			<div class="row">
				<div class="col-sm-12 center">
					<h4 class="header smaller lighter blue">用户注册</h4>
					<div class="tabbable">
						<ul class="nav nav-tabs" id="myTab">
							<li class="active"><a data-toggle="tab" href="#home"
								aria-expanded="true"> <i
									class="green ace-icon fa fa-pencil-square-o bigger-120"></i>
									注册
							</a></li>

						</ul>

						<div class="tab-content">
							<div id="home" class="tab-pane fade active in">
								<!-- 注册信息开始 -->
								<form id="user-add-form" class="form-horizontal" role="form">
									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 单位名称 </label>

												<div class="col-sm-8">
													<input type="text" name="unitName" placeholder="单位名称"
														class="form-control required">
												</div>
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-2">密码</label>

												<div class="col-sm-8">
													<input type="password" name="password" placeholder="密码"
														class="form-control required">
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 联系人 </label>

												<div class="col-sm-8">
													<input type="text" name="contact" placeholder="联系人,姓名如:王五"
														class="form-control required">
												</div>
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 联系电话 </label>

												<div class="col-sm-8">
													<input type="text" name="telephone"
														placeholder="联系电话:如 0851-8888888" class="form-control">
												</div>
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 手机 </label>

												<div class="col-sm-8">
													<input type="text" name="phoneNumber"
														placeholder="手机 13xxxxxxxxx" class="form-control required">
												</div>
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 邮编 </label>

												<div class="col-sm-8">
													<input type="text" name="zipCode" placeholder="邮编"
														class="form-control">
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 传真 </label>

												<div class="col-sm-8">
													<input type="text" name="fax" placeholder="传真"
														class="form-control">
												</div>
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 单位性质 </label>

												<div class="col-sm-8">
													<select name="unitProperty required " >
														<option value="">请选择</option>
														<option value="1">国有企业</option>
														<option value="2">民营企业</option>
														<option value="3">事业单位</option>
													</select>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-xs-6">
											<div class="form-group administration">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 行政区域</label>

												<div class="col-sm-8">
													<select class="province pcd required">
														<option value="" class="no ">请选择</option>
													</select> <select class="city pcd">
														<option value="" class="no">请选择</option>
													</select> <select class="district pcd">
														<option value="" class="no">请选择</option>
													</select> <input type="hidden" name="admZone">
												</div>
											</div>
										</div>
										<div class="col-xs-6 delivery">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 汇交区域 </label>

												<div class="col-sm-8">
													<select class="province pcd required"
														id="deliverProvenceSelect">
														<option value="" class="no">请选择</option>
														<option value="52">贵州省</option>
													</select> <select class="city pcd " id="deliverCitySelect">
														<option value="" class="no">请选择</option>
													</select> <select class="district pcd" id="deliverDistinctSelect">
														<option value="" class="no">请选择</option>
													</select> <input type="hidden" name="deliveryZone"> <span
														id="examinerAdd" class="help-button hide" data-rel="popover"
														data-trigger="hover" data-placement="left"
														data-content="暂无审批人" title="" data-original-title="">审</span>
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 办公地址 </label>

												<div class="col-sm-8">
													<input type="text" name="workAddr" placeholder="办公地址"
														class="form-control">
												</div>
											</div>
										</div>
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 单位地址</label>

												<div class="col-sm-8">
													<input type="text" name="unitAddr" placeholder="单位地址"
														class="form-control">
												</div>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-xs-6">
											<div class="form-group">
												<label class="col-sm-4 control-label no-padding-right"
													for="form-field-1"> 组织机构代码</label>

												<div class="col-sm-8">
													<input type="text" name="orgCode" placeholder="组织机构代码"
														class="form-control">
												</div>
											</div>
										</div>
									</div>
									<div id="moreZone">
										<!--  more zone -->



										<div class="row">
											<div class="innerDiv">
												<label for="form-field-9">单位描述</label>

												<textarea class="form-control limited" name="unitdesc"
													maxlength="500"></textarea>
											</div>
										</div>

										<div class="row">
											<div class="innerDiv">
												<label for="form-field-9">业务范围</label>

												<textarea class="form-control limited" name="sphereOfBus"
													maxlength="500"></textarea>
											</div>
										</div>

										<hr>

										<div class="row">

											<div class="col-xs-6">
												<div class="form-group">
													<label class="col-sm-4 control-label no-padding-right"
														for="form-field-1"> 证书编号</label>

													<div class="col-sm-8">
														<input type="text" name="certificateCode"
															placeholder="证书编号" class="form-control">
													</div>
												</div>
											</div>

											<div class="col-xs-6">
												<div class="form-group">
													<label class="col-sm-4 control-label no-padding-right"
														for="form-field-1"> 单位资质 </label>

													<div class="col-sm-8">
														<select style="width: 66px;" id="qualificationSelect"
															class="qulification required" name="qualification">
															<option value="">请选择</option>
															<option value="1">甲级</option>
															<option value="2">乙级</option>
															<option value="3">丙级</option>
															<option value="4">丁级</option>
														</select>
													</div>
												</div>
											</div>
										</div>


										<div class="row">

											<div class="col-xs-6">
												<div class="form-group">
													<label class="col-sm-4 control-label no-padding-right"
														for="form-field-1"> 法人</label>

													<div class="col-sm-8">
														<input type="text" name="legalPerson" placeholder="法人"
															class="form-control">
													</div>
												</div>
											</div>

											<div class="col-xs-6">
												<div class="form-group">
													<label class="col-sm-4 control-label no-padding-right"
														for="form-field-1"> 发证时间</label>

													<div class="col-sm-8">
														<!-- #section:plugins/date-time.datepicker -->
														<div class="input-group">
															<input class="form-control date-picker"
																placeholder="yyyy-mm-dd" name="certificateTime"
																type="text" data-date-format="yyyy-mm-dd"> <span
																class="input-group-addon"> <i
																class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-xs-6">
												<div class="form-group">
													<label class="col-sm-4 control-label no-padding-right"
														for="form-field-1"> 有效期</label>

													<div class="col-sm-8">
														<!-- #section:plugins/date-time.datepicker -->
														<div class="input-group">
															<input class="form-control date-picker"
																placeholder="yyyy-mm-dd" name="valiableTime" type="text"
																data-date-format="yyyy-mm-dd"> <span
																class="input-group-addon"> <i
																class="fa fa-calendar bigger-110"></i>
															</span>
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
									<!--  more zone -->
								</form>

								<!-- 注册信息结束 -->
							</div>

						</div>
						<div class="space"></div>
						
						<p>
											<button class="btn btn-primary btn-round" id="saveButten">
												<i class="ace-icon fa fa-floppy-o bigger-120 "></i>
												注册 
											</button>


											<button class="btn  btn-round">
												<i class="ace-icon fa fa-times "></i>
												取消
											</button>
										</p>
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
	
	<!-- 字数限制js -->
	<script type="text/javascript"
		src="static/ace/assets/js/jquery.inputlimiter.1.3.1.js"></script>
	
	<!-- 日期控件js -->
	<script src="static/ace/assets/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 弹出框插件js -->
	<script src="static/ace/assets/js/bootbox.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("select").addClass('pull-left');//将select左对齐
			
			//初始化城市信息
			initZone();
			//初始化日历
			initDatePicker();
			//保存用户事件
			initSaveEvent();
			//初始化特定事件
			initSpicefied();
			
			//字数限制
			$('textarea.limited').inputlimiter({
						remText: '还能输入 %n 个字',
						limitText: ',最多 : %n 字'
					});
			
		});
		
		function initSpicefied(){
			//甲级资质选择按钮 增加页面
			$("#qualificationSelect").on('change', function(e) {

				if(this.value == 1){//甲级资质  影藏按钮
					$("#deliverCitySelect").val('');
					$("#deliverProvenceSelect").val(52).trigger('change');
					$("#deliverProvenceSelect").attr("disabled","disabled");
					$("#deliverCitySelect").hide();
					$("#deliverDistinctSelect").hide("");
				}else{
					//显示所有的功能
						//打开按钮
						$("#deliverProvenceSelect").removeAttr("disabled");
						$("#deliverCitySelect").show();
						$("#deliverDistinctSelect").show();
				}
			});
		}
		
		function initSaveEvent(){
			$("#saveButten").on('click',function(){
				if(!validate())return ;//校验
				//提交表单
				$.ajax({
					url:'${contextPath}/user/save',
					type:'post',
					dataType:'json',
					data:$('form').serialize(),
					success:function(res){//res应该保存用户编号信息
						bootbox.dialog({
							message: "<span class='bigger-110'>注册成功 您的用户编号为 520100000002,请复制保存,等待管理人员审核</span>",
							buttons: 			
							{
								"button" :
								{
									"label" : "结束",
									"className" : "btn-sm btn-success",
									"callback": function() {
									}
								}
							}
						});
					},
					error:function(){alert('网络错误,请联系管理员!');}
				});
			});
		}
		
		
		
		//校验
		function validate(){
			//把所有带required class的input拿到
			var flag = true;
			$("#user-add-form").find('.required:input').each(function(){
				if(this.value == ''){
					alert('请填写此项');
					this.focus();
					flag = false;
					return false;
				}
			});
			if(!flag)return ;//停止方法执行
			$("#user-add-form").find(".number").each(function(){
				var reg = /^[1-9]\d*$/;
				if(!reg.test(this.value)){
					alert('只能填写数字 	');
					this.focus();
					flag = false;
					return false;
				}
			});

			return flag;
		}
		
		function initDatePicker(){
			//时间控件 汉化
			$.fn.datepicker.dates['en'] = {
				    days: ["日", "一", "二", "三", "四", "五", "六", "日"],
				    daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
				    daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
				    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
				    monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
				    today: "今天"
				};
			//时间控件
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
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
		
		function initSelect(){
			//初始化下拉框
			$(".province").each(function(){
				var province = $(this);//省级
				var selectCity = province.next();	//	市级
				var selectDistrict = selectCity.next();//县级
				province.empty();//清空所有内容
				//初始化省级菜单
				province.append('<option value="">请选择</option>"');
				for(var pro in allZone.province){
					province.append('<option value="'+ pro +'">' + allZone.province[pro]+'</option>"');
				}
				province.on('change',function(){
					//根据省code 初始化市级下拉菜单

					selectCity.empty();//清空市级下拉单
					selectDistrict.empty();//清空县级下拉单
					selectCity.append('<option value="">请选择</option>"');
					selectDistrict.append('<option value="">请选择</option>"');
					var cities = getCityByProvince(this.value);
					for(var city in cities){
						selectCity.append('<option value="'+ city.substr(2) +'">' + cities[city]+'</option>"');
					}
					
					//根据市code 初始化县级下拉菜单
					
					selectCity.on('change',function(){
						
						selectDistrict.empty();//清空所有内容
						
						var districts = getDistrictByCity(province.val() + selectCity.val());
						selectDistrict.append('<option value="">请选择</option>"');
						for(var district in districts){
							selectDistrict.append('<option value="'+ district.substr(4) +'">' + districts[district]+'</option>"');
						}
						
					});
				});
			});
		}
		
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
					initSelect();
					console.log(allZone);
				}
			});
		}
		
		
		
	</script>


</body>
</html>
