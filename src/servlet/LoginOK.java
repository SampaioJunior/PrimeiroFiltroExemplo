package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginOK",
            urlPatterns = "/LoginOK")
public class LoginOK extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        PrintWriter out = response.getWriter();

        if (user == null && user.isEmpty() && pass == null && pass.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("/LoginServlet");
            rd.include(request, response);
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Usuário : "+ user + "</h1>");
            out.println("<h1>Senha : "+ pass + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
