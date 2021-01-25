package View;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea restockArea;
    private JButton removeButton;
    private JButton restockButton;
    private JButton addButton;
    private JButton editButton;
    private JTextField nameTextField;
    private JTextField codeTextField;
    private JTextField price£TextField;
    private JTextField stockTextField;
    private JLabel NameLabel;
    private JLabel codeLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;

    public AdminGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
}
