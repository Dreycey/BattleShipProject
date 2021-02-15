import java.util.ArrayList;

public class TargetBoard extends GameBoard{

    public void fireUpon(ArrayList<String> targetCoord) {
        // if special symbol meaning there is a boat there, then hit and update target board
        // how will i have access to see if there's a boat there?
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
