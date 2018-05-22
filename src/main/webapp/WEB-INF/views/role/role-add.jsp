<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="role-add-modal" class="hide">
	<div class="row">
		<form class="form-horizontal" id="role-add-form"
			novalidate="novalidate">
			<div class="form-group">
				<label class="control-label col-sm-3  no-padding-right">角色名</label>

				<div class="col-xs-9 ">
					<div class="clearfix">
						<input type="text" name="roleName" id="roleName">
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label  col-sm-3 no-padding-right"
					for="platform">状态</label>

				<div class="col-sm-9">
					<div class="clearfix">
						<select class="input-medium" id="status" name="status">
							<option value="1">可用</option>
							<option value="0">停用</option>
						</select>
					</div>
				</div>
			</div>

			<div class="space-2"></div>

			<div class="form-group">
				<label class="control-label  col-sm-3 no-padding-right"
					for="comment">备注</label>

				<div class=" col-sm-9">
					<div class="clearfix">
						<textarea class="input-xlarge" name="remarks" id="remarks"
							style="margin: 0px;"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>