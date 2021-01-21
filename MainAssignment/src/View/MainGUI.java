package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;

public class MainGUI extends JFrame {
    private JPanel MainPanel;
    private JButton adminButton;
    private JButton scanButton;
    private JTextField CodeField;
    private JTextArea ItemsArea;

    public MainGUI(){
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
    public static void main(String[] args){
        FormManager.getInstance();

        String filePath = "resources\\Users.csv";

        MainGUI page = new MainGUI();
        page.setVisible(true);
        FormManager.getInstance().setInitialForm(page);
        adminAreaButtonListener buttonListener = new adminAreaButtonListener();
        page.adminButton.addActionListener(buttonListener);
        System.out.println(FormManager.getInstance().getUsers()[5].getUsername() + "was added");
//        Model.User[] users = new Model.User[25];


//        try{
//            String line = "";
//            String splitBy = ",";
//            int userNum = 0;
//            BufferedReader br = new BufferedReader(new FileReader(filePath));
//            while ((line = br.readLine()) != null)   //returns a Boolean value
//            {
//                String[] entry = line.split(splitBy);    // use comma as separator
//
 //               Model.User testUser = new Model.User(entry[0],entry[1]);
//                users[userNum] = testUser;
//                userNum ++;
//            }
//            System.out.println("Model.User " + users[6].getUsername() + " was added");
//        }
//        catch (IOException error){
//            System.out.println("An error occurred");
//
        //}







    }
}
