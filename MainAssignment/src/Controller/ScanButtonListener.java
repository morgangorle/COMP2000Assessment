package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScanButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //This action is handled by the state machine.
        FormManager.getInstance().getInitialForm().getBasketStateHandler().addItem();
    }
}
