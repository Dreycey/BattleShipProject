import BoatPackage.TargetBoard;
import org.junit.*;


public class TargetBoardTest {
    @Test
    public void fireUpon() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "G5";
        String action = "hit";
        char expectedResult = 'x'; // succeeded
        char result = t.fireUpon(targetCoord, action);
        Assert.assertEquals(expectedResult, result);
    }
}
