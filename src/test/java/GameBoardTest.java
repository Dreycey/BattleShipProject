import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameBoardTest {

    GameBoard g1 = new PlayerBoard(2);
    @Test
    public void getMatrix() {
        char[][] expectedMatrix = {{'-','-'},{'-','-'}};

        char[][] board = g1.getMatrix();
        Assertions.assertArrayEquals(expectedMatrix, board);
    }

    @Test
    public void updateCoord() {
        String coordinate = "A1";
        char action = 'x'; // hit
        boolean isUpdated = g1.updateCoord(coordinate, action);
        Assertions.assertTrue(isUpdated);
    }

    @Test
    public void convertCoordToIndex() {
        int[] expectedLocation = {0,0};
        int[] location = g1.convertCoordToIndex("A1");
        Assertions.assertArrayEquals(expectedLocation, location);
    }

}
