package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //Send the user back the the self-checkout
        FormManager.getInstance().getInitialForm().setVisible(true);
        //Also removes lingering forms
        if(FormManager.getInstance().getLoginForm() != null){
            FormManager.getInstance().getLoginForm().dispose();
            FormManager.getInstance().setLoginForm(null);
        }
        if(FormManager.getInstance().getAdminForm() != null){
            FormManager.getInstance().getAdminForm().dispose();
            FormManager.getInstance().setAdminForm(null);
        }

        if(FormManager.getInstance().getCashForm() != null){
            FormManager.getInstance().getCashForm().dispose();
            FormManager.getInstance().setCashForm(null);
        }
        if(FormManager.getInstance().getCardForm() != null){
            FormManager.getInstance().getCardForm().dispose();
            FormManager.getInstance().setCardForm(null);
        }
    }
}
