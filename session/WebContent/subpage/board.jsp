<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String loginid=(String)session.getAttribute("loginid");//null���� Ȯ���Ұ�..***
	
	if(loginid==null){
%>	
	<script>
		alert("�α����ϼž��մϴ�");
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