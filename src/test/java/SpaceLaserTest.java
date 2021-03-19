import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SpaceLaserTest {
    SpaceLaser laser = new SpaceLaser();

    @Test
    public void testMiss() throws Exception{
        //given empty cell (-), it should return 'o'
        String result = laser.hit("-");

        Assertions.assertEquals("o",result);
    }

}