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
        String newStatus = "Hit";

        boat.setStatus(newStatus);

        Assertions.assertEquals(newStatus, boat.getStatus());
    }
}