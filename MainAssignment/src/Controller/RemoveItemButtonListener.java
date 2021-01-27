package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(FormManager.getInstance().getAdminForm().getStockList().getSelectedIndex() != -1){
            FormManager.getInstance().getAdminForm().getStateLabel().setText("Item successfully deleted");

        }
        else{
            FormManager.getInstance().getAdminForm().getStateLabel().setText("No item is selected");
        }

    }
}
