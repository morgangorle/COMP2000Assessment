package View;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {
    private JPanel mainPanel;
    private JTextArea restockArea;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public AdminGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
}
