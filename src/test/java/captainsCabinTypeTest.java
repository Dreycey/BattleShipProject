import BoatPackage.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class captainsCabinTypeTest {

    @Test
    public void testConstructor() throws Exception{
        captainsCabinType type = new captainsCabinType();
    }

    @Test
    public void testGetAlready() throws Exception{
        captainsCabinType type = new captainsCabinType();

        Assertions.assertFalse(type.getHitStatus());
    }

    @Test
    public void testSetAlready() throws Exception{
        captainsCabinType type = new captainsCabinType();

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void testHit() throws Exception{
        captainsCabinType type = new captainsCabinType();

        Assertions.assertEquals(null, type.hit());
    }
}