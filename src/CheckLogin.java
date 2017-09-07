

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/CheckLogin")
public class CheckLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gebruikersnaam = request.getParameter("username");
        String password = request.getParameter("password");
        ServletContext sc = getServletContext();
        Model model = (Model)sc.getAttribute("Model");
        if(model.correctLogin(gebruikersnaam,password)){
            response.sendRedirect("login.html");
        }
        else {
            response.sendRedirect("fouteinlog.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
