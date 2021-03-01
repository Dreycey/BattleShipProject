import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class armoredCaptainsCabinTest {

    @Test
    public void testConstructor() throws Exception{
        String location = "A3";
        captainsCabinType type = new armoredCaptainsCabin(location);
    }

    @Test
    public void testGettersAndSetters() throws Exception{
        String location = "A3";
        captainsCabinType type = new armoredCaptainsCabin(location);

        Assertions.assertEquals(location, type.getLoc());

        String newLoc = "A4";
        type.setLoc(newLoc);

        Assertions.assertEquals(newLoc, type.getLoc());

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }


}