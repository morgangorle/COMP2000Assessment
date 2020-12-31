import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private JPanel MainPanel;

    public MainGUI(){
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
    public static void main(String[] args){

        MainGUI page = new MainGUI();
        page.setVisible(true);
        User testUser;






    }
}
