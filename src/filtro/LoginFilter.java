package filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void destroy() {
        System.out.println("[INFO]: Destroy Filter...");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("[INFO]: Executing Filter...");

        HttpServletRequest requestHttp = (HttpServletRequest) request ;
        HttpServletResponse responseHttp = (HttpServletResponse) response ;
        HttpSession session = requestHttp.getSession(false);

        String url = requestHttp.getRequestURI();
        String method = requestHttp.getMethod();

        if(url.equalsIgnoreCase("/LoginSession") && method.equalsIgnoreCase("post")){
            chain.doFilter(request, response);
        }else{
            if(session==null){
                sendLoginForm(responseHttp, false);
            }else{
                String result = (String) session.getAttribute("usuarioLogado");
                if(result.equals("OK")){
                    chain.doFilter(request, response);
                }else{
                    sendLoginForm(responseHttp, false);
                }

            }
        }

    }

    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("[INFO]: Init Filter...");
    }

    private void sendLoginForm(ServletResponse response, boolean withErrorMessage) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Login Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Login Form</h1>");

        if(withErrorMessage)
            out.println("<h2 style='color: red'>Login Failed. Please try again. <br></h2>");

        out.println("<form method='post' action='LoginSession'>");
        out.println("Nome Usuário:");
        out.println("<input type='text' name='user'/> <br>");
        out.println("Senha: ");
        out.println("<input type='password' name='pass'/>");
        out.println("<input type='submit' value='Enviar'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}