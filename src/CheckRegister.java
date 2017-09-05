import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet")
public class CheckRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Gebruiker kan niet een huurder en verhuurder zijn
        if(request.getParameter("Huurder") != null & request.getParameter("Verhuurder") != null) {
            response.sendRedirect("fouteinlog.html");
        }
        //Gebruiker moet een keuze maken
        else if(request.getParameter("Huurder") == null & request.getParameter("Verhuurder") == null) {
            response.sendRedirect("fouteinlog.html");
        }
        //Gebruiker is een huurder
        else if(request.getParameter("Huurder") != null){

        }
        //Gebruiker is een verhuurder
        else if(request.getParameter("Verhuurder") != null){

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
