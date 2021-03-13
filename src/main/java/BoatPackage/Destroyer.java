package BoatPackage;

public class Destroyer extends Boat{

    public Destroyer() {
        setName("Destroyer");
        setSize(3);
        setCabinIndex(1);
    }

    public Destroyer(String[] coords){
        setName("Destroyer");
        setSize(3);
        setCabinIndex(1);
        setCaptainsCabin("armored");
    }

}
