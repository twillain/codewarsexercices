package MatrixDeterminant;

import static org.junit.Assert.assertEquals;

public class Matrix {
    public static int determinant(int[][] A){

        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        int[] pivot = new int[n];  // Track row swaps for the sign of the determinant
        boolean evenSwaps = true;  // Track whether the number of swaps is even or odd

        // Initialize pivot array (0, 1, 2, ...)
        for (int i = 0; i < n; i++) {
            pivot[i] = i;
        }

        // LU Decomposition with partial pivoting
        for (int k = 0; k < n; k++) {
            // Partial pivoting: Find the pivot row
            int maxRow = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[maxRow][k])) {
                    maxRow = i;
                }
            }

            // Swap rows in A, pivot and track the swap for the determinant's sign
            if (maxRow != k) {
                int[] temp = A[k];
                A[k] = A[maxRow];
                A[maxRow] = temp;

                int tempPivot = pivot[k];
                pivot[k] = pivot[maxRow];
                pivot[maxRow] = tempPivot;

                evenSwaps = !evenSwaps;  // Each swap inverts the sign of the determinant
            }

            // Decompose into L and U
            for (int i = k; i < n; i++) {
                U[k][i] = A[k][i];  // Upper triangular matrix U
            }

            for (int i = k + 1; i < n; i++) {
                L[i][k] = (double) A[i][k] / U[k][k];  // Lower triangular matrix L (integer division)
                for (int j = k; j < n; j++) {
                    A[i][j] -= L[i][k] * U[k][j];
                }
            }
            L[k][k] = 1.0;  // Diagonal of L is 1
        }

        // Calculate determinant as product of diagonal elements of U
        double determinant = evenSwaps ? 1 : -1;  // Adjust for number of row swaps
        for (int i = 0; i < n; i++) {
            determinant *= U[i][i];
        }

        return (int) determinant;
    }

    public static void main(String... args){
        int[][] test1 = {{1}};
        int[][] test2 = {{1,3},{2,5}};
        int[][] test3 = {{2,5,3},{1,-2,-1},{1,3,4}};

        System.out.println("test1 : " + determinant(test1));
        System.out.println("test2 : " + determinant(test2));
        System.out.println("test3 : " + determinant(test3));
    }

}
