package Controller;

import View.LoginGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminAreaButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FormManager.getInstance().getInitialForm().setVisible(false);
        LoginGUI NewAdminGUI = new LoginGUI();
        FormManager.getInstance().setLoginForm(NewAdminGUI);
        NewAdminGUI.setVisible(true);
        FormManager.getInstance().getLoginForm().setVisible(false);

    }
}
