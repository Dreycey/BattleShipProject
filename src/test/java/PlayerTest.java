import BoatPackage.*;

//Junit imports
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;

public class PlayerTest {

    // Instantiate Player
    Player playerObjOne = new Player();

    @BeforeEach
    public void testNonDefault() {
        List<Boat> bList = new ArrayList<Boat>();
        bList.add(new Destroyer());
        bList.add(new Destroyer());
        Player pNonDefault = new Player(bList);

        String boatNames[] = {"Destroyer", "Destroyer"};
        String actualNames[] = {pNonDefault.getFleet().get(0).getName(), pNonDefault.getFleet().get(1).getName()};
        Assertions.assertArrayEquals(boatNames, actualNames);
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

    @Test
    public void fleetIsEmpty() {
        Player pEmpty = new Player();
        pEmpty.setFleet(new ArrayList<Boat>());
        Assertions.assertEquals(false, playerObjOne.fleetIsEmpty());
        Assertions.assertEquals(true, pEmpty.fleetIsEmpty());
    }

    // test revieveFire
    @Test
    public void revieveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals("Miss", playerObjOne.receiveFire("A5"));
        Assertions.assertEquals("Hit", playerObjOne.receiveFire("C3"));
        Assertions.assertEquals("Sunk", playerObjOne.receiveFire("C4"));

        Player pEmpty = new Player();
        pEmpty.setFleet(new ArrayList<Boat>());
        Assertions.assertEquals("Surrender", pEmpty.receiveFire("C4"));

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
