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
<link href="${contextPath }/static/ace/assets/css/jquery-ui.css"
	rel="stylesheet">
</head>
<body>
	<div class="main-container">
		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">菜单管理</h3>

				<div class="table-header">菜单管理</div>

				<!-- div.table-responsive -->

				<!-- div.dataTables_borderWrap -->
				<div>
					<div id="dynamic-table_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<div class="row">
							<div class="col-xs-2">
								<button class=" btn btn-info btn-sm" id="menu-add">添加菜单</button>
							</div>
							<div class="col-xs-6 col-md-offset-4">
								<div id="dynamic-table_filter" class="dataTables_filter">
									<label>搜索:<input type="search" id="searchInput"
										class="form-control input-sm" placeholder="按菜单名搜索"
										aria-controls="dynamic-table"></label>
								</div>
							</div>
						</div>
						<!-- #弹出窗口    添加窗口 -->
						<%@include file="menu-edit.jsp"%>
						<%@include file="menu-add.jsp"%>
						<table id="menus"
							class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable center"
							role="grid" aria-describedby="dynamic-table_info">
							<thead>
								<tr role="row">
									<th class="center">序号</th>
									<th class="center">菜单名</th>
									<th class="center">菜单图标</th>
									<th class="center">父菜单名称</th>
									<th class="center">备注</th>
									<th class="center">创建时间</th>
									<th class="center">操作</th>
								</tr>
							</thead>

							<tbody>
								<!-- <tr role="row" class="odd">
									<td class="center">1</td>
									<td><a href="#">app.com</a></td>
									<td>$45</td>
									<td class="hidden-480">3,330</td>
									<td>Feb 12</td>

									<td class="hidden-480"><span
										class="label label-sm label-warning">Expiring</span></td>

									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="blue" href="#"> <i
												class="ace-icon fa fa-search-plus bigger-130"></i>
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
								</tr> -->
							</tbody>
						</table>
						<div class="row">
							<div class="col-xs-2">
								<div class="dataTables_length" id="dynamic-table_length">
									<label>总共显示 : <select id="pageSizeSelect" class="form-control input-sm">
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
									role="status" aria-live="polite">显示 1 至 10 条记录,总共 23 条</div>
							</div>
							<div class="col-xs-6">
								<div  id="paginationBar"> </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div id="modal" style="display: none"></div> -->
		<jsp:include page="../../common/js.jsp"></jsp:include>
	</div>
	<script type="text/javascript"
		src="${contextPath }/static/modules/menu/menu.js"></script>
</body>
</html>