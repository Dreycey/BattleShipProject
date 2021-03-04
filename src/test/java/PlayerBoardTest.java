import BoatPackage.PlayerBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerBoardTest {
    PlayerBoard pDefault = new PlayerBoard();
    PlayerBoard p1 = new PlayerBoard(5);

    @Test
    public void placeShipDefault() {
        // place ship on default board
        String[] coordList = {"C3", "C4"};
        String shipType = "Minesweeper";
        boolean isPlaced = pDefault.placeShip(shipType, coordList);
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals('M', pDefault.valueAt("C3"));
    }

    @Test
    public void placeShipNonDefault() {
        // place ship on nondefault board
        String[] coordList = {"A1", "A2"};
        String shipType = "Destroyer";
        boolean isPlaced = p1.placeShip(shipType, coordList);
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals('D', p1.valueAt("A1"));
    }


    @Test
    public void receiveFire() {

        String missTarget = "C9";
        char expectedResultMiss = 'o';
        char actual1 = pDefault.receiveFire(missTarget);
        Assertions.assertEquals(expectedResultMiss, actual1);

        String hitTarget = "A1";
        char expectedResultHit = 'x';
        char actual2 = p1.receiveFire(hitTarget);
        Assertions.assertEquals(expectedResultHit, actual2);
    }

    @Test
    public void renderBoard() {
        p1.renderBoard();
    }
}
