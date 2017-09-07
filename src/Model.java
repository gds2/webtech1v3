import java.util.ArrayList;

public class Model {
    private static Model model;
    private ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private ArrayList<Kamer> kamers = new ArrayList<>();
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
    public boolean correctLogin(String gebruikersNaam, String password){
        for(Gebruiker gebruiker : gebruikers){
            if(gebruiker.getGebruikersnaam().equals(gebruikersNaam)){
                if(gebruiker.correctPassword(password)){
                    return true;
                }
            }
        }
        return false;
    }

    private Model() {
    }

}
