package BoatPackage;

public class Submarine extends Boat{

    private boolean isSubmerged = true;

    public Submarine(){
        setName("Submarine");
        setSize(5);
        setCabinIndex(0);
        setCaptainsCabin("unarmored");
    }

    public boolean getIsSubmerged() {
        return isSubmerged;
    }

    public void changeSubmerged() {
        isSubmerged = !isSubmerged;
    }


    @Override
    public int[][] genLocs(char direction){
        int[][] locs = new int[super.getSize()][2];
        if (direction == 's'){
            for(int i = 0; i < locs.length-1; i++){
                locs[i] = new int[]{i, 0};
            }
            // set periscope loc
            locs[locs.length-1] = new int[]{2, -1};
            return locs;
        }
        else if(direction == 'n'){
            for(int i = 0; i < locs.length-1; i++){
                locs[i] = new int[]{i * -1, 0};
            }
            // set periscope loc
            locs[locs.length-1] = new int[]{-2, -1};
            return locs;
        }
        else if(direction == 'e'){
            for(int i = 0; i < locs.length-1; i++){
                locs[i] = new int[]{0, i};
            }
            // set periscope loc
            locs[locs.length -1] = new int[]{-1,2};
            return locs;
        }
        else if(direction == 'w'){
            for(int i = 0; i < locs.length-1; i++){
                locs[i] = new int[]{0, i * -1};
            }
            // set periscope loc
            locs[locs.length-1] = new int[]{-1, -2};
            return locs;
        }
        else{
            return null;
        }
    }
}
