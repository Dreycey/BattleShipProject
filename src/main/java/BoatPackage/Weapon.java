package BoatPackage;

interface Weapon {

    //should be able to:
    //fire upon
    public void fireUpon(String inCoordinate, String strikeResult);
    public void fireUponMany(String[] coords, String strikeResult);
    //receive fire
    public String receiveFire(String inCoordinate);
}
