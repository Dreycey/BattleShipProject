package BoatPackage;

interface Weapon {

    public String getName();
    //should be able to:
    //given what's at the cell, what will the result be?
    public String hit(String currentValue);
}
