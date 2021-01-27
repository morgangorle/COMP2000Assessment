package Controller;

import View.AdminGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputUsername = FormManager.getInstance().getLoginForm().getusernameField().getText();
        String inputPassword = FormManager.getInstance().getLoginForm().getPasswordField().getText();
        boolean canLogin = false;
        //System.out.println("Input username:" + inputUsername);
        //System.out.println("Input password:" + inputPassword);
        for (int i = 0; i < FormManager.getInstance().getUsers().size(); i++){
            //System.out.println("Looking at username:" + FormManager.getInstance().getUsers().get(i).getUsername());
            //System.out.println("Looking at password:" + FormManager.getInstance().getUsers().get(i).getPassword());
            if(inputUsername.equals(FormManager.getInstance().getUsers().get(i).getUsername()) && inputPassword.equals(FormManager.getInstance().getUsers().get(i).getPassword())){
                canLogin = true;
                break;
            }
        }
        if(canLogin){
            AdminGUI nextView = new AdminGUI();
            FormManager.getInstance().setAdminForm(nextView);
            nextView.setVisible(true);
            FormManager.getInstance().getLoginForm().setVisible(false);

        }
        else{
            //If no matches are found a message is displayed in the GUI
            FormManager.getInstance().getLoginForm().setErrorMessage("Verification failed, please try again.");

        }

    }
}
