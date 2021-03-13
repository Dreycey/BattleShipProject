package BoatPackage;
import java.util.*;


public class Game {

    int turn;
    String[] boats = new String[]{"BoatPackage.Battleship","BoatPackage.Destroyer", "BoatPackage.Minesweeper"};
    private Player playerOne;
    private Player playerTwo;

    /*
    Description
        Instantiates the players.
        Add the boats to the players.
        TODO: get rid of coupling.

     */
    public Game() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        turn = 1;
        //boats = new String[]{"BoatPackage.Battleship","BoatPackage.Destroyer", "BoatPackage.Minesweeper"};

        // Instantiate Players
        String[][] coordPlayerOne = {{"A2","A3","A4"},{"B2","B3","B4","B5"},{"C4","C5"}};
        String[][] coordPlayerTwo = {{"A2","A3","A4"},{"B2","B3","B4","B5"},{"C4","C5"}};
        playerOne = new Player(setUpCoords(coordPlayerOne));
        playerTwo = new Player(setUpCoords(coordPlayerTwo));

        // Play the game!!
       // while(!gameOver()) {
        //    playTurn();
        //}
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int t) {
        if (t == 1 || t == 2) {
            turn = t;
        }
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

    /*
    DESCRIPTION
        This sets up boat object and returns a list of boat object
        with the input coordinates.

     INPUT:
           1. coordinates: [{"C3", "C4"}, []]
     OUTPUT:
            List<Boat> of boat objects with coordinates

    */

    public List<Boat> setUpCoords(String[][] inCoordinates) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Boat> playerBoatList = new ArrayList<Boat>();

        // instantiate boats, add
        int boatCounterInd = 0;
        for (String playerBoat : boats) {
            // Create object from string name
            //TODO: Decouple so player does the next two
            Class<?> boatCall = Class.forName(playerBoat);
            Boat boatObj = (Boat) boatCall.newInstance();
            // print String name, set coordinates
            System.out.println(boatObj.getName());
            /*
            if (isValidCoordinate(inCoordinates[boatCounterInd])) {
                boatObj.setCoordinates(inCoordinates[boatCounterInd]);
            }*/
            //else {break;}
            // add to list
            playerBoatList.add(boatObj);
            //increment counter
            boatCounterInd++;
        }
        return playerBoatList; // if works, returns 0
    }

    public boolean gameOver() {
        if (playerOne.fleetIsEmpty()){
            System.out.println("GAME OVER: player 2 has won!");
            return true;
        }
        if (playerTwo.fleetIsEmpty()){
            System.out.println("GAME OVER: player 1 has won!");
            return true;
        }
        return false;

    }

    public int playTurn() {
        // assign the offensePlayer / defense
        Player offensePlayer;
        Player defensePlayer;
        if (turn == 1) {
            offensePlayer = playerOne;
            defensePlayer = playerTwo;
        } else {
            offensePlayer = playerTwo;
            defensePlayer = playerOne;
        }

        // print out player board
        offensePlayer.render();

        // take input from offense
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter target for strike!");
        //String strikeCoord = sc.next();

        // checks impact on defensive player
        //String strikeRes = defensePlayer.receiveFire(strikeCoord);
        //String[] hits = strikeRes.split(" ", 0);
        //System.out.println("Result:" + hits[0]);

        //if(hits.length > 1){offensePlayer.fireUpon(Arrays.copyOfRange(hits,1,hits.length-1);, hits[0]);}
        //else{offensePlayer.fireUpon(strikeCoord, strikeRes);}

/*        // TODO: impliment later on
        if (player.getSonarPulse > 0) {
            String inputCoord = x;
            char[][] sonarResult = defensePlayer.recieveSonarPulse(inputCoord);
            offensePlayer.fireSonarPulse(inputCoord, sonarResult);
        }*/

        //System.out.println("Result:" + strikeRes);

        // returns output to offensive player
        //

        //then switch turn
        turn = (turn == 1) ? 2 : 1;


        return 0;
    }

    public String[] getBoats() {
        return boats;
    }

    public void setBoats(String[] newBoats) {
        boats = newBoats;
    }
}