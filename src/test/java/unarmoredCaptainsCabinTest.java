import BoatPackage.captainsCabinType;
import BoatPackage.unarmoredCaptainsCabin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unarmoredCaptainsCabinTest {

    @Test
    public void testConstructor() throws Exception{
        String location = "A3";
        captainsCabinType type = new unarmoredCaptainsCabin(location);
    }

}