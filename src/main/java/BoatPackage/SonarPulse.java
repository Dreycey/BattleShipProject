package BoatPackage;

public class SonarPulse implements SpecialWeapon{

    public String[][] hit(String[][] matrix){
        String[][] toReturn = new String[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j].equals("-")){
                    toReturn[i][j] = "0";
                }
                else{
                    toReturn[i][j] = "-1";
                }
            }
        }
        return toReturn;
    }

}
