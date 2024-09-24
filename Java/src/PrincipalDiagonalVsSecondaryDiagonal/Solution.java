package PrincipalDiagonalVsSecondaryDiagonal;

public class Solution {
    public static String diagonal(int[][] matrix){
        int n = matrix.length;
        int sumPremierDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int i=0 ; i < n ; i++){
            sumPremierDiagonal += matrix[i][i];
            sumSecondDiagonal += matrix[i][n-1-i];
        }

        if (sumPremierDiagonal == sumSecondDiagonal) return "Draw!";
        else if (sumPremierDiagonal > sumSecondDiagonal) return "Principal Diagonal win!";
        else return "Secondary Diagonal win!";
    }

    public static void main(String... args){
        int[][] test1 = new int[][]{{2,2,2},
                {4,2,6},
                {8,8,2}};

        int[][] test2 = new int[][]{{2,2,2},
                {4,2,6},
                {1,8,2}};

        int[][] test3 = new int[][]{{1,2,3},
                {4,5,6},
                {7,8,9}};

        System.out.println(diagonal(test1));
        System.out.println(diagonal(test2));
        System.out.println(diagonal(test3));
    }
}
