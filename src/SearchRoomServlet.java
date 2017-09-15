

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/Search")
public class SearchRoomServlet extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        super.init();
        model = (Model)getServletContext().getAttribute("Model");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Haal de gegevens op
        try {
            double grootte = Double.parseDouble(request.getParameter("Grootte"));
            double maxprijs = Double.parseDouble(request.getParameter("Maxprijs"));
            String plaats = request.getParameter("Plaats");
            response.getWriter().write(model.getCertainRooms(grootte,maxprijs,plaats));
        }
        //Vang een numberformat exeption voor wanneer een gebruiker niet een cijfer opgeeft bij de grootte en max prijs
        catch (NumberFormatException  er){
            response.getWriter().println("Voer een cijfer in voor de grootte en de max prijs");
        }


    }
}
