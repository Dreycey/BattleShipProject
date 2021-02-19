package BoatPackage;


public class Player {
    public int age = 28;
    private primaryBoard primaryB; //TODO: ensure this is right class
    private targetBoard targetB; //TODO: ensure this is right class

    // Constructor for Player class
    public Player() {
        primaryB = new primaryBoard();
        targetB = new targetBoard();
    }

    // example return tests
    public int returnAge() {
        return this.age;
    }

    public int returnAge2() {
        return 29;
    }

    /*
    This method places a ship on the board and sends
    the coordinates back to the primary board.
    */
    public int[] placeShip() {

        return new int[]{0, 1};
    }

    /*
    The input for this method is a coordinate where
    a hit is sent. It then updates the fleet, and
    lastly, it returns a True if hit or False if not.

    INPUT:
        int[] inCoordinate

    OUTPUT:
        boolean <True, False>,
        Boat.name
    */
    public boolean receiveFire(int[] inCoordinate) {
        return input;
    }

    /*


    INPUT:

    OUTPUT:

    */
   public boolean fireUpon() {
        return true;
    }

    /*


    INPUT:

    OUTPUT:

    */
    public boolean render() {
        return false;
    }
}