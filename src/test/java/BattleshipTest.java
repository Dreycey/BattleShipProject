import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BattleshipTest {

    Battleship boat = new Battleship();

    @Test
    public void testInheritedWorks() throws Exception{
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

    }


    @Test
    public void testGetSize() throws Exception{
        Assertions.assertEquals(4, boat.getSize());
    }

    @Test
    public void testCabin() throws Exception{

        Battleship boat = new Battleship();

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());
        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void testGenLocs() throws Exception{

        Battleship boat = new Battleship();

        int[][] south = {{0,0},{-1,0},{-2,0},{-3,0}};
        int[][] north = {{0,0},{1,0},{2,0},{3,0}};
        int[][] east = {{0,0},{0,1},{0,2},{0,3}};
        int[][] west = {{0,0},{0,-1},{0,-2},{0,-3}};

        Assertions.assertArrayEquals(south, boat.genLocs('s'));
        Assertions.assertArrayEquals(north, boat.genLocs('n'));
        Assertions.assertArrayEquals(east, boat.genLocs('e'));
        Assertions.assertArrayEquals(west, boat.genLocs('w'));

    }
}