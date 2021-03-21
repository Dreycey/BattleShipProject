package BoatPackage;

public class SonarPulse implements SpecialWeapon, Weapon{

    private String name;

    public SonarPulse(){
        name = "SonarPulse";
    }

    public String getName(){
        return name;
    }

    public String getType() {
        return "SpecialWeapon";
    }

    public String hit(String currentValue) {
        if(currentValue.equals("-") || currentValue.equals("o")){
            return "0";
        }
        else if(currentValue.equals("")){
            return "-1";
        }
        else{
            return "1";
        }
    }

    public String[][] hit(String[][] matrix){
        String[][] toReturn = new String[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                toReturn[i][j] = hit(matrix[i][j]);
            }
        }
        return toReturn;
    }

}
