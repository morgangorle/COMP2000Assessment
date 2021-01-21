package View;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {
    private JPanel mainPanel;
    public AdminGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

    }
}
