package struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodingFilter extends HttpServlet implements Filter {

	private String encoding=null;
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	    encoding=filterConfig.getInitParameter("encoding");//获得初始化参数的值
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
         HttpServletRequest request=(HttpServletRequest) req;
         HttpServletResponse response=(HttpServletResponse) resp;
         
         request.setCharacterEncoding(encoding);
         response.setCharacterEncoding(encoding);
         response.setContentType("text/html;charset="+encoding);

         filterChain.doFilter(req, resp);
	}
    
}
