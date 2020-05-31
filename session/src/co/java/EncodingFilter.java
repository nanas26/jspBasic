package co.java;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName="EncodingFilter", urlPatterns= {"/*"})
public class EncodingFilter implements Filter {
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//인코딩이 안되어 있다면
		if(request.getCharacterEncoding()==null){
		//한글 인코딩 설정하기
		request.setCharacterEncoding(encoding);

		}
		//다음 필터 체인으로 실행순서를 넘긴다, 더이상 필터가 없다면 요청페이지로 실행순서가 넘어간다.
		chain.doFilter(request, response);
	}

	String encoding;

	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encoding");
	}
	

	

}
