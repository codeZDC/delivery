<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<div class="">
	<div id="user-profile-3" class="user-profile row">
		<div class="col-sm-offset-1 col-sm-10">

			<form class="form-horizontal">
				<input type="hidden" name="id">
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
														<input class="col-sm-12 col-sm-10 required" type="text"
															name="xmmc"		id="projectName" placeholder="项目名称">
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">面积</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
															name="mj"	placeholder="面积"> <span class="help-button"
																data-rel="popover" data-trigger="hover"
																data-placement="left" data-content="单位为“平方公里”"
																title="填写帮助" data-original-title="">?</span>
														</div>
													</div>
												</div>


												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">比例尺</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
															name="blc"	placeholder="比例尺">
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成果种类</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
															name="cgzl"	placeholder="成果种类"> <span class="help-button"
																data-rel="popover" data-trigger="hover"
																data-placement="left" data-content="例如:地形图、影像图"
																title="填写帮助" data-original-title="">?</span>
														</div>
													</div>
												</div>


												<hr>
												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">坐标系统</label>

														<div class="col-sm-8">
															<select type="zbxt">
															</select> <input class="hide" type="text" name="zbxt"
																placeholder="坐标系统"> <span class="help-button"
																data-rel="popover" data-trigger="hover"
																data-placement="left"
																data-content="填录“1954年北京坐标系、“1980西安坐标系”或地方独立坐标系全称"
																title="填写帮助" data-original-title="">?</span>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">高程系统</label>

														<div class="col-sm-8">
															<select type="gcxt">
															</select> <input class="hide" type="text" name="gcxt"
																placeholder="高程系统"> <span class="help-button"
																data-rel="popover" data-trigger="hover"
																data-placement="left"
																data-content="填录“1956年黄海高程系”、“1985国家高程基准”或地方高程系全称"
																title="填写帮助" data-original-title="">?</span>
														</div>
													</div>
												</div>


												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成图方法</label>

														<div class="col-sm-8">
															<select type="ctff">
															</select> <input class="hide" type="text" name="ctff"
																placeholder="成图方法">
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
												<jsp:include page="fileUploadView.jsp"></jsp:include>

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
															<div class="input-medium">
																<div class="input-group">
																	<input class="input-medium date-picker required"
																		id="dateBegin" type="text" name="scksnd"
																		data-date-format="yyyy-mm-dd" placeholder="yyyy-mm-dd">
																	<span class="input-group-addon"> <i
																		class="ace-icon fa fa-calendar"></i>
																	</span>
																</div>
															</div>
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测完成年代</label>

														<div class="col-sm-8">
															<div class="input-medium">
																<div class="input-group">
																	<input class="input-medium date-picker required" name="scwcnd"
																		id="dateEnd" type="text"
																		data-date-format="yyyy-mm-dd" placeholder="yyyy-mm-dd">
																	<span class="input-group-addon"> <i
																		class="ace-icon fa fa-calendar"></i>
																	</span>
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">现势性</label>

														<div class="col-sm-8">
															<div class="input-medium">
																<div class="input-group">
																	<input class="input-medium date-picker required"
																	name="xsx"	id="form-field-date" type="text"
																		data-date-format="yyyy-mm-dd" placeholder="yyyy-mm-dd">
																	<span class="input-group-addon"> <i
																		class="ace-icon fa fa-calendar"></i>
																	</span>
																</div>
															</div>

														</div>
													</div>

												</div>
												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测单位名称</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
																name="scdwmc" id="scdwmc" placeholder="施测单位名称">
														</div>
													</div>
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">施测单位地址、联系人及电话</label>

														<div class="col-sm-8">
															<textarea class="form-control" id="scdwAddrAndContact"
																name="scdwContact" placeholder="施测单位地址、联系人及电话"></textarea>
														</div>
													</div>
												</div>


												<div class="row">

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成果保管单位名称</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
																name="cgbgdwmc" id="cgbgdwmc" placeholder="成果保管单位名称">
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">成果保管单位地址、联系人及电话</label>

														<div class="col-sm-8">
															<textarea class="form-control" id="cgbgAddrAndContact"
																name="cgbgdwContact" placeholder="成果保管单位地址、联系人及电话"></textarea>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">项目投资单位名称</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text"
																name="xmtzdwmc" id="xmtzdwmc" placeholder="项目投资单位名称">
														</div>
													</div>

													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">验收机构</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10" type="text" id="ysjg"
																name="ysjg" placeholder="验收机构">
														</div>
													</div>
												</div>

												<hr>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">测绘服务总值(万元)</label>

														<div class="col-sm-8">
															<input class="col-sm-12 col-sm-10 required number" type="text"
																name="chfwzz" id="xmtzdwmc" placeholder="测绘服务总值(万元)">
														</div>
													</div>

												</div>

												<div class="row">
													<div class="form-group col-sm-6">
														<label class="col-sm-4 control-label no-padding-right"
															for="form-field-username">备注</label>

														<div class="col-sm-8">
															<textarea class="form-control" id="cgbgAddrAndContact"
																name="remarks" placeholder="备注"></textarea>
														</div>
													</div>
												</div>

												<hr>

												<div class="row">
													<div class="form-group center">
														<label class="control-label no-padding-right">是否副本</label>

														<label class="inline"> <input value="0"
															name="iscopy" type="radio" class="ace"> <span
															class="lbl middle"> 是</span>
														</label> &nbsp; &nbsp; &nbsp; <label class="inline"> <input
															value="1" name="iscopy" type="radio" class="ace">
															<span class="lbl middle"> 否</span>
														</label>
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
				<div class="clearfix form-actions center">
					<div class=" ">
						<button class="btn btn-info submitForm" type="button">
							<i class="ace-icon fa fa-check bigger-110"></i> 保存
						</button>

						&nbsp; &nbsp;
						<button class="btn resetForm" type="button">
							<i class="ace-icon fa fa-undo bigger-110"></i> 重设
						</button>
					</div>
				</div>


			</form>
		</div>
	</div>


</div>