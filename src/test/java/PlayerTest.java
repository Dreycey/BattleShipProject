import BoatPackage.*;

//Junit imports
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import sun.security.krb5.internal.crypto.Des;

public class PlayerTest {

    // Instantiate Player
    //set up boats
    String[] bCoords = {"A1","A2","A3","A4"};
    String[] dCoords = {"B1","B2","B3"};
    String[] mCoords = {"C1","C2"};

    Battleship battleship = new Battleship(bCoords);
    Destroyer destroyer = new Destroyer(dCoords);
    Minesweeper minesweeper = new Minesweeper(mCoords);

    List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

    //construct player
    Player playerObjOne = new Player(fleet);

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
    public void receiveFireTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals("Miss", playerObjOne.receiveFire("A5"));
        Assertions.assertEquals("Hit", playerObjOne.receiveFire("C2"));
        Assertions.assertEquals("Sunk", playerObjOne.receiveFire("C1"));

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
    public void testReceiveFireUnarmored() throws Exception{
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship(bCoords);
        Destroyer destroyer = new Destroyer(dCoords);
        Minesweeper minesweeper = new Minesweeper(mCoords);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet);

        //hit unarmored captains cabin
        String result = player.receiveFire("C1");

        //did method return sunk?
        Assertions.assertEquals("Sunk C1 C2", result);

        //is the unarmored boat out of the fleet?
        Assertions.assertFalse(player.getFleet().contains(minesweeper));
        Assertions.assertTrue(player.getFleet().contains(battleship));

        //is the player board correct?
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("C1"));
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("C2"));
    }

    @Test
    public void testReceiveFireArmoredFirst() throws Exception{
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship(bCoords);
        Destroyer destroyer = new Destroyer(dCoords);
        Minesweeper minesweeper = new Minesweeper(mCoords);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet);

        //hit armored captains cabin
        String result = player.receiveFire("A3");

        //did method return sunk?
        Assertions.assertEquals("Miss", result);

        //is the armored boat still in the fleet?
        Assertions.assertTrue(player.getFleet().contains(battleship));

        //is the coordinate still in the boat's list?
        Assertions.assertTrue(player.getFleet().get(0).isCoordAfloat("A3"));

        //is the player board correct?
        Assertions.assertEquals('B', player.getPrimaryBoard().valueAt("A3"));
    }

    @Test
    public void testReceiveFireArmoredSecond() throws Exception{
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship(bCoords);
        Destroyer destroyer = new Destroyer(dCoords);
        Minesweeper minesweeper = new Minesweeper(mCoords);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet);

        //hit armored captains cabin
        String result = player.receiveFire("A2");

        Assertions.assertEquals("Hit", result);

        result = player.receiveFire("A3");

        Assertions.assertEquals("Miss", result);

        //hit second time
        result = player.receiveFire("A3");

        //did method return sunk?
        Assertions.assertEquals("Sunk A1 A3 A4", result);

        //is the unarmored boat out of the fleet?
        Assertions.assertFalse(player.getFleet().contains(battleship));

        //is the player board correct?
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("A1"));
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("A2"));
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("A3"));
        Assertions.assertEquals('x', player.getPrimaryBoard().valueAt("A4"));
    }

    @Test
    public void testFireUponMany() throws Exception{
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship(bCoords);
        Destroyer destroyer = new Destroyer(dCoords);
        Minesweeper minesweeper = new Minesweeper(mCoords);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet);

        String[] fires = {"A3","A4","A6"};

        player.fireUponMany(fires, "Sunk A3 A4 A6");

        Assertions.assertEquals('x', player.getTargetBoard().valueAt("A3"));
        Assertions.assertEquals('x', player.getTargetBoard().valueAt("A4"));
        Assertions.assertEquals('x', player.getTargetBoard().valueAt("A6"));
    }


}
