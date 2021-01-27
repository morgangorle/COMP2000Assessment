package Controller;

import Model.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean changesMade = false;
        Item itemToChange;
        if(FormManager.getInstance().getAdminForm().getStockList().getSelectedIndex() != -1){
            itemToChange = FormManager.getInstance().getAdminForm().getRestockList().get(FormManager.getInstance().getAdminForm().getStockList().getSelectedIndex());
            FormManager.getInstance().getItems().remove(itemToChange);

            changesMade = true;
            FormManager.getInstance().getAdminForm().getStateLabel().setText("Item successfully deleted");

        }
        else if(FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()) != null){
            itemToChange = FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText());
            FormManager.getInstance().getItems().remove(itemToChange);
            changesMade = true;

        }
        else{
            FormManager.getInstance().getAdminForm().getStateLabel().setText("No item is selected");
        }


        if(changesMade){
            FormManager.getInstance().getAdminForm().getStateLabel().setText("Item successfully removed");
            FormManager.getInstance().updateItemCSV();
            FormManager.getInstance().getAdminForm().populateRestockArea();
        }

    }
}
