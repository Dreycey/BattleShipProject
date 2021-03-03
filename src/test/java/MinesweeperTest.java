import BoatPackage.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {
    Minesweeper boat = new Minesweeper();

    @Test
    public void testInheritedWorks() throws Exception{
        String[] coords = {"A1","A2","A3"};
        String defaultStatus = "Afloat";

        boat.setCoordinates(coords);

        Assertions.assertArrayEquals(coords, boat.getCoordinates());
        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.removeCoordinate("Z3");

        Assertions.assertArrayEquals(coords, boat.getCoordinates());

        boat.removeCoordinate("A3");

        String[] shouldBe = {"A1","A2"};

        Assertions.assertArrayEquals(shouldBe, boat.getCoordinates());

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
    public void testRealignStatus() throws  Exception{
        String[] coords = {"A1","A2"};
        String[] hitCoords = {"A1"};
        String[] sunkCoords = {};
        String defaultStatus = "Afloat";

        boat.setCoordinates(coords);

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.removeCoordinate("A2");

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.removeCoordinate("A1");

        Assertions.assertEquals("Sunk", boat.getStatus());
    }

    @Test
    public void testCabin() throws Exception{
        String[] coords = {"A1","A2"};

        Minesweeper boat = new Minesweeper(coords);

        Assertions.assertEquals("A1", boat.getCaptainsCabin().getLoc());

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

}