

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/verhuurder")
public class ShowRoomsServlet extends HttpServlet {
    Model model;
    @Override
    public void init() throws ServletException {
        super.init();
        model = (Model) getServletContext().getAttribute("Model");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //Haal de huidige huurder op van de session
        Gebruiker verhuurder = (Gebruiker)request.getSession().getAttribute("gebruiker");
        //Geef de pagina
        out.println("<html><body>");
        out.println(model.getAllRoomsFromUser(verhuurder));
        out.println("<form method=\"post\" action=\"ForwardToAddroom\">");
        out.println("<input type=\"submit\" value=\"Voeg kamer toe\"></td></form>");
        out.println("<form method=\"get\" action=\"Beheer\">");
        out.println("<input type=\"submit\" value=\"Beheer\"></td></form>");
        out.println("<form method=\"post\" action=\"Logout\">");
        out.println("<input type=\"submit\" value=\"Logout\"></td></form>");
        out.println("</body></html>");
    }
}
