package BoatPackage;

public class Minesweeper extends Boat{

    public Minesweeper() {
        setName("Minesweeper");
        setSize(2);
    }

    public Minesweeper(String[] coords){
        setName("Minesweeper");
        setSize(2);
        setCabinIndex(0);
        setCaptainsCabin("unarmored");
    }
}
