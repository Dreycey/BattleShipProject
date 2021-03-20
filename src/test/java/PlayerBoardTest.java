import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
