<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填报 主界面</title>
<jsp:include page="../../common/css.jsp"></jsp:include>
</head>
<body class="no-skin">
	<div class="main-container">
		<div class="page-content">
			<div class="page-header">
				<h1>
					汇交审批
					<i class="ace-icon fa fa-angle-double-right"></i>
					<small id="grade">
						<!-- 根据角色显示 -->
					</small>
				</h1>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<!-- #section:elements.tab -->
					<div class="tabbable">
						<ul class="nav nav-tabs" id="myTab">
							<!-- <li class="dropdown active">
								<a data-toggle="dropdown"  title="" 
									class="dropdown-toggle" href="#" aria-expanded="false"> 贵阳市
										&nbsp; <i class="ace-icon fa fa-caret-down bigger-110 width-auto"></i>
										<span  class="badge badge-danger">4</span>
								</a>
								<ul class="dropdown-menu dropdown-info">
									<li class=""><a>贵阳市</a></li>
									<li class=""><a>云岩区</a></li>

									<li class=""><a>花溪区</a></li>
								</ul>
							</li>
							
							<li class="dropdown ">
							<a data-toggle="dropdown"  title="" 
								class="dropdown-toggle" href="#" aria-expanded="false"> 六盘水
									&nbsp; <i
									class="ace-icon fa fa-caret-down bigger-110 width-auto"></i>
									<span 
									class="badge badge-danger tooltip-error">4</span>
							</a>

								<ul class="dropdown-menu dropdown-info">
									<li class=""><a data-toggle="tab" href="#cityView"
										aria-expanded="false">六盘水</a></li>
									<li class=""><a data-toggle="tab" href="#cityView"
										aria-expanded="false">盘县</a></li>

									<li class=""><a data-toggle="tab" href="#cityView"
										aria-expanded="false">六枝</a></li>
								</ul>
							</li> -->

						</ul>

						<div class="tab-content">
							<div id="cityView" class="tab-pane fade in active">
								<%@include file="citiesView.jsp" %>
							</div>

							<div id="deliverList" class="tab-pane fade"></div>

							<div id="ssss" class="tab-pane fade">
								<input data-rel="tooltip" type="text" id="form-field-6" >
							</div>
						</div>
					</div>

					<!-- /section:elements.tab -->
				</div>
			</div>
		</div>
	</div>
	<!-- 公共js -->
	<jsp:include page="../../common/js.jsp"></jsp:include>
	<!--上移提示 -->

	<!-- 对应的js -->
	<script type="text/javascript"
		src="${contextPath }/static/modules/examinie/examinie.js"></script>
		

</body>
</html>