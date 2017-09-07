

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/CheckRegister")

public class CheckRegister extends HttpServlet {

    private boolean checkError = false;
    private boolean isVerhuurder;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordRe = request.getParameter("passwordRe");
        String sortHuurder = request.getParameter("sortHuurder");

        //Als 1 van de textboxen leeg is, dan meld een error
        if(name.isEmpty()||username.isEmpty()||password.isEmpty()||passwordRe.isEmpty()||sortHuurder.isEmpty()){
            checkError = true;
        }
        //Anders ga verder met controlleren
        if(!checkError){
            if(passwordRe.equals(password)){
                if(sortHuurder.equals("Verhuurder")){
                    isVerhuurder = true;
                }else {
                    isVerhuurder = false;
                }
                //Roep de servlet context aan
                ServletContext servletContext = getServletContext();
                //Pak de model uit de servlet context
                Model model = (Model) servletContext.getAttribute("Model");
                //Maak en voeg de nieuwe gebruiker toe aan de gebruikers
                model.addGebruikers(new Gebruiker(name,username,password,isVerhuurder));
            }else {
                checkError = true;
            }
        }

        if(!checkError){
            response.sendRedirect("login.html");
        }else {
            response.sendRedirect("registreer.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
