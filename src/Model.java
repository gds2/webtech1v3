import java.util.ArrayList;

public class Model {
    private static Model model;
    private static ArrayList<Gebruiker> gebruikers;
    private static ArrayList<Kamer> kamers;
    public static Model getInstance() {
            if(model == null){
                model = new Model();
                Gebruiker testGebruiker = new Gebruiker("Govert de Swart","Govert","Swart",true);
                model.addGebruikers(testGebruiker);
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
     * @param gebruiker
     */
    public void addGebruikers(Gebruiker gebruiker){
        gebruikers.add(gebruiker);
    }
    public void addKamer(Kamer kamer){
        kamers.add(kamer);
    }

    /**
     * Kijkt of de gebruikersnaam en wachtwoord juist zijn
     * @param gebruikersNaam
     * @param password
     * @return
     */
    public Gebruiker getUser(String gebruikersNaam, String password){
        for(Gebruiker gebruiker : gebruikers){
            if(gebruiker.getGebruikersnaam().equals(gebruikersNaam)){
                if(gebruiker.correctPassword(password)){
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

}
