public class User {
    private String username;
    private String password;
    private String sortUser;

    public User(String username, String password, String sortUser) {
        this.username = username;
        this.password = password;
        this.sortUser = sortUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSortUser() {
        return sortUser;
    }

    public void setSortUser(String sortUser) {
        this.sortUser = sortUser;
    }
}
