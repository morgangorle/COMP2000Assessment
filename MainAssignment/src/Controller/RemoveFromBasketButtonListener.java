package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveFromBasketButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(FormManager.getInstance().getInitialForm().getItemList().getSelectedIndex() != -1){
            FormManager.getInstance().getInitialForm().getBasket().remove(FormManager.getInstance().getInitialForm().getItemList().getSelectedIndex());
            FormManager.getInstance().getInitialForm().getListModel().remove(FormManager.getInstance().getInitialForm().getItemList().getSelectedIndex());
            FormManager.getInstance().getInitialForm().getStateLabel().setText("Item removed");
        }
        else {
            FormManager.getInstance().getInitialForm().getStateLabel().setText("No item selected");

        }

    }
}
