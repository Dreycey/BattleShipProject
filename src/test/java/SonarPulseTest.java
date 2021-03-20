import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SonarPulseTest {

    SonarPulse sonarPulse = new SonarPulse();

    @Test
    public void testGetters() throws Exception{
        Assertions.assertEquals("SonarPulse",sonarPulse.getName());
        Assertions.assertEquals("SpecialWeapon",sonarPulse.getType());
    }

    @Test
    public void testMiss() throws Exception{
        //given empty cell (-), it should return '0'
        String[][] curr = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"0","0","0"},{"0","0","0"},{"0","0","0"}};

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testHit() throws Exception{
        String[][] curr = {{"","",""},{"M0","M1","-"},{"-","B0","x"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"-1","-1","-1"},{"1","1","0"},{"0","1","1"}};

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testSub() throws Exception{
        String[][] curr = {{"s0","s1","s2"},{"S0","S1","S2"},{"M0&s0","M1&s1","s2"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"1","1","1"},{"1","1","1"},{"1","1","1"}};

        Assertions.assertArrayEquals(expected,result);
    }
}