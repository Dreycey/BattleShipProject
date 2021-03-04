import BoatPackage.TargetBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TargetBoardTest {
    @Test
    public void fireUpon() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "G5";

        String actionHit = "hit";

        char expectedResult1 = 'x'; // succeeded

        t.fireUpon(targetCoord, actionHit);
        Assertions.assertEquals(expectedResult1, t.valueAt(targetCoord));

    }

    @Test
    public void fireUponMiss() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "A1";
        String actionMiss = "miss";
        char expectedResult2 = 'o'; // miss
        t.fireUpon(targetCoord, actionMiss);
        Assertions.assertEquals(expectedResult2, t.valueAt(targetCoord));
    }
}
