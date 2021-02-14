package edu.colorado.csci44485448;

import java.util.Arrays;

public class Boat {

    private String status = "Afloat";

    public String getStatus(){
        return status;
    }

    public void setStatus(String s){
        String[] validStatuses = {"Afloat", "Hit", "Sunk"};
        if(Arrays.asList(validStatuses).contains(s)) {
            status = s;
        }
    }
}
