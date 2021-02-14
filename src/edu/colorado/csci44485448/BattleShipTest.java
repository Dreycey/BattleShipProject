package edu.colorado.csci44485448;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BattleShipTest {

    BattleShip boat = new BattleShip();

    @Test
    public void testInheritedWorks() throws Exception{
        String[] coords = {"A1","A2","A3"};
        String defaultStatus = "Afloat";

        boat.setCoordinates(coords);

        Assertions.assertArrayEquals(coords, boat.getCoordinates());
        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.removeCoordinate("Z3");

        Assertions.assertArrayEquals(coords, boat.getCoordinates());

        boat.removeCoordinate("A3");

        String[] shouldBe = {"A1","A2"};

        Assertions.assertArrayEquals(shouldBe, boat.getCoordinates());

    }

    @Test
    public void testGetName() throws Exception{
        String name = "BattleShip";

        Assertions.assertEquals(name, boat.getName());
    }
}