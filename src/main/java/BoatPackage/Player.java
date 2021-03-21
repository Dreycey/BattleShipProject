package BoatPackage;
import java.util.*;

public class Player {

    private PlayerBoard primaryBoard;
    private TargetBoard targetBoard;
    private List<Boat> fleet = new ArrayList<Boat>();
    private Weapon weapon;
    private List<SpecialWeapon> specialWeapons = new ArrayList<>();
    private Stack moves = new Stack();
    private Stack redos = new Stack();

    // if no input, construct boats for a example
    public Player() {
        primaryBoard = new PlayerBoard();
        targetBoard = new TargetBoard();

        // Construct Boats
        Boat mineBoat = new Minesweeper();
        Boat DestBoat = new Destroyer();
        Boat BatBoat = new Battleship();

        // add 3 default boats
        fleet.add(mineBoat);
        fleet.add(DestBoat);
        fleet.add(BatBoat);

        //add ships to primaryBoard
        for (int ind=0; ind < fleet.size(); ind++){
            Boat shipIter = fleet.get(ind);
            //primaryBoard.placeShip(shipIter.getName());
        }
        weapon = new Bomb();
    }

    // Constructor for Player class
    public Player(List<Boat> inputBoats, String[] coords, char[] directions) {
        primaryBoard = new PlayerBoard();
        targetBoard = new TargetBoard();
        fleet = inputBoats;
        //add ships to primaryBoard
        for (int ind=0; ind < fleet.size(); ind++){
            Boat shipIter = fleet.get(ind);
            primaryBoard.placeShip(coords[ind], shipIter, directions[ind]);
        }
        weapon = new Bomb();
    }


    // returns the fleet at hand
    public List<Boat> getFleet() {
        return fleet;
    }

    public void setFleet(List<Boat> boatList) {
        this.fleet = boatList;
    }

    public Weapon getWeapon(){return weapon;}

    public List<SpecialWeapon> getSpecialWeapons(){return specialWeapons;}

    public Stack getMoves(){return moves;}

    public Stack getRedos(){return redos;}

    /*
    DESCRIPTION:
        This method places a ship on the board and sends
        the coordinates back to the primary board.

    INPUT:
        List<Boat> boatlist

    OUTPUT:
        List<Boat> (returns the input list.)
    */
    public List<Boat> placeShip(List<Boat> boatlist) { // assumes array type
        List<Boat> outputTestArray = new ArrayList<>();
        for (int ind=0; ind < boatlist.size(); ind++){
            System.out.println(boatlist.get(ind));
            Boat shipIter = boatlist.get(ind);
            //primaryBoard.placeShip(shipIter.getName());
            outputTestArray.add(shipIter);
            fleet.add(shipIter);
        }
        return outputTestArray;
    }

    public boolean fleetIsEmpty(){
        if (fleet.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
    DESCRIPTION:
        The input for this method is a coordinate where
        a hit is sent. It then updates the fleet, and
        lastly, it returns a True if hit or False if not.

    INPUT:
        String inCoordinate

    OUTPUT:
        String <"Sunk", "Surrender", "Hit", "Miss">
    */
    public String receiveFire(String inCoordinate, Weapon firingWeapon) {

        String typeOfHit = "";
        if(firingWeapon.getType().equals("Weapon")){
            typeOfHit = primaryBoard.receiveFire(inCoordinate, firingWeapon);
        }
        else{
            //get type of hit
            typeOfHit = primaryBoard.receiveFireSpecialWeapon(inCoordinate, ((SpecialWeapon) firingWeapon));
            return typeOfHit;

        }

        // initialize variables
        //System.out.println(typeOfHit);

        if(typeOfHit != "Miss"){

            //find the boat that has been hit
            Boat hitBoat = null;
            for(Boat boat : fleet){
                if(typeOfHit.charAt(0) == boat.getName().charAt(0)){
                    hitBoat = boat;
                }
            }


            //has the captains cabin been hit?
            int hitIndex = Integer.parseInt(typeOfHit.substring(1));
            if(hitIndex == hitBoat.getCabinIndex()){
                //see result of hitting captains cabin
                String response = hitBoat.getCaptainsCabin().hit();

                //if the hit sinks the ship, follow sinking procedure
                if(response == "Sunk"){
                    //tell board to sink all of the chars
                    primaryBoard.sink(hitBoat.getName().charAt(0));

                    //remove boat from fleet
                    fleet.remove(hitBoat);

                    //if fleet is empty now, return surrender
                    if(fleetIsEmpty()){
                        return "Surrender";
                    }

                    //otherwise return sunk
                    else{
                        return "Sunk "+hitBoat.getName();
                    }
                }
                else{
                    //update coordinate to be unhit
                    String shouldBe = hitBoat.getName().substring(0,1)+String.valueOf(hitBoat.getCabinIndex());
                    primaryBoard.updateCoord(inCoordinate, shouldBe);

                    //return miss
                    return "Miss";
                }
            }
            //if not:
            else{
                //hit boat
                hitBoat.hit();

                //check status
                //if status is sunk:
                if(hitBoat.getStatus() == "Sunk"){
                    //tell board to sink all of the chars
                    primaryBoard.sink(hitBoat.getName().charAt(0));

                    //remove boat from fleet
                    fleet.remove(hitBoat);

                    //if fleet is empty now, return surrender
                    if(fleetIsEmpty()){
                        return "Surrender";
                    }

                    //otherwise return sunk
                    else{
                        return "Sunk "+hitBoat.getName();
                    }
                }
                //else return hit
                return "Hit";

            }

        }
        else{
            return "Miss";
        }

        } //else{ // IF NOT HIT
            //return "Miss";
        //}
    //}

    /*
    DESCRIPTION:
        This method updates the target board for a player, based on the result
        from the initial offensive. The Game Manager will call this method and
        update the target board for the player on offense.

    INPUT:
        String inCoordinate, String strikeResult

    OUTPUT:
        return 0 for passing
    */
   public int fireUpon(String inCoordinate, String strikeResult) {
       if(strikeResult.contains("Sunk") && weapon.getName().equals("Bomb")){
           weapon = new SpaceLaser();
           specialWeapons.add(new SonarPulse());
           specialWeapons.add(new SonarPulse());
       }

       for(SpecialWeapon specialWeapon : specialWeapons){
           if(specialWeapon.getName().equals(inCoordinate)){
               System.out.println("Sonar Pulse: ");
               System.out.println(strikeResult);
               specialWeapons.remove(specialWeapon);
               return 0;
           }
       }
        targetBoard.fireUpon(inCoordinate, strikeResult);
        return 0;
   }


    /*
    DESCRIPTION:
        The render method called upon by the player displays both boards of the
        player. In effect, this method calls upon the render methods of both the
        primary and target boards.

    INPUT:
        N/A

    OUTPUT:
        returns 0 for passing
    */
    public int render() {
        // print primary board
        System.out.println("Primary Board:");
        primaryBoard.renderBoard();

        // print target board
        System.out.println("Target Board:");
        targetBoard.renderBoard();

        return 0;
   }


    public PlayerBoard getPrimaryBoard() {
        return primaryBoard;
    }

    public TargetBoard getTargetBoard() {return targetBoard;}

    public void fireUponMany(String[] coords, String strikeResult){
        for (String c : coords){
            fireUpon(c, strikeResult);
        }
    }

   /*
   public String[][] receiveSonarPulse(String coordIn) {
        // initialize local DS
        //String[][] sonarOut = {{}};
        //String[][] sonarOut = {
        //       {"-1","-1","-1","-1","-1"},
        //       {"1","1","1","1","0"},
        //       {"0","0","0","0","0"},
        //       {"0","0","0","0","0"},
        //       {"0","0","0","0","0"}
        //};
        String[][] playerMatrix = primaryBoard.getMatrix();

        // init
        int sonarBoardSize =5;
        int[] index = primaryBoard.convertCoordToIndex(coordIn);
        int boardSize = primaryBoard.getBoardSize();
        System.out.println("index: " + Arrays.toString(index));



        Now:
        NOTE:  think about making a char array.
        1. loop through playerMatrix
        1.5 make 5x5 String[5][5]
        2. if off board: "-1" for that element
            2.1 - if  rowmin < row < rowmax || colmin < col < colmax
                   - use getBoardSize()
        3. elif -: "0"
            else: "1"
        4. return the new array


       String[][] outputArray = new String[sonarBoardSize][sonarBoardSize];
       String activeElement;
       int outRow = 0; // counter Row
       // assign half of the  output board size
       int sonarSizeHalf;
       if (sonarBoardSize % 2 == 0) {
           sonarSizeHalf = (sonarBoardSize / 2) - 1;
       } else {
           sonarSizeHalf = (sonarBoardSize / 2);
       }
       // loop over out array
       for (int row = (index[0]-sonarSizeHalf); row <= (index[0]+sonarSizeHalf); row++) {
           int outCol = 0; // counter Col
           for (int col = (index[1]-sonarSizeHalf); col <= (index[1]+sonarSizeHalf); col++) {

               // if on board
               if ( (0 <= row) && (row <= boardSize) && (0 <= col) && (col <= boardSize) ) {
                   activeElement = playerMatrix[row][col];
                   if (activeElement == "-") {
                       outputArray[outRow][outCol] = "0";
                   } else {
                       outputArray[outRow][outCol] = "1";
                   }
               } else { // if not board
                   outputArray[outRow][outCol] = "-1";
               }
               outCol++;
           }
           outRow++;
       }
       for (int row = 0; row < outputArray.length; row++) {
           for (int col = 0; col < outputArray[row].length; col++) {
               System.out.print(outputArray[row][col] + "\t");
           }
           System.out.println();
       }
        return outputArray;
   }
   */

    /*
    public int fireSonarPulse(String[][] resultIn) {
        System.out.println("Sonar Pulse: ");
        if (this.canUseSonarPulse && (numSonarPulse < 2)) {
            for (int row = 0; row < resultIn.length; row++) {
                for (int col = 0; col < resultIn[row].length; col++) {
                    System.out.print(resultIn[row][col] + "\t");
                }
                System.out.println();
            }
            numSonarPulse++; // increment counter
        } else {
            if (numSonarPulse < 2) {
                System.out.println("This play does not have the pulse unlocked");
                System.out.println("(Need to sinnk at least one ship first)");
            } else {
                System.out.println("This player ran out of attempts!");
            }
        }
        return 0;
    }
    */

    public int move(String move){
        String[][] currBoard = getPrimaryBoard().getMatrix();

        String[][] newBoard = new String[currBoard.length][currBoard.length];

        if(move.equals("N")){
            newBoard[0] = currBoard[0];

            for(int i = 1; i < currBoard.length; i++){
                for(int j = 0; j < currBoard.length; j++){
                    //System.out.println(newBoard[i-1][j]);
                    if(newBoard[i-1][j].equals("-") || newBoard[i-1][j].equals("o")){
                        newBoard[i-1][j] = currBoard[i][j];
                        newBoard[i][j] = "-";
                    }
                    else{
                        newBoard[i][j] = currBoard[i][j];
                    }
                }
            }
            moves.push("N");
        }
        else if(move.equals("S")){
            newBoard[currBoard.length-1] = currBoard[currBoard.length-1];

            for(int i = currBoard.length-2; i >= 0; i--){
                for(int j = 0; j < currBoard.length; j++){
                    if(newBoard[i+1][j].equals("-") || newBoard[i+1][j].equals("o")){
                        newBoard[i+1][j] = currBoard[i][j];
                        newBoard[i][j] = "-";
                    }
                    else{
                        newBoard[i][j] = currBoard[i][j];
                    }
                }
            }
            moves.push("S");
        }
        else if(move.equals("E")){
            for(int k = 0; k < currBoard.length; k++){
                newBoard[k][currBoard.length-1] = currBoard[k][currBoard.length-1];
            }
            for(int i = 0; i < currBoard.length; i++){
                for(int j = currBoard.length-2; j >= 0; j--){
                    if(newBoard[i][j+1].equals("-") || newBoard[i][j+1].equals("o")){
                        newBoard[i][j+1] = currBoard[i][j];
                        newBoard[i][j] = "-";
                    }
                    else{
                        newBoard[i][j] = currBoard[i][j];
                    }
                }
            }
            moves.push("E");
        }
        else if(move.equals("W")){
            for(int k = 0; k < currBoard.length; k++){
                newBoard[k][0] = currBoard[k][0];
            }
            for(int i = 0; i < currBoard.length; i++){
                for(int j = 1; j < currBoard.length; j++){
                    if(newBoard[i][j-1].equals("-") || newBoard[i][j-1].equals("o")){
                        newBoard[i][j-1] = currBoard[i][j];
                        newBoard[i][j] = "-";
                    }
                    else{
                        newBoard[i][j] = currBoard[i][j];
                    }
                }
            }
            moves.push("W");
        }
        else if(move.equals("undo")){
            String top = (String)moves.pop();
            String newMove = "";

            if(top.equals("N")){
                newMove = "S";
            }
            else if(top.equals("S")){
                newMove = "N";
            }
            else if(top.equals("E")){
                newMove = "W";
            }
            else{
                newMove = "E";
            }

            move(newMove);
            return 0;


        }

        primaryBoard.setBoard(newBoard);
        return 0;
    }
}
