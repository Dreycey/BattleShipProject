package BoatPackage;

import java.util.Arrays;

public class Boat {
    private String name;
    private int size;
    private String status = "Afloat";
    private captainsCabinType captainsCabin;
    private int cabinIndex;
    private int hitsRemaining;

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
        hitsRemaining = size;
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

    public int getHitsRemaining(){return hitsRemaining;}

    public void hit(){

        hitsRemaining -= 1;
        reAlignStatus();
    }

    public void reAlignStatus(){
        if(hitsRemaining == size){
            setStatus("Afloat");
        }
        else if(hitsRemaining > 0 && hitsRemaining < size){
            setStatus("Hit");
        }
        else{
            setStatus("Sunk");
        }
    }
}
