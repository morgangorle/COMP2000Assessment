import Controller.*;
import Model.*;
import View.*;
import org.junit.Test;

import static org.junit.Assert.*;
public class adminGUITest {
    @Test
    public void DuplicateItemTest(){
        //Test to see if the system properly rejects duplicate items
        int initialStock = FormManager.getInstance().getItems().size();
        Item newItem = (Item) FormManager.getInstance().getItems().get(0).clone();
        FormManager.getInstance().addItem(newItem);
        Item newItem2 = (Item) FormManager.getInstance().getItems().get(0).clone();
        FormManager.getInstance().addItem(newItem2);
        assertEquals(initialStock,FormManager.getInstance().getItems().size());

    }
    @Test
    public void addItemTest(){
        //Test to see if the system can add an item
        int initialStock = FormManager.getInstance().getItems().size();
        Item newItem = new Item("Asparagus","32",6.32f,5);
        FormManager.getInstance().addItem(newItem);
        assertEquals(initialStock + 1,FormManager.getInstance().getItems().size());
        //Some clean-up to ensure that this test successfully after multiple runs.
        FormManager.getInstance().getItems().remove(newItem);
        FormManager.getInstance().updateItemCSV();

    }
    @Test
    public void removeItemTest(){
        //Test to see if the system can remove an item
        int initialStock = FormManager.getInstance().getItems().size();
        AdminGUI testGUI = new AdminGUI();
        FormManager.getInstance().setAdminForm(testGUI);
        testGUI.getCodeTextField().setText("07-486-3022");
        RemoveItemButtonListener RemoveItemListener = new RemoveItemButtonListener();
        RemoveItemListener.actionPerformed(null);
        assertEquals(initialStock - 1,FormManager.getInstance().getItems().size());
        //The item is re-added to ensure that the test can be re-used.
        Item newItem = new Item("Juice - Apple","07-486-3022",4.67f,10);
        FormManager.getInstance().addItem(newItem);

    }
    @Test
    public void editItemTest(){
        //Seeing if items can be edited
        AdminGUI testGUI = new AdminGUI();
        FormManager.getInstance().setAdminForm(testGUI);
        EditItemButtonListener EditItemListener = new EditItemButtonListener();
        testGUI.getCodeTextField().setText("07-486-3022");
        testGUI.getPrice£TextField().setText("4.32");
        EditItemListener.actionPerformed(null);
        assertEquals(4.32f, FormManager.getInstance().getItemFromCode("07-486-3022").getPrice(),0);
        FormManager.getInstance().getItemFromCode("07-486-3022").setPrice(4.67f);
        FormManager.getInstance().updateItemCSV();

    }
    @Test
    public void restockItemTest(){
        //Seeing if items can be restocked
        AdminGUI testGUI = new AdminGUI();
        FormManager.getInstance().setAdminForm(testGUI);
        RestockItemButtonListener RestockItemListener = new RestockItemButtonListener();
        testGUI.getCodeTextField().setText("07-486-3022");
        RestockItemListener.actionPerformed(null);
        assertEquals(20,FormManager.getInstance().getItemFromCode("07-486-3022").getAmountInStock());
        FormManager.getInstance().getItemFromCode("07-486-3022").setAmountInStock(10);
        FormManager.getInstance().updateItemCSV();

    }
}
