import java.util.Objects;

public class UserSession {
    private static UserSession instance = null;
    private String userName;

    private UserSession() {}

    public static UserSession getInstance(){
        if (instance == null) {
            instance = new UserSession();
        }
        else {
            System.out.println("One session at a time please!");
        }
        return instance;
    }

    public void logout(){
        System.out.printf("%s has logged out \n", this.getUserName());
        this.userName = null;
        instance = null;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName) {
        if (Objects.equals(this.userName, userName)){
            System.out.println("User is already logged in!");
        }
        else if (this.userName == null) {
            this.userName = userName;
            System.out.printf("Currently logged in as %s%n", this.getUserName());
        }
        else {
            System.out.println("Only 1 user at a time!");
        }
    }
}
