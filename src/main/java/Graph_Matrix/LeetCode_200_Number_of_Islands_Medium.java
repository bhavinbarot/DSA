package Graph_Matrix;

// LeetCode Problem 200: Number of Islands
// DSA Category: Graph / DFS / BFS / Matrix Traversal

/*
1) Problem Category:
   This problem falls under Graph Traversal / Depth-First Search (DFS) / Breadth-First Search (BFS) / Matrix problems.

2) Problem Description:
   Given a 2D grid map of '1's (land) and '0's (water), count the number of islands.
   An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
   You may assume all four edges of the grid are all surrounded by water.

3) Examples:
   Example 1:
     Input:
       11110
       11010
       11000
       00000
     Output: 1

   Example 2:
     Input:
       11000
       11000
       00100
       00011
     Output: 3

4) Brute Force Approach:
   - For each cell in the grid, if it's a '1', initiate a flood fill to mark all connected land cells.
   - Use DFS or BFS to mark all adjacent '1's from that position to '0' or visited.
   - Continue iterating through the grid.
   - Time Complexity: O(m * n) since every cell is visited once.
   - Space Complexity: O(m * n) in the worst case due to recursion stack.

5) Optimal Approach:
   - Same as brute force in terms of complexity, but we can improve space by iterative DFS or BFS.
   - Avoid creating new matrices and perform operations in-place.

6) Additional Hints:
   - Use direction arrays to traverse in 4 directions.
   - Be careful not to go out of bounds.
   - Mark visited lands to avoid recounting them.

*/

public class LeetCode_200_Number_of_Islands_Medium {

    // Placeholder method: this is where the main logic will be implemented during an interview simulation
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //If you find a land
                if(grid[i][j] == '1'){
                    convert_to_water_dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void convert_to_water_dfs(char[][] grid, int r, int c){
        //This line will return if you find water anywhere
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] != '1') return;

        //This line will convert the land into the water (so that we can find out remaining islands)
        grid[r][c] = 0;

        convert_to_water_dfs(grid, r-1, c); //Up
        convert_to_water_dfs(grid, r+1, c); //Down
        convert_to_water_dfs(grid, r, c-1); //Left
        convert_to_water_dfs(grid, r, c+1); //right

    }

    public static void main(String[] args) {
        LeetCode_200_Number_of_Islands_Medium solution = new LeetCode_200_Number_of_Islands_Medium();

        // Test case 1
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        runTest(solution, grid1, 1, "Test Case 1");

        // Test case 2
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        runTest(solution, grid2, 3, "Test Case 2");

        // Add more test cases as needed...
    }

    // Method to run each test case and compare output with expected answer
    private static void runTest(LeetCode_200_Number_of_Islands_Medium solution, char[][] grid, int expected, String testCaseName) {
        // Deep copy grid since the method might mutate it
        char[][] gridCopy = deepCopyGrid(grid);

        int result = solution.numIslands(gridCopy);
        boolean passed = result == expected;

        System.out.println(testCaseName + ": " + (passed ? "PASS ✅" : "FAIL ❌"));
        System.out.println("Expected: " + expected + ", Actual: " + result);
        System.out.println("--------------------------------------------------");
    }

    // Utility method to deep copy the grid to avoid mutation during testing
    private static char[][] deepCopyGrid(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    // Actual DFS solution implementation (to be completed during coding round)
    // Uncomment this and use it when solving the problem.

    /*
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0'; // mark visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    */
}
