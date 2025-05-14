package Graph_Matrix;

/*
 * LeetCode Problem 994: Rotting Oranges
 *
 * 1) DSA Problem Category:
 *    - Graph
 *    - Breadth-First Search (BFS)
 *    - Queue
 *    - Matrix Traversal
 *
 * 2) Problem Description:
 *    You are given an m x n grid where each cell can have one of three values:
 *      - 0 representing an empty cell,
 *      - 1 representing a fresh orange,
 *      - 2 representing a rotten orange.
 *    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 *    If this is impossible, return -1.
 *
 * 3) Examples:
 *    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 *    Output: 4
 *
 *    Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 *    Output: -1
 *    Explanation: The orange in the bottom left corner (1) is never reachable.
 *
 *    Input: grid = [[0,2]]
 *    Output: 0
 *    Explanation: No fresh oranges.
 *
 * 4) Brute Force Approach:
 *    Repeatedly scan the entire grid each minute to mark fresh oranges next to rotten ones. Repeat until no changes.
 *    Time Complexity: O((mn)^2), very inefficient.
 *
 * 5) Optimum Approach:
 *    Use BFS starting from all rotten oranges at once, propagate the rot level by level.
 *    Use a queue to track rotten oranges and a counter to track time.
 *    Time Complexity: O(m*n)
 *
 * 6) Additional Hints:
 *    - Think of it like levels in a tree or graph.
 *    - Use BFS since you want the shortest time until all reachable fresh oranges rot.
 */

import java.util.*;

public class LeetCode_994_RottingOranges_Medium {

    // Placeholder for implementation
    public int orangesRotting(int[][] grid) {
        int gridRowLength = grid.length;
        int gridColLength = grid[0].length;
        int freshCount = 0;

        Queue<int []> queue = new LinkedList<>(); //Take a queue of the grid location

        //Add rotten to queue and count fresh
        for(int i=0;i<gridRowLength;i++){
            for(int j=0;j<gridColLength;j++){
                if(grid[i][j]==2){ //if grid has rotten oranges
                    queue.add(new int[]{i,j});  //add to co-ordinates to the queue
                }else if(grid[i][j]==1){
                    freshCount++;  //else increase fresh count
                }
            }
        }
        //At the end of above method, you have all rotten oranges in a queue, and you have a count of fresh oranges.


        if(freshCount == 0) return 0;
        int totalMinutes = 0;
        while(queue.size()>0){
            int size = queue.size();
            boolean hasRottenThisMinute =  false;

            for(int i=0;i<size;i++){

                int cell[] = queue.remove();
                int rottenRow = cell[0];
                int rottenCol = cell[1];

                //Left (If you find a fresh orange in on LEFT side, make it rotten and decrease fresh count)
                if(rottenRow >= 0 && rottenRow < gridRowLength && rottenCol-1 >= 0 && rottenCol-1 < gridColLength && grid[rottenRow][rottenCol-1] == 1){
                    queue.add(new int[]{rottenRow, rottenCol-1});
                    grid[rottenRow][rottenCol-1] = 2;
                    hasRottenThisMinute = true;
                    freshCount--;
                }

                //Right (If you find a fresh orange in on Right side, make it rotten and decrease fresh count)
                if(rottenRow>=0 && rottenRow<gridRowLength && rottenCol+1 >=0 && rottenCol+1<gridColLength && grid[rottenRow][rottenCol+1] == 1){
                    queue.add(new int[]{rottenRow, rottenCol+1});
                    grid[rottenRow][rottenCol+1] = 2;
                    hasRottenThisMinute = true;
                    freshCount--;
                }

                //Down (If you find a fresh orange in on Down side, make it rotten and decrease fresh count)
                if(rottenRow+1>=0 && rottenRow+1<gridRowLength && rottenCol >=0 && rottenCol<gridColLength && grid[rottenRow+1][rottenCol] == 1){
                    queue.add(new int[]{rottenRow+1, rottenCol});
                    grid[rottenRow+1][rottenCol] = 2;
                    hasRottenThisMinute = true;
                    freshCount--;
                }
                //Up (If you find a fresh orange in on Up side, make it rotten and decrease fresh count)
                if(rottenRow-1>=0 && rottenRow-1<gridRowLength && rottenCol >=0 && rottenCol<gridColLength && grid[rottenRow-1][rottenCol] == 1){
                    queue.add(new int[]{rottenRow-1, rottenCol});
                    grid[rottenRow-1][rottenCol] = 2;
                    hasRottenThisMinute = true;
                    freshCount--;
                }

            }
            if(hasRottenThisMinute){
                totalMinutes++; //Increase a minute if you could find rotten orange in any direction
            }

        }

        return freshCount == 0 ? totalMinutes : -1;

    }

    // Helper method to run tests
    public static void main(String[] args) {
        LeetCode_994_RottingOranges_Medium solution = new LeetCode_994_RottingOranges_Medium();

        // Define test cases
        int[][][] testCases = {
                {{2,1,1},{1,1,0},{0,1,1}},
                {{2,1,1},{0,1,1},{1,0,1}},
                {{0,2}},
                {{1,2}},
                {{0,0,0},{2,0,0},{0,0,1}},
        };
        int[] expectedResults = {4, -1, 0, 1, -1};

        // Run test cases
        for (int i = 0; i < testCases.length; i++) {
            int result = solution.orangesRotting(testCases[i]);
            boolean passed = result == expectedResults[i];
            System.out.printf("Test case %d: Expected = %d, Actual = %d [%s]%n",
                    i + 1, expectedResults[i], result, passed ? "PASS" : "FAIL");
        }
    }

    /**
     * Actual implementation of BFS approach to solve the problem.
     * Traverses the grid and simulates rotting oranges over time.
     */
    public int orangesRottingSolution(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Initialize the queue with all initially rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        // Step 2: BFS to rot adjacent fresh oranges
        int minutes = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows
                            && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1
                    ) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        hasRottenThisMinute = true;
                    }
                }
            }

            if (hasRottenThisMinute) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
