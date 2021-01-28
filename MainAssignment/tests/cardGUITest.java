import Controller.*;
import Controller.Checkout.CardProceedButtonListener;
import Model.*;
import View.*;
import com.sun.tools.javac.Main;
import org.junit.Test;

import static org.junit.Assert.*;

public class cardGUITest {

    @Test
    public void invalidPayment(){
        //Test when user hasn't input details
        //IntelliJ appears to have a bug where if both of these are run at once, this one will fail for some reason.
        MainGUI initialForm = new MainGUI();
        CardGUI testGUI = new CardGUI();
        FormManager.getInstance().setCardForm(testGUI);
        FormManager.getInstance().setInitialForm(initialForm);

        CardProceedButtonListener CardProceedListener = new CardProceedButtonListener();
        CardProceedListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getRecieptForm());

    }
    @Test
    public void ValidPayment(){
        //Test when user has input details
        MainGUI initialForm = new MainGUI();
        CardGUI testGUI = new CardGUI();
        FormManager.getInstance().setCardForm(testGUI);
        FormManager.getInstance().setInitialForm(initialForm);
        CardProceedButtonListener CardProceedListener = new CardProceedButtonListener();

        testGUI.getNameTextField().setText("Margaret");
        testGUI.getSecurityTextField().setText("543");
        testGUI.getExpiryTextField().setText("1/89");
        testGUI.getCardTextField().setText("4534636547357");
        CardProceedListener.actionPerformed(null);
        assertNotNull(FormManager.getInstance().getRecieptForm());

    }
}
