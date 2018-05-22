<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
<link rel="stylesheet"
	href="${contextPath }/static/ace/assets/css/bootstrap-editable.css" />
</head>
<body>
	<div class="main-container">
		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">个人中心</h3>
				<div class="col-xs-12 col-sm-9">
					<h4 class="blue"> 用户编号 : 
						<span class="middle">${SESSION_USER.username }</span> <span
							class="label label-success arrowed-in-right"> <i
							class="ace-icon fa fa-circle smaller-80 align-middle"></i> 可用
						</span>
					</h4>
					<div id="user-add-modal">

						<!-- PAGE CONTENT BEGINS -->
						<form id="user-add-form" class="form-horizontal" role="form">
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 单位名称 </label>

										<div class="col-sm-8">
											<input type="text" name="unitName" placeholder="单位名称" value="${SESSION_USER.unitName }"
												class="form-control required">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-2">密码</label>

										<div class="col-sm-8">
											<input type="password" name="password" placeholder="密码" value="${SESSION_USER.password }"
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
											<input type="text" name="contact" placeholder="联系人,姓名如:王五" value="${SESSION_USER.contact }"
												class="form-control required">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 联系电话 </label>

										<div class="col-sm-8">
											<input type="text" name="telephone" value="${SESSION_USER.telephone }"
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
											<input type="text" name="phoneNumber" value="${SESSION_USER.phoneNumber }"
												placeholder="手机 13xxxxxxxxx" class="form-control required">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 邮编 </label>

										<div class="col-sm-8">
											<input type="text" name="zipCode" placeholder="邮编" value="${SESSION_USER.zipCode }"
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
											<input type="text" name="fax" placeholder="传真" value="${SESSION_USER.fax }"
												class="form-control">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 单位性质 </label>

										<div class="col-sm-8">
											<input type="text" name="unitProperty" placeholder="单位性质" value="${SESSION_USER.unitProperty }" readonly='readonly'
												class="form-control">
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
											<input type="text" name="admZone" placeholder="行政区域" value="${SESSION_USER.admZone }" readonly='readonly'
												class="form-control">
											 <input type="hidden" name="${SESSION_USER.admZone }">
										</div>
									</div>
								</div>
								<div class="col-xs-6 delivery">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 汇交区域 </label>

										<div class="col-sm-8">
											<input type="text" name="deliveryZone" placeholder="行政区域" value="${SESSION_USER.deliveryZone }" readonly='readonly'
												class="form-control">
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
											<input type="text" name="workAddr" placeholder="办公地址" value="${SESSION_USER.workAddr }"
												class="form-control">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<label class="col-sm-4 control-label no-padding-right"
											for="form-field-1"> 单位地址</label>

										<div class="col-sm-8">
											<input type="text" name="unitAddr" placeholder="单位地址" value="${SESSION_USER.unitAddr }"
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
											<input type="text" name="orgCode" placeholder="组织机构代码" value="${SESSION_USER.orgCode }" readonly='readonly'
												class="form-control">
										</div>
									</div>
								</div>
							</div>
							<div id="moreZone">
								<!--  more zone -->

								<div class="row">
									<div>
										<label for="form-field-9">单位描述</label>

										<textarea class="form-control limited" name="unitdesc" value=""
											maxlength="500">${SESSION_USER.unitdesc }</textarea>
									</div>
								</div>

								<div class="row">
									<div>
										<label for="form-field-9">业务范围</label>

										<textarea class="form-control limited" name="sphereOfBus" value=""
											maxlength="500">${SESSION_USER.sphereOfBus }</textarea>
									</div>
								</div>

								<hr>

								<div class="row">

									<div class="col-xs-6">
										<div class="form-group">
											<label class="col-sm-4 control-label no-padding-right"
												for="form-field-1"> 证书编号</label>

											<div class="col-sm-8">
												<input type="text" name="certificateCode" placeholder="证书编号" value="${SESSION_USER.certificateCode }" readonly="readonly"
													class="form-control">
											</div>
										</div>
									</div>

									<div class="col-xs-6">
										<div class="form-group">
											<label class="col-sm-4 control-label no-padding-right"
												for="form-field-1"> 单位资质 </label>

											<div class="col-sm-8">
												<input type="text" name="qualification" placeholder="单位资质" value="${SESSION_USER.qualification }" readonly="readonly">
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
												<input type="text" name="legalPerson" placeholder="法人" value="${SESSION_USER.legalPerson }"
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
													<input class="form-control" value="<fmt:formatDate type="date" pattern="yyyy年MM月dd日" value="${SESSION_USER.certificateTime }" />"
														placeholder="yyyy-mm-dd" name="certificateTime" readonly="readonly"
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
													<input class="form-control " value="<fmt:formatDate type="date" pattern="yyyy年MM月dd日" value="${SESSION_USER.valiableTime }" />"
														placeholder="yyyy-mm-dd" name="valiableTime" type="text" readonly="readonly"
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


					</div>

					<div class="profile-user-info">

						<div class="row">
							<button class="btn btn-white btn-info btn-bold" onclick="save();">
								<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 修改
							</button>
						</div>
					</div>


				</div>

			</div>

		</div>

	</div>
	<jsp:include page="../../common/js.jsp"></jsp:include>
	<!-- 可编辑插件js -->
	<script
		src="${contextPath }/static/ace/assets/js/x-editable/bootstrap-editable.js"></script>
	<script
		src="${contextPath }/static/ace/assets/js/x-editable/ace-editable.js"></script>
	<!-- 基础js -->
	<script src="${contextPath }/static/ace/assets/js/ace/ace.js"></script>
	<!-- 字数限制js -->
	<script type="text/javascript"
		src="${contextPath }/static/ace/assets/js/jquery.inputlimiter.1.3.1.js"></script>
	<!-- 引用对应的js -->
	<script type="text/javascript">
		/* //editables on first profile page
		$.fn.editable.defaults.mode = 'inline';
		$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
		$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'
				+ '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>';

		$('#password').editable({
			type : 'password',
			name : 'password'
		});

		$('#contact').editable({
			type : 'text',
			name : 'contact'
		});

		$('#phone').editable({
			type : 'text',
			name : 'phone'
		});

		$('#address').editable({
			type : 'text',
			name : 'address'
		}); */
		
		$(function(){
			initInfo();
			
			//字数限制
			$('textarea.limited').inputlimiter({
						remText: '还能输入 %n 个字',
						limitText: ',最多 : %n 字'
					});
			
		});
		
		/**
		*修改信息   
		*/
		function initInfo(){ 
			var unitProperty = $("input[name='unitProperty']");//单位性质
			unitProperty.val(getunitProperty(unitProperty.val()));
			//top.allZone
			var admZone = $("input[name='admZone']");
			admZone.val(top.allZone[admZone.val()]);
			
			var deliveryZone = $("input[name='deliveryZone']");
			deliveryZone.val(top.allZone[deliveryZone.val()]);
			
			var qualification = $("input[name='qualification']");
			qualification.val(getQualification(qualification.val()));
			  
		} 
		
		//获取单位性质
		function getunitProperty(unitProperty){
			if(unitProperty == 1) return '国有企业';
			if(unitProperty == 2) return '民营企业';
			if(unitProperty == 3) return '事业单位';
		}
		
		//获取单位资质
		function getQualification(qualification){
			if(qualification == 1) return '甲级';
			if(qualification == 2) return '乙级';
			if(qualification == 3) return '丙级';
			if(qualification == 4) return '丁级';
		}

		//保存
		function save() {
			var data = {};
			data.id = $
			{
				SESSION_USER.id
			}
			;
			data.phoneNumber = $('#phone').editable('getValue', true);
			data.password = $('#password').editable('getValue', true);
			data.contact = $('#contact').editable('getValue', true);
			data.unitAddr = $('#address').editable('getValue', true);
			if (data.password == '') {
				alert('密码不能为空');
				$('#password').focus();
				return;
			}
			$.post(contextPath + "/user/edit", data, function(res) {
				if (res.success) {
					alert('信息修改成功');
					for ( var key in data) {
						$('#' + key).text(data[key]);
					}
				} else {
					alert('网络异常,请联系管理员!');
				}
			}, 'json');
		}
	</script>

</body>
</html>