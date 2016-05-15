package filtro;

import dao.LoginDAO;
import model.Login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebFilter("/*")
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login </title>");
        out.println("</head>");
        out.println("<body>");

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        Login log = LoginDAO.adiciona(user,pass);

        if(log != null) {
            RequestDispatcher rd = req.getRequestDispatcher("/LoginOk");
            rd.include(req, resp);
        }
        else{
            chain.doFilter(req, resp);
        }

        out.println("</body>");
        out.println("</html>");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
