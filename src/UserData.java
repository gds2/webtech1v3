import java.util.ArrayList;

public class UserData {
    private static UserData instance;
    private ArrayList<User> users;

    private UserData(){
        users = new ArrayList<>();
    }

    public static UserData getInstance(){
        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }

    public void addUser(User user){
        users.add(user);
    }

}
