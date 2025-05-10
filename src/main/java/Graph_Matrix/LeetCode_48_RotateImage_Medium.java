package Graph_Matrix;

// LeetCode48_RotateImage.java

/**
 * Leetcode Problem #48 - Rotate Image
 *
 * Problem Statement:
 * You are given an n x n 2D matrix representing an image,
 * rotate the image by 90 degrees (clockwise) in-place.
 *
 * Constraints:
 * - matrix.length == n
 * - matrix[i].length == n
 * - 1 <= n <= 20
 * - -1000 <= matrix[i][j] <= 1000
 *
 * Example 1:
 * Input: matrix = [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ]
 * Output: [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * Example 2:
 * Input: matrix = [
 *   [5,1,9,11],
 *   [2,4,8,10],
 *   [13,3,6,7],
 *   [15,14,12,16]
 * ]
 * Output: [
 *   [15,13,2,5],
 *   [14,3,4,1],
 *   [12,6,8,9],
 *   [16,7,10,11]
 * ]
 *
 * Approach:
 * 1. Transpose the matrix in-place.
 * 2. Reverse each row.
 * This effectively rotates the matrix 90 degrees clockwise.
 */

public class LeetCode_48_RotateImage_Medium {

    /**
     * Rotates the input n x n matrix 90 degrees clockwise in-place.
     *
     * @param matrix The 2D matrix to rotate
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose Matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<n;j++){
                int temp =  matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse Matrix
        for(int i=0;i<matrix.length;i++){
            int start =  0;
            int end = matrix.length-1;
            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

    }
    public void rotate_debug(int[][] matrix) {
        int n = matrix.length;

        System.out.println("\nStep 1: Transpose the matrix");
        // Step 1: Transpose the matrix (convert rows to columns)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.printf("Swapping matrix[%d][%d] = %d and matrix[%d][%d] = %d\n",
                        i, j, matrix[i][j], j, i, matrix[j][i]);

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("Matrix after transposing:");
        printMatrix(matrix);

        System.out.println("\nStep 2: Reverse each row");
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                System.out.printf("Row %d: Swapping matrix[%d][%d] = %d and matrix[%d][%d] = %d\n",
                        i, i, left, matrix[i][left], i, right, matrix[i][right]);

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

        System.out.println("Matrix after reversing rows (final rotated matrix):");
        printMatrix(matrix);
    }

    // Helper method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Helper method to print a label
    private static void printLabel(String label) {
        System.out.println("\n=== " + label + " ===");
    }

    public static void main(String[] args) {
        LeetCode_48_RotateImage_Medium solver = new LeetCode_48_RotateImage_Medium();

        // Test Case 1
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        printLabel("Original Matrix 1");
        printMatrix(matrix1);
        solver.rotate(matrix1);
        printLabel("Rotated Matrix 1 (Expected: [[7,4,1],[8,5,2],[9,6,3]])");
        printMatrix(matrix1);

        // Test Case 2
        int[][] matrix2 = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        printLabel("Original Matrix 2");
        printMatrix(matrix2);
        solver.rotate(matrix2);
        printLabel("Rotated Matrix 2 (Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]])");
        printMatrix(matrix2);
    }
}
