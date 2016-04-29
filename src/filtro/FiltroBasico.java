package filtro;

import javax.servlet.*;
import java.io.IOException;

public class FiltroBasico implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[INFO] Destruindo filtro.FiltroBasico Basico...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("[INFO] filtro.FiltroBasico Funcionando Basico...");
         filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("[INFO] Inicializando filtro.FiltroBasico Basico...");
    }
}
