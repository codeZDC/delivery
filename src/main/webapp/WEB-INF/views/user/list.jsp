<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
</head>
<body>
	<div class="main-container">
		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">用户管理</h3>

				<div class="table-header" id="table-header">用户管理</div>

				<div>
					<div id="dynamic-table_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<div class="row">
							<div class="col-xs-6">
								<div class="btn-toolbar">
									<button class=" btn btn-info btn-sm" id="user-add">添加用户</button>
									<div class="btn-group">
										<button data-toggle="dropdown" id="switchUserButten"
											class="btn btn-primary btn-white dropdown-toggle"
											aria-expanded="false">
											切换用户<i class="ace-icon fa fa-angle-down icon-on-right"></i>
										</button>

										<ul class="dropdown-menu">
											<li><a href="#" onclick="switchUser(0);">普通用户</a></li>

											<li><a href="#" onclick="switchUser(1);">审核用户</a></li>

										</ul>
									</div>
								</div>

							</div>
							<!-- #弹出窗口    添加窗口 -->
							<%@include file="user-add.jsp"%>
							<%@include file="user-edit.jsp"%>

							<div class="col-xs-6">
								<p class="pull-right">
									<button id="searchButten"
										class="btn btn-primary btn-white btn-purple dropdown-toggle ">
										<i class="ace-icon fa fa-search"></i> 查询
									</button>

									<button id="userRight"
										class="btn btn-primary btn-white dropdown-toggle ">
										<i class="ace-icon fa fa-key"></i> 用户授权
									</button>
								</p>
							</div>

						</div>
						<!-- #弹出窗口   查询窗口-->
						<%@include file="user-search.jsp"%>
						<!-- #弹出窗口   查询窗口-->
						<%@include file="rightView.jsp"%>

						<table id="user-table"
							class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable center"
							role="grid" aria-describedby="dynamic-table_info">
							<thead>
								<tr role="row">
									<th class="center">序号</th>
									<th class="center">用户编号</th>
									<th class="center">用户状态</th>
									<th class="center">单位名称</th>
									<th class="center">汇交区域</th>
									<th class="center">单位资质</th>
									<th class="center">创建时间</th>
									<th class="center">操作</th>
								</tr>
							</thead>

							<tbody>
								<tr role="row" class="odd">
									<td class="center">1</td>
									<td><a href="#">52012330101</a></td>
									<td>贵州大白鲨xxxx公司</td>
									<td>贵州省贵阳市</td>
									<td>。。。。</td>
									<td>2015年</td>
									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											</a> <a class="green" href="#"> <i
												class="ace-icon fa fa-pencil bigger-130"></i>
											</a> <a class="red" href="#"> <i
												class="ace-icon fa fa-trash-o bigger-130"></i>
											</a>
										</div>

										<div class="hidden-md hidden-lg">
											<div class="inline pos-rel">
												<button class="btn btn-minier btn-yellow dropdown-toggle"
													data-toggle="dropdown" data-position="auto">
													<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
												</button>

												<ul
													class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
													<li><a href="#" class="tooltip-info"
														data-rel="tooltip" title="" data-original-title="View">
															<span class="blue"> <i
																class="ace-icon fa fa-search-plus bigger-120"></i>
														</span>
													</a></li>

													<li><a href="#" class="tooltip-success"
														data-rel="tooltip" title="" data-original-title="Edit">
															<span class="green"> <i
																class="ace-icon fa fa-pencil-square-o bigger-120"></i>
														</span>
													</a></li>

													<li><a href="#" class="tooltip-error"
														data-rel="tooltip" title="" data-original-title="Delete">
															<span class="red"> <i
																class="ace-icon fa fa-trash-o bigger-120"></i>
														</span>
													</a></li>
												</ul>
											</div>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<div class="row">
							<div class="col-xs-2">
								<div class="dataTables_length" id="dynamic-table_length">
									<label>总共显示 : <select id="pageSize-select"  class="form-control input-sm">
											<option value="5">5</option>
											<option value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> 条
									</label>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="dataTables_info" id="paginationMsg"
									role="status" aria-live="polite">显示  至 1条记录,总共 10 条</div>
							</div>
							<div class="col-xs-6">
								<div id="paginationBar"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- modal -->


		<jsp:include page="../../common/js.jsp"></jsp:include>

	</div>
	<!-- 引用对应的js -->
	<script type="text/javascript"
		src="${contextPath }/static/modules/user/user.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/modules/user/province_city_district.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/ace/assets/js/jquery-ui.custom.js"></script>
	<!-- 字数限制js -->
	<script type="text/javascript"
		src="${contextPath }/static/ace/assets/js/jquery.inputlimiter.1.3.1.js"></script>
	<script type="text/javascript">
		//添加鼠标上移弹出提示功能
		$('[data-rel=popover]').popover({container:'body'});
		//字数限制
		$('textarea.limited').inputlimiter({
					remText: '还能输入 %n 个字',
					limitText: ',最多 : %n 字'
				});
		
	</script>

</body>
</html>