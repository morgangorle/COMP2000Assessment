package View;

import javax.swing.*;
import java.awt.*;
public class RecieptGUI extends JFrame {
    private JTextArea ItemsArea;
    private JPanel mainPanel;
    private JLabel totalLabel;
    private JLabel CashPaidLabel;
    private JLabel ChangeLabel;
    private JList itemsList;
    private JLabel itemsLabel;

    public RecieptGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200,750));
        pack();

    }

    public JList getItemsList() {
        return itemsList;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }

    public JLabel getCashPaidLabel() {
        return CashPaidLabel;
    }

    public JLabel getChangeLabel() {
        return ChangeLabel;
    }
}
