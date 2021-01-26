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
                Item inputItem = new Item(StoredItems.get(i).getName(), StoredItems.get(i).getCode(), StoredItems.get(i).getPrice(), StoredItems.get(i).getAmountInStock());
                FormManager.getInstance().getInitialForm().getListModel().addElement(inputItem.getName() + " £" +inputItem.getPrice());
                FormManager.getInstance().getInitialForm().getBasket().add(inputItem);
                System.out.println("Valid item code");
                validItem = true;
                break;

            }

        }
        //Add to shop area
        if(!validItem){
            System.out.println("No matches");


        }




    }
}
