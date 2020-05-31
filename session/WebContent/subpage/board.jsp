<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String loginid=(String)session.getAttribute("loginid");//null인지 확인할것..***
	
	if(loginid==null){
%>	
	<script>
		alert("로그인하셔야합니다");
		location.href='/session/index.jsp?subpage=login&from=board';
	</script>
<% 	
	}	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
	<BR><BR>
	THIS IS BOARD<BR><BR>
	HELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLO<BR>
	HELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLO<BR>
	HELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLO<BR>
	HELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLO<BR>
	</div>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>