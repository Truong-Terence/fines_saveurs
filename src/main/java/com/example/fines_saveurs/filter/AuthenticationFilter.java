package com.example.fines_saveurs.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("email") != null) {
            chain.doFilter(req, res);
        } else {
            if (request.getRequestURI().contains(request.getContextPath() + "/webapi") || (request.getRequestURI().contains(request.getContextPath() + "/home")) || (request.getRequestURI().contains(request.getContextPath() + "/login")) ) {
                ((HttpServletResponse) res).addHeader("Access-Control-Allow-Origin", "http://localhost:9090");
                ((HttpServletResponse) res).addHeader("Access-Control-Allow-Methods", "POST, GET");
                ((HttpServletResponse) res).addHeader("Access-Control-Allow-Headers", "Content-Type");

                chain.doFilter(req, res);
            } else {
                response.sendRedirect("/home");
            }
        }
    }
}