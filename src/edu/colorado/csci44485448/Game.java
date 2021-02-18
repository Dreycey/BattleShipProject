package edu.colorado.csci44485448;

public class Game {

    int turn;

    public Game(){

        turn = 1;

    }

    public int getTurn(){
        return turn;
    }

    public void setTurn(int t){
        turn = t;
    }

    public void playTurn(){
        //more complex behavior here -actual gameplay

        //then switch turn
        turn = (turn == 1)?2:1;
    }

}
