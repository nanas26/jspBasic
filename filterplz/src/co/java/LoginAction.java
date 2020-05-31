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
		
		//�ּҰ���: ��𿡼� �α����� �����ߴ���
		String subpage=(String)request.getParameter("subpage");
		System.out.println("��𼭿Դ�?loginAction:"+subpage);//�׳� �α��ο��� ������  null�̶�ž� �Ƹ�?
		if(subpage.equals("")) {
			subpage="/filterplz/index.jsp";
		}
		
		//remember ����
		if(remember!=null&&remember.equals("on")) {
			session.setAttribute("rememberid", inputid);//member�Ǿ�������
						
		}else if(remember==null){
			session.removeAttribute("rememberid");
		}
		
		//�α���
		if(memberid.equals(inputid)) {//�α��μ�����
			if(memberpw.equals(inputpw)) {
				session.setAttribute("loginid", inputid);
				response.sendRedirect(subpage);
			}
			//��й�ȣ ���н�
			writer.println("<script>alert('password wrong!');</script>");
			writer.println("<script>history.back();</script>");
		}else {
			//���̵� ���н�
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
