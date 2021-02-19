

import BoatPackage.Example;

import static junit.framework.TestCase.*;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {

    Example personObjOne = new Example();

    // runs before the tests.
    @Before
    public void before() {
    }

    // Tests that returnTrue and returnFalse give back good feedback
    @Test
    public void isEmpty() {
        assertTrue(personObjOne.returnTrue());
        assertFalse(personObjOne.returnFalse());
    }

    // Test that input is correct as expected
    @Test
    public void testEquals() {
        assertEquals(45, personObjOne.returnsInput(45));
        assertEquals(-45, personObjOne.returnsInput(-45));
    }

//    // Testing the get method for retrieving value from a key
//    //@Test
//    //public String testNull() {
//    //    assertNull(personObjOne.returnNull());
//    //}
}
