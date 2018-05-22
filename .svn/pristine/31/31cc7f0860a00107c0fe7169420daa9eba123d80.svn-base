var setting = {
	view : {
		// addHoverDom: addHoverDom,
		removeHoverDom : removeHoverDom,
		selectedMulti : false
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "pid",
			rootpid : null
		}
	},
	/*
	 * check: { autoCheckTrigger: true, enable: true, chkStyle: "checkbox",
	 * chkboxType: { "Y": "ps", "N": "ps" } },
	 */
	/*
	 * edit: { enable: true, editNameSelectAll: true, showRenameBtn: true,
	 * renameTitle: "重命名", showRemoveBtn: true, removeTitle: "删除" },
	 */
	callback : {
		onRename : zTreeOnRename,
		onClick : onClick,
		onNodeCreated : zTreeOnNodeCreated
	},
	check : {
		enable : true,
		chkStyle : "checkbox"
	}
};
function zTreeOnNodeCreated(event, treeId, treeNode) {
	//console.log(event);
	//console.log(treeNode);
};
function zTreeOnRename(treeId, treeNode, node) {
	//console.log(treeNode);
	//console.log(node.id);
	//console.log(node.name);
}
function onClick(event, domId, node) {
	//if (node.isParent)
		///console.log('父节点');
	//else
		//console.log('叶子节点');
}
/*
 * for(var i in zNodes){ zNodes[i].icon ="di.png"; }
 */

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.addNodes(treeNode, {
				id : (100 + newCount),
				pid : treeNode.id,
				name : "new node" + (newCount++),
				icon : "di.png"
			});
			return false;
		});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};
// -->
function setMenuTree(id){
	var menuTree;
	$.ajax({
		url : contextPath + '/role/roleMenu',
		type:'get',
		dataType : 'json',
		async : false,
		data : {id:id},
		success:function(res){
			if(res.success)
				menuTree = res.data ;
			else alert('获取菜单树失败!');
		},
		error :function(){
			alert('网络错误,请联系管理员!');
		}
	});
	if(!menuTree||!menuTree.length){
		alert('没有菜单可以分配!');
		return;
	}
	console.log(menuTree);
	$.fn.zTree.init($("#menuTree"), setting, menuTree);
}
function submitTree(id,ele){
	var treeObj = $.fn.zTree.getZTreeObj("menuTree");
	var nodes = treeObj.getCheckedNodes(true);
	var ids = [] ;
	for ( var i in nodes) {
		if(nodes[i].pid)ids.push(nodes[i].id);
	}
	$.post(contextPath + 'role/roleMenu',{ids:ids,id:id},function(res){
		if(res.success){
			alert('授权成功');
			$( ele ).dialog( "close" );
		}else{
			alert('授权失败');
		}
	},'json');
}