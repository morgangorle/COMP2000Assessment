package Controller;

import Model.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            //If none of the text boxes are empty
            if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getStockTextField().getText().equals("") ){
                //An attempt is made to add the item
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()),Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));
                if(FormManager.getInstance().addItem(newItem)){
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("Item added");
                }
                else{
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("Duplicate found");

                }



            }
            //If all of the text boxes except the Stock box are empty
            else if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("") && !FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("")&& !FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("")){
                //An attempt is made to add the item using the default stock value of 0
                Item newItem = new Item(FormManager.getInstance().getAdminForm().getNameTextField().getText(),FormManager.getInstance().getAdminForm().getCodeTextField().getText(),Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));
                if(FormManager.getInstance().addItem(newItem)){
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("Item added");
                }
                else{
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("Duplicate found");

                }
            }
            else{
                //Let the user know that the textFields are empty
                FormManager.getInstance().getAdminForm().getStateLabel().setText("Text Boxes are empty");

            }

        }
        catch (Exception error){
            //Let the user know that an error occurred
            FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred");


        }

    }
}
