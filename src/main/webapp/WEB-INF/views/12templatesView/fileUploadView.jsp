<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<div class="row">
	<div class="form-group col-sm-12">
		<input type="hidden" name="area">
		<input type="hidden" name="type" value="${param.type}">
		<label class="col-sm-3 control-label pull-left"
			for="form-field-username">范围</label>
		
		<div class="col-sm-9">
			<div class="form-group">
				<div class="col-sm-6">
					<label class="ace-file-input ace-file-multiple"> <input
						multiple="" type="file" id="shpFile"> <a class="remove"
						href="#"> <i class=" ace-icon fa fa-times"></i></a>
					</label>
	
				</div>
				<div class="col-sm-6">
					<button class="btn btn-info" type="button" id="viewMap">
						<i class="ace-icon fa fa-globe bigger-110"></i> 查看地图
					</button>
				</div>

			</div>
		</div>
	</div>

</div>

<hr>

<div class="row">
	<div class="form-group col-sm-12">
		<input type="hidden" name="zlzk">
		<label class="col-sm-3 control-label pull-left"
			for="form-field-username">质量状况</label>
		
		<div class="col-sm-9">
			<div class="form-group">
				<div class="col-sm-6">
					<label class="ace-file-input ace-file-multiple"> <input
						multiple="" type="file" id="qualityFile"> <a
						class="remove" href="#"> <i class=" ace-icon fa fa-times"></i></a>
					</label>

				</div>
				<div class="col-sm-6">
					<button class="btn btn-info" type="button">
						<i class="ace-icon fa fa-cloud-upload bigger-110"></i> 上传
					</button>
					
					<button class="btn btn-info" type="button" id="viewImgs">
						<i class="ace-icon fa fa-image bigger-110"></i> 查看图片
					</button>

				</div>

			</div>
		</div>

	</div>
</div>