//package com.myblog.filter;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CORSFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        res.addHeader("Access-Control-Allow-Credentials","true");
//        res.addHeader("Access-Control-Allow-Origin","*");
//        res.addHeader("Access-Control-Allow-Methods","GET,POST,DELETE,PUT");
//        res.addHeader("Access-Control-Allow-Headers","Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN, Authorization");
//        if (((HttpServletRequest) servletRequest).getMethod().equals("OPTIONS")){
//            servletResponse.getWriter().println("ok");
//            return;
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
