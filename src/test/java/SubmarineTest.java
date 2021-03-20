import BoatPackage.Submarine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubmarineTest {


    @Test
    public void testChangeSubmerged() {
        Submarine sub = new Submarine();
        boolean expected = false;
        sub.changeSubmerged();
        boolean actual = sub.getIsSubmerged();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetters() {
        Submarine sub = new Submarine();
        // test default status
        boolean expected = true;
        boolean actual = sub.getIsSubmerged();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGenLocs() {
        Submarine sub = new Submarine();
        int[][] south = {{0,0},{1,0},{2,0},{3,0},{2,-1}};
        int[][] north = {{0,0},{-1,0},{-2,0},{-3,0},{-2,-1}};
        int[][] east = {{0,0},{0,1},{0,2},{0,3},{-1,2}};
        int[][] west = {{0,0},{0,-1},{0,-2},{0,-3},{-1,-2}};

        Assertions.assertArrayEquals(south, sub.genLocs('s'));
        Assertions.assertArrayEquals(north, sub.genLocs('n'));
        Assertions.assertArrayEquals(east, sub.genLocs('e'));
        Assertions.assertArrayEquals(west, sub.genLocs('w'));

        Assertions.assertEquals(null, sub.genLocs('k'));
    }
}
