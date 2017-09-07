

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/Search")
public class SearchRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Model model = (Model)getServletContext().getAttribute("Model");
        double grootte = Double.parseDouble(request.getParameter("Grootte"));
        double maxprijs = Double.parseDouble(request.getParameter("Maxprijs"));
        String plaats = request.getParameter("Plaats");
        model.printCertainRooms(grootte,maxprijs,plaats,response);


    }
}
