package BoatPackage;

public class SpaceLaser implements Weapon{

    public String hit(String currentValue) {
        if(currentValue.equals("-")){
            return "o";
        }
        else {
            return "x";
        }
    }
}
