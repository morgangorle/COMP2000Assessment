package Controller;

import View.AdminGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminAreaButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FormManager.getInstance().getInitialForm().setVisible(false);
        AdminGUI NewAdminGUI = new AdminGUI();
        FormManager.getInstance().setAdminForm(NewAdminGUI);
        NewAdminGUI.setVisible(true);

    }
}
