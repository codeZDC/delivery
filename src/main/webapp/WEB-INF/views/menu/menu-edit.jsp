<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu-edit-modal" class="hide overflowHidden">
	<!-- PAGE CONTENT BEGINS -->
	<form class="form-horizontal" id="menu-edit-form" role="form">
		<input type="hidden" name="id">
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 菜单名</label>
				<div class="col-sm-9">
					<input type="text" name="name" placeholder="菜单名" >
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1-1"> 备注</label>

				<div class="col-sm-9">
					<input type="text" name="remarks" placeholder="备注" >
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 父级菜单 </label>
				<div class="col-sm-9">
					<select name="pid" >
						<option value="0">无</option>
					</select> 
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 菜单图标 </label>

				<div class="col-sm-9">
					<select name="icon">
						<option value="0">请选择</option>
						<option value="car">车</option>
						<option value="bank">银行</option>
						<option value="bell">闹钟</option>
						<option value="book">书</option>
						<option value="pencil">编辑(笔)</option>
					</select>
					&nbsp;&nbsp;&nbsp;
					<span class='show-icon  bigger-160'><i class=""></i></span>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1"> 创建时间</label>
				<div class="col-sm-9">
					<input type="text" readonly="readonly" name="createdTime" placeholder="菜单名">
				</div>
			</div>
		</div>
	</form>
</div>