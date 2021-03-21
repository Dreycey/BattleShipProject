import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllTest {
    private Player p1;
    private Boat b;
    private Boat d;
    private Boat m;
    private GameBoard pBoard;
    private GameBoard tBoard;
    private Game g1;


    @Test
    public void defaultConstructors() {
        Boat b = new Battleship();
        Boat d = new Destroyer();
        Boat m = new Minesweeper();

        Assertions.assertEquals("Battleship", b.getName());
        Assertions.assertEquals("Destroyer", d.getName());
        Assertions.assertEquals("Minesweeper", m.getName());
    }

    @Test
    public void otherConstructors() {
//        Boat b2 = new Battleship(new String[]{"A1","A2","A3","A4"});
//        Boat d2 = new Destroyer(new String[]{"B1","B2","B3"});
//        Boat m2 = new Minesweeper(new String[]{"C1","C2"});
//
//        Assertions.assertArrayEquals(new String[]{"A1","A2","A3","A4"}, b2.getCoordinates());
//        Assertions.assertArrayEquals(new String[]{"B1","B2","B3"}, d2.getCoordinates());
//        Assertions.assertArrayEquals(new String[]{"C1","C2"}, m2.getCoordinates());
    }

    @Test
    public void testBoatSetters() {

    }
}
