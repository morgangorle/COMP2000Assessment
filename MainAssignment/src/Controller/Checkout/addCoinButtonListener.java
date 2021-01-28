package Controller.Checkout;

import Controller.FormManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCoinButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the amount which is selected
        if(FormManager.getInstance().getCashForm().getSelectedAmount() != null){
            //And add it to the amount paid.
            FormManager.getInstance().getCashForm().setAmountPaid(FormManager.getInstance().getCashForm().getAmountPaid() + FormManager.getInstance().getCashForm().getSelectedAmount());

        }
        else{
            //If the user neglected to select a coin to add, they are informed of this.
            FormManager.getInstance().getCashForm().getStateLabel().setText("Please select a coin to add");
        }


    }
}
