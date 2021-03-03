package BoatPackage;

public class unarmoredCaptainsCabin extends captainsCabinType{

    public unarmoredCaptainsCabin(){super();}

    public unarmoredCaptainsCabin(String location){
        super(location);
    }

    @Override
    public String hit(){
        return "Sunk";
    }

}
