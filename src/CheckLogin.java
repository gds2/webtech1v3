

import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/CheckLogin")
public class CheckLogin extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext sc = getServletContext();
        model = (Model)sc.getAttribute("Model");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gebruikersnaam = request.getParameter("username");
        String password = request.getParameter("password");
        //Haal de gebruiker op die bij de username en password horen
        Gebruiker gebruiker = model.getUser(gebruikersnaam,password);
        //Bepaal naar welke pagina de gebruiker wordt gestuurd
        if(gebruiker != null){
            //Wanner de gebruiker is ingelogd, dan maken we een sessie aan
            HttpSession loginSession = request.getSession();
            //Voeg de gebruiker toe aan de sessie
            loginSession.setAttribute("gebruiker",gebruiker);
            if(gebruiker.isVerhuurder()){
                //Forward de verhuurder naar de bijbehorende huurder.html
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/verhuurder");
                rd.forward(request,response);
            }
            else{
                //Forward de huurder naar de bijbehorende huurder.html
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/huurder.html");
                rd.forward(request,response);
            }

        }
        else {
            //Redirect de gebruiker naar de fouteinlogpagina
            response.sendRedirect("fouteinlog.html");
        }


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
