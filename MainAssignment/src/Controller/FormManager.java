package Controller;

import View.*;
import Model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//This uses the singleton Pattern to help manage Forms
public class FormManager {

    private static FormManager Instance;
    private MainGUI InitialForm;
    private LoginGUI LoginForm;
    private AdminGUI AdminForm;
    private ArrayList<Item> items;
    private ArrayList<User> users;

    private FormManager(){

    }
    public static FormManager getInstance(){
        if(Instance == null){
            Instance = new FormManager();


        }
        return Instance;

    }
    public ArrayList<User> getUsers(){
        String filePath = "resources\\Users.csv";
        if(users == null){
            try{

                users = new ArrayList<>();
                String line = "";
                String splitBy = ",";
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] entry = line.split(splitBy);// use comma as separator
                    boolean inputBool = false;
                    if(entry[2] == "true"){
                        inputBool = true;
                    }

                    User newUser = new User(entry[0],entry[1],inputBool);
                    users.add(newUser);
                }
                //System.out.println("Model.User " + users[6].getUsername() + " was added");
            }
            catch (IOException error){
                System.out.println("An error occurred");

            }

        }
        return users;
    }
    public ArrayList<Item> getItems(){
        String filePath = "resources\\Stock.csv";
        if(items == null){
            try{
                items = new ArrayList<>();
                String line = "";
                String splitBy = ",";
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] entry = line.split(splitBy);// use comma as separator
                    float Price = Float.parseFloat(entry[2].replace("£",""));


                    Item newItem = new Item(entry[0],entry[1],Price,Integer.parseInt(entry[3]));
                    items.add(newItem);
                }
            }
            catch (IOException error){
                System.out.println("An error occurred");

            }

        }
        return items;
    }
    private void updateItemCSV(){
        String filePath = "resources\\Stock.csv";


        if(items != null){
            try{
                FileWriter itemWriter = new FileWriter(filePath);
                for (int i=0; i < items.size(); i++){


                    itemWriter.append(items.get(i).getName() + "," + items.get(i).getCode() + ",£" + items.get(i).getPrice() + "," + items.get(i).getAmountInStock());
                    itemWriter.append('\n');
                }
                itemWriter.close();

            }
            catch (IOException error){
                System.out.println("An error occurred");

            }


        }
    }
    public Boolean addItem(Item inputItem){
        getItems();
        if(getItemFromCode(inputItem.getCode()) != null){
            items.add(inputItem);
            updateItemCSV();
            return true;
        }
        else {
            return false;
        }


    }
    public Item getItemFromCode(String inputCode){
        for(int i=0;i < items.size(); i++){
            if(items.get(i).getCode().equals(inputCode)){
                return items.get(i);
            }

        }
        return null;
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
