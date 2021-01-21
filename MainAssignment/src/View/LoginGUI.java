package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JPanel AdminPanel;
    private JLabel errorMessage;
    private JButton backButton;

    public LoginGUI(){
        setContentPane(AdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        loginButtonListener loginListener = new loginButtonListener();
        loginButton.addActionListener(loginListener);

    }
    public JTextField getusernameField(){
        return  usernameField;
    }
    public  JTextField getPasswordField(){
        return passwordField;
    }
    public void setErrorMessage(String inputMessage){
        errorMessage.setText(inputMessage);
    }
}
