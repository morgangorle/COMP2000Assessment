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
            AdminGUI nextView = new AdminGUI();
            FormManager.getInstance().setAdminForm(nextView);
            nextView.setVisible(true);

        }
        else{
            //Need to output an error to the GUI
            System.out.println("Model.User input incorrect details");

        }

    }
}
