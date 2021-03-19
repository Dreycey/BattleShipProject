package BoatPackage;

public class SpaceLaser implements Weapon{

    public String hit(String currentValue) {
        if(currentValue.equals("-")){
            return "o";
        }
        return null;
    }
}
