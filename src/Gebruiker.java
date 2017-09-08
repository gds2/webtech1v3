public class Gebruiker {
    private String naam;
    private String gebruikersnaam;
    private String password;
    private Boolean isVerhuurder;


    public Gebruiker(String naam, String gebruikersnaam, String password, Boolean isVerhuurder) {
        this.naam = naam;
        this.gebruikersnaam = gebruikersnaam;
        this.password = password;
        this.isVerhuurder = isVerhuurder;
    }

    /**
     * Controleert of het wachtwoord bij de gebruiker hoort
     * @param password
     * @return
     */
    public boolean correctPassword (String password) {
        if (password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Controleert of de gebruiker een verhuurder is
     * @return
     */
    public boolean isVerhuurder(){
        return isVerhuurder;
    }

    /**
     * Zet de gevens van de gebruiker om in een string
     * @return
     */
    @Override
    public String toString() {
        if(isVerhuurder) {
            return "Naam:" + naam + ";Gebruikersnaam:" + gebruikersnaam + ";Rol:Verhuurder";
        }
        else{
            return "Naam:" + naam + ";Gebruikersnaam:" + gebruikersnaam + ";Rol:Huurder";
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public boolean getIsVerhuurder(){ return isVerhuurder; }

}
