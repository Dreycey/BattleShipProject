package edu.colorado.csci44485448;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BoatTest {

    Boat boat = new Boat();

    @Test
    public void testGetStatus() throws Exception{
        String defaultStatus = "Afloat";
        Assertions.assertEquals(defaultStatus,boat.getStatus());
    }

    @Test
    public void testSetStatus() throws Exception{
        String defaultStatus = "Afloat";
        String badStatus = "BadStatus";

        boat.setStatus(badStatus);

        Assertions.assertEquals(defaultStatus, boat.getStatus());
    }

    @Test
    public void testGetCoords() throws Exception{
        String[] emptyCoords = {};
        Assertions.assertArrayEquals(emptyCoords,boat.getCoordinates());

    }

    @Test
    public void testSetCoords() throws Exception{
        String[] newCoords = {"A1","A2","A3"};

        boat.setCoordinates(newCoords);

        Assertions.assertArrayEquals(newCoords, boat.getCoordinates());
    }

    //what if there's a bad coordinate?
    //first need to have a way to test if an individual coordinate is valid
    @Test
    public void testValidCoord() throws Exception{
        String badCoord = "A30";
        String badCoordAgain = "Z1";

        Assertions.assertFalse(boat.isValidCoordinate(badCoord));
        Assertions.assertFalse(boat.isValidCoordinate(badCoordAgain));
    }
}