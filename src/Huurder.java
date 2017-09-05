public class Huurder extends Gebruiker {
    private Kamer kamer;
    public void setKamer(Kamer kamer) {
        this.kamer = kamer;
    }
    public double getKamerGrootte(){
        return kamer.getGrootte();
    }
    public double getMaxKamerPrijs(){
        return kamer.getMaxprijs();
    }
    public String getKamerPlaats(){
        return kamer.getPlaats();
    }

}
