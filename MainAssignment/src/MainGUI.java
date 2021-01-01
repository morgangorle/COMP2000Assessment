import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainGUI extends JFrame {
    private JPanel MainPanel;

    public MainGUI(){
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
    public static void main(String[] args){
        String filePath = "resources\\Users.csv";

        MainGUI page = new MainGUI();
        page.setVisible(true);


        try{
            String line = "";
            String splitBy = ",";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] entry = line.split(splitBy);    // use comma as separator

                User testUser = new User(entry[0],entry[1]);
                System.out.println("User sucessfully created");
                break;
            }
        }
        catch (IOException error){
            System.out.println("An error occurred");

        }







    }
}
