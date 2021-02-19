package BoatPackage;
import java.util.*;

import java.sql.SQLOutput;

public class Player {
    public int age = 28;
    //private primaryBoard primaryB; //TODO: ensure this is right class
    //private targetBoard targetB; //TODO: ensure this is right class

    // Constructor for Player class
    public Player() {
      //  primaryB = new primaryBoard();
      //  targetB = new targetBoard();
    }

    // example return tests
    public int returnAge() {
        return this.age;
    }

    public int returnAge2() {
        return 29;
    }



    ///////////////
    //
    //
    //   CODE BELOW
    //
    //
    ///////////////


    /*
    This method places a ship on the board and sends
    the coordinates back to the primary board.

    INPUT:
        Array[] boatlist

    OUTPUT:
        Current: array of list with "C" added to each item
        Eventual: add Object Boat
    */
    public List<String> placeShip(List<String> boatlist) { // assumes array type
        List<String> outputTestArray = new ArrayList<>();
        for (int ind=0; ind < boatlist.size(); ind++){
            System.out.println(boatlist.get(ind));
            outputTestArray.add(boatlist.get(ind) + "C");
            // primaryB.addShip(boatlist.get(ind)) //TODO: Make sure this works.
        }
        return outputTestArray;
    }


    /*
    The input for this method is a coordinate where
    a hit is sent. It then updates the fleet, and
    lastly, it returns a True if hit or False if not.

    INPUT:
        String inCoordinate

    OUTPUT:
        boolean <True, False>,
        Boat.name <- NOT YET
    */
    public boolean receiveFire(String inCoordinate) {
        // TODO: Find out whether or not it was a hit
        //typeOfHit = primaryB.receiveFire(inCoordinate);
        String typeOfHit = "hit";

        //check if typeOfHit is a hit
        //List<String> arr = new ArrayList<String>("hit","miss");
        if (typeOfHit == "hit"){
            return true;
        } else{
            return false;
        }

        /*
        TODO:
            supposed to find out which ship was hit, if there was a hit.
            One way to do this could be to find out the ship from the
            primaryB object using the method latifa described.
         */

    }

    /*
    DESCRIPTION:
        This method updates the target board for a player, based on the result
        from the inital offensive. The Game Manager will call this method and
        update the target board for the player on offense.

    INPUT:
        String inCoordinate, String strikeResult

    OUTPUT:
        return 0 for passing
    */
   public int fireUpon(String inCoordinate, String strikeResult) {
        //targetB.fireUpon(inCoordinate, strikeResult);
        return 0;
   }

    /*


    INPUT:

    OUTPUT:

    */
    //public boolean render() {
      //  return false;
   // }
}