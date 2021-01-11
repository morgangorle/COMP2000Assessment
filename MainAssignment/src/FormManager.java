import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//This uses the singleton Pattern to help manage Forms
public class FormManager {

    private static FormManager Instance;
    private MainGUI InitialForm;
    private AdminGUI AdminForm;
    private User[] users;

    private FormManager(){

    }
    public static FormManager getInstance(){
        if(Instance == null){
            Instance = new FormManager();


        }
        return Instance;

    }
    public User[] getUsers(){
        String filePath = "resources\\Users.csv";
        if(users == null){
            try{
                users = new User[25];
                String line = "";
                String splitBy = ",";
                int userNum = 0;
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] entry = line.split(splitBy);    // use comma as separator

                    User testUser = new User(entry[0],entry[1]);
                    users[userNum] = testUser;
                    userNum ++;
                }
                System.out.println("User " + users[6].getUsername() + " was added");
            }
            catch (IOException error){
                System.out.println("An error occurred");

            }

        }
        return users;
    }
    public void setInitialForm(MainGUI newForm){
        InitialForm = newForm;
    }
    public void setAdminForm(AdminGUI newForm){
        AdminForm = newForm;
    }
    public AdminGUI getAdminForm(){
        return AdminForm;
    }
    public MainGUI getInitialForm(){
        return InitialForm;
    }
}
