package Controller.BasketStates;

import Controller.FormManager;

public class BasketEmpty implements IBasketState {

    @Override
    public void addItem(BasketTurnStile inputTurnStile) {

    }

    @Override
    public void removeItem(BasketTurnStile inputTurnStile) {
        FormManager.getInstance().getInitialForm().getStateLabel().setText("The basket is empty");

    }
}
