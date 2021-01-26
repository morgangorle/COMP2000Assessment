package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {
    private JPanel mainPanel;
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
    private JList stockList;
    private JLabel listLabel;

    public AdminGUI(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        AddItemButtonListener AddItemListener = new AddItemButtonListener();
        RestockItemButtonListener RestockItemListener = new RestockItemButtonListener();
        EditItemButtonListener EditItemListener = new EditItemButtonListener();
        RemoveItemButtonListener RemoveItemListener = new RemoveItemButtonListener();
        addButton.addActionListener(AddItemListener);
        restockButton.addActionListener(RestockItemListener);
        editButton.addActionListener(EditItemListener);
        removeButton.addActionListener(RemoveItemListener);
        pack();




    }
    public void populateRestockArea(){

    }
    public JTextField getNameTextField(){
        return nameTextField;
    }
    public JTextField getCodeTextField(){
        return codeTextField;
    }
    public JTextField getPrice£TextField(){
        return price£TextField;
    }
    public JTextField getStockTextField(){
        return stockTextField;
    }
}
