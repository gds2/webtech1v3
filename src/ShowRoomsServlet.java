

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        //Geef alle kamers
        response.getWriter().write(model.getAllRooms());
    }
}
