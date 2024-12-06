/*
package com.beien;

import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

*/
/**
 * @author beien
 * @date 2023-05-19 12:19
 * Copyright© 2023 beien
 *//*

public class ActuatorAuthFilter implements Filter, Ordered {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean authPass = false;
        HttpServletRequest req = (HttpServletRequest) request;
        String system = req.getHeader("system");
        String token = req.getHeader("token");
        if ( system!=null && token!=null) {
            if(system.equals("itbeien.cn") && token.equals("7e447e5d38d323b847edf2b4895eb242")){
                authPass = true;
            }
        }
        if (authPass) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().println("NoAuthAccess");
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public int getOrder() {
        return 11;
    }
}
*/
