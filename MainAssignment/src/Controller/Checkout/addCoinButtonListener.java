package Controller.Checkout;

import Controller.FormManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCoinButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(FormManager.getInstance().getCashForm().getSelectedAmount() != null){
            FormManager.getInstance().getCashForm().setAmountPaid(FormManager.getInstance().getCashForm().getAmountPaid() + FormManager.getInstance().getCashForm().getSelectedAmount());

        }


    }
}
