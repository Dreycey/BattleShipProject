package edu.colorado.csci44485448;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BoatTest {
    @Test
    public void testCreation() throws Exception{
        Boat b = new Boat();
    }

    @Test
    public void testGetStatus() throws Exception{
        Boat b = new Boat();
        String defaultStatus = "Afloat";
        Assertions.assertEquals(defaultStatus,b.getStatus());
    }
}