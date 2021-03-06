<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row" id="deliverList2"  style="display: none;">
	<div class="col-sm-10 col-sm-offset-1">
 	<img  src="" src-rooPath="${contextPath }/static/imgs/"    
 	style="width:150px;height:150px; position: absolute;  display:none; right:100px;top:150px;" id="examinieMark"/>
		<!-- #section:pages/invoice --> 
		<div class="widget-box transparent">
			<div class="widget-header widget-header-large">
				<h3 class="widget-title  lighter">汇交清单</h3>  	

				<!-- #section:pages/invoice.info -->
				<div class="widget-toolbar no-border invoice-info">
					<br> <span class="invoice-info-label">日期:</span> <span
						class="blue dateSpan"></span>
				</div>

				<!-- /section:pages/invoice.info -->
			</div>

			<div class="widget-body">
				<div class="widget-main padding-24">

					<div class="space"></div>

					<div>
						<table id="deliveries_table" class="table table-striped table-bordered center">
							<thead>
								<tr>
									<th class="center">序号</th>
									<th class="center">汇 交 项 目 名 称</th>
									<th class="center">汇 交 项 目 类型</th>
									<th class="center">是否副本</th>
									<th class="center">备 注</th>
									<th class="center">操作</th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td class="center">1</td>

									<td><a href="#">水准网少时诵诗书</a></td>
									<td class="hidden-xs">水准网</td>
									<td class="hidden-480">是</td>
									<td>xxxxxx</td>
									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="green editData" href="#"> <i
												class="ace-icon fa fa-pencil bigger-130"></i></a> <a
												class="red removeData" href="#"> <i
												class="ace-icon fa fa-trash-o bigger-130"></i></a>
										</div>
									</td>
								</tr>

								<tr>
									<td class="center">2</td>

									<td><a href="#">GPS</a></td>
									<td class="hidden-xs">天文、三角、GPS、导线锁网成果</td>
									<td class="hidden-480">是</td>
									<td>xxxxxxxxx</td>
									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="green editData" href="#"> <i
												class="ace-icon fa fa-pencil bigger-130"></i></a> <a
												class="red removeData" href="#"> <i
												class="ace-icon fa fa-trash-o bigger-130"></i></a>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>


					<div class="row">
						<label for="form-field-9">汇交说明</label>

						<textarea class="form-control limited deliveryRemarks" id="deliverRemark"
							maxlength="50"></textarea>
					</div>
					<div class="row" id="declineRow" >
						<label for="form-field-9 " class="red">不同意意见</label>

						<textarea class="form-control limited" id="declineRemarkText"
							maxlength="50"></textarea>
					</div>
					<div class="hr hr8 hr-double hr-dotted"></div>
					<div class="row">
						<div class="col-sm-5 pull-right">
							<h4 class="pull-right">
								总共 : <span class="red" id="deliveryCount"></span>个项目
							</h4>
						</div>
						<div class="col-sm-7 pull-left text-muted">
							注：1、基础测绘项目在“备注”栏中标注“基础测绘”。<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp2、表中“类型”栏中填写内容应与第十六条规定的十种类型一致。<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp3、根据第十六条规定，要求填报详细信息的项目优先填写，并在备注栏中注明“详细”；未要求填报详细信息的项目随后填写，并在备注栏中注明“一般”。<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp4、此页加盖单位公章报测绘行政主管部门。
						</div>
					</div>
 
					<div class="space-6"></div>
					<div class="row">
						<div class="pull-right">
							<p>
								<button class="btn btn-primary submitDelivery">
									<i class="ace-icon fa fa-check align-top bigger-125"></i>提交审核
								</button> 
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

<div class="row" id="noDelivery" style="display: none;">
	<div class="col-sm-12">
		<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125"> <i
									class="ace-icon fa fa-circle-o"></i> 您没有申请项目
								</span> 
							</h1> 

							<hr>
							<h3 class="lighter smaller">
								请 添加项目<i
									class="ace-icon fa fa-plus	 bigger-125 icon-animated-wrench"></i>
									
								  或者  零汇交 <i
									class="ace-icon fa fa-folder-o bigger-125 icon-animated-wrench"></i>

							</h3>

							<div class="space"></div>



							<hr>
							<div class="space"></div>

							<div class="center">
								<p>
								<a href="#add" class="btn btn-primary" data-toggle="tab" id="toAdd">
												<i class="ace-icon fa fa-plus"></i>
												添加项目
								</a>
								<button class="btn " id="zeroDeliver">
									<i class="ace-icon fa fa-folder-o align-top bigger-125"></i>零汇交
								</button>
							</p>
							</div>
						</div>
					</div> 
	</div>
</div>

