package View;

import Controller.BackButtonListener;
import Controller.Checkout.CardProceedButtonListener;
import Controller.RemoveFromBasketButtonListener;
import Controller.ScanButtonListener;
import Controller.adminAreaButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField cardTextField;
    private JTextField securityTextField;
    private JTextField nameTextField;
    private JButton proceedWithPurchaseButton;
    private JLabel statusLabel;
    private JLabel InstructionLabel;
    private JLabel CardLabel;
    private JLabel SecurityLabel;
    private JLabel NameLabel;
    private JTextField ExpiryTextField;
    private JLabel ExpiryLabel;
    private JButton backButton;
    public CardGUI(){

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200,750));
        pack();
        BackButtonListener BackListener = new BackButtonListener();
        backButton.addActionListener(BackListener);
        CardProceedButtonListener CardProceedListener = new CardProceedButtonListener();
        proceedWithPurchaseButton.addActionListener(CardProceedListener);


    }

    public JTextField getCardTextField() {
        return cardTextField;
    }

    public JTextField getExpiryTextField() {
        return ExpiryTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getSecurityTextField() {
        return securityTextField;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }
}
