package BoatPackage;

public abstract class GameBoard {
    private int n = 10;
    private String matrix[][];

    public GameBoard() {
        matrix = new String[n][n];
        setMatrix("-");
    }

    public GameBoard(int boardSize) {
        n = boardSize;
        matrix = new String[n][n];
        setMatrix("-");
    }

    public void setBoardSize(int boardSize) {
        n = boardSize;
    }

    public int getBoardSize() {
        return n;
    }

    private void setMatrix(String emptySymbol) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++)
                matrix[i][j] = emptySymbol; // initial state, empty board
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public String valueAt(String coord) {
        int[] cell = convertCoordToIndex(coord);
        return matrix[cell[0]][cell[1]];
    }

    public boolean updateCoord(String coordinate, String action) {
        int[] indexCoord = convertCoordToIndex(coordinate);
        //System.out.println(indexCoord[0]);
        //System.out.println(indexCoord[1]);
        if (indexCoord[0] != -1 && indexCoord[1] != -1) {
            matrix[indexCoord[0]][indexCoord[1]] = action;
            return true;
        }

        return false;
    }

//    // need validation for when there's already something done in a given cell (e.g. if != 0)
//    public void setCoord(int []coord, char status) {
//        // do something with the coordinate depending on what it is that's happening?
//        matrix[coord[0]][coord[1]] = 9;
//    }

    public int[] convertCoordToIndex(String coordinate) {
        int index[] = new int[2]; // e.g. [2, 8] = row 3, col 9 = C9
        char row = coordinate.toLowerCase().charAt(0);

        if (row == 'a') index[0] = 0;
        else if (row == 'b') index[0] = 1;
        else if (row == 'c') index[0] = 2;
        else if (row == 'd') index[0] = 3;
        else if (row == 'e') index[0] = 4;
        else if (row == 'f') index[0] = 5;
        else if (row == 'g') index[0] = 6;
        else if (row == 'h') index[0] = 7;
        else if (row == 'i') index[0] = 8;
        else return new int[]{-1, -1};

        if (coordinate.length() == 2) {
            index[1] = Integer.parseInt(String.valueOf(coordinate.charAt(1))) - 1;
        }
        else if (coordinate.length() == 3) // a letter + two digits
            index[1] = Integer.parseInt(coordinate.substring(1))-1;
        else return new int[]{-1, -1};

        return index;
    }

    public void renderBoard() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }


}
