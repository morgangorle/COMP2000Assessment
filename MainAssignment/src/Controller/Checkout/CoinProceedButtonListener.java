package Controller.Checkout;

import Controller.FormManager;
import View.CashGUI;
import View.RecieptGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinProceedButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CashGUI currentForm = FormManager.getInstance().getCashForm();
        if(currentForm.getTotal() <= currentForm.getAmountPaid()){
            RecieptGUI newGUI = new RecieptGUI();
            FormManager.getInstance().setRecieptForm(newGUI);
            newGUI.setVisible(true);
            currentForm.setVisible(false);
            newGUI.getCashPaidLabel().setText("Cash Paid:£"+String.format("%.2f",currentForm.getAmountPaid()));
            float ChangeRecieved = currentForm.getAmountPaid() - currentForm.getTotal();
            newGUI.getChangeLabel().setText("Change Given:£" +String.format("%.2f",ChangeRecieved));
            newGUI.getTotalLabel().setText("Total £" +String.format("%.2f",currentForm.getTotal()));
            newGUI.getItemsList().setModel(FormManager.getInstance().getInitialForm().getListModel());
            for(int i=0;i < FormManager.getInstance().getInitialForm().getBasket().size(); i++){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getInitialForm().getBasket().get(i).getCode()).setAmountInStock(FormManager.getInstance().getItemFromCode(FormManager.getInstance().getInitialForm().getBasket().get(i).getCode()).getAmountInStock() - 1);

            }
            FormManager.getInstance().updateItemCSV();

        }
        else{
            currentForm.getStateLabel().setText("Insufficient money, please insert more cash.");
        }

    }
}
