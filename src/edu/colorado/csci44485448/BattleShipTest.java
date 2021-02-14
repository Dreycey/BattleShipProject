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

    @Test
    public void testGetSize() throws Exception{
        Assertions.assertEquals(4, boat.getSize());
    }

    @Test
    public void testRealignStatus() throws  Exception{
        String[] coords = {"A1","A2","A3","A4"};
        String[] hitCoords = {"A1","A2","A4"};
        String[] sunkCoords = {};
        String defaultStatus = "Afloat";

        boat.setCoordinates(coords);

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.removeCoordinate("A3");

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.removeCoordinate("A1");
        boat.removeCoordinate("A2");
        boat.removeCoordinate("A4");

        Assertions.assertEquals("Sunk", boat.getStatus());
    }
}