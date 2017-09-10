import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/CheckKamer")
public class CheckKamer extends HttpServlet {
    private boolean checkError;
    private Model model;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext servletContext = getServletContext();
        model = (Model) servletContext.getAttribute("Model");
        checkError = false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double grootte = Double.parseDouble(req.getParameter("kGrootte"));
        double maxprijs = Double.parseDouble(req.getParameter("kMaxPrijs"));
        String plaats = req.getParameter("kPlaats");

        if(grootte <=0||maxprijs <=0||plaats.isEmpty()){
            checkError = true;
        }

        if(!checkError){
            //Voeg een nieuwe kamer toe met de gegevens die ingevoerd zijn + de sessie waarin de gebruiker is ingelogd
            model.addKamer(new Kamer(grootte,maxprijs,plaats, (Gebruiker) req.getSession().getAttribute("gebruiker")));
            RequestDispatcher  rd = getServletContext().getRequestDispatcher("/verhuurder");
            rd.forward(req,resp);
        }
    }
}
