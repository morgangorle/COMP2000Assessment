package View;

import javax.swing.*;
import java.awt.*;
public class RecieptGUI extends JFrame {
    private JTextArea ItemsArea;
    private JPanel mainPanel;
    public RecieptGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200,750));
        pack();

    }
}
