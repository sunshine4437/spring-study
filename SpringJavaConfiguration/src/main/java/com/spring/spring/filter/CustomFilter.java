package com.spring.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		System.out.println("=== Filtering Start ===");
		System.out.println("Filter getServletPath : " + httpServletRequest.getServletPath());
		chain.doFilter(request, response);

		System.out.println("=== Filtering End ===");
	}

	@Override
	public void destroy() {
		System.out.println("Filter destory");
	}

}
