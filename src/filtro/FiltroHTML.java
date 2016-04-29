package filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "filtro.FiltroHTML",
            urlPatterns = "/ServletHTML")
public class FiltroHTML implements Filter {
    public void destroy() {
        System.out.println("[INFO] Destruindo Filtro Anotations...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("[INFO] Filtro Funcionando HTML...");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> ExemploSendRedirect Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1><center>HEADER</cenetr></h1>");
        out.println("<br><br>");
        out.println("<hr>");
        out.println("<br><br>");


        chain.doFilter(req, resp);

        out.println("<br><br>");
        out.println("<hr>");
        out.println("<br><br>");
        out.println("<h1><center>FOOTER</center></h1>");
        out.println("</body>");
        out.println("</html>");

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("[INFO] Inicializando Filtro Anotations...");

    }

}
