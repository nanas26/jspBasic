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
		System.out.println("들어왔음?");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out =response.getWriter();
		//자식객체로 형변환 한다음
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		
//		String uri=httpRequest.getRequestURI();
//		System.out.println("uri:"+uri);
//		String includewhat=(String) request.getAttribute("javax.servlet.include.request_uri");
//		System.out.println("include된 uri:"+includewhat);
		
		//세션 객체를 얻어온다.
		HttpSession session=httpRequest.getSession(false);
		//로그인 했는지 아닌지에 대한 여부
		boolean isLogin=false;
		if(session!=null){
			String loginid=(String)session.getAttribute("loginid");
			System.out.println("logFilter:"+loginid+"있어?");
			if(loginid!=null)isLogin=true;
		}

		if(isLogin){//로그인 된 경우에는 요청된 작업을 계속한다.
			chain.doFilter(request, response);
		}else{//로그인 하지 않은 경우
			out.println("<script>alert('login please');</script>");
			out.println("<script>location.href='/session/index.jsp?subpage=login&from=board';</script>");
		}
		chain.doFilter(request,response);
	}


}
