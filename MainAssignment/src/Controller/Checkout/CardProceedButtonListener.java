package Controller.Checkout;

import Controller.FormManager;
import View.CardGUI;
import View.RecieptGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardProceedButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CardGUI currentForm = FormManager.getInstance().getCardForm();
        if(!currentForm.getNameTextField().getText().equals("") && !currentForm.getCardTextField().getText().equals("") && !currentForm.getExpiryTextField().getText().equals("") && !currentForm.getSecurityTextField().getText().equals("")){
            RecieptGUI newGUI = new RecieptGUI();
            FormManager.getInstance().setRecieptForm(newGUI);
            newGUI.setVisible(true);
            currentForm.setVisible(false);
            newGUI.getCashPaidLabel().setText("");
            newGUI.getChangeLabel().setText("");
            newGUI.getTotalLabel().setText("Total £" +String.format("%.2f",FormManager.getInstance().getInitialForm().getTotal()));
            newGUI.getItemsList().setModel(FormManager.getInstance().getInitialForm().getListModel());
            for(int i=0;i < FormManager.getInstance().getInitialForm().getBasket().size(); i++){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getInitialForm().getBasket().get(i).getCode()).setAmountInStock(FormManager.getInstance().getItemFromCode(FormManager.getInstance().getInitialForm().getBasket().get(i).getCode()).getAmountInStock() - 1);

            }
            FormManager.getInstance().updateItemCSV();

        }
        else{
            currentForm.getStatusLabel().setText("Please input all the required details");

        }

    }
}
