package by.tsarionok.controller.filter;

import by.tsarionok.page.JspPage;
import by.tsarionok.page.PageManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UriActionFilter implements Filter {
    // TODO:
    //  - add logging

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws
            IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();

        int beginAction = contextPath.length();
        String pageUri = uri.substring(beginAction);
        JspPage page = PageManager.createPage(pageUri);
        if (page != null) {
            request.setAttribute("page", page);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getServletContext()
                    .setAttribute("error", "Unknown " + uri + " page");
            request.getServletContext()
                    .getRequestDispatcher("/jsp/error.jsp")
                    .forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
