package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CountFilter implements Filter {
    private static int count = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        count++;
        System.out.println("Filter 가 작동한 횟수는 : " + count);

        chain.doFilter(request, response);
    }
}
