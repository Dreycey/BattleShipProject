import BoatPackage.*;

//Junit imports
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import sun.security.krb5.internal.crypto.Des;

public class PlayerTest {

    // Instantiate Player
    //set up boats
    String[] bCoords = {"A1","A2","A3","A4"};
    String[] dCoords = {"B1","B2","B3"};
    String[] mCoords = {"C1","C2"};

    Battleship battleship = new Battleship();
    Destroyer destroyer = new Destroyer();
    Minesweeper minesweeper = new Minesweeper();

    List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
    String[] starts = {"A1","B1","C1"};
    char[] directions = {'e','e','e'};

    //construct player
    Player playerObjOne = new Player(fleet, starts, directions);

    @BeforeEach
    public void testNonDefault() {
        List<Boat> bList = new ArrayList<Boat>();
        String[] starts = {"A1","B1"};
        char[] directions = {'e','e'};
        bList.add(new Destroyer());
        bList.add(new Destroyer());
        Player pNonDefault = new Player(bList, starts, directions);

        String boatNames[] = {"Destroyer", "Destroyer"};
        String actualNames[] = {pNonDefault.getFleet().get(0).getName(), pNonDefault.getFleet().get(1).getName()};
        Assertions.assertArrayEquals(boatNames, actualNames);
    }

    // text placeShip
    @Test
    public void placeShipTest() {
        // need the primary boat class for ultimate test
        // for now test
        Boat boat1 = new Minesweeper();
        Boat boat2 = new Destroyer();
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);
        boatsList.add(boat2);
        Assertions.assertEquals(boatsList, playerObjOne.placeShip(boatsList));
    }

    @Test
    public void fleetIsEmpty() {
        Player pEmpty = new Player();
        pEmpty.setFleet(new ArrayList<Boat>());
        Assertions.assertEquals(false, playerObjOne.fleetIsEmpty());
        Assertions.assertEquals(true, pEmpty.fleetIsEmpty());
    }

    // test revieveFire
    @Test
    public void receiveFireTest() {
        // Instantiate Player
        Bomb weapon = new Bomb();
        //set up boats
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Minesweeper minesweeper = new Minesweeper();
        Destroyer destroyer = new Destroyer();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(minesweeper, destroyer));
        String[] starts = {"B1","C1"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        // need the primary boat class for ultimate test
        // for now return True
        //TODO: Add surrender
        Assertions.assertEquals("Miss", playerObjOne.receiveFire("A5",weapon));
        Assertions.assertEquals("Hit", playerObjOne.receiveFire("B2",weapon));
        Assertions.assertEquals("Sunk Minesweeper", playerObjOne.receiveFire("B1",weapon));

        Minesweeper minesweeper2 = new Minesweeper();

        List<Boat> fleet2 = new LinkedList<Boat>(Arrays.asList(minesweeper2));
        String[] starts2 = {"B1"};
        char[] directions2 = {'e'};

        //construct player
        Player playerObjOne2 = new Player(fleet2, starts2, directions2);

        // need the primary boat class for ultimate test
        // for now return True
        //TODO: Add surrender
        Assertions.assertEquals("Miss", playerObjOne2.receiveFire("A5",weapon));
        Assertions.assertEquals("Hit", playerObjOne2.receiveFire("B2",weapon));
        Assertions.assertEquals("Surrender", playerObjOne2.receiveFire("B1",weapon));

    }

    // test fireUpon
    @Test
    public void fireUponTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(0, playerObjOne.fireUpon("C3", "hit"));
    }

    // test render
    @Test
    public void renderTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Boat boat1 = new Minesweeper();
        Boat boat2 = new Destroyer();
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);
        boatsList.add(boat2);
        playerObjOne.placeShip(boatsList);
        playerObjOne.fireUpon("C3", "hit");
        Assertions.assertEquals(0, playerObjOne.render());
    }

    @Test
    public void boatArrayTest() {
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(3, playerObjOne.getFleet().size());
    }

    @Test
    public void testReceiveFireUnarmored() throws Exception{
        //set up boats
        Bomb weapon = new Bomb();
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player player = new Player(fleet, starts, directions);

        //hit unarmored captains cabin
        String result = player.receiveFire("C1",weapon);

        //did method return sunk?
        Assertions.assertEquals("Sunk Minesweeper", result);

        //is the unarmored boat out of the fleet?
        Assertions.assertFalse(player.getFleet().contains(minesweeper));
        Assertions.assertTrue(player.getFleet().contains(battleship));

        //is the player board correct?
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("C1"));
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("C2"));
    }

    @Test
    public void testReceiveFireArmoredFirst() throws Exception{
        Bomb weapon = new Bomb();
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player player = new Player(fleet, starts, directions);

        //hit armored captains cabin
        String result = player.receiveFire("A3",weapon);

        //did method return sunk?
        Assertions.assertEquals("Miss", result);

        //is the armored boat still in the fleet?
        Assertions.assertTrue(player.getFleet().contains(battleship));

        //is the player board correct?
        Assertions.assertEquals("B2", player.getPrimaryBoard().valueAt("A3"));
    }

    @Test
    public void testReceiveFireArmoredSecond() throws Exception{
        Bomb weapon = new Bomb();
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet, starts, directions);

        //hit armored captains cabin
        String result = player.receiveFire("A2",weapon);

        Assertions.assertEquals("Hit", result);

        result = player.receiveFire("A3",weapon);

        Assertions.assertEquals("Miss", result);

        //hit second time
        result = player.receiveFire("A3",weapon);

        //did method return sunk?
        Assertions.assertEquals("Sunk Battleship", result);

        //is the unarmored boat out of the fleet?
        Assertions.assertFalse(player.getFleet().contains(battleship));

        //is the player board correct?
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("A1"));
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("A2"));
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("A3"));
        Assertions.assertEquals("x", player.getPrimaryBoard().valueAt("A4"));
    }

    @Test
    public void testFireUponMany() throws Exception{
        //set up boats
        String[] bCoords = {"A1","A2","A3","A4"};
        String[] dCoords = {"B1","B2","B3"};
        String[] mCoords = {"C1","C2"};

        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        Player player = new Player(fleet, starts, directions);

        String[] fires = {"A3","A4","A6"};

        player.fireUponMany(fires, "Sunk A3 A4 A6");

        Assertions.assertEquals("x", player.getTargetBoard().valueAt("A3"));
        Assertions.assertEquals("x", player.getTargetBoard().valueAt("A4"));
        Assertions.assertEquals("x", player.getTargetBoard().valueAt("A6"));
    }

    @Test
    public void testFireSonarPulse() throws  Exception {

        // expected input
        String[][] sonarInExpected = {
                {"-1","-1","-1","-1","-1"},
                {"1","1","1","1","0"},
                {"0","0","0","0","0"},
                {"0","0","1","1","0"},
                {"0","0","0","0","0"}
        };

        // testing
        Boat boat1 = new Destroyer();
        Boat boat2 = new Minesweeper();
        List<Boat> boatsList = new ArrayList<>();
        boatsList.add(boat1);

        // testing the receiveFire method
        playerObjOne.placeShip(boatsList);
        // check that it runs - actually a void but use 0 for passing
        //Assertions.assertEquals(0, playerObjOne.fireSonarPulse(sonarInExpected));

    }

    //test receiveFire with sonar pulse
    @Test
    public void testReceiveSonarPulse() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        String[] s = {"A1","C2","D1"};
        char[] d = {'e','e','e'};
        Player player = new Player(fleet, s, d);


        String[][] expected = {{"0","0","0","0","0"},
                               {"0","1","1","1","0"},
                               {"1","1","0","0","0"},
                               {"0","0","0","0","0"},
                               {"0","0","0","0","0"}};

        SonarPulse pulse = new SonarPulse();

        Assertions.assertEquals(Arrays.deepToString(expected),player.receiveFire("D3",pulse));
    }

    //test receiveFire for ship sinking
    @Test
    public void testReceiveFireSink() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.setCabinIndex(-1);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        String[] s = {"A1","C2","D1"};
        char[] d = {'e','e','e'};
        Player player = new Player(fleet, s, d);

        SpaceLaser laser = new SpaceLaser();

        Assertions.assertEquals("Hit",player.receiveFire("D1",laser));
        Assertions.assertEquals("Sunk Minesweeper",player.receiveFire("D2",laser));
    }

    //test receiveFire for surrender
    @Test
    public void testReceiveFireSurrender() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.setCabinIndex(-1);

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        String[] s = {"A1","C2","D1"};
        char[] d = {'e','e','e'};
        Player player = new Player(fleet, s, d);

        SpaceLaser laser = new SpaceLaser();

        Assertions.assertEquals("Miss",player.receiveFire("A3",laser));
        Assertions.assertEquals("Sunk Battleship",player.receiveFire("A3",laser));
        Assertions.assertEquals("Miss",player.receiveFire("C3",laser));
        Assertions.assertEquals("Sunk Destroyer",player.receiveFire("C3",laser));
        Assertions.assertEquals("Hit",player.receiveFire("D1",laser));
        Assertions.assertEquals("Surrender",player.receiveFire("D2",laser));
    }

    //test fireupon for sonar
    @Test
    public void testFireUponSonar() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));

        //construct player
        String[] s = {"A1","C2","D1"};
        char[] d = {'e','e','e'};
        Player player = new Player(fleet, s, d);

        //confirm weapon name is bomb
        Assertions.assertTrue(player.getWeapon() instanceof Bomb);
        //confirm length of special weapons is 0
        Assertions.assertEquals(0, player.getSpecialWeapons().size());

        //sink a ship
        Assertions.assertEquals(0, player.fireUpon("B5","Sunk Minesweeper"));

        //confirm weapon is space laser
        Assertions.assertTrue(player.getWeapon() instanceof SpaceLaser);
        //confirm length of special weapons is 2
        Assertions.assertEquals(2, player.getSpecialWeapons().size());

        //fireupon with sonar
        Assertions.assertEquals(0, player.fireUpon("SonarPulse","results of pulse"));

        //make sure length is now 1
        Assertions.assertEquals(1, player.getSpecialWeapons().size());
    }

    @Test
    public void playerTestMoveNorth() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B1","C1"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        String[][] currentBoard = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                {"M0", "M1","-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        String[][] shouldBe = {
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                { "M0", "M1", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-","-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        playerObjOne.move("N");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        Assertions.assertArrayEquals(shouldBe,playerObjOne.getPrimaryBoard().getMatrix());
    }

    @Test
    public void playerTestMoveSouth() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B1","C1"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        String[][] currentBoard = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                {"M0", "M1","-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        String[][] shouldBe = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"D0", "D1","D2", "-", "-", "-", "-", "-", "-", "-"},
                { "M0", "M1", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        playerObjOne.move("S");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        Assertions.assertArrayEquals(shouldBe,playerObjOne.getPrimaryBoard().getMatrix());
    }

    @Test
    public void playerTestMoveEast() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B1","C1"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        String[][] currentBoard = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                {"M0", "M1","-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        String[][] shouldBe = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "D0", "D1", "D2", "-", "-", "-", "-", "-", "-"},
                {"-", "M0","M1", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        playerObjOne.move("E");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        Assertions.assertArrayEquals(shouldBe,playerObjOne.getPrimaryBoard().getMatrix());
    }

    @Test
    public void playerTestMoveWest() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B2","C2"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        String[][] currentBoard = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "D0", "D1", "D2", "-", "-", "-", "-", "-", "-"},
                {"-", "M0","M1", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        String[][] shouldBe = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                {"M0","M1", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        playerObjOne.move("W");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        Assertions.assertArrayEquals(shouldBe,playerObjOne.getPrimaryBoard().getMatrix());
    }

    @Test
    public void playerTestKeepMoves() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B2","C2"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        playerObjOne.move("N");
        playerObjOne.move("E");
        playerObjOne.move("S");

        Stack moves = playerObjOne.getMoves();

        Assertions.assertEquals("S", moves.pop());
        Assertions.assertEquals("E", moves.pop());
        Assertions.assertEquals("N", moves.pop());

    }

    @Test
    public void playerTestUndo() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B2","C2"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        String[][] currentBoard = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "D0", "D1", "D2", "-", "-", "-", "-", "-", "-"},
                {"-", "M0","M1", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        String[][] shouldBe = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "D0", "D1", "D2", "-", "-", "-", "-", "-", "-", "-"},
                {"M0","M1", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        playerObjOne.move("W");
        playerObjOne.move("undo");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        Assertions.assertArrayEquals(currentBoard,playerObjOne.getPrimaryBoard().getMatrix());
    }

    @Test
    public void playerTestKeepUndos() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B2","C2"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        playerObjOne.move("N");
        playerObjOne.move("E");
        playerObjOne.move("S");
/*
        Stack check = playerObjOne.getMoves();

        System.out.println(check.pop());
        System.out.println(check.pop());
        System.out.println(check.pop());
*/
        playerObjOne.move("undo");
        playerObjOne.move("undo");
        playerObjOne.move("undo");

        Stack moves = playerObjOne.getRedos();

        Assertions.assertEquals("N", moves.pop());
        Assertions.assertEquals("E", moves.pop());
        Assertions.assertEquals("S", moves.pop());

    }

    @Test
    public void playerTestRedo() throws Exception{
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"B2","C2"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        playerObjOne.move("N");
        playerObjOne.move("E");
        playerObjOne.move("S");
        playerObjOne.move("W");
/*
        Stack check = playerObjOne.getMoves();

        System.out.println(check.pop());
        System.out.println(check.pop());
        System.out.println(check.pop());
*/
        playerObjOne.move("undo");
        playerObjOne.move("undo");
        playerObjOne.move("undo");
        playerObjOne.move("undo");

        playerObjOne.move("redo");
        playerObjOne.move("redo");
        playerObjOne.move("redo");
        playerObjOne.move("redo");

        String[][] shouldBe = {
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "D0", "D1", "D2", "-", "-", "-", "-", "-", "-"},
                {"-","M0", "M1", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        Assertions.assertArrayEquals(shouldBe,playerObjOne.getPrimaryBoard().getMatrix());

    }

    @Test
    public void playerTestCantMoveN() throws Exception{
        Destroyer destroyer = new Destroyer();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer));
        String[] starts = {"A2"};
        char[] directions = {'e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        playerObjOne.move("N");

        playerObjOne.getMoves().push("S");

        playerObjOne.move("undo");

    }

    @Test
    public void playerTestCantMoveS() throws Exception{
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"I1","J1"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        playerObjOne.move("S");

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        playerObjOne.getMoves().push("N");

        playerObjOne.move("undo");

    }

    @Test
    public  void playerTestBadMove() throws Exception{
        Destroyer destroyer = new Destroyer();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer));
        String[] starts = {"J1"};
        char[] directions = {'e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        Assertions.assertEquals(0, playerObjOne.move("oogabooga"));
    }

    @Test
    public void playerTestCantMoveW() throws Exception{
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"A1","A4"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        playerObjOne.move("W");

        playerObjOne.getMoves().push("E");

        playerObjOne.move("undo");
    }

    @Test
    public void playerTestCantMoveE() throws Exception{
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(destroyer, minesweeper));
        String[] starts = {"A6","A9"};
        char[] directions = {'e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

        //System.out.println(Arrays.deepToString(playerObjOne.getPrimaryBoard().getMatrix()));

        playerObjOne.move("E");

        playerObjOne.getMoves().push("W");

        playerObjOne.move("undo");
    }
}
