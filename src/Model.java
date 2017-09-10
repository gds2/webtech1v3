
import java.util.ArrayList;

public class Model {
    private static Model model;
    private static ArrayList<Gebruiker> gebruikers;
    private static ArrayList<Kamer> kamers;

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
            Gebruiker testGebruiker = new Gebruiker("Govert de Swart", "Govert", "Swart", true);
            model.addGebruikers(testGebruiker);
            model.addKamer(new Kamer(100,20,"Almelo",testGebruiker));
        }
        return model;
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

    /**
     * Haal een string op die kamers bevat met de opgegeven criteria
     * @param grootte
     * @param maxPrijs
     * @param plaats
     * @return
     */
    public String getCertainRooms(double grootte, double maxPrijs, String plaats)  {
        String result = "";
        for(Kamer kamer : kamers){
            double tempGrootte = kamer.getGrootte();
            double tempMaxPrijs = kamer.getMaxprijs();
            String tempPlaats = kamer.getPlaats();
            if(tempGrootte == grootte && tempMaxPrijs== maxPrijs && tempPlaats.equals(plaats)){
                result = result + kamer.toString() + "\n";
            }
        }
        if(result.isEmpty()){
            return "Geen kamers gevonden met de opgeven criteria";
        }
        return result;
    }

    /**
     * Haal een string op die alle kamers bevat
     * @return
     */
    public String getAllRooms(){
        String result = "";
        for(Kamer kamer : kamers){
            result = result + kamer.toString() + "\n";
        }
        if(result.isEmpty()){
            return "Er zijn geen kamers om te weergeven";
        }
        return result;
    }

    /**
     * Geeft een string met de gevens van alle gebruikers
     * @return
     */
    public String getAllUsers(){
        String result = "";
        for(Gebruiker gebruiker : gebruikers){
            result = result + gebruiker.toString() + "\n";
        }
        return result;
    }

}
