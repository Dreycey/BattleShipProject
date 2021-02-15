import java.util.ArrayList;

public class PlayerBoard extends GameBoard {

    //private int[][] playerMatrix;

    public PlayerBoard() {
        super();
    }


    public void placeShip(int type, ArrayList<String> coordinates) {
        // int type will change to Ship object instead, then access type attribute
        // coordinates are most likely going to be given in the format B9, not B,9, thus using String
        System.out.println("placeShip");
        boolean legalPlacement = false;
        if (type == 0) // minesweeper, take first two elements in coordinates list
        {

        }

        //return legalPlacement;
    }

    // during opponent's turn, check to see if I've been hit
    public boolean receiveFire() {
        // based on symbol
        return false;
    }

    public void renderBoard() {
        int[][] matrix = super.getMatrix();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
}