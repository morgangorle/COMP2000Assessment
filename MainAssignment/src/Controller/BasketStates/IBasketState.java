package Controller.BasketStates;
//An interface used for handling adding and removing items from the basket.
public interface IBasketState {
    public void addItem(BasketTurnStile inputTurnStile);

    public void removeItem(BasketTurnStile inputTurnStile);
}
