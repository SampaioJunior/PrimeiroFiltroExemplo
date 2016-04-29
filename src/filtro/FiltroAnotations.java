package filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filtro.FiltroAnotations",
            urlPatterns = {"/ServletFiltrado", "/ServletFiltrado2"})
public class FiltroAnotations implements Filter {
    public void destroy() {
        System.out.println("[INFO] Destruindo Filtro Anotations...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("[INFO] Filtro Funcionando Anotations...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("[INFO] Inicializando Filtro Anotations...");
    }

}
