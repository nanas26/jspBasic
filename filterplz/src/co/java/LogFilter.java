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
    
    // filter �ʱ�ȭ �۾� �ۼ�
   public void init(FilterConfig fConfig) throws ServletException {}
   
   // filter�� ���ŵǱ� ���� ����Ǿ�� �� ������ �۾� �ۼ�
   public void destroy() {}

   
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // 1. ������ ��û�� �ޱ� ���� ó���� �۾� �ۼ�(��û ��ó�� �۾�)
      HttpServletRequest httpRequest = (HttpServletRequest)request;
      HttpSession session = httpRequest.getSession(true);

      System.out.println("logFilter����");
      
      // id�� �� ���� ��������
      String id = (String)session.getAttribute("loginid");
      boolean isLogin = id!=null? true : false;
      
      // uri ��������
      String uri = httpRequest.getRequestURI();
      System.out.println("���Ϳ��� uri��:"+uri);
      
      // �޽��� ����
      String errMsg = "���� ������ �����ϴ�. �α��� ���ּ���.";
      errMsg = URLEncoder.encode(errMsg, "utf-8");
      
      
       //1. �α����� �Ǿ� ������, chain.doFilter(request, response)�� ȣ���ؼ� ������ service()�� ȣ��.
      if(isLogin) {
         // ���� filter�� �۾��� �� �� �ְ� ��û�� ������ ����(�״�� ���)
         chain.doFilter(request, response);
         
      // 2. �α����� �Ǿ� ���� ������, login.jsp
      } else {
         // �α��� �ʿ��ϴٴ� �޼����� �Բ� ����
         RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp?errMsg="+errMsg+"&uri="+uri);
         dispatcher.forward(request, response);
      }

   }



}