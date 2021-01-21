package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        FormManager.getInstance().getInitialForm().setVisible(true);
        if(FormManager.getInstance().getLoginForm() != null){
            FormManager.getInstance().getLoginForm().dispose();
        }
        if(FormManager.getInstance().getAdminForm() != null){
            FormManager.getInstance().getAdminForm().dispose();
        }

    }
}
