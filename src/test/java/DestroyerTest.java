import BoatPackage.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DestroyerTest {
    Destroyer boat = new Destroyer();

    @Test
    public void testInheritedWorks() throws Exception{
        String[] coords = {"A1","A2","A3"};
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

    }

    @Test
    public void testGetName() throws Exception{
        String name = "Destroyer";

        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void testCabin() throws Exception{
        String[] coords = {"A1","A2","A3"};

        Destroyer boat = new Destroyer(coords);

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());
        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

}