package Controller;

import View.LoginGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminAreaButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FormManager.getInstance().getInitialForm().setVisible(false);
        LoginGUI NewLoginGUI = new LoginGUI();
        FormManager.getInstance().setLoginForm(NewLoginGUI);
        NewLoginGUI.setVisible(true);

    }
}
