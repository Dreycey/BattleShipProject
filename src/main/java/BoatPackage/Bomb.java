package BoatPackage;

public class Bomb implements Weapon{
    public String hit(String currentValue){
        if(currentValue == "-"){
            return "o";
        }
        else{
            return "x";
        }
    }
}
