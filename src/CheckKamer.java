import javax.jws.WebParam;
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
        checkError = false;
        ServletContext servletContext = getServletContext();
        model = (Model) servletContext.getAttribute("Model");

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
            //model.addKamer(new Kamer(grootte,maxprijs,plaats,new Gebruiker(verhuurder)));
        }
    }
}
