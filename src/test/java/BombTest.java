import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BombTest {

    Bomb bomb = new Bomb();

    @Test
    public void testMiss() throws Exception{
        //given empty cell (-), it should return 'o'
        String curr = "-";

        String result = bomb.hit(curr);

        Assertions.assertEquals("o",result);
    }

    @Test
    public void testHit() throws Exception{
        //given a boat, should return 'x'
        String curr = "M0";
        String curr1 = "D1";
        String curr2 = "B2";
        String curr3 = "S3";

        Assertions.assertEquals("x",bomb.hit(curr));
        Assertions.assertEquals("x",bomb.hit(curr1));
        Assertions.assertEquals("x",bomb.hit(curr2));
        Assertions.assertEquals("x",bomb.hit(curr3));
    }
}