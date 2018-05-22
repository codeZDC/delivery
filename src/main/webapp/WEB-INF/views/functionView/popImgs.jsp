<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!-- 弹出全屏的空间  用于显示地图 -->
<div class="row hide" id="imgs-modal">
	<div class="col-sm-12 widget-container-col ui-sortable"
		style="min-height: 127px;">
		<!-- #section:custom/widget-box.options.transparent -->
		<div class="widget-box transparent ui-sortable-handle"
			style="opacity: 1;">
			<div class="widget-header">
				<h4 class="widget-title lighter">图片</h4>

				<div class="widget-toolbar no-border">
					<a href="#" data-action="fullscreen" class="orange2"> <i
						class="ace-icon fa fa-expand"></i>
					</a> <a href="#" data-action="close"> <i
						class="ace-icon fa fa-times hide"></i>
					</a>
				</div>
			</div>

			<div class="widget-body">
				<div class="widget-main">
					<!-- 图片显示区域 -->
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div>
							<ul class="ace-thumbnails clearfix" id="imgsPanel">
								<!-- #section:pages/gallery -->
								<li><a href="${contextPath}/static/ace/assets/images/gallery/image-2.jpg"
									data-rel="colorbox" class="cboxElement"> <img width="150"
										height="150" alt="150x150"
										src="${contextPath}/static/ace/assets/images/gallery/thumb-2.jpg">
										<div class="text">
											<div class="inner">点击查看大图</div>
										</div>
								</a></li>
								
								
								<li><a href="${contextPath}/static/ace/assets/images/gallery/image-1.jpg"
									data-rel="colorbox" class="cboxElement"> <img width="150"
										height="150" alt="150x150"
										src="${contextPath}/static/ace/assets/images/gallery/thumb-1.jpg">
										<div class="text">
											<div class="inner">点击查看大图</div>
										</div>
								</a></li>

							</ul>
						</div>
						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- 图片显示区域 -->
					
				</div>
			</div>
		</div>

		<!-- /section:custom/widget-box.options.transparent -->
	</div>
</div>