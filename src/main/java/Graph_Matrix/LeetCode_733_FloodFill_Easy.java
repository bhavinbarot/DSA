package Graph_Matrix;

public class LeetCode_733_FloodFill_Easy {

    // === Flood Fill Method using DFS ===
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image; // Prevent infinite loop
        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    // === Helper DFS method ===
    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        // Boundary and color check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != color) return;

        // Recolor the pixel
        image[r][c] = newColor;

        // Recursive DFS in 4 directions
        dfs(image, r + 1, c, color, newColor); // Down
        dfs(image, r - 1, c, color, newColor); // Up
        dfs(image, r, c + 1, color, newColor); // Right
        dfs(image, r, c - 1, color, newColor); // Left
    }

    // === Main driver method ===
    public static void main(String[] args) {
        LeetCode_733_FloodFill_Easy solution = new LeetCode_733_FloodFill_Easy();

        // Test Case 1
        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] expected1 = {{2,2,2},{2,2,0},{2,0,1}};
        int[][] result1 = solution.floodFill(cloneMatrix(image1), 1, 1, 2);
        printResult(result1, expected1, "Test Case 1");

        // Test Case 2
        int[][] image2 = {{0,0,0},{0,0,0}};
        int[][] expected2 = {{0,0,0},{0,0,0}};
        int[][] result2 = solution.floodFill(cloneMatrix(image2), 0, 0, 0);
        printResult(result2, expected2, "Test Case 2");

        // Test Case 3 - small island
        int[][] image3 = {{0,1,1},{1,1,0},{1,0,1}};
        int[][] expected3 = {{0,2,2},{2,2,0},{2,0,1}};
        int[][] result3 = solution.floodFill(cloneMatrix(image3), 1, 1, 2);
        printResult(result3, expected3, "Test Case 3");
    }

    // === Utility: Deep clone a matrix ===
    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            clone[i] = matrix[i].clone();
        }
        return clone;
    }

    // === Utility: Print results and compare ===
    private static void printResult(int[][] result, int[][] expected, String testCase) {
        boolean isPass = compareMatrices(result, expected);
        System.out.println(testCase + ": " + (isPass ? "PASS" : "FAIL"));
        System.out.println("Expected:");
        printMatrix(expected);
        System.out.println("Actual:");
        printMatrix(result);
        System.out.println("--------------------------");
    }

    // === Utility: Compare two matrices ===
    private static boolean compareMatrices(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) return false;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    // === Utility: Print matrix ===
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
