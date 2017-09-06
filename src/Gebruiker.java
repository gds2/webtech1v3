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
     * Controleert of de gebruikersnaam en wachtwoord bij de gebruiker horen
     * @param gebruikersnaam
     * @param password
     * @return
     */
    public boolean correctLogin(String gebruikersnaam, String password){
        if(gebruikersnaam.equals(this.gebruikersnaam) && (password.equals(this.password))){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isHuurder(){
        if(type.equals("Huurder")){
            return true;
        }
        else {
            return false;
        }
    }

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
