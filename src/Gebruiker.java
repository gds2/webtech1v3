public abstract class Gebruiker {
    private String naam;
    private String password;
    /**
     * Controleert of de gebruikersnaam en wachtwoord bij de gebruiker horen
     * @param naam
     * @param password
     * @return
     */
    public boolean correctLogin(String naam, String password){
        if(naam.equals(this.naam) && (password.equals(this.password))){
            return true;
        }
        else {
            return false;
        }
    }
}
