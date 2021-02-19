package edu.colorado.csci44485448;

import java.util.Arrays;

public class Boat {

    private String status = "Afloat";
    private String[] coordinates = {};

    public boolean isValidCoordinate(String coord){
        int letter = (int) coord.charAt(0);
        int number = Integer.parseInt(coord.substring(1));
        if(number > 0 && number < 11 && letter > 64 && letter < 75){
            return true;
        }
        return false;
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

    public String[] getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(String[] c){
        coordinates = Arrays.stream(c).filter(x -> isValidCoordinate(x)).toArray(String[]::new);
    }

    public boolean isCoordAfloat(String c){
        return Arrays.asList(coordinates).contains(c);
    }

    public void removeCoordinate(String c) {
        if(isCoordAfloat(c)){
            int freshLength = coordinates.length - 1;
            String[] coords = new String[freshLength];

            for (int i = 0, k = 0; i < coordinates.length; i++) {

                // check if index is crossed, continue without copying
                if (coordinates[i].equals(c)) {
                    continue;
                }

                // else copy the element
                coords[k++] = coordinates[i];


            }
            coordinates = coords;
        }
    }
}
