<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="../../common/css.jsp"></jsp:include>
</head>
<body>
	<div class="main-container">
		<input type="hidden" id="deliveryType" value="${param.type}">
		<input type="hidden" id="handle" value="save">
		<div class="page-content">
			<div class="page-header">
				<h1>
					<span id="headerTitle"></span><small> <i
						class="ace-icon fa fa-angle-double-right"></i> 网上填报测绘成果目录
					</small>
				</h1>
			</div>

			<!-- 根据传过来的参数 加载页面 -->
			<jsp:include page="${param.type}.jsp"></jsp:include>
		</div>
	</div>
	<!-- 公共js -->
	<jsp:include page="../../common/js.jsp"></jsp:include>
	<!-- 对应的js -->
	<script type="text/javascript"
		src="${contextPath }/static/modules/12templates/common.js"></script>

	<!-- 文件上传	控件 -->
	<script
		src="${contextPath }/static/ace/assets/js/ace/elements.fileinput.js"></script>
	<!-- ace支持js -->
	<script src="${contextPath }/static/ace/assets/js/ace/ace.js"></script>
	<!-- widgets插件 -->
	<script
		src="${contextPath }/static/ace/assets/js/ace/ace.widget-box.js"></script>
</body>
</html>