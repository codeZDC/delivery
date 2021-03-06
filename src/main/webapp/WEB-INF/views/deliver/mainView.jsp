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
<body>
	<div class="main-container">
		<div class="page-content">
			<div class="page-header">
				<h1>
					汇交办理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
						网上填报测绘成果目录
					</small>
				</h1>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<!-- #section:elements.tab -->
					<div class="tabbable">
						<ul class="nav nav-tabs" id="myTab">
							<li id="addTanContent" class="hide"><a data-toggle="tab" href="#add"> <i
									class="green ace-icon fa fa-plus bigger-120"></i> 添加
							</a></li>

							<li><a data-toggle="tab" href="#draft" class="hide">
								<i class="purple ace-icon fa fa-archive bigger-120"></i>
								 草稿箱 <span
									class="badge badge-danger">4</span>
							</a></li>


							<li class="active" id="listTabContent"><a data-toggle="tab" href="#deliverList" id="ssss">
								<i class="ace-icon fa fa-list-alt icon-animated-wrench"></i>
									汇交清单<span class="badge badge-danger">_</span>
							</a></li>

						</ul>

						<div class="tab-content">
							<div id="add" class="tab-pane fade">
								<%@include file="choseType.jsp"%>
							</div>

							<div id="draft" class="tab-pane fade">
								<%@include file="draftList.jsp"%>
							</div>

							<div id="deliverList" class="tab-pane fade in active">
								<%@include file="deliverList.jsp"%>
							</div>

							<div id="dropdown2" class="tab-pane fade">
								<p>Trust fund seitan letterpress, keytar raw denim keffiyeh
									etsy art party before they sold out master cleanse gluten-free
									squid scenester freegan cosby sweater. Fanny pack portland
									seitan DIY, art party locavore wolf cliche high life echo park
									Austin.</p>
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
	<!-- 对应的js -->
	<script type="text/javascript"
		src="${contextPath }/static/modules/deliver/deliver.js"></script>

	<!-- 字数限制js -->
	<script type="text/javascript"
		src="${contextPath }/static/ace/assets/js/jquery.inputlimiter.1.3.1.js"></script>

	<script type="text/javascript">
		//字数限制
		$('textarea.limited').inputlimiter({
			remText : '还能输入 %n 个字',
			limitText : ',最多 : %n 字'
		});

	</script>
</body>
</html>