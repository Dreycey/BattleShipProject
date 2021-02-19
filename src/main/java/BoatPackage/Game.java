package BoatPackage;

public class Game {

    int turn;
    String[] boats;

    public Game(){

        turn = 1;
        boats = new String[]{"Minesweeper","Destroyer","Battleship"};

    }

    public int getTurn(){
        return turn;
    }

    public void setTurn(int t){
        if(t==0 || t==1){
            turn = t;
        }
    }

    public void playTurn(){
        //more complex behavior here -actual gameplay

        //then switch turn
        turn = (turn == 1)?2:1;
    }

    public String[] getBoats(){
        return boats;
    }

    public void setBoats(String[] newBoats){
        boats = newBoats;
    }

}
