
package BoatPackage;

public class Game {

    int turn;
    String[] boats;

    /*
    Description
        Instantiates the players.
        Add the boats to the players.
        TODO: get rid of coupling.

     */
    public Game() {
        turn = 1;
        boats = new String[]{"Minesweeper", "Destroyer", "Battleship"};
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int t) {
        if (t == 1 || t == 2) {
            turn = t;
        }
    }

    /*
    DESCRIPTION
        This sets up all of the players

     INPUT:
           1. PLayerObj
           2. [minesweeper(), ..., destroyer()]
           3. [[A1, C3, C4], []]

    */
    public int setUpBoard() {
        playerObj
        return 0; // if works, returns 0
    }

    public void playTurn() {
        //more complex behavior here -actual gameplay

        //then switch turn
        turn = (turn == 1) ? 2 : 1;
    }

    public String[] getBoats() {
        return boats;
    }

    public void setBoats(String[] newBoats) {
        boats = newBoats;
    }
}