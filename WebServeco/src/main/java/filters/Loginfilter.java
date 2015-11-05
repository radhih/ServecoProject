package filters;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoginBean;






/**
 * Servlet Filter implementation class Loginfilter
 */
@WebFilter("/Pages/supplier/*")
public class Loginfilter implements Filter {


	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
		if (loginBean != null && loginBean.isLoggedIn() == true) {
			filterChain.doFilter(request, response);
		} else if (request.getRequestURL().toString().contains("login.jsf")) {
			filterChain.doFilter(request, response);

		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsf");
		}

	}
   

	public void init(FilterConfig fConfig) throws ServletException {
		// Not	to do here
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
