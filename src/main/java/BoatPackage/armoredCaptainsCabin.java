package BoatPackage;

public class armoredCaptainsCabin extends captainsCabinType{

    public  armoredCaptainsCabin(){super();}

    @Override
    public String hit(){
        if(!getHitStatus()){
            setHitStatus(true);
            return "Miss";
        }
        return "Sunk";
    }

}
