<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${contextPath }" target="iframe_body" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>贵州测绘成果目录汇交系统</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="static/ace/assets/css/bootstrap.css" />
<link rel="stylesheet" href="static/ace/assets/css/font-awesome.css" />

<!-- 显示图片 plugin styles -->
<link rel="stylesheet"
	href="${contextPath }/static/ace/assets/css/colorbox.css" />
<!-- alert styles -->
<link rel="stylesheet" href="static/ace/assets/css/jquery.gritter.css">
<!-- ace styles -->
<link rel="stylesheet" href="static/ace/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />


<!-- jquaryUI styles -->
<link href="${contextPath }/static/ace/assets/css/jquery-ui.css"
	rel="stylesheet">

</head>

<body class="no-skin">

	<input type="hidden" id="contextPath" value="${contextPath }">

	<!-- 头部的工具条 -->
	<!-- #section:basics/navbar.layout -->
	<%@include file="WEB-INF/common/navbar.jsp"%>
	<!-- /section:basics/navbar.layout -->

	<div class="main-container" id="main-container">
		<!-- 用于弹出全屏的控件-->
		<!-- 地图-->
		<%@include file="WEB-INF/views/functionView/popMap.jsp"%>
		<!-- 图片-->
		<%@include file="WEB-INF/views/functionView/popImgs.jsp"%>

		<!-- 汇交清单-->
		<!--startprint-->
		<%@include file="WEB-INF/views/examinie/deliverList.jsp"%>
		<!--endprint-->
		<!-- 查看12种模板-->
		<%@include file="WEB-INF/views/12templatesView/popView.jsp"%>
		<!-- 用于弹出全屏的控件-->


		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<!-- 左边的菜单栏 -->
		<!-- #section:basics/sidebar -->
		<%@include file="WEB-INF/common/sidebar.jsp"%>
		<!-- /section:basics/sidebar -->


		<div class="main-content">
			<%@include file="WEB-INF/common/guider.jsp"%>
			<iframe name="iframe_body" src="" width="100%" frameborder="no" id="mainIframe"></iframe>
		</div>
		<!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<!-- #section:basics/footer -->
				<%-- <%@include file="WEB-INF/common/footer.jsp" %> --%>
				<!-- /section:basics/footer -->
			</div>
		</div>

		<!-- 页面样式控制器,,需要时添加 -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
			window.jQuery || document.write("<script src='static/ace/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

	<!-- <![endif]-->

	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='static/ace/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
	<script src="static/ace/assets/js/bootstrap.js"></script>

	<!-- page specific plugin scripts -->

	<!-- widgets插件 -->
	
	<script src="${contextPath}/static/ace/assets/js/jquery-ui.js"></script>
	<script type="text/javascript"
		src="${contextPath }/static/ace/assets/js/jquery-ui.custom.js"></script>
	<script
		src="${contextPath }/static/ace/assets/js/ace/ace.widget-box.js"></script>

	<!-- gritter alert插件 -->
	<script src="${contextPath }/static/ace/assets/js/jquery.gritter.js"></script>

	<!-- 图片插件 plugin scripts -->
	<script src="${contextPath }/static/ace/assets/js/jquery.colorbox.js"></script>

	
	
	<!-- ace scripts -->
	<script src="static/ace/assets/js/ace/ace.js"></script>
	<script src="static/ace/assets/js/ace/ace.sidebar.js"></script>
	<script src="static/ace/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<!-- index scripts -->
	<script type="text/javascript" src="${contextPath }/static/modules/index/index.js"></script>
	<!--加上这句话-->
	 <OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0" id="WebBrowser3" width="0" VIEWASTEXT>
	 </OBJECT>
</body>
</html>
