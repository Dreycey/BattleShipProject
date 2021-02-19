import BoatPackage.Player;

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
    Player playerObjOne = new Player();

    @BeforeEach
    public void before() {
    }

    // text placeShip
    @Test
    public void placeShipTest() {
        // need the primary boat class for ultimate test
        // for now test
        List<String> boatsList = new ArrayList<>(Arrays.asList("A3", "C5", "D5"));
        List<String> boatsListRed = new ArrayList<>(Arrays.asList("A3C", "C5C", "D5C"));
        Assertions.assertEquals(boatsListRed, playerObjOne.placeShip(boatsList));
    }

    // test revieveFire
    @Test
    public void revieveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(true, playerObjOne.receiveFire("A5"));
    }

    // test fireUpon
    @Test
    public void fireUponTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(0, playerObjOne.fireUpon("A5", "hit"));
    }

    // test render
    @Test
    public void renderTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(0, playerObjOne.render());
    }
}
