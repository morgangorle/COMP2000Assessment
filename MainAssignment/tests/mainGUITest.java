import Controller.*;
import Model.*;
import View.*;
import org.junit.Test;

import java.io.FileOutputStream;

import static org.junit.Assert.*;
public class mainGUITest {
    @Test
    public void addToBasket(){
        //This tests to see if items can be added to the basket
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        assertEquals(1,testGUI.getBasket().size());
    }
    @Test
    public void addManyToBasket(){
        //This tests to see if the program limits item adding by the amount of stock
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        assertEquals(2,testGUI.getBasket().size());
    }
    @Test
    public void addRemoveFromBasket(){
        //This tests to see if items can be added to the basket
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        testGUI.getCodeField().setText("73-105-3282");
        ScanButtonListener ScanListener = new ScanButtonListener();
        ScanListener.actionPerformed(null);
        FormManager.getInstance().getInitialForm().getItemList().setSelectedIndex(0);
        testGUI.getBasketStateHandler().removeItem();
        assertEquals(0,testGUI.getBasket().size());
    }
    @Test
    public void nullCheckoutButtonTest(){
        //This tests to see if nothing comes up if nothing is selected
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        checkoutListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getCashForm());
        assertNull(FormManager.getInstance().getCardForm());

    }
    @Test
    public void CardCheckoutButtonTest(){
        //This tests to see if the card form comes up when selected
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        testGUI.getCardButton().setSelected(true);
        checkoutListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getCashForm());
        assertNotNull(FormManager.getInstance().getCardForm());

    }
    @Test
    public void CashCheckoutButtonTest(){
        //This tests to see if the cash form comes up when selected
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        checkoutButtonListener checkoutListener = new checkoutButtonListener();
        testGUI.getCashButton().setSelected(true);
        checkoutListener.actionPerformed(null);
        assertNotNull(FormManager.getInstance().getCashForm());
        assertNull(FormManager.getInstance().getCardForm());

    }
    @Test
    public void loginTest(){
        //This tests to see if the user can access the login screen
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        adminAreaButtonListener adminListener = new adminAreaButtonListener();
        adminListener.actionPerformed(null);
        assertNotNull(FormManager.getInstance().getLoginForm());
    }
    @Test
    public void addToBasketTotalTest(){
        //This tests to see if items added to the basket are totalled up correctly
        MainGUI testGUI = new MainGUI();
        FormManager.getInstance().setInitialForm(testGUI);
        testGUI.getCodeField().setText("73-105-3282");
        testGUI.getBasketStateHandler().addItem();
        assertEquals(6.43f,testGUI.getTotal().floatValue(),0);
    }
}
