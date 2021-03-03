package BoatPackage;

public class armoredCaptainsCabin extends captainsCabinType{

    public  armoredCaptainsCabin(){super();}
    public armoredCaptainsCabin(String location){
        super(location);
    }

    @Override
    public String hit(){
        if(!getHitStatus()){
            setHitStatus(true);
            return "Miss";
        }
        return "Sunk";
    }

}
