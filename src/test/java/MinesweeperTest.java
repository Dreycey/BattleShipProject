import BoatPackage.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {
    Minesweeper boat = new Minesweeper();

    @Test
    public void testInheritedWorks() throws Exception{
        String[] coords = {"A1","A2"};
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());
    }

    @Test
    public void testGetName() throws Exception{
        String name = "Minesweeper";

        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void testGetSize() throws Exception{
        Assertions.assertEquals(2, boat.getSize());
    }


    @Test
    public void testCabin() throws Exception{
        String[] coords = {"A1","A2"};

        Minesweeper boat = new Minesweeper();

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void testGenLocs() throws Exception{

        Minesweeper boat = new Minesweeper();

        int[][] south = {{0,0},{-1,0}};
        int[][] north = {{0,0},{1,0}};
        int[][] east = {{0,0},{0,1}};
        int[][] west = {{0,0},{0,-1}};

        Assertions.assertArrayEquals(south, boat.genLocs('s'));
        Assertions.assertArrayEquals(north, boat.genLocs('n'));
        Assertions.assertArrayEquals(east, boat.genLocs('e'));
        Assertions.assertArrayEquals(west, boat.genLocs('w'));

    }

}