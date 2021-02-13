package test.collective;
import io.collective.Example; //Make sure to open the java class

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

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

    // Testing the get method for retrieving value from a key
    @Test
    public String testNull() {
        assertNull(personObjOne.returnNull());
    }
}
