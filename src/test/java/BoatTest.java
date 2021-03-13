import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BoatTest {

    Boat boat = new Boat();

    @Test
    public void testSetName() throws Exception {
        String name = "Destroyer";
        boat.setName(name);
        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void testSetStatus() throws Exception{
        String defaultStatus = "Afloat";
        String badStatus = "BadStatus";

        boat.setStatus(badStatus);
        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus(defaultStatus);
        Assertions.assertEquals(defaultStatus, boat.getStatus());
    }

    @Test
    public void testSetSize() throws Exception{
        boat.setSize(5);
        Assertions.assertEquals(5, boat.getSize());
    }

    @Test
    public void testCabin() throws Exception{
        boat.setCaptainsCabin("armored");

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        boat.getCaptainsCabin().setHitStatus(true);

        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());
    }

    @Test
    public void testCabinIndex() throws Exception{
        boat.setCabinIndex(2);

        Assertions.assertEquals(2, boat.getCabinIndex());
    }

    @Test
    public void testCabinHits() throws Exception{
        boat.setCaptainsCabin("armored");

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());

        boat.setCaptainsCabin("unarmored");
        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

}