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
<link rel="stylesheet" href="${contextPath}/static/jquery/tree/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/static/jquery/tree/metroStyle/metroStyle.css" type="text/css">
	
</head>
<body>
	<div class="main-container" >
		<div class="row">
			<div class="col-xs-12">
				<h3 class="header smaller lighter blue">角色管理</h3>

				<div class="table-header">角色管理</div>

				<!-- div.table-responsive -->

				<!-- div.dataTables_borderWrap -->
				<div>
					<div id="dynamic-table_wrapper"
						class="dataTables_wrapper form-inline no-footer">
						<div class="row">
							<div class="col-xs-6">
								<button class=" btn btn-info btn-sm" id="role-add">添加角色</button>
							</div>
							<div class="col-xs-6 ">
								<div id="dynamic-table_filter" class="dataTables_filter">
									<label>搜索:<input type="search" id="searchInput"
										class="form-control input-sm" placeholder=""
										aria-controls="dynamic-table"></label>
								</div>
							</div>
							<!-- #弹出窗口  开始-->
							<%@include file="role-tree.jsp"%>
							<%@include file="role-add.jsp"%>
							<%@include file="role-edit.jsp"%>
							<!-- #弹出窗口 结束-->

							
						</div>
						<table id="roles"
							class="table table-striped table-bordered table-hover dataTable no-footer DTTT_selectable center"
							role="grid" aria-describedby="dynamic-table_info">
							<thead>
								<tr role="row">
									<th class="center">序号</th>
									<th class="center">角色名</th>
									<!-- <th class="center">角色等级</th> -->
									<th class="center">状态</th>
									<th class="center">备注</th>
									<th class="center">创建时间</th>
									<th class="center">操作</th>
								</tr>
							</thead>

							<tbody>
								<tr class="" role="row">
									<td class="center">1</td>
									<td><a href="#">管理员</a></td>
									<td>I</td>
									<td><span class="label label-success">可用</span> <span
										class="label label-danger">停用 </span></td>
									<td>用于后台管理</td>

									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="green" href="#"> <i
												class="ace-icon fa fa-pencil bigger-130"></i>
											</a> <a class="red" href="#"> <i
												class="ace-icon fa fa-trash-o bigger-130"></i>
											</a>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<div class="row">
							<div class="col-xs-2">
								<div class="dataTables_length" id="dynamic-table_length">
									<label>总共显示 : <select id="pageSizeSelect"  class="form-control input-sm">
											<option value="3">3</option>
											<option value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> 条
									</label>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="dataTables_info" id="paginationMsg"
									role="status" aria-live="polite">显示 1 至 10 条记录,总共 10 条</div>
							</div>
							<div class="col-xs-6">
								<div id="paginationBar"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<jsp:include page="../../common/js.jsp"></jsp:include>
	<!-- 树插件 -->
	<script src="${contextPath }/static/ace/assets/js/fuelux/fuelux.tree.js"></script>
	<script src="${contextPath }/static/ace/assets/js/ace/elements.treeview.js"></script>
	<script src="${contextPath }/static/ace/assets/js/ace/ace.js"></script>
	<!-- 引用对应的js -->
	<script type="text/javascript" src="${contextPath }/static/modules/role/role.js"></script>
	<script type="text/javascript" src="${contextPath }/static/modules/role/tree.js"></script>
	<script type="text/javascript" src="${contextPath}/static/jquery/tree/jquery.ztree.all.js"></script>
	
</body>
</html>