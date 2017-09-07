import sun.java2d.pipe.OutlineTextRenderer;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Model {
    private static Model model;
    private static ArrayList<Gebruiker> gebruikers;
    private static ArrayList<Kamer> kamers;

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
            Gebruiker testGebruiker = new Gebruiker("Govert de Swart", "Govert", "Swart", false);
            model.addGebruikers(testGebruiker);
            model.addKamer(new Kamer(100,20,"Almelo",testGebruiker));
        }
        return model;
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    /**
     * Voeg een gebruiker toe
     *
     * @param gebruiker
     */
    public void addGebruikers(Gebruiker gebruiker) {
        gebruikers.add(gebruiker);
    }

    public void addKamer(Kamer kamer) {
        kamers.add(kamer);
    }

    /**
     * Kijkt of de gebruikersnaam en wachtwoord bij een gebruiker horen en stuurt deze gebruiker terug
     *
     * @param gebruikersNaam
     * @param password
     * @return
     */
    public Gebruiker getUser(String gebruikersNaam, String password) {
        for (Gebruiker gebruiker : gebruikers) {
            if (gebruiker.getGebruikersnaam().equals(gebruikersNaam)) {
                if (gebruiker.correctPassword(password)) {
                    return gebruiker;
                }
            }
        }
        return null;
    }


    private Model() {
        gebruikers = new ArrayList<>();
        kamers = new ArrayList<>();
    }

    public void printCertainRooms(double grootte, double maxPrijs, String plaats, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        boolean found = false;
        for(Kamer kamer : kamers){
            double tempGrootte = kamer.getGrootte();
            double tempMaxPrijs = kamer.getMaxprijs();
            String tempPlaats = kamer.getPlaats();
            //String tempHuurderNaam = kamer.getHuurderNaam();
            String tempVerhuurderNaam = kamer.getVerHuurderNaam();
            if(tempGrootte == grootte || grootte == 0){
                if(tempMaxPrijs == maxPrijs || maxPrijs == 0){
                    if(tempPlaats.equals(plaats) || plaats.isEmpty()){
                        found = true;
                        out.write("Verhuurder:" + tempVerhuurderNaam + " Grootte:" + tempGrootte +"m2 maxprijs:" + tempMaxPrijs + "euro plaats:" + tempPlaats);
                    }
                }
            }
            if(!found){
                out.write("Geen kamers gevonden met de opgeven  criteria");
            }

        }
    }

}
