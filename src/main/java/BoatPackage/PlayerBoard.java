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
        boolean validShipPlacement = true;
        String shipSymbol = boat.getName().toUpperCase().substring(0,1);

        int[][] locs = boat.genLocs(direction);

        String[] coords = new String[locs.length];

        char row = coordinate.charAt(0);
        char col = coordinate.charAt(1);

        for(int i = 0; i < locs.length; i++){
            char newRow = (char)(row+locs[i][0]);
            char newCol = (char)(col+locs[i][1]);
            coords[i] = new StringBuilder().append(newRow).append(newCol).toString();
        }

        //check that all coords are valid
        for(String coord : coords){
            if(!isValidCoordinate(coord)){
                return false;
            }
        }

        for(int i = 0; i < coords.length; i++){
            StringBuilder sb = new StringBuilder(String.valueOf (shipSymbol));
            sb.append(i);
            updateCoord(coords[i],sb.toString());
        }

        return true;
    }

    public boolean isValidCoordinate(String coord){
        int[] index = super.convertCoordToIndex(coord);

        if(index[0] < 0 || index[0] >= super.getBoardSize() || index[1] < 0 || index[1] >= super.getBoardSize()){
            return false;
        }
        return true;
    }

    // during opponent's turn, check to see if I've been hit
    public String receiveFire(String coord) {

        String fireStatus = "-";
        String returnVal = "";
        int[] cell = convertCoordToIndex(coord);
        // TODO: validation of indices should be done in Game Class
        if (cell[0] != -1 && cell[1] != -1) {
            //if (getMatrix()[cell[0]][cell[1]] == '-')
            //System.out.println(valueAt(coord));
            returnVal = valueAt(coord);
            if (returnVal == "-") {
                fireStatus = "o"; // miss
                returnVal = "Miss";
            }
            else{
                fireStatus = "x"; // hit (anything that's not a '-' would be a ship
            }
        }

        updateCoord(coord, fireStatus);
        return returnVal;
    }


}