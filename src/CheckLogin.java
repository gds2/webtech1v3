

import javax.servlet.RequestDispatcher;
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
        Gebruiker gebruiker = model.getUser(gebruikersnaam,password);
        if(gebruiker != null){
            if(gebruiker.isVerhuurder()){

            }
            else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/huurder.html");
                rd.forward(request,response);
            }

        }
        else {
            response.sendRedirect("fouteinlog.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
