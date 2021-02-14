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
        Assertions.assertEquals(emptyCoords,boat.getCoordinates());

    }
}