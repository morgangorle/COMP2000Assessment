package Controller.BasketStates;

public class BasketTurnStile {
    private IBasketState currentState;
    public BasketTurnStile(IBasketState inputState){
        currentState = inputState;

    }
    public BasketTurnStile(){
        IBasketState emptyState = new BasketEmpty();
        currentState = emptyState;
    }
    public void addItem(){
        currentState.addItem(this);

    }
    public void removeItem(){
        currentState.removeItem(this);

    }
    public void setCurrentState(IBasketState inputState){
        currentState = inputState;
    }
}
