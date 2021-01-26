package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("")){
            if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("")){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setName(FormManager.getInstance().getAdminForm().getNameTextField().getText());
            }
            if(!FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("")){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setPrice(Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));

            }
            if(!FormManager.getInstance().getAdminForm().getStockTextField().getText().equals("")){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setAmountInStock(Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));

            }
        }

    }
}
