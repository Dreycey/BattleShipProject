package BoatPackage;

public class TargetBoard extends GameBoard {

    public void fireUpon(String coordinate, String action) {
        // if special symbol meaning there is a boat there, then hit and update target board
        // how will i have access to see if there's a boat there?
        // updates target board
        char symbol = ' ';
        if(action.equalsIgnoreCase("miss")){
            symbol = 'o';
        }
        else{
            symbol = 'x';
        }
        updateCoord(coordinate, symbol);
    }

}
