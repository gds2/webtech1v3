public class Gebruiker {
    private String naam;
    private String gebruikersnaam;
    private String password;
    private String type;


    public Gebruiker(String naam, String gebruikersnaam, String password, String type) {
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
        this.password = password;
        this.type = type;
    }

    /**
     * Controleert of het wachtwoord bij de gebruiker hoort
     * @param password
     * @return
     */
    public boolean correctPassword (String password){
        if(password.equals(this.password)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Controleert of de gebruiker een huurder is
     * @return
     */
    public boolean isHuurder(){
        if(type.equals("Huurder")){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Controleert of de gebruiker een verhuurder is
     * @return
     */
    public boolean isVerhuurder(){
        if(type.equals("Verhuurder")){
            return true;
        }
        else {
            return false;
        }
    }



    public String getNaam() {
        return naam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

}
