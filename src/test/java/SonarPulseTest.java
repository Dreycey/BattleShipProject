import BoatPackage.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SonarPulseTest {

    SonarPulse sonarPulse = new SonarPulse();

    @Test
    public void testMiss() throws Exception{
        //given empty cell (-), it should return 'o'
        String[][] curr = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"0","0","0"},{"0","0","0"},{"0","0","0"}};

        Assertions.assertEquals(expected,result);
    }
}