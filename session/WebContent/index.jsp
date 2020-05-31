<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>made by RIM</title>
<style>
	body,html{
		background-color:#f1f1f1;
	
	}
</style>
</head>
<body>
	<%@ include file="inc/header.jsp" %><%--소스포함 --%>
		<%
			String subpage="home";
			if(request.getParameter("subpage")!=null){
				subpage=request.getParameter("subpage");
			}
			subpage="subpage/"+subpage+".jsp";
		%>
		<jsp:include page="<%=subpage %>" flush="false"></jsp:include>
	
	<%@ include file="inc/footer.jsp" %>
	
</body>
</html>