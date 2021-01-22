package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;

public class MainGUI extends JFrame {
    private JPanel MainPanel;
    private JButton adminButton;
    private JButton scanButton;
    private JTextField CodeField;
    private JTextArea ItemsArea;
    private JButton checkoutButton;
    private JList ItemList;
    private DefaultListModel ListModel;

    public MainGUI(){
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        ListModel = new DefaultListModel();
        //ListModel.addElement("Item");
        ItemList.setModel(ListModel);

    }
    public static void main(String[] args){
        FormManager.getInstance();
        MainGUI page = new MainGUI();
        page.setVisible(true);
        FormManager.getInstance().setInitialForm(page);
        adminAreaButtonListener AdminListener = new adminAreaButtonListener();
        ScanButtonListener ScanListener = new ScanButtonListener();
        page.adminButton.addActionListener(AdminListener);
        page.scanButton.addActionListener(ScanListener);
        //page.getListModel().addElement("Item");
    }
    public JTextField getCodeField(){
        return CodeField;
    }
    public JList getItemList(){ return ItemList;}
    public DefaultListModel<String> getListModel(){return ListModel;}
}
