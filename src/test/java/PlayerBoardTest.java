import BoatPackage.PlayerBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerBoardTest {
    PlayerBoard p = new PlayerBoard();

    @Test
    public void placeShip() {
        int shipType = 1; // minesweeper
        String[] coordList = {"C3", "C4"};

        boolean isPlaced = p.placeShip(shipType, coordList);
        Assertions.assertTrue(isPlaced);
    }

    @Test
    public void receiveFire() {

        String targetCell = "C9";
        char expectedResult = 'o';
        char result = p.receiveFire(targetCell);
        Assertions.assertEquals(expectedResult, result);
    }

}
