<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//세션확인 후 login되어있으면 
	String loginid=(String)session.getAttribute("loginid");//null인지 확인할것..***
	String areulogin="LOGIN";
	if(loginid!=null){
		areulogin="LOGOUT";
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이소리미</title>
<style>
</style>
</head>
<body>
	<hr>
	<h1 align="center">THIS IS HOMEPAGE</h1>
	<p align="center">
		<a href="<%=request.getContextPath()%>/?subpage=home">HOME</a> <%--현재 경로--%>
		<a href="<%=request.getContextPath()%>/?subpage=board">	BOARD</a>
		<a href="<%=request.getContextPath()%>/?subpage=lecture">	LECTURE</a>
		<a href="<%=request.getContextPath()%>/?subpage=login" >	<%=areulogin %></a>
		
	</p>
	<hr>
		
</body>
</html>