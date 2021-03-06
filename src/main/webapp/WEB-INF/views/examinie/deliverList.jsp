<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row hide" id="deliverList">
	<div class="col-sm-10 col-sm-offset-1">
	<img  src="" src-rooPath="${contextPath }/static/imgs/"    
 	style="width:150px;height:150px; position: absolute;  display:none; right:100px;top:150px;" id="examinieMark"/>
 	<input type="hidden" id="deliverListId">
		<!-- #section:pages/invoice -->
		<div class="widget-box transparent">
			<div class="widget-header widget-header-large">
				<h3 class="widget-title lighter">汇交清单
					<small id="compnayName"> <i class="ace-icon fa fa-angle-double-right"></i>
						遵义xxxxxx公司
					</small>
				</h3>

				<!-- #section:pages/invoice.info -->
				<div class="widget-toolbar no-border invoice-info">
					<br> <span class="invoice-info-label">日期:</span> <span
						class="blue" id="dateSpan">2018.8.8</span>
				</div>

				<!-- /section:pages/invoice.info -->
			</div>

			<div class="widget-body">
				<div class="widget-main padding-24">

					<div class="space"></div>

					<div>
						<div class="alert alert-warning" id="zeroDeliverSpan">
											<strong>零汇交!</strong>

												该单位没有项目提交,零汇交
											<br>
						</div>
						<table class="table table-striped table-bordered center " >
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

							<tbody id="deliverListTable">
								<tr>
									<td class="center">1</td>

									<td><a href="#">水准网少时诵诗书</a></td>
									<td class="hidden-xs">水准网</td>
									<td class="hidden-480">是</td>
									<td>xxxxxx</td>
									<td>
										<div class="hidden-sm hidden-xs action-buttons">
											<a class="purple editData"  data-rel="tooltip" href="javascript:;" onclick="view12templates('gps')"
												title="查看"> <i class="ace-icon fa fa-eye bigger-130"></i></a>
										</div>
									</td>
								</tr>


							</tbody>
						</table>
					</div>


					<div class="row">
						<label for="form-field-9">汇交说明</label>

						<textarea class="form-control limited" readonly="readonly" id="deliverRemark"
							maxlength="50"></textarea>
					</div>
					<div class="hr hr8 hr-double hr-dotted"></div>
					<div class="row">
						<div class="col-sm-5 pull-right">
							<h4 class="pull-right">
								总共 : <span class="red" id="totalCount">1</span>个项目
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
						<label for="form-field-9 " class="red">不同意意见</label>

						<textarea class="form-control limited" id="declineRemarks"
							maxlength="50"></textarea>
					</div>
					<div class="space-6"></div>	
					<div class="row" id="operationPane">
						<p class="pull-right">
						<button class="btn btn-white btn-info btn-bold" id="agreeButton">
												<i class="ace-icon fa fa-check bigger-120 green"></i>
												同意
											</button>
						<button class="btn btn-white btn-info btn-bold" id="declineButton">
												<i class="ace-icon fa fa-times bigger-120 red" onclick="dissagree()"></i>
												不同意
											</button>
						<button class="btn btn-white btn-info btn-bold" id="printButton" onclick="printDeliveryList()">
												<i class="ace-icon fa fa-print bigger-120 blue" ></i>
												打印
						 </button>
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

