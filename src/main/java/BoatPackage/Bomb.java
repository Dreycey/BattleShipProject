package BoatPackage;

public class Bomb implements Weapon{
    public String hit(String currentValue){
        if(currentValue == "-"){
            return "o";
        }
        else{
            if(currentValue.contains("s")){
                if(currentValue.contains("&")){ //means a boat is above it
                    String sub = currentValue.split("&")[1];
                    return "x&"+sub;
                }
                else{
                    return "o";
                }
            }
            return "x";
        }
    }
}
