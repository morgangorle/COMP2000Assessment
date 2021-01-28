import Controller.*;
import Model.*;
import View.*;
import com.sun.tools.javac.Main;
import org.junit.Test;

import static org.junit.Assert.*;
public class loginGUITest {
    @Test
    public void CorrectDetailsTest(){
        //Tests that a successful login occurs with correct details
        LoginGUI testGUI = new LoginGUI();
        FormManager.getInstance().setLoginForm(testGUI);
        loginButtonListener loginListener = new loginButtonListener();
        testGUI.getusernameField().setText("mpagin0");
        testGUI.getPasswordField().setText("Md8Vc9dQ0kk");
        loginListener.actionPerformed(null);
        assertNotNull(FormManager.getInstance().getAdminForm());

    }
    @Test
    public void WrongDetailsTest(){
        //Tests that a successful login occurs with incorrect details
        LoginGUI testGUI = new LoginGUI();
        FormManager.getInstance().setLoginForm(testGUI);
        loginButtonListener loginListener = new loginButtonListener();
        loginListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getAdminForm());

    }
    @Test
    public void backButtonTest(){
        //Tests the back button
        LoginGUI testGUI = new LoginGUI();
        MainGUI initialForm = new MainGUI();
        FormManager.getInstance().setLoginForm(testGUI);
        FormManager.getInstance().setInitialForm(initialForm);
        BackButtonListener BackListener = new BackButtonListener();
        BackListener.actionPerformed(null);
        assertNull(FormManager.getInstance().getLoginForm());
    }
}
