import BoatPackage.*;

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
        String[] newCoords = {"A1","A2","A3","A30"};
        String[] shouldBeCoords = {"A1","A2","A3"};

        boat.setCoordinates(newCoords);

        Assertions.assertArrayEquals(shouldBeCoords, boat.getCoordinates());
    }

    //what if there's a bad coordinate?
    //first need to have a way to test if an individual coordinate is valid
    @Test
    public void testValidCoord() throws Exception{
        String badCoord = "A30";
        String badCoordAgain = "Z1";

        Assertions.assertFalse(boat.isValidCoordinate(badCoord));
        Assertions.assertFalse(boat.isValidCoordinate(badCoordAgain));
        Assertions.assertTrue(boat.isValidCoordinate("A9"));
        Assertions.assertTrue(boat.isValidCoordinate("J10"));
    }

    @Test
    public void testIsCoordInList() throws Exception{
        String[] coords = {"A1","A2","A3"};
        boat.setCoordinates(coords);

        Assertions.assertTrue(boat.isCoordAfloat("A2"));
        Assertions.assertFalse(boat.isCoordAfloat("A4"));
    }

    @Test
    public void removeCoord() throws Exception{
        String[] coords = {"A1","A2","A3"};
        String[] postRemoval = {"A1","A3"};
        boat.setCoordinates(coords);

        boat.removeCoordinate("A2");

        Assertions.assertArrayEquals(postRemoval,boat.getCoordinates());

        boat.removeCoordinate("J9");

        Assertions.assertArrayEquals(postRemoval,boat.getCoordinates());
    }

    @Test
    public void testCabin() throws Exception{
        boat.setCaptainsCabin("armored","A3");

        String location = "A3";

        Assertions.assertEquals(location, boat.getCaptainsCabin().getLoc());

        String newLoc = "A4";
        boat.getCaptainsCabin().setLoc(newLoc);

        Assertions.assertEquals(newLoc, boat.getCaptainsCabin().getLoc());

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        boat.getCaptainsCabin().setHitStatus(true);

        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());
    }

}