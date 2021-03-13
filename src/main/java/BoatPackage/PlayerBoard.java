package BoatPackage;


import java.util.Locale;

public class PlayerBoard extends GameBoard {

    public PlayerBoard() {
        super();
    }

    public PlayerBoard(int boardSize) {
        super(boardSize);
    }

    // is shipType needed or can I get ship type from coordList.length?
    // shipType data type may change
    // should it return boolean or the new matrix?
    public boolean placeShip(String coordinate, Boat boat, char direction) {
        boolean validShipPlacement = false;
        /*
        String shipSymbol;
        // validate that there is no other existing ship

        shipSymbol = shipName.toUpperCase().substring(0,1);


         TODO: previous, delete below
        if (shipName == 1) shipSymbol = 'M'; // minesweeper
        else if (shipName == 2) shipSymbol = 'D';
        else if (shipType == 3) shipSymbol = 'B';
        else return false;


        for (String cell: coordList)
            updateCoord(cell, shipSymbol);
        */
        return true;
    }

    // during opponent's turn, check to see if I've been hit
    public String receiveFire(String coord) {

        String fireStatus = "-";
        int[] cell = convertCoordToIndex(coord);
        // TODO: validation of indices should be done in Game Class
        if (cell[0] != -1 && cell[1] != -1) {
            //if (getMatrix()[cell[0]][cell[1]] == '-')
            //System.out.println(valueAt(coord));
            if (valueAt(coord) == "-") {
                fireStatus = "o"; // miss
            }
            else fireStatus = "x"; // hit (anything that's not a '-' would be a ship
        }

        updateCoord(coord, fireStatus);
        return fireStatus;
    }


}