<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="${contextPath }static/login/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${contextPath }static/jquery/1.9.1/jquery.min.js"></script>
<script src="${contextPath }static/login/cloud.js" type="text/javascript"></script>

<script language="javascript">
$(function(){
	$('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });
	$(document).keydown(function(event){ 
		if(event.keyCode==13){ 
			login();
		} 
	});		
});
function login(){
	//先校验,,然后提交
	if($('[name=username]').val()=='')$('[name=username]').val('zdc');
	if($('[name=password]').val()=='')$('[name=password]').val('123');
	$('#loginForm').submit();
}
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(${contextPath }static/login/imgs/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">

	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="homePage.jsp">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<form id="loginForm" action="${contextPath }/user/admin/login">
			<ul>
				<li><input name="username" type="text" class="loginuser" placeholder="请输入用户名"
				 value="${param.username }"/><br/><span style="color: red">${param.msg }</span></li>
				<li><input name="password" type="password" class="loginpwd"  placeholder="请输入密码"/></li>
				<li><input name="" type="button" class="loginbtn" value="登录" onclick="login();"/> 
				<label><a href="register.jsp">注册</a></label>
				 <label>
				<input name="rememberMe" type="checkbox" value="1"/>记住密码</label>
				<label><a href="#">忘记密码？</a></label>
				
				</li>
			</ul>
			</form>
		</div>
	</div>

	<div class="loginbm">版权所有  图智信息</div>
</body>
</html>

