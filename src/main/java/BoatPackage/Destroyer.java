package BoatPackage;

public class Destroyer extends Boat{

    public Destroyer() {
        setName("Destroyer");
        setSize(3);
        setCabinIndex(1);
    }

    public Destroyer(String[] coords){
        setName("Destroyer");
        setSize(3);
        setCabinIndex(1);
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
