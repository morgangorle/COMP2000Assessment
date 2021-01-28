package Controller.BasketStates;

import Controller.FormManager;
import Model.Item;
import View.AdminGUI;
import View.MainGUI;

import java.util.ArrayList;

public class BasketEmpty implements IBasketState {
    MainGUI currentForm;

    @Override
    public void addItem(BasketTurnStile inputTurnStile) {
        currentForm = FormManager.getInstance().getInitialForm();
        ArrayList<Item> StoredItems = FormManager.getInstance().getItems();
        Boolean validItem = false;
        //Check to see if the item exists
        for (int i=0;i < StoredItems.size(); i++){
            if(currentForm.getCodeField().getText().equals(StoredItems.get(i).getCode())){
                //And if it exists, is there enough of it in stock
                if(currentForm.getNumofObjectinBasket(StoredItems.get(i).getCode()) < StoredItems.get(i).getAmountInStock()){
                    Item inputItem = new Item(StoredItems.get(i).getName(), StoredItems.get(i).getCode(), StoredItems.get(i).getPrice(), StoredItems.get(i).getAmountInStock());
                    currentForm.getListModel().addElement(inputItem.getName() + " £" +inputItem.getPrice());
                    currentForm.getBasket().add(inputItem);
                    currentForm.setTotal(currentForm.getTotal() + inputItem.getPrice());
                    currentForm.getStateLabel().setText("Item successfully added");
                    //Upon an item being added to the basket, the state changes to the basketHasItems
                    IBasketState newState = new BasketHasItems();
                    inputTurnStile.setCurrentState(newState);

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
        //Can't remove items when there are no items to remove
        FormManager.getInstance().getInitialForm().getStateLabel().setText("The basket is empty");

    }
}
