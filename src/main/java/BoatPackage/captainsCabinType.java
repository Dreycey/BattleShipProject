package BoatPackage;

public class captainsCabinType {

    private  String loc;
    private boolean alreadyHit;

    public captainsCabinType(){
        alreadyHit = false;
    }

    public captainsCabinType(String coordinate){
        loc = coordinate;
        alreadyHit = false;
    }

    public String getLoc(){
        return loc;
    }

    public void setLoc(String newLoc){
        loc = newLoc;
    }

    public boolean getHitStatus(){
        return alreadyHit;
    }

    public void setHitStatus(boolean status){
        alreadyHit = status;
    }

    public String hit() {
        return null;
    }

}
