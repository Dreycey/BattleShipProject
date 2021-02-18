package edu.colorado.csci44485448;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void testMakeGame(){
        Game g = new Game();

        Assertions.assertEquals(1,g.getTurn());

        g.playTurn();

        Assertions.assertEquals(2,g.getTurn());

        //oops, set turn to 1 just bc
        g.setTurn(1);

        Assertions.assertEquals(1,g.getTurn());
    }

}