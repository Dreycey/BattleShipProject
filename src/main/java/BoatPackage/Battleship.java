package BoatPackage;

public class Battleship extends Boat{
    public Battleship() {
        setName("Battleship");
        setSize(4);
    }

    public Battleship(String[] coords){
        setName("Battleship");
        setSize(4);
        setCabinIndex(2);
        setCoordinates(coords);
        setCaptainsCabin("armored",getCoordinates()[getCabinIndex()]);
    }

    @Override
    public void removeCoordinate(String c) {
        if(isCoordAfloat(c)){
            String[] coords = new String[getCoordinates().length];

            for (int i = 0; i < getCoordinates().length; i++) {

                // check if index is crossed, add empty string
                if (getCoordinates()[i].equals(c)) {
                    coords[i] = "";
                }

                // else copy the element
                else {
                    coords[i] = getCoordinates()[i];
                }


            }
            setCoordinates(coords);
        }
        realignStatus();
    }

    public void realignStatus(){
        int validLength = 0;

        String[] oldCoords = getCoordinates();

        for(int i = 0; i < oldCoords.length; i++){
            if(oldCoords[i] != ""){
                validLength += 1;
            }
        }

        if(validLength == getSize()){
            setStatus("Afloat");
        }
        else if(validLength < getSize() && validLength > 0){
            setStatus("Hit");
        }
        else{
            setStatus("Sunk");
        }
    }
}
