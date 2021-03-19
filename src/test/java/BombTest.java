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
}