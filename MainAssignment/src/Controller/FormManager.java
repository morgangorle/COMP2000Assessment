package Controller;

import View.*;
import Model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//This uses the singleton Pattern to help manage Forms
public class FormManager {

    private static FormManager Instance;
    private MainGUI InitialForm;
    private LoginGUI LoginForm;
    private AdminGUI AdminForm;
    private User[] users;
    private Item[] items;

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
                    String[] entry = line.split(splitBy);// use comma as separator
                    boolean inputBool = false;
                    if(entry[2] == "true"){
                        inputBool = true;
                    }

                    User newUser = new User(entry[0],entry[1],inputBool);
                    users[userNum] = newUser;
                    userNum ++;
                }
                //System.out.println("Model.User " + users[6].getUsername() + " was added");
            }
            catch (IOException error){
                System.out.println("An error occurred");

            }

        }
        return users;
    }
    public Item[] getItems(){
        String filePath = "resources\\Stock.csv";
        if(items == null){
            try{
                items = new Item[10];
                String line = "";
                String splitBy = ",";
                int itemNum = 0;
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] entry = line.split(splitBy);// use comma as separator


                    Item newItem = new Item(entry[0],entry[1],Float.parseFloat(entry[2]),Integer.parseInt(entry[3]));
                    items[itemNum] = newItem;
                    itemNum ++;
                }
                //System.out.println("Model.User " + users[6].getUsername() + " was added");
            }
            catch (IOException error){
                System.out.println("An error occurred");

            }

        }
        return items;
    }
    public void setInitialForm(MainGUI newForm){
        InitialForm = newForm;
    }
    public void setLoginForm(LoginGUI newForm){
        LoginForm = newForm;
    }
    public void setAdminForm(AdminGUI newForm){
        AdminForm = newForm;
    }
    public LoginGUI getLoginForm(){
        return LoginForm;
    }
    public MainGUI getInitialForm(){
        return InitialForm;
    }
    public AdminGUI getAdminForm(){
        return AdminForm;
    }
}
