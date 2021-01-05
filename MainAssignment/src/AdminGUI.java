import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JPanel AdminPanel;
    public AdminGUI(){
        setContentPane(AdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
}
