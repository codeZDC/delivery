<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<div class="">
	<div id="user-profile-3" class="user-profile row">
		<div class="col-sm-offset-1 col-sm-10">

			<form class="form-horizontal" id="validation-form">
				<div class="tabbable">
					<!-- 页头 开始 -->
					<ul class="nav nav-tabs padding-16">
						<li class="active"><a data-toggle="tab" href="#edit-basic"
							aria-expanded="true"> <i
								class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
								填写资料
						</a></li>

						<!-- <li class="hide"><a data-toggle="tab" href="#edit-settings"
							aria-expanded="false"> <i
								class="purple ace-icon fa fa-cog bigger-125"></i> Settings
						</a></li>

						<li class="hide"><a data-toggle="tab" href="#edit-password"
							aria-expanded="false"> <i
								class="blue ace-icon fa fa-key bigger-125"></i> Password
						</a></li> -->
					</ul>
					<!-- 页头  结束-->
					<div class="tab-content profile-edit-tab-content">
						<div id="edit-basic" class="tab-pane active">
							<div class="row">
								<div class="col-sm-12 widget-container-col ui-sortable">
									<!-- #section:custom/widget-box.options.transparent -->
									<div class="widget-box transparent ui-sortable-handle">
										<div class="widget-header">
											<h4 class="widget-title lighter">基本信息</h4>

											<div class="widget-toolbar no-border">
												<a href="#" data-action="collapse"> <i
													class="ace-icon fa fa-chevron-up"></i>
												</a>
											</div>
										</div>

										<div class="widget-body" style="display: block;">
											<div
												class="widget-main padding-6 no-padding-left no-padding-right">
												<!-- 基本信息 开始 -->
												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">项目名称</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="xmmc">xxxx项目</span>
															</div>
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">锁网名称</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="swmc">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>


												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">点数</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="point">xxxx项目</span>
															</div>
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">平均误差</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="pjwc">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>


												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">最弱边误差</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="zrbwc">xxxx项目</span>
															</div>
														</div>
													</div>

												</div>

												<hr>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">坐标系统</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="zbxt">xxxx项目</span>
															</div>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">高程系统</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="gcxt">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">等级</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="level">xxxx项目</span>
															</div>
														</div>
													</div>

												</div>

												<!-- 基本信息 结束 -->
											</div>
										</div>
									</div>
									<!-- /section:custom/widget-box.options.transparent -->
								</div>
							</div>


							<div class="row">
								<div class="col-sm-12 widget-container-col ui-sortable">
									<!-- #section:custom/widget-box.options.transparent -->
									<div class="widget-box transparent ui-sortable-handle">
										<div class="widget-header">
											<h4 class="widget-title lighter">文件区域</h4>

											<div class="widget-toolbar no-border">
												<a href="#" data-action="collapse"> <i
													class="ace-icon fa fa-chevron-up"></i>
												</a>
											</div>
										</div>

										<div class="widget-body" style="display: block;">
											<div
												class="widget-main padding-6 no-padding-left no-padding-right">
												<!-- 文件区域  开始 -->
												<div class="row">
													<div class="form-group col-sm-12">
														<input type="hidden" name="area"> <label
															class="col-sm-3 control-label pull-left"
															for="form-field-username">范围</label>

														<div class="col-sm-9">
															<div class="form-group">

																<div class="col-sm-10">
																	<button class="btn btn-info" type="button" id="viewMap">
																		<i class="ace-icon fa fa-globe bigger-110"></i> 查看地图
																	</button>
																</div>
																<div class="col-sm-2"></div>

															</div>
														</div>
													</div>

												</div>

												<div class="row">
													<div class="form-group col-sm-12">
														<input type="hidden" name="zlzk"> <label
															class="col-sm-3 control-label pull-left"
															for="form-field-username">质量状况</label>

														<div class="col-sm-9">
															<div class="form-group">

																<div class="col-sm-10">


																	<button class="btn btn-info" type="button"
																		id="viewImgs">
																		<i class="ace-icon fa fa-image bigger-110"></i> 查看图片
																	</button>

																</div>
																<div class="col-sm-2"></div>

															</div>
														</div>

													</div>
												</div>

												<!-- 文件区域  结束 -->
											</div>
										</div>
									</div>
									<!-- /section:custom/widget-box.options.transparent -->
								</div>
							</div>


							<div class="row">
								<div class="col-sm-12 widget-container-col ui-sortable">
									<!-- #section:custom/widget-box.options.transparent -->
									<div class="widget-box transparent ui-sortable-handle">
										<div class="widget-header">
											<h4 class="widget-title lighter">通用区域</h4>

											<div class="widget-toolbar no-border">
												<a href="#" data-action="collapse"> <i
													class="ace-icon fa fa-chevron-up"></i>
												</a>
											</div>
										</div>

										<div class="widget-body" style="display: block;">
											<div
												class="widget-main padding-6 no-padding-left no-padding-right">
												<!-- 通用区域 开始 -->
												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测开始年代</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="scksnd">xxxx项目</span>
															</div>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测完成年代</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="scwcnd">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>


												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测单位名称</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="scdwmc">xxxx项目</span>
															</div>
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测单位地址、联系人及电话</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="scdwContact">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>


												<div class="row">

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成果保管单位名称</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="cgbgdwmc">xxxx项目</span>
															</div>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成果保管单位地址、联系人及电话</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="cgbgdwContact">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">项目投资单位名称</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="xmtzdwmc">xxxx项目</span>
															</div>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">验收机构</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="ysjg">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>

												<hr>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">测绘服务总值(万元)</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="chfwzz">xxxx项目</span>
															</div>
														</div>
													</div>

												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">备注</label>

														<div class="col-sm-8">
															<div class="profile-info-value">
																<span class="editable editable-click" name="remarks">xxxx项目</span>
															</div>
														</div>
													</div>
												</div>

												<hr>

												<div class="row">
													<div class="form-group center">
														<label class="control-label no-padding-right">是否副本</label>

														<span class="lbl middle" name="iscopy"> 是</span>
													</div>
												</div>

												<!-- 通用区域 结束 -->
											</div>
										</div>
									</div>
									<!-- /section:custom/widget-box.options.transparent -->
								</div>
							</div>



						</div>
					</div>
				</div>


			</form>
		</div>
	</div>


</div>