package BoatPackage;

public class TestToName {
    public static void main(String[] args) throws Exception {
        String coord = "B5";
        int letter = (int) coord.charAt(0);
        System.out.println(letter);

        Class<?> aClass = Class.forName("BoatPackage.Minesweeper");
        Boat mClass = (Boat) aClass.newInstance();
        mClass.setCoordinates(new String[]{"C3", "C4"});
        System.out.println("Here is the output");
        System.out.println(mClass.getName());



    }
    public boolean isValidCoordinate(String[] inCoords){
        int[][] convCoordArray = new int[inCoords.length][2];

        // check each in array is good.
        int indCounter = 0;
        for (String coord : inCoords) {
            int letter = (int) coord.charAt(0);
            int number = Integer.parseInt(coord.substring(1));

            if (number > 0 && number < 11 && letter > 64 && letter < 75) {
                // create convCoordArray
                int letterNew = letter - 64;
                convCoordArray[indCounter][0] = letterNew;
                convCoordArray[indCounter][1] = number;
                indCounter++;
            } else {
                return false;
            }
        }

        // check all next to one another.
        int countIter = 0;
        int prevRow = 100;
        int prevCol = 100;
        boolean isVertical = true;
        for (int[] coordIndex  : convCoordArray) {
            int row = coordIndex[0];
            int column = coordIndex[1];

            if (countIter == 1) {
                int rowDist = row - prevRow;
                int colDist = column - prevCol;
                if (rowDist == 1 && colDist == 0) {
                    isVertical = false;
                }
            }

            if (countIter > 1) {
                // now start checking
                int rowDist = row - prevRow;
                int colDist = column - prevCol;
                if ((rowDist == 1 && colDist == 0 && isVertical == false) ||
                        (rowDist == 0 && colDist == 1 && isVertical == true)) {}
                else {
                    return false;
                }
            }

            prevRow = row;
            prevCol = column;
            countIter++;
        }
        return true;
    }
}
