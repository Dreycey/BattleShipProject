package BoatPackage;

public class Bomb implements Weapon{
    public String hit(String currentValue){
        if(currentValue == "-"){
            return "o";
        }
        else{
            if(currentValue.contains("s")){
                return "o";
            }
            return "x";
        }
    }
}
