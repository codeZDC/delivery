<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 弹出全屏的空间  用于显示地图 -->
<div class="row hide" id="map-modal">
	<div class="col-sm-12 widget-container-col ui-sortable"
		style="min-height: 127px;">
		<!-- #section:custom/widget-box.options.transparent -->
		<div class="widget-box transparent ui-sortable-handle"
			style="opacity: 1;">
			<div class="widget-header">
				<h4 class="widget-title lighter">地图</h4>

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
					<!-- 显示地图开始 -->
						<iframe id="mapIframe" src="mapView.jsp" width="100%" height="700"  frameborder="no" ></iframe>
					
					
					<!-- 显示地图结束 -->

				</div>
			</div>
		</div>
		<script type="text/script">
			$('#mapIframe').height($(window).height());
		</script>

		<!-- /section:custom/widget-box.options.transparent -->
	</div>
</div>