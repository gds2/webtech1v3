public class Kamer {
   private double grootte;
   private double maxprijs;
   private String plaats;

    public Kamer(double grootte, double maxprijs, String plaats) {
        this.grootte = grootte;
        this.maxprijs = maxprijs;
        this.plaats = plaats;
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
}
