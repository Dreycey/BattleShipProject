import BoatPackage.captainsCabinType;
import BoatPackage.unarmoredCaptainsCabin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unarmoredCaptainsCabinTest {

    @Test
    public void testConstructor() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();
    }

    @Test
    public void testGettersAndSetters() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void testHit() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();

        Assertions.assertEquals("Sunk", type.hit());
    }

}