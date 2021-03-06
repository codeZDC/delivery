<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
<%-- <link href="${contextPath}/static/util/alert/jquery-confirm.min.css" rel="stylesheet"> --%>

<%-- <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">--%>
 <link href="${contextPath }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
 <link rel="stylesheet" href="${contextPath }/static/ace/assets/css/font-awesome.css" />
 
 <!-- text fonts -->
 <link rel="stylesheet" href="${contextPath }/static/ace/assets/css/ace-fonts.css" />
 
 <!-- ace styles -->
 <link href="${contextPath }/static/ace/assets/css/ace.css" rel="stylesheet">
 
 <!-- ace styles -->
 <link href="${contextPath }/static/ace/assets/css/datepicker.css" rel="stylesheet">
 
<%-- <link href="${contextPath}/static/bootstrap-table/bootstrap-table.css" rel="stylesheet" /> --%>
<%-- <link href="${contextPath}/static/font-awesome/css/font-awesome.min.css" rel="stylesheet" /> --%>
<!--dynamic table-->
<link href="${contextPath }/static/ace/assets/css/jquery-ui.css" rel="stylesheet">
<link href="${contextPath}/static/common/common.css" rel="stylesheet" />
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${contextPath }/static/util/js/html5shiv.min.js"></script>
<script src="${contextPath }/static/util/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="${contextPath }/static/jquery/jquery.pagination/pagination.css">

<!-- ace settings handler -->
<script src="${contextPath }/static/ace/assets/js/ace-extra.js"></script>
</head>
<body>
	<div id="alert-modal" class="hide">
		<p id="dialog-message-text">
			您确定执行此操作？
		</p>
	</div>
</body>
<script>
	function showConfirm(ok){
		$( "#alert-modal" ).removeClass('hide').dialog({
			resizable: false,
			width: '350',
			modal: true,
			title: "请确认操作",
			title_html: true,	
			buttons: {
				'确认': ok,
				'取消':function(){$( "#alert-modal" ).dialog( "close" );}
			}
		});
	}
	function cancelConfirm(){
		$( "#alert-modal" ).dialog( "close" );
	};
	//公共的分页条
	function initPaginationBar(total,pageSize,currentPage,callback){
		currentPage = currentPage>(total/pageSize)?Math.ceil(total/pageSize):currentPage;
		//更新下分页信息
		$('#paginationMsg').text('显示 '+ ((currentPage-1)*pageSize+1) 
									  +' 至 '+(currentPage*pageSize>total?total:currentPage*pageSize) 
									  +' 条记录,总共 '+total+' 条');
		if(total/pageSize<=1){
			$("#paginationBar *").remove();
			return;
		}
		$("#paginationBar").pagination(total, {
			paginationBarCount: 10, //主体页数
			callback: callback,
			currentPage :currentPage,
			pageSize: pageSize, //每页显示1项
			prev_text: "上一页",
			next_text: "下一页"
		});
	}
</script>
</html>