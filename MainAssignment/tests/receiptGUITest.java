import Controller.*;
import Controller.Checkout.CoinProceedButtonListener;
import Model.*;
import View.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class receiptGUITest {
    @Test
    public void checkTotal(){
        //Check to see if the total is correct on the receipt
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setInitialForm(initialForm);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        initialForm.getCashButton().setSelected(true);
        initialForm.getCodeField().setText("73-105-3282");
        initialForm.getBasketStateHandler().addItem();
        checkoutListener.actionPerformed(null);
        CoinProceedButtonListener CoinProceedListener = new CoinProceedButtonListener();
        FormManager.getInstance().getCashForm().setAmountPaid(10f);
        CoinProceedListener.actionPerformed(null);
        FormManager.getInstance().getItemFromCode("73-105-3282").setAmountInStock(2);
        FormManager.getInstance().updateItemCSV();
        assertEquals("Total £6.43",FormManager.getInstance().getRecieptForm().getTotalLabel().getText());
    }
    @Test
    public void checkAmountPaid(){
        //Check to see if the cash given is correct on the receipt
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setInitialForm(initialForm);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        initialForm.getCashButton().setSelected(true);
        initialForm.getCodeField().setText("73-105-3282");
        initialForm.getBasketStateHandler().addItem();
        checkoutListener.actionPerformed(null);
        CoinProceedButtonListener CoinProceedListener = new CoinProceedButtonListener();
        FormManager.getInstance().getCashForm().setAmountPaid(10f);
        CoinProceedListener.actionPerformed(null);
        FormManager.getInstance().getItemFromCode("73-105-3282").setAmountInStock(2);
        FormManager.getInstance().updateItemCSV();
        assertEquals("Cash Paid:£10.00",FormManager.getInstance().getRecieptForm().getCashPaidLabel().getText());
    }
    @Test
    public void checkChangeGiven(){
        //Check to see if the change given is correct on the receipt
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setInitialForm(initialForm);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        initialForm.getCashButton().setSelected(true);
        initialForm.getCodeField().setText("73-105-3282");
        initialForm.getBasketStateHandler().addItem();
        checkoutListener.actionPerformed(null);
        CoinProceedButtonListener CoinProceedListener = new CoinProceedButtonListener();
        FormManager.getInstance().getCashForm().setAmountPaid(10f);
        CoinProceedListener.actionPerformed(null);
        FormManager.getInstance().getItemFromCode("73-105-3282").setAmountInStock(2);
        FormManager.getInstance().updateItemCSV();
        assertEquals("Change Given:£3.57",FormManager.getInstance().getRecieptForm().getChangeLabel().getText());
    }
}
