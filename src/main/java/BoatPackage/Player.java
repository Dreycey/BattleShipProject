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
    */
    public List<String> placeShip(List<String> boatlist) { // assumes array type
        List<String> outputTestArray = new ArrayList<>();
        for (int ind=0; ind < boatlist.size(); ind++){
            System.out.println(boatlist.get(ind));
            outputTestArray.add(boatlist.get(ind) + "C");
        }
        return outputTestArray;
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
    //public boolean receiveFire(int[] inCoordinate) {
    //    return input;
   // }

    /*


    INPUT:

    OUTPUT:

    */
   //public boolean fireUpon() {
    //    return true;
   // }

    /*


    INPUT:

    OUTPUT:

    */
    //public boolean render() {
      //  return false;
   // }
}