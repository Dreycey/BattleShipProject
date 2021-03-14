package BoatPackage;

public class captainsCabinType {

    private boolean alreadyHit;

    public captainsCabinType(){
        alreadyHit = false;
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
