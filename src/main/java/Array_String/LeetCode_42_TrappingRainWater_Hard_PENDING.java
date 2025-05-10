package Array_String;

/**
 * LeetCode Problem: 42
 * Title: Trapping Rain Water
 * Difficulty: Hard
 *
 * 1) DSA Category:
 *    - Arrays
 *    - Two Pointers
 *    - Stack
 *    - Dynamic Programming
 *
 * 2) Problem Statement:
 *    Given n non-negative integers representing an elevation map where the width of each bar is 1,
 *    compute how much water it can trap after raining.
 *
 * 3) Examples:
 *    Example 1:
 *      Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *      Output: 6
 *
 *    Example 2:
 *      Input: height = [4,2,0,3,2,5]
 *      Output: 9
 *
 * 4) Brute Force Approach:
 *    - For each element, find the max height on the left and right.
 *    - Take the minimum of those two and subtract the current height.
 *    - Time Complexity: O(n^2), Space Complexity: O(1)
 *
 * 5) Optimal Approach:
 *    - Use two-pointer approach or precomputed arrays (leftMax/rightMax).
 *    - Two-pointer solution has Time Complexity: O(n), Space Complexity: O(1)
 *
 * 6) Additional Hints:
 *    - Water trapped at index i = min(maxLeft, maxRight) - height[i]
 *    - If maxLeft < maxRight, move from the left.
 *    - Else move from the right.
 */

public class LeetCode_42_TrappingRainWater_Hard_PENDING {

    // ====== PLACEHOLDER FOR ACTUAL INTERVIEW IMPLEMENTATION ======
    // Implement this method during a real coding interview
    public static int trap(int[] height) {
        // TODO: Implement optimized two-pointer solution
        return -1; // placeholder return
    }

    // ========== MAIN METHOD FOR TESTING ==========

    public static void main(String[] args) {
        // Test Cases
        int[][] testCases = {
                {0,1,0,2,1,0,1,3,2,1,2,1},  // Expected: 6
                {4,2,0,3,2,5},              // Expected: 9
                {1,0,2,1,0,1,3},            // Expected: 5
                {2,0,2},                    // Expected: 2
                {3,0,0,2,0,4}               // Expected: 10
        };

        int[] expectedResults = {6, 9, 5, 2, 10};

        System.out.println("Running Test Cases for LeetCode 42: Trapping Rain Water");

        for (int i = 0; i < testCases.length; i++) {
            int result = trapSolution(testCases[i]); // Using working solution
            boolean pass = result == expectedResults[i];
            System.out.printf("Test Case %d: Expected = %d, Actual = %d --> %s\n",
                    i + 1, expectedResults[i], result, pass ? "PASS" : "FAIL");
        }
    }

    // ========== WORKING SOLUTION FOR COMPARISON / VALIDATION ==========
    // Two Pointer Solution (Optimal)
    public static int trapSolution(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}

