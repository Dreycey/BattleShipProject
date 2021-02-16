package test.BoatPackage;

import BoatPackage.Person;
//Junit imports
import static junit.framework.TestCase.*;
import org.junit.Before;
import org.junit.Test;


public class PersonTest {
    Person personObjOne = new Person();

    @Before
    public void before() {
    }

    //ensure they are 28
    @Test
    public void assertAge() {
        assertEquals(28, personObjOne.returnAge());
    }

    // return boats
    @Test
    public void returnBoatsTest() {
        assertEquals(29, personObjOne.returnAge2());
    }
    // return boats
    @Test
    public void returBoatsTest() {
        assertEquals(29, personObjOne.returnAge2());
    }
}
