import Controller.*;
import Model.*;
import View.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class generalTest {
    @Test
    public void UserReadTest(){
        //This tests that the file Read works
        FormManager.getInstance().getUsers();
        assertEquals("mpagin0",FormManager.getInstance().getUsers().get(0).getUsername());

    }
    @Test
    public void ItemReadTest(){
        //Check to see if the file read-in works for items
        assertEquals("Wine La Vielle Ferme Cote Du",FormManager.getInstance().getItems().get(0).getName());
    }


}
