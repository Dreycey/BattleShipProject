package BoatPackage;

public class SpaceLaser implements Weapon{

    private String name;

    public SpaceLaser(){
        name = "SpaceLaser";
    }

    public String getName(){
        return name;
    }

    public String hit(String currentValue) {
        if(currentValue.equals("-")){
            return "o";
        }
        else {
            return "x";
        }
    }
}
