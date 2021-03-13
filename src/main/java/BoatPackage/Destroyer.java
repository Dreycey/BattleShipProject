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
        setCaptainsCabin("armored");
    }

    @Override
    public int[][] genLocs(char direction){
        int[][] locs = new int[super.getSize()][2];
        if (direction == 's'){
            for(int i = 0; i < locs.length; i++){
                locs[i] = new int[]{i * -1, 0};
            }

            return locs;
        }
        else if(direction == 'n'){
            for(int i = 0; i < locs.length; i++){
                locs[i] = new int[]{i, 0};
            }

            return locs;
        }
        else if(direction == 'e'){
            for(int i = 0; i < locs.length; i++){
                locs[i] = new int[]{0, i};
            }

            return locs;
        }
        else if(direction == 'w'){
            for(int i = 0; i < locs.length; i++){
                locs[i] = new int[]{0, i * -1};
            }

            return locs;
        }
        else{
            return null;
        }
    }

}
