<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="user-add-modal" class="hide">

	<!-- PAGE CONTENT BEGINS -->
	<form id="user-add-form" class="form-horizontal" role="form">
		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 单位名称 </label>

					<div class="col-sm-8">
						<input type="text" name="unitName"
							placeholder="单位名称" class="form-control required">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-2">密码</label>

					<div class="col-sm-8">
						<input type="password" name="password"
							placeholder="密码" class="form-control required">
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 联系人 </label>

					<div class="col-sm-8">
						<input type="text"  name="contact"
							placeholder="联系人,姓名如:王五" class="form-control required">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 联系电话 </label>

					<div class="col-sm-8">
						<input type="text" name="telephone"
							placeholder="联系电话:如 0851-8888888" class="form-control">
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 手机 </label>

					<div class="col-sm-8">
						<input type="text" name="phoneNumber"
							placeholder="手机 13xxxxxxxxx" class="form-control required">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 邮编 </label>

					<div class="col-sm-8">
						<input type="text" name="zipCode" placeholder="邮编"
							class="form-control">
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 传真 </label>

					<div class="col-sm-8">
						<input type="text"  name="fax" placeholder="传真"
							class="form-control">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 单位性质 </label>

					<div class="col-sm-8">
						<select  name="unitProperty required">
							<option value="">请选择</option>
							<option value="1">国有企业</option>
							<option value="2">民营企业</option>
							<option value="3">事业单位</option>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6">
				<div class="form-group administration">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 行政区域</label>

					<div class="col-sm-8">
						<select class="province pcd required" error-tip="请填选择行政区域">
							<option value="" class="no ">请选择</option>
						</select> <select class="city pcd">
							<option value="" class="no">请选择</option>
						</select> <select class="district pcd">
							<option value="" class="no">请选择</option>
						</select> <input type="hidden" name="admZone">
					</div>
				</div>
			</div>
			<div class="col-xs-6 delivery">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 汇交区域 </label>

					<div class="col-sm-8">
						<select class="province pcd required" error-tip="请填选择汇交区域" id="deliverProvenceSelect">
							<option value="" class="no" >请选择</option>
							<option value="52">贵州省</option>
						</select> <select class="city pcd " id="deliverCitySelect">
							<option value="" class="no">请选择</option>
						</select> <select class="district pcd" id="deliverDistinctSelect">
							<option value="" class="no">请选择</option>
						</select> <input type="hidden" name="deliveryZone"> <span id="examinerAdd"
							class="help-button" data-rel="popover" data-trigger="hover"
							data-placement="left" data-content="暂无审批人"
							title="" data-original-title="">审</span>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 办公地址 </label>

					<div class="col-sm-8">
						<input type="text" name="workAddr"
							placeholder="办公地址" class="form-control">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 单位地址</label>

					<div class="col-sm-8">
						<input type="text" name="unitAddr"
							placeholder="单位地址" class="form-control">
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1"> 组织机构代码</label>

					<div class="col-sm-8">
						<input type="text" name="orgCode"
							placeholder="组织机构代码" class="form-control">
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-sm-4 control-label no-padding-right"
						for="form-field-1">用户类型 </label>

					<div class="col-sm-2">
						<select name="userType" id="userTypeSelect">
							<option value="0">普通用户</option>
							<option value="1">审核用户</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="col-sm-6 control-label no-padding-right"
							for="form-field-1">用户角色 </label>
						<div class="col-sm-6">
							<select name="roleId" class="required" error-tip="请填选择用户角色">
								<option value="">请选择</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="moreZone"> <!--  more zone -->



			<div class="row">
				<div>
					<label for="form-field-9">单位描述</label>

					<textarea class="form-control limited" 
						name="unitdesc" maxlength="500"></textarea>
				</div>
			</div>

			<div class="row">
				<div>
					<label for="form-field-9">业务范围</label>

					<textarea class="form-control limited" 
						name="sphereOfBus" maxlength="500"></textarea>
				</div>
			</div>

			<hr>

			<div class="row">

				<div class="col-xs-6">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> 证书编号</label>

						<div class="col-sm-8">
							<input type="text"  name="certificateCode"
								placeholder="证书编号" class="form-control">
						</div>
					</div>
				</div>

				<div class="col-xs-6">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> 单位资质 </label>

						<div class="col-sm-8">
							<select style="width: 66px;" id="qualificationSelect" class="qulification required" error-tip="请填写单位资质"
								name="qualification">
								<option value="">请选择</option>
								<option value="1">甲级</option>
								<option value="2">乙级</option>
								<option value="3">丙级</option>
								<option value="4">丁级</option>
							</select>
						</div>
					</div>
				</div>
			</div>


			<div class="row">

				<div class="col-xs-6">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> 法人</label>

						<div class="col-sm-8">
							<input type="text" name="legalPerson"
								placeholder="法人" class="form-control">
						</div>
					</div>
				</div>

				<div class="col-xs-6">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> 发证时间</label>

						<div class="col-sm-8">
							<!-- #section:plugins/date-time.datepicker -->
							<div class="input-group">
								<input class="form-control date-picker" 
									placeholder="yyyy-mm-dd" name="certificateTime" type="text"
									data-date-format="yyyy-mm-dd"> <span
									class="input-group-addon"> <i
									class="fa fa-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6">
					<div class="form-group">
						<label class="col-sm-4 control-label no-padding-right"
							for="form-field-1"> 有效期</label>

						<div class="col-sm-8">
							<!-- #section:plugins/date-time.datepicker -->
							<div class="input-group">
								<input class="form-control date-picker" 
									placeholder="yyyy-mm-dd" name="valiableTime" type="text"
									data-date-format="yyyy-mm-dd"> <span
									class="input-group-addon"> <i
									class="fa fa-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div><!--  more zone -->
	</form>


</div>