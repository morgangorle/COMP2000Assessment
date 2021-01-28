package Controller.BasketStates;

import Controller.FormManager;

public class BasketInCheckout implements IBasketState {
    //If a checkout is in progress, changes to the basket are blocked.

    @Override
    public void addItem(BasketTurnStile inputTurnStile) {
        FormManager.getInstance().getInitialForm().getStateLabel().setText("Checkout in progress");


    }

    @Override
    public void removeItem(BasketTurnStile inputTurnStile) {
        FormManager.getInstance().getInitialForm().getStateLabel().setText("Checkout in progress");

    }
}
