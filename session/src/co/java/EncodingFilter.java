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
		//���ڵ��� �ȵǾ� �ִٸ�
		if(request.getCharacterEncoding()==null){
		//�ѱ� ���ڵ� �����ϱ�
		request.setCharacterEncoding(encoding);

		}
		//���� ���� ü������ ��������� �ѱ��, ���̻� ���Ͱ� ���ٸ� ��û�������� ��������� �Ѿ��.
		chain.doFilter(request, response);
	}

	String encoding;

	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encoding");
	}
	

	

}
