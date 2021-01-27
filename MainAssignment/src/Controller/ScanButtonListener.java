package Controller;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Item> StoredItems = FormManager.getInstance().getItems();
        //Item inputItem = null;
        Boolean validItem = false;
        for (int i=0;i < StoredItems.size(); i++){
            if(FormManager.getInstance().getInitialForm().getCodeField().getText().equals(StoredItems.get(i).getCode())){
                if(FormManager.getInstance().getInitialForm().getNumofObjectinBasket(StoredItems.get(i).getCode()) < StoredItems.get(i).getAmountInStock()){
                    Item inputItem = new Item(StoredItems.get(i).getName(), StoredItems.get(i).getCode(), StoredItems.get(i).getPrice(), StoredItems.get(i).getAmountInStock());
                    FormManager.getInstance().getInitialForm().getListModel().addElement(inputItem.getName() + " £" +inputItem.getPrice());
                    FormManager.getInstance().getInitialForm().getBasket().add(inputItem);
                    FormManager.getInstance().getInitialForm().setTotal(FormManager.getInstance().getInitialForm().getTotal() + inputItem.getPrice());
                    FormManager.getInstance().getInitialForm().getStateLabel().setText("Item successfully added");

                }
                else{
                    FormManager.getInstance().getInitialForm().getStateLabel().setText("Not enough of the item in stock");
                }
                validItem = true;
                break;


            }

        }
        if(!validItem){
            FormManager.getInstance().getInitialForm().getStateLabel().setText("Invalid item code");


        }




    }
}
