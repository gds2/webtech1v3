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

    /**
     * Geeft een string terug met alle benodigde informatie van een kamer
     * @return
     */
    @Override
    public String toString() {
        return "Verhuurder:" + verhuurder.getNaam() + ";Grootte:" + grootte +" vierkante meter;Maxprijs:" + maxprijs + " euro;plaats:" + plaats;
    }

    /**
     * Controleert of de opgegeven verhuurder hetzelfde is als de verhuurder van de huidige kamer
     * @param gebruiker
     * @return
     */
    boolean zelfdeGebruiker(Gebruiker gebruiker){
        if(gebruiker.getGebruikersnaam().equals(this.verhuurder.getGebruikersnaam())){
            return true;
        }
        else{
            return false;
        }
    }
}
