package Model;

public class User extends ModelItem {
    private String Username;
    private String Password;
    private Boolean isAdmin;
    public User(String inputUsername, String inputPassword){
        Username = inputUsername;
        Password = inputPassword;
        isAdmin = false;

    }
    public User(String inputUsername, String inputPassword, Boolean inputisAdmin){
        Username = inputUsername;
        Password = inputPassword;
        isAdmin = inputisAdmin;

    }
    public String getUsername(){
        return Username;

    }
    public String getPassword(){
        return Password;

    }
    public Boolean getIsAdmin(){
        return isAdmin;

    }
}
