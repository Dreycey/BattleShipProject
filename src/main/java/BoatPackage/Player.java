package BoatPackage;
import java.util.*;

public class Player {
    private PlayerBoard primaryBoard;
    private TargetBoard targetBoard;
    private List<Boat> fleet = new ArrayList<Boat>();

    // if no input, construct boats for a example
    public Player() {
        primaryBoard = new PlayerBoard();
        targetBoard = new TargetBoard();

        // Construct Boats
        Boat mineBoat = new Minesweeper();
        Boat DestBoat = new Destroyer();
        Boat BatBoat = new Battleship();

        // Define Boats
        mineBoat.setCoordinates(new String[]{"C3", "C4"});

        // add 3 default boats
        fleet.add(mineBoat);
        fleet.add(DestBoat);
        fleet.add(BatBoat);

        //add ships to primaryBoard
        for (int ind=0; ind < fleet.size(); ind++){
            Boat shipIter = fleet.get(ind);
            primaryBoard.placeShip(shipIter.getName(), shipIter.getCoordinates());
        }
    }

    // Constructor for Player class
    public Player(List<Boat> inputBoats) {
        primaryBoard = new PlayerBoard();
        targetBoard = new TargetBoard();
        fleet = inputBoats;
        //add ships to primaryBoard
        for (int ind=0; ind < fleet.size(); ind++){
            Boat shipIter = fleet.get(ind);
            primaryBoard.placeShip(shipIter.getName(), shipIter.getCoordinates());
        }
    }

    // returns the fleet at hand
    public List<Boat> getFleet() {
        return fleet;
    }

    public void setFleet(List<Boat> boatList) {
        this.fleet = boatList;
    }

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
            primaryBoard.placeShip(shipIter.getName(), shipIter.getCoordinates());
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
    public String receiveFire(String inCoordinate) {

        // initialize variables
        char typeOfHit = primaryBoard.receiveFire(inCoordinate);
        String hitOrSunk = "Hit";
        int indexToSink = -1;

        // If hit, remove from fleet and determine Hit, Sunk, or Surrender
        // Else, Miss
        if (typeOfHit == 'x'){ // IF HIT
            // go through boats in the fleet
            for (Boat b : fleet) {
                if (b.isCoordAfloat(inCoordinate)){
                    b.removeCoordinate(inCoordinate);
                    if (b.getStatus() == "Sunk") {
                        //"Afloat", "Hit", "Sunk"
                        indexToSink = fleet.indexOf(b);
                        hitOrSunk = "Sunk";
                    }
                }
            }
            // If sunk, remove that ship.
            if (hitOrSunk == "Sunk") {
                fleet.remove(indexToSink);
            }
            // Check if all boats are sunk. -> this is a surrender
            if (fleet.isEmpty()){
                return "Surrender";
            } else {
                return hitOrSunk;
            }

        } else{ // IF NOT HIT
            return "Miss";
        }
    }

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
}