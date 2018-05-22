var localData = {};
var menuData ={};
$(function(){
	//页面表单初始化
	loadTable(1);
	//用户页面需要setRoleData();
	//设置父级菜单下拉框
	//这里不应该使用这样的方式获取角色信息,,,应该使用实体扩展类添加一个属性显示就好
	setMenusSelect();
});

//加载列表数据
function loadTable(pageNum){
	var pageSize = $('#pageSizeSelect').val();
	var searchText = $('#searchInput').val().replace('/\s/g','');
	
	$.getJSON(contextPath + 'menu/list',{name:searchText,pageNum:pageNum,pageSize:pageSize},function(res){
		buildTable(res.rows);
		initPaginationBar(res.total,pageSize,pageNum,function(currentPage){loadTable(currentPage);});
	});
}
function setMenusSelect(){
	$.ajax({
		url : contextPath + 'menu/list',
		type:'get',
		dataType:'json',
		data : {pid:0},
		async:false,
		success:function(res){
			$(':input[name=pid] option[value!=0]').remove();
			$.each(res.rows,function(index,per){
				menuData[per.id]=per.name;
				//初始化下拉框信息
				$(':input[name=pid]').append($('<option>').val(per.id).text(per.name));
			});
		},
		error:function(){
			alert('获取下拉框菜单失败,请稍后重试!')
		}
	});
}
//初始化角色信息//
var roleData ;
function setRoleData(){
	$.ajax({
		url : contextPath + 'role/list',
		type:'get',
		dataType:'json',
		async:false,
		success:function(res){
			$.each(res.rows,function(index,per){
				roleData[per.id]=per.roleName;
				//初始化下拉框信息
				$(':input[name=pid]').append($('<option>').val(per.id).text(per.roleName));
			});
		},
		error:function(){
			alert('获取角色失败,请稍后重试!')
		}
	});
}
function buildTable(data){
	localData = data ;
	var index,name,icon,pname,remarks,createdTime
	handler =  	$('<td>').append('<div class="hidden-sm hidden-xs action-buttons">'
				+'<a class="green menu-edit" href="#"> <i class="ace-icon fa fa-pencil bigger-130"></i>'
				+'</a> <a class="red menu-remove" href="#"> <i '
				+'class="ace-icon fa fa-trash-o bigger-130"></i></a></div>');
	var tbody = $('#menus tbody').empty();
	$.each(data,function(temp , per){
		index = $('<td>').text(temp + 1);
		name = $('<td>').text(per.name); 
		icon = $('<td>').append($('<i>').addClass('bigger-130 fa fa-'+per.icon)); 
		pname = $('<td>').text(menuData[per.pid]); 
		remarks = $('<td>').text(per.remarks); 
		createdTime = $('<td>').text(per.createdTime) ; 
		$('<tr>').attr('id',per.id).append(index).append(name).append(icon)
		.append(pname).append(remarks).append(createdTime)
		.append(handler.clone()).appendTo(tbody);
	})
}

function validate(){
	var menuName = $("#menuName");
	if(menuName.val() == ""){
		alert("请输入用户名");
		menuName.focus();
		return false;
	}
	return true;
}

//添加菜单点击事件
$( "#menu-add" ).on('click', function(e) {
	setMenusSelect();
	//去除图标选择旁边的显示 i
	$('#menu-add-form .show-icon i').removeClass();
	e.preventDefault();
	$('#menu-add-form')[0].reset();
	$( "#menu-add-modal" ).removeClass('hide').dialog({
		resizable: false,
		width: '420',
		modal: true,
		title: "添加菜单",
		title_html: true,
		buttons: [
			{
				html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
				"class" : "btn btn-white btn-info btn-bold",
				click: function() {
					$('#menu-add-modal').next().find('button').attr('disabled','disabled');
					//校验
					//if(!validate()) return;
					$.post(contextPath + 'menu/save',$('#menu-add-form').serialize(),function(res){
						alert(res.message);
						loadTable(9999);
						$("#menu-add-modal").dialog( "close" );
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
//编辑菜单,,本地数据
$(document).on('click','.menu-edit',function(){
	setMenusSelect();
	var id = $(this).parents('tr').attr('id');
	var currentPage = $('#paginationBar .current:not(:hidden)').text();
	//假如自己是一级菜单隐藏下拉框中的自己
	$.each(localData,function(index,per){
		if(per.id == id){
			for(var key in per){
				$('#menu-edit-form [name='+key+']').val(per[key]);
			}
			if(!per.pid){
				$(':input[name=pid] option[value='+id+']').hide();
			}
			//添加图标
			$('#menu-edit-form .show-icon i').removeClass().addClass('fa fa-'+per.icon);
		}
		$( "#menu-edit-modal" ).removeClass('hide').dialog({
			resizable: false,
			width: '420',
			modal: true,
			title: "编辑菜单",
			title_html: true,
			buttons: [
				{
					html: "<i class='ace-icon fa fa-floppy-o bigger-120 blue'></i>&nbsp; 保存",
					"class" : "btn btn-white btn-info btn-bold",
					click: function() {
						$('#menu-edit-modal').next().find('button').attr('disabled','disabled');
						//if(!validate()) return;
						$.post(contextPath + 'menu/edit',$('#menu-edit-form').serialize(),function(res){
							alert(res.message);
							loadTable(currentPage);
							$("#menu-edit-modal").dialog( "close" );
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
$(document).on('click','.menu-remove',function(){
	var id  = $(this).parents('tr').attr('id');
	showConfirm(function(){
		$.post(contextPath + 'menu/del' ,{ids:[id]} ,function(res){
			alert(res.message);
			if(res.success){
				loadTable(1);
				cancelConfirm();
			}
		},'jSON');
	});
})

$('#searchInput').keyup(function(){
	loadTable(1);
});
$('#pageSizeSelect').change(function(){
	loadTable(1);
});
$(':input[name=icon]').change(function(){
	$(this).next().find('i').removeClass().addClass('fa fa-'+this.value);
});