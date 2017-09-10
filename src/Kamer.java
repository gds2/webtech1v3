public class Kamer {
   private double grootte;
   private double maxprijs;
   private String plaats;
   private Gebruiker verhuurder;

    public Kamer(double grootte, double maxprijs, String plaats, Gebruiker verhuurder) {
        this.grootte = grootte;
        this.maxprijs = maxprijs;
        this.plaats = plaats;
        this.verhuurder = verhuurder;
    }

    public double getGrootte() {
        return grootte;
    }

    public double getMaxprijs() {
        return maxprijs;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getVerHuurderNaam() {
        return verhuurder.getNaam();
    }

    @Override
    public String toString() {
        return "Verhuurder:" + verhuurder.getNaam() + ";Grootte:" + grootte +" vierkante meter;Maxprijs:" + maxprijs + " euro;plaats:" + plaats;
    }
}
