package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputUsername = FormManager.getInstance().getAdminForm().getusernameField().getText();
        String inputPassword = FormManager.getInstance().getAdminForm().getPasswordField().getText();
        boolean canLogin = false;
        System.out.println("Input username:" + inputUsername);
        System.out.println("Input password:" + inputPassword);
        for (int i = 0; i< FormManager.getInstance().getUsers().length; i++){
            System.out.println("Looking at username:" + FormManager.getInstance().getUsers()[i].getUsername());
            System.out.println("Looking at password:" + FormManager.getInstance().getUsers()[i].getPassword());
            if(inputUsername.equals(FormManager.getInstance().getUsers()[i].getUsername()) && inputPassword.equals(FormManager.getInstance().getUsers()[i].getPassword())){
                canLogin = true;
                break;
            }
        }
        if(canLogin){
            System.out.println("Model.User can login");

        }
        else{
            System.out.println("Model.User input incorrect details");

        }

    }
}
