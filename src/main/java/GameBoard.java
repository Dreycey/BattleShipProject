import java.util.ArrayList;

public abstract class GameBoard {
    private int n = 10;
    private int matrix[][];

    public GameBoard() {
        matrix = new int[n][n];
    }

    public GameBoard(int boardSize) {
        n = boardSize;
        matrix = new int[n][n];
    }

    public void setBoardSize(int boardSize) {
        n = boardSize;
    }

    public int getBoardSize() {
        return n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    // need validation for when there's already something done in a given cell (e.g. if != 0)
    public void setCoord(int []coord) { // is this needed? Isn't this something the ship should know?
        // do something with the coordinate depending on what it is that's happening?
        matrix[coord[0]][coord[1]] = 9;
    }

    public int[] convertCoordToIndex(String coordinate) {
        int index[] = new int[2]; // e.g. [2, 8] = row 3, col 9 = C9
        char row = coordinate.toLowerCase().charAt(0);

        if (row == 'a') index[0] = 0;
        if (row == 'b') index[0] = 1;
        if (row == 'c') index[0] = 2;
        if (row == 'd') index[0] = 3;
        if (row == 'e') index[0] = 4;
        if (row == 'f') index[0] = 5;
        if (row == 'g') index[0] = 6;
        if (row == 'h') index[0] = 7;
        if (row == 'i') index[0] = 8;

        if (coordinate.length() == 2) {
            index[1] = Integer.parseInt(String.valueOf(coordinate.charAt(1))) - 1;
        }
        else if (coordinate.length() == 3) // a letter + two digits
            index[1] = Integer.parseInt(coordinate.substring(1));
        else return new int[]{-1, -1};
        return index;
    }

    public abstract void renderBoard();
}
