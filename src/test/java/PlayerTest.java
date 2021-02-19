import BoatPackage.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static junit.framework.TestCase.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Junit imports

public class PlayerTest {

    //Minesweeper[] boatList;

    // add boats to array TODO: This isn't working.
    //boatList[0] = new Minesweeper();
    //boatList[1] = new Destroyer();
    //boatList[2] = new Battleship();

    // Instantiate Player
    Player playerObjOne = new Player();

    @BeforeEach
    public void before() {
    }

    // text placeShip
    @Test
    public void placeShipTest() {
        // need the primary boat class for ultimate test
        // for now test
        Boat boat1 = new Minesweeper();
        Boat boat2 = new Destroyer();
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);
        boatsList.add(boat2);
        Assertions.assertEquals(boatsList, playerObjOne.placeShip(boatsList));
    }

    // test revieveFire
    @Test
    public void revieveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals("Miss", playerObjOne.receiveFire("A5"));
        Assertions.assertEquals("Hit", playerObjOne.receiveFire("C3"));
        Assertions.assertEquals("Sunk", playerObjOne.receiveFire("C4"));

    }

    // test fireUpon
    @Test
    public void fireUponTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(0, playerObjOne.fireUpon("C3", "hit"));
    }

    // test render
    @Test
    public void renderTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Boat boat1 = new Minesweeper();
        Boat boat2 = new Destroyer();
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);
        boatsList.add(boat2);
        playerObjOne.placeShip(boatsList);
        playerObjOne.fireUpon("C3", "hit");
        Assertions.assertEquals(0, playerObjOne.render());
    }

    @Test
    public void boatArrayTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(3, playerObjOne.getFleet().size());
    }


}
