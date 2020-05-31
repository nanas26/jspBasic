package co.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	String memberid="me";
	String memberpw="1234";
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();

		String inputid=(String)request.getParameter("id");
		String inputpw=(String)request.getParameter("pw");
		String remember=(String)request.getParameter("remember");
		
		//주소관리: 어디에서 로그인을 접근했는지
		String subpage=(String)request.getParameter("subpage");
		System.out.println("어디서왔니?loginAction:"+subpage);//그냥 로그인에서 왔으면  null이뜰거야 아마?
		if(subpage.equals("")) {
			subpage="/filterplz/index.jsp";
		}
		
		//remember 제어
		if(remember!=null&&remember.equals("on")) {
			session.setAttribute("rememberid", inputid);//member되어있으면
						
		}else if(remember==null){
			session.removeAttribute("rememberid");
		}
		
		//로그인
		if(memberid.equals(inputid)) {//로그인성공시
			if(memberpw.equals(inputpw)) {
				session.setAttribute("loginid", inputid);
				response.sendRedirect(subpage);
			}
			//비밀번호 실패시
			writer.println("<script>alert('password wrong!');</script>");
			writer.println("<script>history.back();</script>");
		}else {
			//아이디 실패시
			writer.println("<script>alert('no existing id!');</script>");
			writer.println("<script>history.back();</script>");
		
		}

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
