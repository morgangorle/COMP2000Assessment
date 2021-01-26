package Controller;

import Model.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(FormManager.getInstance().getAdminForm().getNameTextField().getText() != null && FormManager.getInstance().getAdminForm().getCodeTextField().getText() != null && FormManager.getInstance().getAdminForm().getPrice£TextField().getText() != null && FormManager.getInstance().getAdminForm().getStockTextField().getText() != null ){
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()),Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));
                FormManager.getInstance().addItem(newItem);

            }
            else if(FormManager.getInstance().getAdminForm().getNameTextField().getText() != null && FormManager.getInstance().getAdminForm().getCodeTextField().getText() != null && FormManager.getInstance().getAdminForm().getPrice£TextField().getText() != null){
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));
                FormManager.getInstance().addItem(newItem);
            }
            else{
                //Let the user know that the textFields are empty
            }

        }
        catch (Exception error){
            //Let the user know that an error occurred

        }

    }
}
