package com.figue.test.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AMRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
      
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
        	String headName = names.nextElement();
        	System.out.println("head:"+headName+"【"+request.getHeader(headName)+"】");
        }
      
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("结束-----------------------");
    }

    @Override
    public void destroy() {

    }
}