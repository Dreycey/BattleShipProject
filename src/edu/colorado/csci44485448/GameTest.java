package edu.colorado.csci44485448;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    Game g = new Game();

    @Test
    public void testTurns(){

        Assertions.assertEquals(1,g.getTurn());

        g.playTurn();

        Assertions.assertEquals(2,g.getTurn());
    }

    @Test
    public void testSetTurn(){
        //oops, set turn to 1 just bc
        g.setTurn(1);

        Assertions.assertEquals(1,g.getTurn());
    }

    @Test
    public void testSetTurnBad(){
        g.setTurn(10);

        Assertions.assertEquals(1,g.getTurn());
    }

    @Test
    public void testGetSetBoats(){
        String[] defaultBoats = {"Minesweeper","Destroyer","Battleship"};

        Assertions.assertArrayEquals(defaultBoats, g.getBoats());
    }

}