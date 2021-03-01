import BoatPackage.captainsCabinType;
import BoatPackage.unarmoredCaptainsCabin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unarmoredCaptainsCabinTest {

    @Test
    public void testConstructor() throws Exception{
        String location = "A3";
        captainsCabinType type = new unarmoredCaptainsCabin(location);
    }

    @Test
    public void testGettersAndSetters() throws Exception{
        String location = "A3";
        captainsCabinType type = new unarmoredCaptainsCabin(location);

        Assertions.assertEquals(location, type.getLoc());

        String newLoc = "A4";
        type.setLoc(newLoc);

        Assertions.assertEquals(newLoc, type.getLoc());

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void testHit() throws Exception{
        String location = "A3";
        captainsCabinType type = new unarmoredCaptainsCabin(location);

        Assertions.assertEquals("Sunk", type.hit());
    }

}