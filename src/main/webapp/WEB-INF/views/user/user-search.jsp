<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 查询界面 -->
<div id="user-search-modal" class="hide">
	<!-- PAGE CONTENT BEGINS -->
	<form class="form-horizontal" id="user-search-form" role="form">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 单位名称</label>

				<div class="col-sm-9">
					<input type="text" id="unitname1" name="unitName" placeholder="单位名称"
						class="form-control">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1-1"> 用户名</label>

				<div class="col-sm-9">
					<input type="text" name="username" id="usernameSearch" placeholder="用户名"
						class="form-control">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 汇交区域 </label>

				<div class="col-sm-9 delivery">
					<select class="province pcd">
						<option value="" class="no">请选择</option>
						<option value="52">贵州省</option>
					</select> 
					<select  class="city pcd">
						<option class="no" value="">请选择</option>
					</select> 
					<select class="district pcd">
						<option class="no" value="">请选择</option>
					</select>
					<input type="hidden" name="deliveryZone">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 用户资质 </label>

				<div class="col-sm-9">
					<select name="qualification">
						<option value="">请选择</option>
						<option value="1">甲级</option>
						<option value="2">乙级</option>
						<option value="3">丙级</option>
						<option value="4">丁级</option>
					</select> 
				</div>
			</div>
		</div>
	</form>
</div>