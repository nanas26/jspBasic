<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   // 세션으로 확인 할 때
   String id = (String)session.getAttribute("loginid");
   System.out.println("헤더에서 id발견?:"+id);
   
   // 세션(id)가 비어 있으면
   String logChk = id==null? "LOGIN" : "LOGOUT" ;
   String src = id==null? "/filterplz/subpage/login.jsp" : "/filterplz/subpage/logout.jsp"; 
   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title></title>
  	<script type="text/javascript">
  		function changeContent(value){
  			if(value=="0"){
  				location.href="/filterplz/index.jsp?contentPage=home";
  			} else if(value=="1"){
  				location.href="/filterplz/board.jsp";
  			} else if(value=="2"){
  				location.href="/filterplz/lecture.jsp";
  			} else if(value=="3"){
  				location.href="/filterplz/login.jsp";
  			}
  		}
   
  	</script>
  </head>
  <body>
  <div align="center">
  <h1>HELLO MY PAGE</h1>
  <button onclick="changeContent(0)">HOME</button>
  <button onclick="changeContent(1)">BOARD</button>	
  <button onclick="changeContent(2)">LECTURE</button>
  <button onclick="changeContent(3)"><%=logChk %></button>
  <hr>
 </div>
</body>
</html>