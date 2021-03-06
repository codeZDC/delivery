var localData ;
$(function(){
	//页面表单初始化
	loadTable(1);
});

//加载列表数据
function loadTable(pageNum){
	var pageSize = $('#pageSizeSelect').val();
	var searchText = $('#searchInput').val().replace('/\s/g','');
	
	$.getJSON(contextPath + 'role/list',{roleName:searchText,pageNum:pageNum,pageSize:pageSize},function(res){
		buildTable(res.rows);
		initPaginationBar(res.total,pageSize,pageNum,function(currentPage){loadTable(currentPage);	});
	});
}
function buildTable(data){
	localData = data ;
	var index,roleName,status,remarks,createdTime,
	handler =  	$('<td>').append('<div class="hidden-sm hidden-xs action-buttons">\
				<a class="blue menuAuth" href="#"> <i class="ace-icon fa fa-list-ul bigger-130"></i>\
				</a> <a class="green role-edit" href="#"> <i class="ace-icon fa fa-pencil bigger-130"></i>\
				</a> <a class="red role-remove" href="#"> <i \
				class="ace-icon fa fa-trash-o bigger-130"></i></a></div>');
	var tbody = $('#roles tbody').empty();
	$.each(data,function(temp , per){
		index = $('<td>').text(temp + 1);
		roleName = $('<td>').text(per.roleName) ; 
		status = $('<td>').append(per.status==1?'<span class="label label-success">可用</span>':'<span class="label label-danger">停用</span>'); 
		remarks = $('<td>').text(per.remarks); 
		createdTime = $('<td>').text(per.createdTime); 
		$('<tr>').attr('id',per.id).append(index).append(roleName).append(status).append(remarks)
		.append(createdTime).append(handler.clone()).appendTo(tbody);
	})
}

function validate(){
	var roleName = $("#roleName");
	if(roleName.val() == ""){
		alert("请输入用户名");
		roleName.focus();
		return false;
	}
	return true;
}

//添加角色点击事件
$( "#role-add" ).on('click', function(e) {
	e.preventDefault();
	$('#role-add-form')[0].reset();
	$( "#role-add-modal" ).removeClass('hide').dialog({
		resizable: false,
		width: '420',
		modal: true,
		title: "添加角色",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
				"class" : "btn btn-white btn-info btn-bold",
				click: function() {
					$('#role-add-modal').next().find('button').attr('disabled','disabled');
					//校验
					//if(!validate()) return;
					$.post(contextPath + 'role/save',$('#role-add-form').serialize(),function(res){
						alert(res.message);
						loadTable(9999);
						$("#role-add-modal").dialog( "close" );
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

//编辑角色,,本地数据
$(document).on('click','.role-edit',function(){
	var id = $(this).parents('tr').attr('id');
	var currentPage = $('#paginationBar .current:not(:hidden)').text();
	$.each(localData,function(index,per){
		if(per.id == id){
			for(var key in per){
				$('#role-edit-form [name='+key+']').val(per[key]);
			}
		}
		$( "#role-edit-modal" ).removeClass('hide').dialog({
			resizable: false,
			width: '420',
			modal: true,
			title: "编辑角色",
			title_html: true,
			buttons: [
				{
					html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
					"class" : "btn btn-white btn-info btn-bold",
					click: function() {
						$('#role-edit-modal').next().find('button').attr('disabled','disabled');
						//if(!validate()) return;
						$.post(contextPath + 'role/edit',$('#role-edit-form').serialize(),function(res){
							alert(res.message);
							loadTable(currentPage);
							$("#role-edit-modal").dialog( "close" );
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
$(document).on('click','.role-remove',function(){
	var id  = $(this).parents('tr').attr('id');
	showConfirm(function(){
		$.post(contextPath + 'role/del' ,{ids:[id]} ,function(res){
			alert(res.message);
			if(res.success){
				loadTable(1);
				cancelConfirm();
			}
		},'jSON');
	});
})

/*//分页条
function initPaginationBar(total,pageSize,currentPage){
	currentPage = currentPage>(total/pageSize)?Math.ceil(total/pageSize):currentPage;
	//更新下分页信息
	$('#paginationMsg').text('显示 '+ ((currentPage-1)*pageSize+1) +' 至 '+currentPage*pageSize +' 条记录,总共 '+total+' 条');
	$("#paginationBar").pagination(total, {
		//num_edge_entries: 4, //边缘页数
		num_display_entries: 10, //主体页数
		callback: pageselectCallback,
		current_page :currentPage-1,
		items_per_page: pageSize, //每页显示1项
		prev_text: "前一页",
		next_text: "后一页"
	});
}
function pageselectCallback(currentPage){
	loadTable(currentPage);	
}*/

$('#searchInput').keyup(function(){
	loadTable(1);
});
$('#pageSizeSelect').change(function(){
	loadTable(1);
});


//添加菜单点击事件
$(document).on('click','.menuAuth', function(e) {
	var id = $(this).parents('tr').attr('id');
	setMenuTree(id);
	e.preventDefault();
	$( "#dialog-menuTree" ).removeClass('hide').dialog({
		resizable: false,
		width: '250',
		modal: true,
		title: "菜单管理",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
				"class" : "btn btn-white btn-info btn-bold",
				click: function() {
					submitTree(id,this);
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