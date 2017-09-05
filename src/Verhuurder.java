import java.util.ArrayList;

public class Verhuurder extends Gebruiker {
    private ArrayList<Kamer> kamers = new ArrayList<>();

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public void addKamers(Kamer kamer){
        kamers.add(kamer);
    }
}
