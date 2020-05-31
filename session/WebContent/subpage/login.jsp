  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String loginid=(String)session.getAttribute("loginid");
	String remembername="";
	String rememberid=(String)session.getAttribute("rememberid");
	
	
	//어디서 넘어왔는지에 대한
	String from=request.getParameter("from");
	System.out.println(from);
	if(from==null){
		from="";//넘어온게 없으면 공백처리->loginAction에서 home으로 붙게됨
	}
	
	if(rememberid!=null){
		remembername=rememberid;
	}else{
		remembername="";
	}
	
	
	if(loginid!=null){
		session.removeAttribute("loginid");
		%>
		<script>
			alert("로그아웃되셨습니다");
			location.href='index.jsp';
		</script>
		
		<% 
	}
%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>LOGIN</h1>
		<form action="/session/LoginAction" method="get">	
			<table width="200px">
				<tr>
					<td align="center">ID: <input type="text" size="10" name="id"></td>			
				</tr>
				<tr>
					<td align="center">pw: <input type="password" size="10" name="pw"><br><br>
					</td>			
				</tr>
			
			</table>
			
			<input type="checkbox" checked="checked" name="remember">remember this ID
			<input type="hidden" name="subpage" value="<%=from %>"><%--공갈용 --%>
			
			&nbsp;&nbsp;<input type="submit" value="login">
			<input type="button" value="join" onclick="location.href='index.jsp?subpage=join'">
		</form>
	</div><br><br><br><br><br><br><br><br><br><br>
</body>
</html>