package BoatPackage;


import java.util.Arrays;
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
    public String receiveFire(String coord, Weapon weapon) {

        String fireStatus = "Miss";
        String currVal = "";
        String newVal = "";
        int[] cell = convertCoordToIndex(coord);
        // TODO: validation of indices should be done in Game Class
        if (cell[0] != -1 && cell[1] != -1) {
            //if (getMatrix()[cell[0]][cell[1]] == '-')
            //System.out.println(valueAt(coord));
            currVal = valueAt(coord);
            newVal = weapon.hit(currVal);
            if (newVal == "o") {
                fireStatus = "Miss"; // miss
            }
            else{
                fireStatus = currVal; // hit (anything that's not a '-' would be a ship, return what's there to parse
            }
        }

        updateCoord(coord, newVal);
        return fireStatus;
    }

    public String receiveFireSpecialWeapon(String coord, SpecialWeapon weapon){
        //FOR NOW
        int weaponSize = 5;
        //get appropriate array
        String[][] boardSegment = getBoardSegment(coord, weaponSize);
        //give array to weapon
        //return result from weapon as a string
        return Arrays.deepToString(weapon.hit(boardSegment));
    }

    public String[][] getBoardSegment(String coord, int size){
        int upperThresh = 0;
        int lowerThresh = 0;
        int[] index = convertCoordToIndex(coord);
        String[][] toReturn = new String[size][size];

        if((size - 1) % 2 == 0){
            upperThresh = (size-1)/2;
            lowerThresh = (size-1)/2;
        }
        else{
            upperThresh = size/2;
            lowerThresh = (size/2)-1;
        }

        int outRow = 0;

        for(int i = index[0]-lowerThresh; i <= index[0]+upperThresh; i++){
            int outCol = 0;
            for(int j = index[0]-lowerThresh; j <= index[0]+upperThresh; j++){
                toReturn[outRow][outCol] = getMatrix()[i][j];
                outCol += 1;
            }

            outRow += 1;

        }
        return  toReturn;
    }

    public void sink(char token){
        for(int i = 0; i < getBoardSize(); i ++){
            for(int j = 0; j < getBoardSize(); j++){
                if(super.getMatrix()[i][j].indexOf(token) != -1){
                    super.updateCoordByIndex(i,j,"x");
                }
            }
        }
    }


}