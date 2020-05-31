package co.java;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="LogFilter", urlPatterns={"/board.jsp","/lecture.jsp"})
public class LogFilter implements Filter {

    public LogFilter() {}
    
    // filter 초기화 작업 작성
   public void init(FilterConfig fConfig) throws ServletException {}
   
   // filter가 제거되기 전에 수행되어야 할 마무리 작업 작성
   public void destroy() {}

   
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // 1. 서블릿이 요청을 받기 전에 처리할 작업 작성(요청 전처리 작업)
      HttpServletRequest httpRequest = (HttpServletRequest)request;
      HttpSession session = httpRequest.getSession(true);

      System.out.println("logFilter가동");
      
      // id로 된 세션 가져오기
      String id = (String)session.getAttribute("loginid");
      boolean isLogin = id!=null? true : false;
      
      // uri 가져오기
      String uri = httpRequest.getRequestURI();
      System.out.println("필터에서 uri는:"+uri);
      
      // 메시지 띄우기
      String errMsg = "접근 권한이 없습니다. 로그인 해주세요.";
      errMsg = URLEncoder.encode(errMsg, "utf-8");
      
      
       //1. 로그인이 되어 있으면, chain.doFilter(request, response)를 호출해서 서블릿의 service()를 호출.
      if(isLogin) {
         // 다음 filter가 작업을 할 수 있게 요청과 응답을 전달(그대로 사용)
         chain.doFilter(request, response);
         
      // 2. 로그인이 되어 있지 않으면, login.jsp
      } else {
         // 로그인 필요하다는 메세지와 함께 전달
         RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp?errMsg="+errMsg+"&uri="+uri);
         dispatcher.forward(request, response);
      }

   }



}