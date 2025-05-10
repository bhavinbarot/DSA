package Recursion;

/**
 * LeetCode Problem 51: N-Queens
 *
 * 1) DSA Category:
 *    - Backtracking
 *    - Recursion
 *    - 2D Arrays
 *
 * 2) Problem Statement:
 *    The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 *    such that no two queens attack each other. Given an integer n, return all
 *    distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 *    Each solution contains a distinct board configuration of the n-queens' placement,
 *    where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * 3) Examples:
 *    Input: n = 4
 *    Output: [
 *      [".Q..","...Q","Q...","..Q."],
 *      ["..Q.","Q...","...Q",".Q.."]
 *    ]
 *
 *    Input: n = 1
 *    Output: [["Q"]]
 *
 * 4) Brute Force Approach:
 *    - Try placing queens in every row in every possible column and check for each configuration
 *    whether the board remains valid (no queen attacking another).
 *    - Check all permutations and prune invalid ones.
 *    - Time complexity: O(n!), highly inefficient for large n.
 *
 * 5) Optimal Approach:
 *    - Use backtracking with:
 *      - A column set to avoid placing multiple queens in same column.
 *      - Two diagonals: one for (row + col) and one for (row - col).
 *      - This avoids checking the board every time; reduces time complexity.
 *
 * 6) Additional Hints:
 *    - This is a classic example of backtracking.
 *    - Visualize how queens can attack: same row, column, and diagonals.
 *    - You only need to track placements row by row due to recursive nature.
 *
 * 7) The program will test the implementation and print PASS/FAIL with expected vs actual outputs.
 */

import java.util.*;

public class LeetCode_51_NQueens_Hard {

    public static void main(String[] args) {
        // Test cases
        int[] testNs = {1, 4};
        List<List<List<String>>> expectedResults = new ArrayList<>();

        expectedResults.add(Arrays.asList(
                Arrays.asList("Q")
        ));

        expectedResults.add(Arrays.asList(
                Arrays.asList(".Q..","...Q","Q...","..Q."),
                Arrays.asList("..Q.","Q...","...Q",".Q..")
        ));

        for (int i = 0; i < testNs.length; i++) {
            int n = testNs[i];
            List<List<String>> result = solveNQueens(n);
            boolean passed = compareResults(result, expectedResults.get(i));
            System.out.println("Test for n = " + n);
            System.out.println("Expected: " + expectedResults.get(i));
            System.out.println("Actual:   " + result);
            System.out.println(passed ? "PASS ✅" : "FAIL ❌");
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * Placeholder for interviewee to implement the core logic.
     * Given an integer n, returns all distinct solutions to the n-queens puzzle.
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensHelper(board, 0,n,ans);  // Replace or implement below
        return ans;
    }

    private static void solveNQueensHelper(char board[][], int row, int n, List<List<String>> ans) {
        if(row ==n){
            List<String> current = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                solveNQueensHelper(board, row+1,n,ans);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char board[][], int row, int col, int n){
        //Horizontal
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        //Vertical
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q' ){
                return false;
            }
        }

        //Left Diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q' ){
                return false;
            }
        }

        //Right Diagonal
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q' ){
                return false;
            }
        }

        return true;
    }

    /**
     * Optimal implementation using backtracking and sets for columns and diagonals.
     */
    private static List<List<String>> solveNQueensOptimal(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backtrack(0, board, cols, diag1, diag2, result);
        return result;
    }

    /**
     * Helper method to backtrack through the board and place queens safely.
     */
    private static void backtrack(int row, char[][] board, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(row + 1, board, cols, diag1, diag2, result);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }

    /**
     * Helper method to convert board into list of strings.
     */
    private static List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

    /**
     * Compares two results for testing.
     * Returns true if both contain same board configurations (order-independent).
     */
    private static boolean compareResults(List<List<String>> result1, List<List<String>> result2) {
        Set<Set<String>> set1 = new HashSet<>();
        for (List<String> board : result1) {
            set1.add(new HashSet<>(board));
        }

        Set<Set<String>> set2 = new HashSet<>();
        for (List<String> board : result2) {
            set2.add(new HashSet<>(board));
        }

        return set1.equals(set2);
    }
}
