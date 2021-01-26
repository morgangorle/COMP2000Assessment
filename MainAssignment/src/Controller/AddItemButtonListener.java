package Controller;

import Model.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getStockTextField().getText().equals("") ){
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()),Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));
                FormManager.getInstance().addItem(newItem);
                FormManager.getInstance().getAdminForm().getStateLabel().setText("Item added");

            }
            else if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("")&& !FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("")){
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));
                FormManager.getInstance().addItem(newItem);
                FormManager.getInstance().getAdminForm().getStateLabel().setText("Item added");
            }
            else{
                //Let the user know that the textFields are empty
                FormManager.getInstance().getAdminForm().getStateLabel().setText("Text Boxes are empty");
                Item myItem = new Item("Cabbage","123",3.50f,5);
                FormManager.getInstance().addItem(myItem);
            }

        }
        catch (Exception error){
            //Let the user know that an error occurred
            FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred");
            Item myItem = new Item("Cabbage","123",3.50f,5);
            FormManager.getInstance().addItem(myItem);

        }

    }
}
