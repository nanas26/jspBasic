<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	
	String loginid=(String)session.getAttribute("loginid");
	String remembername="";
	String rememberid=(String)session.getAttribute("rememberid");
	
	String errMsg=request.getParameter("errMsg");
	if(errMsg==null){
		errMsg="";
	}
	//��� �Ѿ�Դ����� ����
	String from=request.getParameter("uri");
	System.out.println("**"+from);
	if(from==null){
		from="";//�Ѿ�°� ������ ����ó��->loginAction���� home���� �ٰԵ�
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
			alert("�α׾ƿ��Ǽ̽��ϴ�");
			location.href='index.jsp';
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
	<header>
      <jsp:include page="inc/header.jsp" flush="false"/>
  </header>
  
  <div align="center">
  <h4><%=errMsg %></h4>
		<h1>LOGIN</h1>
		<form action="/filterplz/LoginAction" method="get">	
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
			<input type="hidden" name="subpage" value="<%=from %>"><%--������ --%>
			
			&nbsp;&nbsp;<input type="submit" value="login">
			<input type="button" value="join" onclick="location.href='index.jsp?subpage=join'">
		</form>
	</div>
</body>
</html>