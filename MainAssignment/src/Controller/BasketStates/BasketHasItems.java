package Controller.BasketStates;

import Controller.FormManager;
import Model.Item;
import View.MainGUI;

import java.util.ArrayList;

public class BasketHasItems implements IBasketState {
    MainGUI currentForm;

    @Override
    public void addItem(BasketTurnStile inputTurnStile) {
        currentForm = FormManager.getInstance().getInitialForm();
        ArrayList<Item> StoredItems = FormManager.getInstance().getItems();
        Boolean validItem = false;
        for (int i=0;i < StoredItems.size(); i++){
            if(currentForm.getCodeField().getText().equals(StoredItems.get(i).getCode())){
                if(currentForm.getNumofObjectinBasket(StoredItems.get(i).getCode()) < StoredItems.get(i).getAmountInStock()){
                    Item inputItem = new Item(StoredItems.get(i).getName(), StoredItems.get(i).getCode(), StoredItems.get(i).getPrice(), StoredItems.get(i).getAmountInStock());
                    currentForm.getListModel().addElement(inputItem.getName() + " £" +inputItem.getPrice());
                    currentForm.getBasket().add(inputItem);
                    currentForm.setTotal(currentForm.getTotal() + inputItem.getPrice());
                    currentForm.getStateLabel().setText("Item successfully added");

                }
                else{
                    currentForm.getStateLabel().setText("Not enough of the item in stock");
                }
                validItem = true;
                break;


            }

        }
        if(!validItem){
            currentForm.getStateLabel().setText("Invalid item code");


        }




    }

    @Override
    public void removeItem(BasketTurnStile inputTurnStile) {
        currentForm = FormManager.getInstance().getInitialForm();
        if(currentForm.getItemList().getSelectedIndex() != -1){
            currentForm.setTotal(currentForm.getTotal() - currentForm.getBasket().get(currentForm.getItemList().getSelectedIndex()).getPrice());
            currentForm.getBasket().remove(currentForm.getItemList().getSelectedIndex());
            currentForm.getListModel().remove(currentForm.getItemList().getSelectedIndex());
            currentForm.getStateLabel().setText("Item removed");
            if(currentForm.getBasket().size() == 0){
                IBasketState newState = new BasketEmpty();
                inputTurnStile.setCurrentState(newState);
            }
        }
        else {
            currentForm.getStateLabel().setText("No item selected");

        }

    }
}
