package BoatPackage;

public class armoredCaptainsCabin extends captainsCabinType{

    private boolean alreadyHit;

    public armoredCaptainsCabin(String location){
        super(location);
        alreadyHit = false;
    }

    public boolean getHitStatus(){
        return alreadyHit;
    }

}
