package co.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName="LogFilter", urlPatterns= {"/subpage/board.jsp"})
public class LogFilter implements Filter {
    public LogFilter() {}
	public void destroy() {}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("������?");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out =response.getWriter();
		//�ڽİ�ü�� ����ȯ �Ѵ���
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		
//		String uri=httpRequest.getRequestURI();
//		System.out.println("uri:"+uri);
//		String includewhat=(String) request.getAttribute("javax.servlet.include.request_uri");
//		System.out.println("include�� uri:"+includewhat);
		
		//���� ��ü�� ���´�.
		HttpSession session=httpRequest.getSession(false);
		//�α��� �ߴ��� �ƴ����� ���� ����
		boolean isLogin=false;
		if(session!=null){
			String loginid=(String)session.getAttribute("loginid");
			System.out.println("logFilter:"+loginid+"�־�?");
			if(loginid!=null)isLogin=true;
		}

		if(isLogin){//�α��� �� ��쿡�� ��û�� �۾��� ����Ѵ�.
			chain.doFilter(request, response);
		}else{//�α��� ���� ���� ���
			out.println("<script>alert('login please');</script>");
			out.println("<script>location.href='/session/index.jsp?subpage=login&from=board';</script>");
		}
		chain.doFilter(request,response);
	}


}
