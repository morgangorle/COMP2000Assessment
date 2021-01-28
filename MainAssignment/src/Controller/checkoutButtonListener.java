package Controller;

import View.CardGUI;
import View.CashGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkoutButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(FormManager.getInstance().getInitialForm().getCardButton().isSelected()){
            CardGUI newGUI = new CardGUI();
            newGUI.setVisible(true);
            FormManager.getInstance().getInitialForm().setVisible(false);
            FormManager.getInstance().setCardForm(newGUI);

        }
        else if(FormManager.getInstance().getInitialForm().getCashButton().isSelected()){
            CashGUI newGUI = new CashGUI();
            newGUI.setVisible(true);
            FormManager.getInstance().getInitialForm().setVisible(false);
            FormManager.getInstance().setCashForm(newGUI);

        }
        else {
            FormManager.getInstance().getInitialForm().getStateLabel().setText("Please select a payment method");
        }
    }
}
