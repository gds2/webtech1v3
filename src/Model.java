import java.util.ArrayList;

public class Model {
    private static Model model;
    private ArrayList<Gebruiker> gebruikers = new ArrayList<>();
    private ArrayList<Kamer> kamers = new ArrayList<>();
    private String test = "Govert";
    public static Model getInstance() {
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    private Model() {
    }

    public String getTest() {
        return test;
    }
}
