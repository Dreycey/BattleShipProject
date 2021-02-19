import BoatPackage.*;
import org.junit.Assert;
import org.junit.Test;

public class GameBoardTest {

    GameBoard g1 = new PlayerBoard(2);
    @Test
    public void getMatrix() {
        char[][] expectedMatrix = {{'-','-'},{'-','-'}};

        char[][] board = g1.getMatrix();
        Assert.assertArrayEquals(expectedMatrix, board);
    }

    @Test
    public void updateCoord() {
        String coordinate = "A1";
        char action = 'x'; // hit
        boolean isUpdated = g1.updateCoord(coordinate, action);
        Assert.assertTrue(isUpdated);
    }

    @Test
    public void convertCoordToIndex() {
        int[] expectedLocation = {0,0};
        int[] location = g1.convertCoordToIndex("A1");
        Assert.assertArrayEquals(expectedLocation, location);
    }

}
