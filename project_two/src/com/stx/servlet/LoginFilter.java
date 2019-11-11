package com.stx.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 判断用户有没有登录：从session中判断有没有用户编号
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession session = hsr.getSession();
		Integer uid = (Integer)session.getAttribute("uid");
		if (uid != null) {
			// 用户已处于登录成功状态
			chain.doFilter(request, response);
		} else {
			// 用户没有登录的状态，重定向到登录界面
			HttpServletResponse res = (HttpServletResponse)response;
			System.out.println(hsr.getContextPath());
			res.sendRedirect(hsr.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
