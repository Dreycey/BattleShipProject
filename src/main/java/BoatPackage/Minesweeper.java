package BoatPackage;

public class Minesweeper extends Boat{

    public Minesweeper() {
        setName("Minesweeper");
        setSize(2);
    }

    public Minesweeper(String[] coords){
        setName("Minesweeper");
        setSize(2);
        setCabinIndex(0);
        setCoordinates(coords);
        setCaptainsCabin("unarmored",getCoordinates()[getCabinIndex()]);
    }

    @Override
    public void removeCoordinate(String c) {
        if(isCoordAfloat(c)){
            int freshLength = getCoordinates().length - 1;
            String[] coords = new String[freshLength];

            for (int i = 0, k = 0; i < getCoordinates().length; i++) {

                // check if index is crossed, continue without copying
                if (getCoordinates()[i].equals(c)) {
                    continue;
                }
                // else copy the element
                coords[k++] = getCoordinates()[i];
            }
            setCoordinates(coords);
        }
        realignStatus();
    }

    public void realignStatus(){
        int coordLength = getCoordinates().length;

        if(coordLength == getSize()){
            setStatus("Afloat");
        }
        else if(coordLength < getSize() && coordLength > 0){
            setStatus("Hit");
        }
        else{
            setStatus("Sunk");
        }
    }
}
