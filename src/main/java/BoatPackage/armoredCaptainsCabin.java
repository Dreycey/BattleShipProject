package BoatPackage;

public class armoredCaptainsCabin extends captainsCabinType{



    public armoredCaptainsCabin(String location){
        super(location);
    }

    @Override
    public String hit(){
        return "Miss";
    }

}
