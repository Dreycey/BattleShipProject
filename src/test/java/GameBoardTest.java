import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class GameBoardTest {

    GameBoard g1 = new PlayerBoard(2);

    @Test
    public void testBoardSize() {
        GameBoard testBoard = new PlayerBoard();
        testBoard.setBoardSize(3);

        int expectedSize = 3;
        int actualSize = testBoard.getBoardSize();

        Assertions.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void getMatrix() {
        String[][] expectedMatrix = {{"-","-"},{"-","-"}};

        String[][] board = g1.getMatrix();
        Assertions.assertArrayEquals(expectedMatrix, board);
    }

    @Test
    public void updateCoordTrue() {
        String coordinate = "A1";
        String action = "x"; // hit
        boolean isUpdated = g1.updateCoord(coordinate, action);
        Assertions.assertTrue(isUpdated);

        String falseCoord = "Z10";
        String anotherAction = "o";

        Assertions.assertFalse(g1.updateCoord(falseCoord, anotherAction));
    }


    @Test
    public void convertCoordToIndex() {
        // test letter + single digit
        int[] expectedLoc1 = {0,0};
        int[] actualLoc1 = g1.convertCoordToIndex("A1");
        Assertions.assertArrayEquals(expectedLoc1, actualLoc1);

        // test letter + two digits
        int[] expectedLoc2 = {0,9};
        int[] actualLoc2 = g1.convertCoordToIndex("A10");
        Assertions.assertArrayEquals(expectedLoc2, actualLoc2);

        // test invalid coordinate
        int[] expectedInv = {-1, -1};
        int[] actualIndex = g1.convertCoordToIndex("A349");
        Assertions.assertArrayEquals(expectedInv, actualIndex);
    }

    @Test
    public void renderBoard() {
        GameBoard g2 = new TargetBoard();
        g1.renderBoard();

    }

}
