

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "/Beheer")
public class ShowPersonsServlet extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (Model)getServletContext().getAttribute("Model");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Maak een nieuwe cookie aan van de huidige tijd
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        Date date = new Date();
        Cookie huidigeDatum = new Cookie("lastVisit",dateFormat.format(date));
        huidigeDatum.setMaxAge(60*60*24);
        response.addCookie(huidigeDatum);
        //Kijk door de cookies naar de tijd van wanneer de gebruiker voor het laatst de pagina bezocht heeft
        Cookie[] cookies = request.getCookies();
        int aantalKeerBezocht = 1;
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("lastVisit")) {
                //Print de tijd van het laatste bezoek
                response.getWriter().println("Deze pagina heeft u voor het laatst bezocht op " + cookie.getValue());
            }
            if(cookie.getName().equals("visitAmount")){
                aantalKeerBezocht = Integer.parseInt(cookie.getValue());
                aantalKeerBezocht++;
                response.getWriter().println("Deze pagina heeft u " + cookie.getValue() + " keer bezocht");
            }
        }
        Cookie aantalKeerBezochtCookie = new Cookie("visitAmount",Integer.toString(aantalKeerBezocht));
        response.addCookie(aantalKeerBezochtCookie);
        //Print de gegevens van alle gebruikers
        response.getWriter().println(model.getAllUsers());


    }
}
