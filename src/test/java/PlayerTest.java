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
    public void recieveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        //TODO: Add surrender
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

    @Test
    public void testReceiveSonarPulse() throws  Exception{
        // input
        String coordIn = "B3";

        // expected output
        String[][] sonarOutExpected = {
                {"-1","-1","-1","-1","-1"},
                {"1","1","1","1","0"},
                {"0","0","0","0","0"},
                {"0","0","1","1","0"},
                {"0","0","0","0","0"}
        };

        // testing
        Boat boat1 = new Destroyer();
        Boat boat2 = new Minesweeper();
        boat1.setCoordinates(new String[] {"A1","A2","A3","A4"});
        boat2.setCoordinates(new String[] {"C3", "C4"});
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);

        // testing the receiveFire method
        playerObjOne.placeShip(boatsList);
        Assertions.assertArrayEquals(sonarOutExpected, playerObjOne.receiveSonarPulse(coordIn));
    }

    @Test
    public void testFireSonarPulse() throws  Exception {

        // expected input
        String[][] sonarInExpected = {
                {"-1","-1","-1","-1","-1"},
                {"1","1","1","1","0"},
                {"0","0","0","0","0"},
                {"0","0","1","1","0"},
                {"0","0","0","0","0"}
        };

        // testing
        Boat boat1 = new Destroyer();
        Boat boat2 = new Minesweeper();
        boat1.setCoordinates(new String[] {"A1","A2","A3","A4"});
        boat1.setCoordinates(new String[] {"C3", "C4"});
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);

        // testing the receiveFire method
        playerObjOne.placeShip(boatsList);
        // check that it runs - actually a void but use 0 for passing
        Assertions.assertEquals(0, playerObjOne.fireSonarPulse(sonarInExpected));

    }
}
