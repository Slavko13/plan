package ru.dayPlanning.auth;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@WebFilter(urlPatterns = "/main/*")
public class LoginFilter implements Filter {

    @Inject
    private LoginBean loginBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        loginBean.setPageAfterLogin(request.getContextPath() + "/main/home.xhtml");

        if (loginBean.isLoggedIn()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
            response.sendRedirect(request.getContextPath() + "/auth/login.xhtml");
    }

    @Override
    public void destroy() {
        //
    }
}
