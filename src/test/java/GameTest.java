import BoatPackage.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    Game g = new Game();

    /*
    This constructor tests setUpCoords() while constructing players
     */
    GameTest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
    }

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
        String[] defaultBoats = {"BoatPackage.Battleship","BoatPackage.Destroyer", "BoatPackage.Minesweeper"};
        String[] newBoats = {"Destroyer","Battleship"};

        Assertions.assertArrayEquals(defaultBoats, g.getBoats());

        g.setBoats(newBoats);

        Assertions.assertArrayEquals(newBoats, g.getBoats());
    }

    @Test
    public void testIsValidCoordinate(){
        String[] trueInput = {"A2","A3","A4"};
        Assertions.assertEquals(true, g.isValidCoordinate(trueInput));
        String[] falseInput = {"A2","A3","B3"};
        Assertions.assertEquals(false, g.isValidCoordinate(falseInput));
        String[] falseInput2 = {"A2","A3","A10"};
        Assertions.assertEquals(false, g.isValidCoordinate(falseInput2));
    }

}