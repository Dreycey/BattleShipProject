package test.BoatPackage;

import BoatPackage.Player;
//Junit imports
import static junit.framework.TestCase.*;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
    Player playerObjOne = new Player();

    @Before
    public void before() {
    }
    // CHANGINNG THE FILEEEE

    //ensure they are 28
    @Test
    public void assertAge() {
        assertEquals(28, playerObjOne.returnAge());
    }

    // return boats
    @Test
    public void returnBoatsTest() {
        assertEquals(29, playerObjOne.returnAge2());
    }
    // return boats
    @Test
    public void returBoatsTest() {
        assertEquals(29, playerObjOne.returnAge2());
    }

    // text placeShip
    @Test
    public void placeShipTest() {

    }
}
