import BoatPackage.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestroyerTest {
    Destroyer boat = new Destroyer();

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
        String name = "Destroyer";

        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void testGetSize() throws Exception{
        Assertions.assertEquals(3, boat.getSize());
    }

    @Test
    public void testRealignStatus() throws  Exception{
        String[] coords = {"A1","A2","A3"};
        String[] hitCoords = {"A1","A2"};
        String[] sunkCoords = {};
        String defaultStatus = "Afloat";

        boat.setCoordinates(coords);

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.removeCoordinate("A3");

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.removeCoordinate("A1");
        boat.removeCoordinate("A2");

        Assertions.assertEquals("Sunk", boat.getStatus());
    }

    @Test
    public void testCabin() throws Exception{
        String[] coords = {"A1","A2","A3"};

        Destroyer boat = new Destroyer(coords);

        Assertions.assertEquals("A2", boat.getCaptainsCabin().getLoc());

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());
        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

}