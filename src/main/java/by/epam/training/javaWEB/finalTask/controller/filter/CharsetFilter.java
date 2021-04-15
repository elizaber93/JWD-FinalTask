package by.epam.training.javaWEB.finalTask.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private static final String INIT_PARAMETER = "characterEncoding";

    private String encoding;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(INIT_PARAMETER);
        context = filterConfig.getServletContext();
        context.log("CharsetFilter is initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        context.log("Charset was set.");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        context = null;
    }
}
