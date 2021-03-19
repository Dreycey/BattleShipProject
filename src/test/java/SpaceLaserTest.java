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

    @Test
    public void testHit() throws Exception{
        //given a boat, should return 'x'
        String curr = "M0";
        String curr1 = "D1";
        String curr2 = "B2";
        String curr3 = "S3";

        Assertions.assertEquals("x",laser.hit(curr));
        Assertions.assertEquals("x",laser.hit(curr1));
        Assertions.assertEquals("x",laser.hit(curr2));
        Assertions.assertEquals("x",laser.hit(curr3));
    }

    @Test
    public void testSubHit() throws Exception{
        //sub underwater can't be hit! - underwater signified by lowercase S

        String curr = "s0";

        Assertions.assertEquals("x",laser.hit(curr));
    }

    @Test
    public void testSubHitUnderBoat() throws  Exception{
        //sub under a boat should hit boat, but not sub

        String curr = "B2&s1";

        Assertions.assertEquals("x",laser.hit(curr));
    }

}