package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkoutButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(FormManager.getInstance().getInitialForm().getCardButton().isSelected()){

        }
        else if(FormManager.getInstance().getInitialForm().getCashButton().isSelected()){

        }
        else {
            FormManager.getInstance().getInitialForm().getStateLabel().setText("Please select a payment method");
        }
    }
}
