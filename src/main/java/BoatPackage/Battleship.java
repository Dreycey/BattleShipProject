package BoatPackage;

public class Battleship extends Boat{

    public Battleship(){
        setName("Battleship");
        setSize(4);
        setCabinIndex(2);
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
