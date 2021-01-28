package Controller.BasketStates;

import Controller.FormManager;

public class BasketInCheckout implements IBasketState {

    @Override
    public void addItem(BasketTurnStile inputTurnStile) {
        FormManager.getInstance().getInitialForm().getStateLabel().setText("Checkout in progress");


    }

    @Override
    public void removeItem(BasketTurnStile inputTurnStile) {
        FormManager.getInstance().getInitialForm().getStateLabel().setText("Checkout in progress");

    }
}
