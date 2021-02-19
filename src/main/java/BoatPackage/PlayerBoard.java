package BoatPackage;


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
    public boolean placeShip(int shipType, String[] coordList) {
        boolean validShipPlacement = false;
        char shipSymbol;
        // validate that there is no other existing ship
        if (shipType == 1) shipSymbol = 'M'; // minesweeper
        else if (shipType == 2) shipSymbol = 'D';
        else if (shipType == 3) shipSymbol = 'B';
        else return false;

        for (String cell: coordList)
            updateCoord(cell, shipSymbol);
        return true;
    }

    // during opponent's turn, check to see if I've been hit
    public char receiveFire(String coord) {

        char fireStatus = '-';
        int[] cell = convertCoordToIndex(coord);
        // TODO: validation of indices should be done in Game Class
        if (cell[0] != -1 && cell[1] != -1) {
            //if (getMatrix()[cell[0]][cell[1]] == '-')
            if (valueAt(coord) == '-') {
                fireStatus = 'o'; // miss
            }
            else fireStatus = 'x'; // hit (anything that's not a '-' would be a ship
        }

        updateCoord(coord, fireStatus);

        return fireStatus;
    }


}