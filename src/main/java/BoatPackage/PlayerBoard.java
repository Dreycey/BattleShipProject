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
        char fireStatus = 'o';
        int[] cell = convertCoordToIndex(coord);

        if (cell[0] != -1 && cell[1] != -1) {
            if (getMatrix()[cell[0]][cell[1]] == '-')
                fireStatus = 'o'; // miss
            else fireStatus = 'x'; // hit (anything that's not a '-' would be a ship
        }
        else fireStatus = '-'; // what to do in this case?

        return fireStatus;
    }


}