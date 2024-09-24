package BuildTower;

public class Kata {
    public static String[] towerBuilder(int nFloors){
        String[] floors = new String[nFloors];
        for (int i=0 ; i<nFloors ; i++){
            floors[i] = " ".repeat(nFloors-i-1).concat("*".repeat(2*i+1)).concat(" ".repeat(nFloors-i-1));
        }
        return floors;
    }

    public static void main(String... args){
        System.out.print(towerBuilder(6));
    }
}
