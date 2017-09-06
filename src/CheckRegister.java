import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/CheckRegister")
public class CheckRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean error = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordRe = request.getParameter("passwordRe");
        String sortUser = request.getParameter("sortUser");

        //Check of alle gegevens zijn ingevoerd
        if(username == null){
            error = true;
        }
        if(password == null){
            error = true;
        }
        if(passwordRe == null){
            error = true;
        }
        if(sortUser == null){
            error = true;
        }
        //Als we geen errors hebben dan gaan we verder met het aanmaken van de gebruiker
        if(!error){
            //Als de wachtwoorden niet overeen komen
            if(password!=passwordRe){
                error = true;
            }
            //Als er geen errors zijn, maak gebruiker aan en voeg toe aan gebruikers
            if(!error){
                //Voeg de nieuwe gebruiker toe
                UserData.getInstance().addUser(new User(username,password,sortUser));
            }
            //Als de nieuwe gebruiker is toegevoegd, dan redirect naar login.html pagina
            if(!error){
                response.sendRedirect("login.html");
            }else {
                response.sendRedirect("fouteregistratie.html");

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
