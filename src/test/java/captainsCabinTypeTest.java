import BoatPackage.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class captainsCabinTypeTest {

    @Test
    public void testContructor() throws Exception{
        String location = "A3";
        captainsCabinType type = new captainsCabinType(location);
    }
}