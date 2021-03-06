<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 加载省市县的view -->
<div class="row">
	<h3 class="row header smaller lighter blue">
		<span class="col-sm-6" id="cityName"></span>
	</h3>
	<div class="row">
		<div class="col-sm-12">
			<div class="pull-left col-sm-12">
				<div class="form-group " >
					<p class="pull-right">
						<label class=" control-label no-padding-right" for="form-field-1">单位名称
						</label> <input type="text" id="companyName" placeholder="单位名称">
						&nbsp&nbsp&nbsp&nbsp&nbsp 
						
						
						<label
							class=" control-label no-padding-right ">汇交状态 </label>
							 <select
							id="deliveryStatus" >
							<option value="">全部</option>
							<option value="8">通过</option>
							<option value="3">不通过</option>
							<option value="1">已汇交</option>
							<option value="7">未汇交</option>
							<option value="0">零汇交</option>
							
						</select>
						
						<label
							class=" control-label no-padding-right ">单位资质 </label>
							 <select
							id="qualification" >
							<option value="">全部</option>
							<option value="1">甲级</option>
							<option value="2">乙级</option>
							<option value="3">丙级</option>
							<option value="4">丁级</option>
						</select>
						<button class="btn btn-white btn-default btn-round" id="searchButton">
						<i class="ace-icon fa fa-search purple"></i> 查询
						</button>
					</p>
				</div>
			</div>




		</div>
	</div>
	<table class="table table-striped table-bordered center">
		<thead>
			<tr>
				<th class="center">序号</th>
				<th class="center">年份</th>
				<th class="center">单位名称</th>
				<th class="center">是否汇交</th>
				<th class="center">备 注</th>
				<th class="center">单位资质</th>
				<th class="center">操作</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td class="center">1</td>

				<td><a href="#">2018</a></td>
				<td>遵义市xxxxx公司</td>
				<td><span class="label label-success ">已汇交</span> <span
					class="label ">未汇交</span></td>
				<td>xxxxxx</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						<a class="purple editData" href="#" data-rel="tooltip" title="查看"
							onclick="top.viewDeliverList()"> <i
							class="ace-icon fa fa-eye bigger-130"></i></a> <a
							class="green editData" href="#" data-rel="tooltip" title="同意">
							<i class="ace-icon fa fa-check bigger-130"></i>
						</a> <a class="red removeData" href="#" data-rel="tooltip" title="不同意">
							<i class="ace-icon fa fa-times bigger-130"></i>
						</a>
					</div>
				</td>
			</tr>

			<tr>
				<td class="center">2</td>

				<td><a href="#">2018</a></td>
				<td>贵州xxxxxxx公司</td>
				<td><span class="label label-success ">已汇交</span> <span
					class="label ">未汇交</span></td>
				<td>xxxxxxxxx</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						<a class="purple editData" href="#" data-rel="tooltip" title="查看">
							<i class="ace-icon fa fa-eye bigger-130"></i>
						</a> <a class="green editData" href="#" data-rel="tooltip" title="同意">
							<i class="ace-icon fa fa-check bigger-130"></i>
						</a> <a class="red removeData" href="#" data-rel="tooltip" title="不同意">
							<i class="ace-icon fa fa-times bigger-130"></i>
						</a>
					</div>
				</td>
			</tr>

		</tbody>
	</table>
</div>
<div class="row">
	<div class="col-xs-12">
		<div id="paginationBar"></div>
	</div>
</div>