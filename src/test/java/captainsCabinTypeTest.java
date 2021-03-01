import BoatPackage.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class captainsCabinTypeTest {

    @Test
    public void testConstructor() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);
    }

    @Test
    public void testGetLoc() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);

        Assertions.assertEquals(location, type.getLoc());
    }

    @Test
    public void testSetLoc() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);

        String newLoc = "A4";
        type.setLoc(newLoc);

        Assertions.assertEquals(newLoc, type.getLoc());
    }

    @Test
    public void testGetAlready() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);

        Assertions.assertFalse(type.getHitStatus());
    }

    @Test
    public void testSetAlready() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void testHit() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);

        Assertions.assertEquals(null, type.hit());
    }
}