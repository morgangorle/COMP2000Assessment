package View;

import Controller.BackButtonListener;
import Controller.Checkout.*;

import javax.swing.*;
import java.awt.*;

public class CashGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel amountLabel;
    private JLabel remainingLabel;
    private JButton purchaseButton;
    private JButton backButton;
    private JLabel stateLabel;
    private JRadioButton a5pRadioButton;
    private JRadioButton £1RadioButton;
    private JRadioButton a10pRadioButton;
    private JRadioButton £2RadioButton;
    private JRadioButton a20pRadioButton;
    private JRadioButton £5RadioButton;
    private JRadioButton a50pRadioButton;
    private JRadioButton £10RadioButton;
    private JButton addCoinButton;
    private float total ;
    private float remainingDue;
    private float amountPaid;

    public CashGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200,750));
        pack();
        addCoinButtonListener addCoinListener = new addCoinButtonListener();
        BackButtonListener BackListener = new BackButtonListener();
        CoinProceedButtonListener CoinProceedListener = new CoinProceedButtonListener();
        addCoinButton.addActionListener(addCoinListener);
        backButton.addActionListener(BackListener);
        purchaseButton.addActionListener(CoinProceedListener);


    }
    public Float getSelectedAmount(){
        if(a5pRadioButton.isSelected()){
            return 0.05f;
        }
        else if(a10pRadioButton.isSelected()){
            return 0.1f;

        }
        else if(a20pRadioButton.isSelected()){
            return 0.2f;

        }
        else if(a50pRadioButton.isSelected()){
            return 0.5f;

        }
        else if(£1RadioButton.isSelected()){
            return 1f;

        }
        else if(£2RadioButton.isSelected()){
            return 2f;

        }
        else if(£5RadioButton.isSelected()){
            return 5f;

        }
        else if(£10RadioButton.isSelected()){
            return 10f;

        }
        else{
            return null;

        }

    }

    private float getRemainingDue() {
        return remainingDue;
    }

    public float getTotal() {
        return total;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setTotal(float inputTotal) {

        total = inputTotal;
        amountLabel.setText("Total: "+"£" + String.format("%.2f",total));
        setRemainingDue(total - amountPaid);
    }

    private void setRemainingDue(float InputRemainingDue) {
        remainingDue = InputRemainingDue;
        remainingLabel.setText("Remaining: "+"£" + String.format("%.2f",remainingDue));
    }

    public void setAmountPaid(float InputAmountPaid) {
        amountPaid = InputAmountPaid;
        setRemainingDue(total - amountPaid);
    }

    public JLabel getStateLabel() {
        return stateLabel;
    }
}
