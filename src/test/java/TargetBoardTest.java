import BoatPackage.TargetBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TargetBoardTest {
    @Test
    public void fireUpon() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "G5";
        String action = "hit";
        char expectedResult = 'x'; // succeeded
        t.fireUpon(targetCoord, action);
        //Assertions.assertEquals(expectedResult, result);
    }
}
