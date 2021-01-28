import Controller.*;
import Controller.Checkout.CoinProceedButtonListener;
import Model.*;
import View.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class cashGUITest {
    @Test
    public void checkTotal(){
        //Check to see if the total is carried from the mainGUI
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setInitialForm(initialForm);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        initialForm.getCashButton().setSelected(true);
        initialForm.getCodeField().setText("73-105-3282");
        initialForm.getBasketStateHandler().addItem();
        checkoutListener.actionPerformed(null);
        assertEquals(6.43f,FormManager.getInstance().getCashForm().getTotal(),0);

    }
    @Test
    public void validPayment(){
        //Check to see if the purchase proceeds upon a valid payment
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
        assertNotNull(FormManager.getInstance().getRecieptForm());
        //Some cleanup here
        FormManager.getInstance().getItemFromCode("73-105-3282").setAmountInStock(2);
        FormManager.getInstance().updateItemCSV();




    }
    @Test
    public void invalidPayment(){
        //Check to see that the purchase halts upon an invalid payment
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setInitialForm(initialForm);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        initialForm.getCashButton().setSelected(true);
        initialForm.getCodeField().setText("73-105-3282");
        initialForm.getBasketStateHandler().addItem();
        checkoutListener.actionPerformed(null);
        CoinProceedButtonListener CoinProceedListener = new CoinProceedButtonListener();
        CoinProceedListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getRecieptForm());

    }
}
