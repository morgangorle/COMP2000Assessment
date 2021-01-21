package Controller;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Item[] StoredItems = FormManager.getInstance().getItems();
        Boolean validItem = false;
        for (int i=0;i < StoredItems.length; i++){
            if(FormManager.getInstance().getInitialForm().getCodeField().getText().equals(StoredItems[i].getCode())){

                validItem = true;
                break;

            }

        }
        //Add to shop area
        if(validItem){

            FormManager.getInstance().getInitialForm().getItemList().getModel();
            System.out.println("Valid item code");
        }
        else{
            System.out.println("No matches");
        }




    }
}
