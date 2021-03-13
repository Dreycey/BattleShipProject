package BoatPackage;

import java.util.Arrays;

public class Boat {
    private String name;
    private int size;
    private String status = "Afloat";
    private String[] coordinates = {};
    private captainsCabinType captainsCabin;
    private int cabinIndex;

    public Boat() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String s){
        String[] validStatuses = {"Afloat", "Hit", "Sunk"};
        if(Arrays.asList(validStatuses).contains(s)) {
            status = s;
        }
    }

    public void setCaptainsCabin(String type){
        if(type == "armored"){
            captainsCabin = new armoredCaptainsCabin();
        }
        else{
            captainsCabin = new unarmoredCaptainsCabin();
        }
    }

    public captainsCabinType getCaptainsCabin(){
        return captainsCabin;
    }

    public void setCabinIndex(int i){
        cabinIndex = i;
    }

    public int getCabinIndex(){return cabinIndex;}

    public int[][] genLocs(char direction){return null;}
}
