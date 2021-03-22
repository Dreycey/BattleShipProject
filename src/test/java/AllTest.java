import BoatPackage.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class AllTest {

    //Boat
    @Test
    public void BoattestSetName() throws Exception {
        Boat boat = new Boat();
        String name = "Destroyer";
        boat.setName(name);
        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void BoattestSetStatus() throws Exception{
        Boat boat = new Boat();
        String defaultStatus = "Afloat";
        String badStatus = "BadStatus";

        boat.setStatus(badStatus);
        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus(defaultStatus);
        Assertions.assertEquals(defaultStatus, boat.getStatus());
    }

    @Test
    public void BoattestSetSize() throws Exception{
        Boat boat = new Boat();
        boat.setSize(5);
        Assertions.assertEquals(5, boat.getSize());
    }

    @Test
    public void BoattestCabin() throws Exception{
        Boat boat = new Boat();
        boat.setCaptainsCabin("armored");

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        boat.getCaptainsCabin().setHitStatus(true);

        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());
    }

    @Test
    public void BoattestCabinIndex() throws Exception{
        Boat boat = new Boat();
        boat.setCabinIndex(2);

        Assertions.assertEquals(2, boat.getCabinIndex());
    }

    @Test
    public void BoattestCabinHits() throws Exception{
        Boat boat = new Boat();
        boat.setCaptainsCabin("armored");

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());

        boat.setCaptainsCabin("unarmored");
        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void BoattestHitsRemaining() throws Exception{
        Boat boat = new Boat();
        boat.setSize(5);
        Assertions.assertEquals(5, boat.getHitsRemaining());
    }

    @Test
    public void BoattestHit() throws Exception{
        Boat boat = new Boat();

        boat.setSize(3);
        boat.setCabinIndex(1);
        boat.setName("Destroyer");

        Assertions.assertEquals("Afloat", boat.getStatus());

        boat.hit();

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.hit();

        Assertions.assertEquals("Hit", boat.getStatus());

        boat.hit();

        Assertions.assertEquals("Sunk", boat.getStatus());
    }

    //Battleship
    @Test
    public void battleshipTestInheritedWorks() throws Exception{
        Battleship boat = new Battleship();
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

    }


    @Test
    public void battleshipTestGetSize() throws Exception{
        Battleship boat = new Battleship();
        Assertions.assertEquals(4, boat.getSize());
    }

    @Test
    public void battleshipTestCabin() throws Exception{

        Battleship boat = new Battleship();

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());
        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void battleshipTestGenLocs() throws Exception{

        Battleship boat = new Battleship();

        int[][] south = {{0,0},{1,0},{2,0},{3,0}};
        int[][] north = {{0,0},{-1,0},{-2,0},{-3,0}};
        int[][] east = {{0,0},{0,1},{0,2},{0,3}};
        int[][] west = {{0,0},{0,-1},{0,-2},{0,-3}};

        Assertions.assertArrayEquals(south, boat.genLocs('s'));
        Assertions.assertArrayEquals(north, boat.genLocs('n'));
        Assertions.assertArrayEquals(east, boat.genLocs('e'));
        Assertions.assertArrayEquals(west, boat.genLocs('w'));

    }

    //Destroyer
    @Test
    public void destroyerTestInheritedWorks() throws Exception{
        Destroyer boat = new Destroyer();
        String[] coords = {"A1","A2","A3"};
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());

    }

    @Test
    public void destroyerTestGetName() throws Exception{
        Destroyer boat = new Destroyer();
        String name = "Destroyer";

        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void destroyerTestCabin() throws Exception{
        String[] coords = {"A1","A2","A3"};

        Destroyer boat = new Destroyer();

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Miss", boat.getCaptainsCabin().hit());
        Assertions.assertTrue(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void destroyerTestGenLocs() throws Exception{

        Destroyer boat = new Destroyer();

        int[][] south = {{0,0},{1,0},{2,0}};
        int[][] north = {{0,0},{-1,0},{-2,0}};
        int[][] east = {{0,0},{0,1},{0,2}};
        int[][] west = {{0,0},{0,-1},{0,-2}};

        Assertions.assertArrayEquals(south, boat.genLocs('s'));
        Assertions.assertArrayEquals(north, boat.genLocs('n'));
        Assertions.assertArrayEquals(east, boat.genLocs('e'));
        Assertions.assertArrayEquals(west, boat.genLocs('w'));

    }

    //Minesweeper
    @Test
    public void minesweeperTestInheritedWorks() throws Exception{
        Minesweeper boat = new Minesweeper();
        String[] coords = {"A1","A2"};
        String defaultStatus = "Afloat";

        Assertions.assertEquals(defaultStatus, boat.getStatus());

        boat.setStatus("Hit");

        Assertions.assertEquals("Hit", boat.getStatus());
    }

    @Test
    public void minesweeperTestGetName() throws Exception{
        Minesweeper boat = new Minesweeper();
        String name = "Minesweeper";

        Assertions.assertEquals(name, boat.getName());
    }

    @Test
    public void minesweeperTestGetSize() throws Exception{
        Minesweeper boat = new Minesweeper();
        Assertions.assertEquals(2, boat.getSize());
    }


    @Test
    public void minesweeperTestCabin() throws Exception{
        String[] coords = {"A1","A2"};

        Minesweeper boat = new Minesweeper();

        Assertions.assertFalse(boat.getCaptainsCabin().getHitStatus());

        Assertions.assertEquals("Sunk", boat.getCaptainsCabin().hit());
    }

    @Test
    public void minesweeperTestGenLocs() throws Exception{

        Minesweeper boat = new Minesweeper();

        int[][] south = {{0,0},{1,0}};
        int[][] north = {{0,0},{-1,0}};
        int[][] east = {{0,0},{0,1}};
        int[][] west = {{0,0},{0,-1}};

        Assertions.assertArrayEquals(south, boat.genLocs('s'));
        Assertions.assertArrayEquals(north, boat.genLocs('n'));
        Assertions.assertArrayEquals(east, boat.genLocs('e'));
        Assertions.assertArrayEquals(west, boat.genLocs('w'));

    }

    //Submarine
    @Test
    public void subTestChangeSubmerged() {
        Submarine sub = new Submarine();
        boolean expected = false;
        sub.changeSubmerged();
        boolean actual = sub.getIsSubmerged();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void subTestGetters() {
        Submarine sub = new Submarine();
        // test default status
        boolean expected = true;
        boolean actual = sub.getIsSubmerged();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void subTestGenLocs() {
        Submarine sub = new Submarine();
        int[][] south = {{0,0},{1,0},{2,0},{3,0},{2,-1}};
        int[][] north = {{0,0},{-1,0},{-2,0},{-3,0},{-2,-1}};
        int[][] east = {{0,0},{0,1},{0,2},{0,3},{-1,2}};
        int[][] west = {{0,0},{0,-1},{0,-2},{0,-3},{-1,-2}};

        Assertions.assertArrayEquals(south, sub.genLocs('s'));
        Assertions.assertArrayEquals(north, sub.genLocs('n'));
        Assertions.assertArrayEquals(east, sub.genLocs('e'));
        Assertions.assertArrayEquals(west, sub.genLocs('w'));

        Assertions.assertEquals(null, sub.genLocs('k'));
    }

    //captainsCabinType
    @Test
    public void cabinTypeTestConstructor() throws Exception{
        captainsCabinType type = new captainsCabinType();
    }

    @Test
    public void cabinTypeTestGetAlready() throws Exception{
        captainsCabinType type = new captainsCabinType();

        Assertions.assertFalse(type.getHitStatus());
    }

    @Test
    public void cabinTypeTestSetAlready() throws Exception{
        captainsCabinType type = new captainsCabinType();

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void cabinTypeTestHit() throws Exception{
        captainsCabinType type = new captainsCabinType();

        Assertions.assertEquals(null, type.hit());
    }

    //armoredCaptainsCabin
    @Test
    public void armoredCabinTestConstructor() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();
    }

    @Test
    public void armoredCabinTestGettersAndSetters() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void armoredCabinTestHit() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertEquals("Miss", type.hit());
    }

    @Test
    public void armoredCabinTestHitTwice() throws Exception{
        captainsCabinType type = new armoredCaptainsCabin();

        Assertions.assertEquals("Miss", type.hit());
        Assertions.assertEquals("Sunk", type.hit());
    }

    //unarmoredCaptainsCabin
    @Test
    public void unarmoredCabinTestConstructor() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();
    }

    @Test
    public void unarmoredCabinTestGettersAndSetters() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();

        Assertions.assertFalse(type.getHitStatus());

        type.setHitStatus(true);

        Assertions.assertTrue(type.getHitStatus());
    }

    @Test
    public void unarmoredCabinTestHit() throws Exception{
        captainsCabinType type = new unarmoredCaptainsCabin();

        Assertions.assertEquals("Sunk", type.hit());
    }

    //Bomb
    @Test
    public void bombTestGetters() throws Exception{
        Bomb bomb = new Bomb();
        Assertions.assertEquals("Bomb",bomb.getName());
        Assertions.assertEquals("Weapon",bomb.getType());
    }

    @Test
    public void bombTestMiss() throws Exception{
        Bomb bomb = new Bomb();
        //given empty cell (-), it should return 'o'
        String curr = "-";

        String result = bomb.hit(curr);

        Assertions.assertEquals("o",result);
    }

    @Test
    public void bombTestHit() throws Exception{
        Bomb bomb = new Bomb();
        //given a boat, should return 'x'
        String curr = "M0";
        String curr1 = "D1";
        String curr2 = "B2";
        String curr3 = "S3";

        Assertions.assertEquals("x",bomb.hit(curr));
        Assertions.assertEquals("x",bomb.hit(curr1));
        Assertions.assertEquals("x",bomb.hit(curr2));
        Assertions.assertEquals("x",bomb.hit(curr3));
    }

    @Test
    public void bombTestSubHit() throws Exception{
        Bomb bomb = new Bomb();
        //sub underwater can't be hit! - underwater signified by lowercase S

        String curr = "s0";

        Assertions.assertEquals("o",bomb.hit(curr));
    }

    @Test
    public void bombTestSubHitUnderBoat() throws  Exception{
        Bomb bomb = new Bomb();
        //sub under a boat should hit boat, but not sub

        String curr = "B2&s1";

        Assertions.assertEquals("x&s1",bomb.hit(curr));
    }

    //SonarPulse
    @Test
    public void pulseTestGetters() throws Exception{
        SonarPulse sonarPulse = new SonarPulse();
        Assertions.assertEquals("SonarPulse",sonarPulse.getName());
        Assertions.assertEquals("SpecialWeapon",sonarPulse.getType());
    }

    @Test
    public void pulseTestMiss() throws Exception{
        SonarPulse sonarPulse = new SonarPulse();
        //given empty cell (-), it should return '0'
        String[][] curr = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"0","0","0"},{"0","0","0"},{"0","0","0"}};

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void pulseTestHit() throws Exception{
        SonarPulse sonarPulse = new SonarPulse();
        String[][] curr = {{"","",""},{"M0","M1","-"},{"-","B0","x"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"-1","-1","-1"},{"1","1","0"},{"0","1","1"}};

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void pulseTestSub() throws Exception{
        SonarPulse sonarPulse = new SonarPulse();
        String[][] curr = {{"s0","s1","s2"},{"S0","S1","S2"},{"M0&s0","M1&s1","s2"}};

        String[][] result = sonarPulse.hit(curr);

        String[][] expected = {{"1","1","1"},{"1","1","1"},{"1","1","1"}};

        Assertions.assertArrayEquals(expected,result);
    }

    //SpaceLaser
    @Test
    public void laserTestGetters() throws Exception{
        SpaceLaser laser = new SpaceLaser();
        Assertions.assertEquals("SpaceLaser",laser.getName());
        Assertions.assertEquals("Weapon",laser.getType());
    }

    @Test
    public void laserTestMiss() throws Exception{
        SpaceLaser laser = new SpaceLaser();
        //given empty cell (-), it should return 'o'
        String result = laser.hit("-");

        Assertions.assertEquals("o",result);
    }

    @Test
    public void laserTestHit() throws Exception{
        SpaceLaser laser = new SpaceLaser();
        //given a boat, should return 'x'
        String curr = "M0";
        String curr1 = "D1";
        String curr2 = "B2";
        String curr3 = "S3";

        Assertions.assertEquals("x",laser.hit(curr));
        Assertions.assertEquals("x",laser.hit(curr1));
        Assertions.assertEquals("x",laser.hit(curr2));
        Assertions.assertEquals("x",laser.hit(curr3));
    }

    @Test
    public void laserTestSubHit() throws Exception{
        SpaceLaser laser = new SpaceLaser();
        //sub underwater can't be hit! - underwater signified by lowercase S

        String curr = "s0";

        Assertions.assertEquals("x",laser.hit(curr));
    }

    @Test
    public void laserTestSubHitUnderBoat() throws  Exception{
        SpaceLaser laser = new SpaceLaser();
        //sub under a boat should hit boat, but not sub

        String curr = "B2&s1";

        Assertions.assertEquals("x",laser.hit(curr));
    }

    //GameBoard
    @Test
    public void gameboardTestBoardSize() {
        GameBoard testBoard = new PlayerBoard();
        testBoard.setBoardSize(3);

        int expectedSize = 3;
        int actualSize = testBoard.getBoardSize();

        Assertions.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void gameboardGetMatrix() {
        GameBoard g1 = new PlayerBoard(2);
        String[][] expectedMatrix = {{"-","-"},{"-","-"}};

        String[][] board = g1.getMatrix();
        Assertions.assertArrayEquals(expectedMatrix, board);
    }

    @Test
    public void gameboardUpdateCoordTrue() {
        GameBoard g1 = new PlayerBoard(2);
        String coordinate = "A1";
        String action = "x"; // hit
        boolean isUpdated = g1.updateCoord(coordinate, action);
        Assertions.assertTrue(isUpdated);

        String falseCoord = "Z10";
        String anotherAction = "o";

        Assertions.assertFalse(g1.updateCoord(falseCoord, anotherAction));
    }


    @Test
    public void gameboardConvertCoordToIndex() {
        GameBoard g1 = new PlayerBoard(2);
        // test letter + single digit
        int[] expectedLoc1 = {0,0};
        int[] actualLoc1 = g1.convertCoordToIndex("A1");
        Assertions.assertArrayEquals(expectedLoc1, actualLoc1);

        // test letter + two digits
        int[] expectedLoc2 = {0,9};
        int[] actualLoc2 = g1.convertCoordToIndex("A10");
        Assertions.assertArrayEquals(expectedLoc2, actualLoc2);

        // test invalid coordinate
        int[] expectedInv = {-1, -1};
        int[] actualIndex = g1.convertCoordToIndex("A349");
        Assertions.assertArrayEquals(expectedInv, actualIndex);
    }

    @Test
    public void gameboardRenderBoard() {
        GameBoard g1 = new PlayerBoard(2);
        GameBoard g2 = new TargetBoard();
        g1.renderBoard();

    }

    //PlayerBoard
    @Test
    public void playerboardTestValidCoord() throws Exception{
        PlayerBoard p2 = new PlayerBoard(10);

        Assertions.assertFalse(p2.isValidCoordinate("K200"));
        Assertions.assertTrue(p2.isValidCoordinate("A10"));
    }

    @Test
    public void playerboardPlaceShipDefault() {
        PlayerBoard pDefault = new PlayerBoard();
        // place ship on default board
        String[] coordList = {"C3", "C4"};
        String shipType = "Minesweeper";
        Minesweeper boat = new Minesweeper();
        boolean isPlaced = pDefault.placeShip("C3",boat,'e');
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals("M1", pDefault.valueAt("C4"));
    }

    @Test
    public void playerboardPlaceShipNonDefault() {
        PlayerBoard p1 = new PlayerBoard(5);
        // place ship on nondefault board
        String[] coordList = {"A1", "A2"};
        String shipType = "Destroyer";
        Destroyer boat = new Destroyer();
        boolean isPlaced = p1.placeShip("A1", boat, 'e');
        Assertions.assertTrue(isPlaced);
        Assertions.assertEquals("D0", p1.valueAt("A1"));
    }

    @Test
    public void playerboardPlaceInvalidShip() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        Destroyer boat = new Destroyer();
        boolean isPlaced = p1.placeShip("A4", boat, 'e');
        Assertions.assertFalse(isPlaced);
    }


    @Test
    public void playerboardReceiveFireBomb() {
        PlayerBoard pDefault = new PlayerBoard();

        Bomb weapon = new Bomb();

        String missTarget = "C9";
        String expectedResultMiss = "Miss";
        String actual1 = pDefault.receiveFire(missTarget, weapon);
        Assertions.assertEquals(expectedResultMiss, actual1);

        String[] coordList = {"A1", "A2"};
        String shipType = "Minesweeper";
        Minesweeper boat = new Minesweeper();
        boolean isPlaced = pDefault.placeShip("A1",boat,'e');
        Assertions.assertEquals("M0", pDefault.valueAt("A1"));
        Assertions.assertEquals("M1", pDefault.valueAt("A2"));
        String hitTarget = "A2";
        String expectedResultHit = "M1";
        String actual2 = pDefault.receiveFire(hitTarget, weapon);
        Assertions.assertEquals(expectedResultHit, actual2);
    }

    @Test
    public void playerboardRenderBoard() {
        PlayerBoard p1 = new PlayerBoard(5);
        p1.renderBoard();
    }

    @Test
    public void playerboardTestSink() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);

        p1.updateCoord("A1","B0");
        p1.updateCoord("A2","B1");
        p1.updateCoord("A3","B2");
        p1.updateCoord("A4","B3");

        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));
        Assertions.assertEquals("B0", p1.valueAt("A1"));

        p1.sink('B');

        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
        Assertions.assertEquals("x", p1.valueAt("A1"));
    }

    //need: getBoardSegment test, receiveFireSpecialWeapon

    @Test
    public void playerboardTestGetBoardSegment() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("B3","B1");
        p1.updateCoord("C3","S2");
        p1.updateCoord("C1","s3");
        p1.updateCoord("D1","x&s2");
        p1.updateCoord("D2","o&s0");
        p1.updateCoord("C4","M0");
        p1.updateCoord("C5","x&S2");
        p1.updateCoord("A1","o");

        /*
        String[][] expected = {{"-1","-1","-1","-1","-1"},
                               {"0","0","1","0","0"},
                               {"0","0","1","0","0"},
                               {"1","0","1","1","1"},
                               {"1","1","0","0","0"}};

         */

        String[][] expected = {{"","","","",""},
                {"o","-","x","-","-"},
                {"-","-","B1","-","-"},
                {"s3","-","S2","M0","x&S2"},
                {"x&s2","o&s0","-","-","-"}};
        Assertions.assertArrayEquals(expected,p1.getBoardSegment("B3",5));
    }

    @Test
    public void playerboardTestGetBoardSegmentOdd() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("A5","s3");
        p1.updateCoord("B3","M0");
        p1.updateCoord("B4","B1");
        p1.updateCoord("B5","o");
        p1.updateCoord("C4","S2");
        p1.updateCoord("D5","x&s2");
        p1.updateCoord("E3","o&s0");
        p1.updateCoord("E4","x&S2");
        p1.updateCoord("E5","o");

        /*
        String[][] expected = {{"-1","-1","-1","-1","-1"},
                               {"0","0","1","0","0"},
                               {"0","0","1","0","0"},
                               {"1","0","1","1","1"},
                               {"1","1","0","0","0"}};

         */

        String[][] expected = {{"M0","B1","o",""},
                {"-","S2","-",""},
                {"-","-","x&s2",""},
                {"o&s0","x&S2","o",""}};
        Assertions.assertArrayEquals(expected,p1.getBoardSegment("C4",4));
    }

    @Test
    public void playerboardTestReceiveSpecialWeapon() throws Exception{
        PlayerBoard p1 = new PlayerBoard(5);
        p1.updateCoord("A3","x");
        p1.updateCoord("B3","B1");
        p1.updateCoord("C3","S2");
        p1.updateCoord("C1","s3");
        p1.updateCoord("D1","x&s2");
        p1.updateCoord("D2","o&s0");
        p1.updateCoord("C4","M0");
        p1.updateCoord("C5","x&S2");
        p1.updateCoord("A1","o");


        String[][] expected = {{"-1","-1","-1","-1","-1"},
                {"0","0","1","0","0"},
                {"0","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","0","0","0"}};

        SonarPulse pulse = new SonarPulse();

        Assertions.assertEquals(Arrays.deepToString(expected),p1.receiveFireSpecialWeapon("B3",pulse));
    }

    //TargetBoard
    @Test
    public void targetboardFireUpon() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "G5";

        String actionHit = "hit";

        String expectedResult1 = "x"; // succeeded

        t.fireUpon(targetCoord, actionHit);
        Assertions.assertEquals(expectedResult1, t.valueAt(targetCoord));

    }

    @Test
    public void targetboardFireUponMiss() {
        TargetBoard t = new TargetBoard();
        String targetCoord = "A1";
        String actionMiss = "miss";
        String expectedResult2 = "o"; // miss
        t.fireUpon(targetCoord, actionMiss);
        Assertions.assertEquals(expectedResult2, t.valueAt(targetCoord));
    }

    //Player
    @Test
    public void playerPlaceShipTest() {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);
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
    public void playerFleetIsEmpty() {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);
        Player pEmpty = new Player();
        pEmpty.setFleet(new ArrayList<Boat>());
        Assertions.assertEquals(false, playerObjOne.fleetIsEmpty());
        Assertions.assertEquals(true, pEmpty.fleetIsEmpty());
    }

    // test revieveFire
    @Test
    public void playerReceiveFireTest() {
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
    public void playerFireUponTest() {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(0, playerObjOne.fireUpon("C3", "hit"));
    }

    // test render
    @Test
    public void playerRenderTest() {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);
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
    public void playerBoatArrayTest() {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);
        // need the primary boat class for ultimate test
        // for now return True
        Assertions.assertEquals(3, playerObjOne.getFleet().size());
    }

    @Test
    public void playerTestReceiveFireUnarmored() throws Exception{
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
    public void playerTestReceiveFireArmoredFirst() throws Exception{
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
    public void playerTestReceiveFireArmoredSecond() throws Exception{
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

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
    public void playerTestFireUponMany() throws Exception{
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

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
    public void playerTestFireSonarPulse() throws  Exception {
        Battleship battleship = new Battleship();
        Destroyer destroyer = new Destroyer();
        Minesweeper minesweeper = new Minesweeper();

        List<Boat> fleet = new LinkedList<Boat>(Arrays.asList(battleship, destroyer, minesweeper));
        String[] starts = {"A1","B1","C1"};
        char[] directions = {'e','e','e'};

        //construct player
        Player playerObjOne = new Player(fleet, starts, directions);

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
    public void playerTestReceiveSonarPulse() throws Exception{
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
    public void playerTestReceiveFireSink() throws Exception{
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
    public void playerTestReceiveFireSurrender() throws Exception{
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
    public void playerTestFireUponSonar() throws Exception{
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

    //Game
    @Test
    public void gameTestTurns(){
        Game g = new Game();
        Assertions.assertEquals(1,g.getTurn());
        g.playTurn();
        Assertions.assertEquals(2,g.getTurn());
    }

    @Test
    public void gameTestSetTurn(){
        Game g = new Game();
        //oops, set turn to 1 just bc
        g.setTurn(1);

        Assertions.assertEquals(1,g.getTurn());
    }

    @Test
    public void gameTestSetTurnBad(){
        Game g = new Game();
        g.setTurn(10);

        Assertions.assertEquals(1,g.getTurn());
    }

    @Test
    public void gameTestGetSetBoats(){
        Game g = new Game();
        String[] defaultBoats = {"BoatPackage.Battleship","BoatPackage.Destroyer", "BoatPackage.Minesweeper"};
        String[] newBoats = {"Destroyer","Battleship"};

        Assertions.assertArrayEquals(defaultBoats, g.getBoats());

        g.setBoats(newBoats);

        Assertions.assertArrayEquals(newBoats, g.getBoats());
    }

    @Test
    public void gameTestIsValidCoordinate(){
        Game g = new Game();
        String[] trueInput = {"A2","A3","A4"};
        Assertions.assertEquals(true, g.isValidCoordinate(trueInput));
        String[] falseInput = {"A2","A3","B3"};
        Assertions.assertEquals(false, g.isValidCoordinate(falseInput));
        String[] falseInput2 = {"A2","A3","A10"};
        Assertions.assertEquals(false, g.isValidCoordinate(falseInput2));
    }

    @Test
    public void gameTestGameOver(){
        Game g = new Game();
        Assertions.assertEquals(false, g.gameOver());
    }
}
