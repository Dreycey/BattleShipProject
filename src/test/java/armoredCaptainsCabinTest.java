import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class armoredCaptainsCabinTest {

    @Test
    public void testConstructor() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();
    }

    @Test
    public void testGettersAndSetters() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void testHit() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertEquals("Miss", type.hit());
    }

    @Test
    public void testHitTwice() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertEquals("Miss", type.hit());
        Assertions.assertEquals("Sunk", type.hit());
    }


}