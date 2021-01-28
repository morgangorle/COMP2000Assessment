package Controller;

import View.CardGUI;
import View.CashGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkoutButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //If the user selected Card
        if(FormManager.getInstance().getInitialForm().getCardButton().isSelected()){
            //They proceed to the card Checkout
            CardGUI newGUI = new CardGUI();
            newGUI.setVisible(true);
            FormManager.getInstance().getInitialForm().setVisible(false);
            FormManager.getInstance().setCardForm(newGUI);

        }
        //If the user selected Cash
        else if(FormManager.getInstance().getInitialForm().getCashButton().isSelected()){
            //They proceed to the cash checkout
            CashGUI newGUI = new CashGUI();
            newGUI.setVisible(true);
            newGUI.setTotal(FormManager.getInstance().getInitialForm().getTotal());
            FormManager.getInstance().getInitialForm().setVisible(false);
            FormManager.getInstance().setCashForm(newGUI);

        }
        //If nothing was selected
        else {
            //The user is informed that they need to make a choice
            FormManager.getInstance().getInitialForm().getStateLabel().setText("Please select a payment method");
        }
    }
}
