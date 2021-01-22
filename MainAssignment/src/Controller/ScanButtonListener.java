package Controller;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Item[] StoredItems = FormManager.getInstance().getItems();
        Item inputItem = null;
        Boolean validItem = false;
        for (int i=0;i < StoredItems.length; i++){
            if(FormManager.getInstance().getInitialForm().getCodeField().getText().equals(StoredItems[i].getCode())){
                inputItem = new Item(StoredItems[i].getName(),StoredItems[i].getCode(),StoredItems[i].getPrice(),StoredItems[i].getAmountInStock());

                validItem = true;
                break;

            }

        }
        //Add to shop area
        if(validItem){

            FormManager.getInstance().getInitialForm().getListModel().addElement(inputItem.getName() + " £" +inputItem.getPrice());
            System.out.println("Valid item code");
        }
        else{
            System.out.println("No matches");
        }




    }
}
