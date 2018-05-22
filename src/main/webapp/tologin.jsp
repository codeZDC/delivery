<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="${contextPath }static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
try {
	if(parent.$('iframe[name]')[0]){
		parent.location='${contextPath}/login.jsp';
	}
} catch (e) {
	location='${contextPath}/login.jsp';
}
</script>
</head>
</html>