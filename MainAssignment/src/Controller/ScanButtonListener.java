package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
       //Compare to Items array
        if(FormManager.getInstance().getInitialForm().getCodeField().getText() == ""){

        }

    }
}
