import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PlayerBoardTest {
    PlayerBoard pDefault = new PlayerBoard();
    PlayerBoard p1 = new PlayerBoard(5);

    @Test
    public void testValidCoord() throws Exception{
        PlayerBoard p2 = new PlayerBoard(10);

        Assertions.assertFalse(p2.isValidCoordinate("K200"));
        Assertions.assertTrue(p2.isValidCoordinate("A10"));
    }

    @Test
    public void placeShipDefault() {
        // place ship on default board
        String[] coordList = {"C3", "C4"};
        String shipType = "Minesweeper";
        Minesweeper boat = new Minesweeper();
        boolean isPlaced = pDefault.placeShip("C3",boat,'e');
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals("M1", pDefault.valueAt("C4"));
    }

    @Test
    public void placeShipNonDefault() {
        // place ship on nondefault board
        String[] coordList = {"A1", "A2"};
        String shipType = "Destroyer";
        Destroyer boat = new Destroyer();
        boolean isPlaced = p1.placeShip("A1", boat, 'e');
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals("D0", p1.valueAt("A1"));
    }

    @Test
    public void placeInvalidShip() throws Exception{
        Destroyer boat = new Destroyer();
        boolean isPlaced = p1.placeShip("A4", boat, 'e');
        Assertions.assertFalse(isPlaced);
    }


    @Test
    public void receiveFireBomb() {

        Bomb weapon = new Bomb();

        String missTarget = "C9";
        String expectedResultMiss = "Miss";
        String actual1 = pDefault.receiveFire(missTarget, weapon);
        Assertions.assertEquals(expectedResultMiss, actual1);

        String[] coordList = {"A1", "A2"};
        String shipType = "Minesweeper";
        Minesweeper boat = new Minesweeper();
        boolean isPlaced = pDefault.placeShip("A1",boat,'e');
        Assertions.assertEquals("M0", pDefault.valueAt("A1"));
        Assertions.assertEquals("M1", pDefault.valueAt("A2"));
        String hitTarget = "A2";
        String expectedResultHit = "M1";
        String actual2 = pDefault.receiveFire(hitTarget, weapon);
        Assertions.assertEquals(expectedResultHit, actual2);
    }

    @Test
    public void renderBoard() {
        p1.renderBoard();
    }

    @Test
    public void testSink() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);

        p1.updateCoord("A1","B0");
        p1.updateCoord("A2","B1");
        p1.updateCoord("A3","B2");
        p1.updateCoord("A4","B3");

        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));

        p1.sink('B');

        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
    }

    //need: getBoardSegment test, receiveFireSpecialWeapon

    @Test
    public void testGetBoardSegment() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("B3","B1");
        p1.updateCoord("C3","S2");
        p1.updateCoord("C1","s3");
        p1.updateCoord("D1","x&s2");
        p1.updateCoord("D2","o&s0");
        p1.updateCoord("C4","M0");
        p1.updateCoord("C5","x&S2");
        p1.updateCoord("A1","o");

        /*
        String[][] expected = {{"-1","-1","-1","-1","-1"},
                               {"0","0","1","0","0"},
                               {"0","0","1","0","0"},
                               {"1","0","1","1","1"},
                               {"1","1","0","0","0"}};

         */

        String[][] expected = {{"","","","",""},
                               {"o","-","x","-","-"},
                               {"-","-","B1","-","-"},
                               {"s3","-","S2","M0","x&S2"},
                               {"x&s2","o&s0","-","-","-"}};
        Assertions.assertArrayEquals(expected,p1.getBoardSegment("B3",5));
    }

    @Test
    public void testGetBoardSegmentOdd() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("A5","s3");
        p1.updateCoord("B3","M0");
        p1.updateCoord("B4","B1");
        p1.updateCoord("B5","o");
        p1.updateCoord("C4","S2");
        p1.updateCoord("D5","x&s2");
        p1.updateCoord("E3","o&s0");
        p1.updateCoord("E4","x&S2");
        p1.updateCoord("E5","o");

        /*
        String[][] expected = {{"-1","-1","-1","-1","-1"},
                               {"0","0","1","0","0"},
                               {"0","0","1","0","0"},
                               {"1","0","1","1","1"},
                               {"1","1","0","0","0"}};

         */

        String[][] expected = {{"M0","B1","o",""},
                               {"-","S2","-",""},
                               {"-","-","x&s2",""},
                               {"o&s0","x&S2","o",""}};
        Assertions.assertArrayEquals(expected,p1.getBoardSegment("C4",4));
    }

    @Test
    public void testReceiveSpecialWeapon() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("B3","B1");
        p1.updateCoord("C3","S2");
        p1.updateCoord("C1","s3");
        p1.updateCoord("D1","x&s2");
        p1.updateCoord("D2","o&s0");
        p1.updateCoord("C4","M0");
        p1.updateCoord("C5","x&S2");
        p1.updateCoord("A1","o");


        String[][] expected = {{"-1","-1","-1","-1","-1"},
                               {"0","0","1","0","0"},
                               {"0","0","1","0","0"},
                               {"1","0","1","1","1"},
                               {"1","1","0","0","0"}};

        SonarPulse pulse = new SonarPulse();

        Assertions.assertEquals(Arrays.deepToString(expected),p1.receiveFireSpecialWeapon("B3",pulse));
    }

}
