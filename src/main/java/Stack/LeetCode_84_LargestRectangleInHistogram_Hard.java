package Stack;

import java.util.Arrays;

/**
 * LeetCode Problem #84: Largest Rectangle in Histogram
 *
 * 1) Problem Category:
 *    - Arrays
 *    - Stack (Monotonic Stack)
 *    - Greedy
 *
 * 2) Problem Statement:
 *    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 *    return the area of the largest rectangle in the histogram.
 *
 * 3) Examples:
 *    Input: heights = [2,1,5,6,2,3]
 *    Output: 10
 *    Explanation: The rectangle with area 10 is formed by heights[2] and heights[3] => 5 and 6.
 *
 *    Input: heights = [2,4]
 *    Output: 4
 *
 *    Input: heights = [2,1,2]
 *    Output: 3
 *
 * 4) Brute Force Approach:
 *    - For each bar, expand to the left and right while the bars are >= current height.
 *    - Time Complexity: O(n^2)
 *
 * 5) Optimal Approach:
 *    - Use a monotonic increasing stack.
 *    - For each bar, maintain index of bars in ascending order.
 *    - When a smaller height comes, calculate area using previous heights.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * 6) Additional Hints:
 *    - Think in terms of maintaining left and right bounds for each height.
 *    - Stack helps in identifying previous and next smaller elements.
 *
 * 7) Outputs and Testing:
 *    - Actual outputs are compared with expected outputs.
 *    - Result is printed as PASS or FAIL.
 */

public class LeetCode_84_LargestRectangleInHistogram_Hard {

    public static void main(String[] args) {
        // Test cases with expected outputs
        int[][] testCases = {
                {2, 1, 5, 6, 2, 3}, // Expected: 10
                {2, 4},             // Expected: 4
                {2, 1, 2},          // Expected: 3
                {6, 2, 5, 4, 5, 1, 6} // Expected: 12
        };
        int[] expected = {10, 4, 3, 12};

        for (int i = 0; i < testCases.length; i++) {
            int result = largestRectangleArea(testCases[i]);
            System.out.printf("Test %d: Expected = %d, Actual = %d => %s\n",
                    i + 1, expected[i], result, (result == expected[i]) ? "PASS" : "FAIL");
        }
    }

    /**
     * Placeholder for the actual implementation method.
     * You can use this signature in a real interview scenario.
     */
    public static int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        System.out.println(Arrays.toString(heights));
        for(int i = 0 ; i < heights.length ; i++){
            int height = heights[i];
            for(int j=i; j < heights.length ; j++){
                int width = j-i+1; //width
                height = Math.min(height, heights[j]);
                largestArea = Math.max(largestArea, width*height);
                //System.out.printf("i=%d, j=%d, heights[i]=%d, heights[j]=%d, height=%d, CurrentArea=%d, LargestArea=%d\n", i,j,heights[i], heights[j], height, width*height, largestArea);
            }
        }
        return largestArea; // For now, delegate to real implementation
    }

    /**
     * Actual implementation using a monotonic stack.
     * This method computes the largest rectangle in histogram in O(n) time.
     */
    private static int computeLargestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        // Stack to store indices
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            // Process the stack while the current height is less than the stack's top height
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
