package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Controller.*;
import Controller.BasketStates.BasketTurnStile;
import Model.Item;

public class MainGUI extends JFrame {
    private JPanel MainPanel;
    private JButton adminButton;
    private JButton scanButton;
    private JTextField CodeField;
    private JTextArea ItemsArea;
    private JButton checkoutButton;
    private JList ItemList;
    private JButton removeButton;
    private JLabel instructionLabel;
    private JLabel stateLabel;
    private JRadioButton cashButton;
    private JRadioButton cardButton;
    private JLabel paymentLabel;
    private JLabel totalLabel;
    private DefaultListModel BasketModel;
    private ArrayList<Item> Basket;
    private Float Total;
    private BasketTurnStile BasketStateHandler;

    public MainGUI(){
        Total = 0f;
        Basket = new ArrayList<>();
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200,750));
        pack();
        BasketModel = new DefaultListModel();
        //ListModel.addElement("Item");
        ItemList.setModel(BasketModel);
        adminAreaButtonListener AdminListener = new adminAreaButtonListener();
        ScanButtonListener ScanListener = new ScanButtonListener();
        RemoveFromBasketButtonListener RemoveListener = new RemoveFromBasketButtonListener();
        checkoutButtonListener CheckoutListener = new checkoutButtonListener();
        checkoutButton.addActionListener(CheckoutListener);
        removeButton.addActionListener(RemoveListener);
        adminButton.addActionListener(AdminListener);
        scanButton.addActionListener(ScanListener);
        BasketStateHandler = new BasketTurnStile();

    }
    public static void main(String[] args){
        FormManager.getInstance();
        MainGUI page = new MainGUI();
        page.setVisible(true);
        FormManager.getInstance().setInitialForm(page);
    }
    public JTextField getCodeField(){
        return CodeField;
    }
    public JList getItemList(){ return ItemList;}
    public DefaultListModel<String> getListModel(){return BasketModel;}
    public ArrayList<Item> getBasket(){
        return Basket;
    }
    public int getNumofObjectinBasket(String inputCode){
        int amountFound = 0;
        for(int i = 0; i < Basket.size(); i++){
            if(Basket.get(i).getCode().equals(inputCode)){
                amountFound ++;
            }

        }

        return amountFound;
    }
    public JLabel getStateLabel(){
        return stateLabel;
    }
    public JRadioButton getCashButton(){
        return cashButton;
    }
    public JRadioButton getCardButton(){
        return cardButton;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        Total = total;

        totalLabel.setText("£" + String.format("%.2f",Total));
    }

    public BasketTurnStile getBasketStateHandler() {
        return BasketStateHandler;
    }
}
