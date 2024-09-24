package Snail;

public class Snail {

    public static int[] snail(int[][] array){
        int n = array.length;
        int[] snail = new int[n*n];
        int count = 0;
        for (int i=0 ; i<n ; i++){
            for (int j=0 ; j<n ; j++){
                snail[i*n+j] = array[i][j];
            }
        }
        return snail;
    }

    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(snail(array));
    }
}
