import BoatPackage.Player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

//Junit imports

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
        // need the primary boat class for ultimate test
        // for now test
        List<String> boatsList = new ArrayList<>(Arrays.asList("A3", "C5", "D5"));
        List<String> boatsListRed = new ArrayList<>(Arrays.asList("A3C", "C5C", "D5C"));
        assertEquals(boatsListRed, playerObjOne.placeShip(boatsList));
    }

    // text placeShip
    @Test
    public void revieveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        assertEquals(true, playerObjOne.receiveFire("A5"));
    }

    // text placeShip
    @Test
    public void fireUponTest() {
        // need the primary boat class for ultimate test
        // for now return True
        assertEquals(0, playerObjOne.fireUpon("A5", "hit"));
    }

    // text placeShip
    @Test
    public void renderTest() {
        // need the primary boat class for ultimate test
        // for now return True
        assertEquals(0, playerObjOne.render());
    }
}
