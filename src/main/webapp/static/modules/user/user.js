var localData = {};
var hasRoleData = false;//角色下拉框是否已经初始化
var modalWidth = '70%';//添加和编辑modal的宽度
$(function(){
	//页面表单初始化
	console.log($('#user-add-form').attr('class'));
	loadTable(1);
	
	//时间控件
	 $('.date-picker').each(function(){
	});
});

//加载列表数据
function loadTable(pageNum){
	//获取分页大小
	var pageSize = $('#pageSize-select').val();
	//用户类型条件
	var userType = $('#switchUserButten').attr('userType');
	var param = {};
	param.pageNum = pageNum ;
	param.pageSize = pageSize ;
	if(typeof userType != 'undefined' && userType.length>0)
		param.userType = userType ;
	//获取搜索框中的单位名称,用户名称,汇交区域,用户自制条件
	$('#user-search-modal :input').each(function(){
		if(this.value.replace(/\s/g,'').length!=0)
			param[$(this).attr('name')] = this.value.replace(/\s/g,'');
	});
	$.getJSON(contextPath + 'user/list',param,function(res){
		buildTable(res.rows);
		initPaginationBar(res.total,pageSize,pageNum,function(currentPage){loadTable(currentPage);});
	});
}
//初始化角色信息//
function setRoleData(){
	if(hasRoleData)return;
	$.ajax({
		url : contextPath + 'role/list',
		type:'get',
		dataType:'json',
		async:false,
		success:function(res){
			$.each(res.rows,function(index,per){
				//初始化下拉框信息
				hasRoleData = true;
				$(':input[name=roleId]').append($('<option>').val(per.id).text(per.roleName));
			});
		},
		error:function(){
			alert('获取角色失败,请稍后重试!')
		}
	});
}
function buildTable(data){
	localData = data ;
	console.log(data);
	var index,username,userStatus,unitName,deliveryZone,unitdesc,createdTime
	handler =  	$('<td>').append('<div class="hidden-sm hidden-xs action-buttons">'
				+'<a class="green user-edit" href="#"> <i class="ace-icon fa fa-pencil bigger-130"></i>'
				+'</a> <a class="red user-remove" href="#"> <i '
				+'class="ace-icon fa fa-trash-o bigger-130"></i></a></div>');
	var tbody = $('#user-table tbody').empty();
	$.each(data,function(temp , per){
		index = $('<td>').text(temp + 1);
		username = $('<td>').text(per.username); 
		userStatus = $('<td>');
		//启用状态   0  未审核状态//
		if(per.userStatus == 1)userStatus.append('<label>\
				<input class="ace ace-switch ace-switch-3" type="checkbox" checked onchange="showValue(this)">\
				<span class="lbl"></span>\
			</label>');
		else userStatus.append('<label>\
				<input class="ace ace-switch ace-switch-3" type="checkbox"  onchange="showValue(this)">\
				<span class="lbl"></span>\
			</label>');
			
		unitName = $('<td>').text(per.unitName); 
		deliveryZone = $('<td>').text(top.allZone[per.deliveryZone]); //把汇交区域编码改成名字
		unitdesc = $('<td>').text(getQualification(per.qualification)); 
		createdTime = $('<td>').text(per.createdTime) ; 
		$('<tr>').attr('id',per.id).append(index).append(username).append(userStatus).append(unitName)
		.append(deliveryZone).append(unitdesc).append(createdTime)
		.append(handler.clone()).appendTo(tbody);
	})
}

function showValue(obj){
	//alert($(obj).val());
	var id =$(obj).parents('tr').attr('id');
	if($(obj).is(':checked')){
		updateStatus(id,1);
	}else{
		updateStatus(id,0);
	}
}

/**
 * 
 * @returns 用户资质
 */
function getQualification(qualification){
	switch(qualification){
		case 1: return '甲';
		case 2: return '乙';
		case 3: return '丙';
		case 4: return '丁';
	}
}

//添加用户点击事件
$( "#user-add" ).on('click', function(e) {
	setRoleData();
	//去除图标选择旁边的显示 i
	e.preventDefault();
	$('#user-add-form')[0].reset();
	//显示 more区域
	$("#moreZone").show();
	showAllSelect();//显示所有的下拉框
	//删除市级,区县信息
	$('.district option:not(.no),.city option:not(.no)').remove();
	$( "#user-add-modal" ).removeClass('hide').dialog({
		resizable: false,
		width: modalWidth,
		modal: true,
		title: "添加用户",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
				"class" : "btn btn-white btn-info btn-bold",
				click: function() {
					setPCD('#user-add-form');//设置省市县信息到隐藏框
					
					console.log($('#user-add-form').serialize());
					//校验
					if(!validate()) return;
					//防重复提交
					$('#user-add-modal').next().find('button').attr('disabled','disabled');
					console.log($('#user-add-form').serialize());
					$.post(contextPath + 'user/save',$('#user-add-form').serialize(),function(res){
						alert(res.message);
						loadTable(9999);
						$("#user-add-modal").dialog( "close" );
					},'JSON');
				}
			}
			,
			{
				html: "<i class='ace-icon fa fa-times red2'></i>&nbsp; 取消",
				"class" : "btn btn-white btn-default btn-round",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
			]
	});
});

//校验
function validate(){
	//把所有带required class的input拿到
	var flag = true;
	$("#user-add-form").find('.required:input').each(function(){
		if(this.value == ''){
			alert($(this).attr('error-tip')==undefined ? '请填写此项' : $(this).attr('error-tip'));
			this.focus();
			flag = false;
			return false;
		}
	});
	if(!flag)return ;//停止方法执行
	$("#user-add-form").find(".number").each(function(){
		var reg = /^[1-9]\d*$/;
		if(!reg.test(this.value)){
			alert('只能填写数字 	');
			this.focus();
			flag = false;
			return false;
		}
	});

	return flag;
}
//编辑用户,,本地数据
$(document).on('click','.user-edit',function(){
	setRoleData();//设置角色信息
	var id = $(this).parents('tr').attr('id');
	var currentPage = $('#paginationBar .current:not(:hidden)').text();
	//假如自己是一级用户隐藏下拉框中的自己
	$.each(localData,function(index,per){
		if(per.id == id){
			for(var key in per){
				$('#user-edit-form [name='+key+']').val(per[key]);
				//将username保存到全局变量中,,,校验用户名合理的时候使用
				username = per.username;
			}
			//设置一下省市县信息
			setProvinceCityDisrtict(per.admZone,per.deliveryZone);
		}
		$( "#user-edit-modal" ).removeClass('hide').dialog({
			resizable: false,
			width: modalWidth,
			modal: true,
			title: "编辑用户",
			title_html: true,
			buttons: [
				{
					html: "<i class='green ace-icon fa fa-chevron-up red2'></i>&nbsp; 启用",
					"class" : " btn btn-white btn-default btn-round",
					click: function() {
						updateStatus(id,1)
					}
				}
				,
				{
					html: "<i class='red ace-icon fa fa-chevron-down red2'></i>&nbsp; 停用",
					"class" : " btn btn-white btn-default btn-round",
					click: function() {
						updateStatus(id,0)
					}
				}
				,
				{
					html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
					"class" : "btn btn-white btn-info btn-bold",
					click: function() {
						if($('.onError')[0]){
							alert($('#errorDiv').text());
							return;
						}
						
						setPCD('#user-edit-form');//设置省市县信息到隐藏框
						$('#user-edit-modal').next().find('button').attr('disabled','disabled');
						//if(!validate()) return;
						$.post(contextPath + 'user/edit',$('#user-edit-form').serialize(),function(res){
							alert(res.message);
							loadTable(currentPage);
							$("#user-edit-modal").dialog( "close" );
						},'JSON');
					}
				}
				,
				{
					html: "<i class='ace-icon fa fa-times red2'></i>&nbsp; 取消",
					"class" : "btn btn-white btn-default btn-round",
					click: function() {
						$( this ).dialog( "close" );
					}
				}
				
				]
		});
	});
})
//删除角色
$(document).on('click','.user-remove',function(){
	var id  = $(this).parents('tr').attr('id');
	showConfirm(function(){
		$.post(contextPath + 'user/del' ,{ids:[id]} ,function(res){
			alert(res.message);
			if(res.success){
				loadTable(1);
				cancelConfirm();
			}
		},'jSON');
	});
})

$('#pageSize-select').change(function(){
	loadTable(1);
});

//普通用户和审核用户分类查询
function switchUser(type){
	$('#switchUserButten').attr('userType',type).text(type==0?'普通用户':'审核用户');
	loadTable(1);
}

//添加查询按钮点击事件
$( "#searchButten" ).on('click', function(e) {
	e.preventDefault();
	//初始化
	$('#user-search-form')[0].reset();
	var width = 400;//屏幕的宽
	
	$( "#user-search-modal" ).removeClass('hide').dialog({
		resizable: false,
		width: width,//弹窗的宽
		modal: true,
		title: "用户条件查询",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-search bigger-120 '></i>&nbsp; 查询",
				"class" : "btn btn-white btn-purple btn-bold",
				click: function() {
					setPCD('#user-search-form');//设置省市县信息到隐藏框
					loadTable(1);
					$( this ).dialog( "close" );
				}
			}
			,
			{
				html: "<i class='ace-icon fa fa-times red2'></i>&nbsp; 取消",
				"class" : "btn btn-white btn-default btn-round",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
			]
	});
});

//添加用户类型按钮监听
$("#userTypeSelect").on('change', function(e) {
	if(this.value == 0){//普通用户
		$("#moreZone").show();
	}else{
		$("#moreZone").hide();
	}
});


//甲级资质选择按钮 增加页面
$("#qualificationSelect").on('change', function(e) {

	if(this.value == 1){//甲级资质  影藏按钮
		$("#deliverCitySelect").val('');
		$("#deliverProvenceSelect").val(52).trigger('change');
		$("#deliverProvenceSelect").attr("disabled","disabled");
		$("#deliverCitySelect").hide();
		$("#deliverDistinctSelect").hide("");
	}else{
		//打开按钮
		showAllSelect();
	}
});

//甲级资质选择按钮  修改页面qualification
$("#qualification").on('change', function(e) {

	if(this.value == 1){//甲级资质  影藏按钮
		$("#districtEditSelect").val('');
		$("#provinceEditSelect").val(52).trigger('change');
		$("#provinceEditSelect").attr("disabled","disabled");
		$("#cityEditSelect").hide();
		$("#districtEditSelect").hide("");
	}else{
		//打开按钮
		showAllSelect();
	}
});

//显示所有的功能
function showAllSelect(){
	//打开按钮
	$("#deliverProvenceSelect").removeAttr("disabled");
	$("#deliverCitySelect").show();
	$("#deliverDistinctSelect").show();
	
	$("#provinceEditSelect").removeAttr("disabled");
	$("#cityEditSelect").show();
	$("#districtEditSelect").show();
	
	//把审核人去掉
	$('#examinerAdd').attr('data-content','暂无审核人');
}

//添加用户授权点击事件
$( "#userRight" ).on('click', function(e) {
	e.preventDefault();
	
	var width = 300;//屏幕的宽
	
	$( "#rightModel" ).removeClass('hide').dialog({
		resizable: false,
		width: width,//弹窗的宽
		modal: true,
		title: "授权",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-key bigger-120 '></i>&nbsp; 用户授权",
				"class" : "btn btn-primary btn-white dropdown-toggle",
				click: function() {
					//查询页面
					search();
					return;
					$( this ).dialog( "close" );
				}
			}
			,
			{
				html: "<i class='ace-icon fa fa-times red2'></i>&nbsp; 取消",
				"class" : "btn btn-white btn-default btn-round",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
			]
	});
});

//启用,停用用户
function updateStatus(id,status){
	$.post(contextPath+'/user/updateStatus',{id:id,status:status},function(res){
		if(res.success){
			alert(status==1?'已启动':'已停用');
		}
	},'json');
}
//编辑的时候用户编号不能重复
$('#user-edit-form [name=username]').keyup(function(){
	var errorDiv = $('#errorDiv').removeClass('onError');
	if(username==this.value){
		errorDiv.text('');
		return;
	}
	if(this.value.length!=12)
		{
		errorDiv.text('用户名长度必须为12位');
		errorDiv.addClass('onError');
		return;
		}
	//去数据库查询
	$.getJSON(contextPath+'/user/reasonableUsername',{username:this.value},function(res){
		if(!res.success){
			//说明不是合理的username,添加error
			errorDiv.text('用户名已存在,请重新填写');
			errorDiv.addClass('onError');
		}else{
			errorDiv.text('');
		}
	});

});

