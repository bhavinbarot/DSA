package Array_String;
/**
 * Category: Arrays, Sorting, Two Pointers
 *
 * 2) Problem Description:
 * Given an integer array `nums`, return the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 *
 * A triplet (i, j, k) forms a triangle if:
 *   nums[i] + nums[j] > nums[k],
 *   nums[i] + nums[k] > nums[j], and
 *   nums[j] + nums[k] > nums[i]
 * Since the array will be sorted, we can simplify this by:
 *   nums[i] + nums[j] > nums[k]
 * if i < j < k
 *
 * 3) Examples:
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * (2,3,4), (2,3,4), (2,2,3)
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 * Explanation: Valid combinations are:
 * (2,3,4), (2,4,4), (3,4,4), (4,4,4)
 *
 * 4) Brute Force Approach:
 * - Use 3 nested loops (i, j, k) and check for each triplet whether it can form a triangle.
 * - Time Complexity: O(n^3)
 *
 * 5) Optimal Approach:
 * - Sort the array.
 * - Fix the third side (k), and use two pointers (i = 0, j = k - 1) to find pairs (i, j) such that nums[i] + nums[j] > nums[k].
 * - Time Complexity: O(n^2)
 *
 * 6) Additional Hints:
 * - The triangle inequality helps reduce complexity.
 * - Sorting is a key step in optimizing the check.
 *
 * 7) Actual answers and expected answers are printed with PASS/FAIL status.
 */

public class LeetCode_611_ValidTriangleNumber_Medium {

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {2, 2, 3, 4},
                {4, 2, 3, 4},
                {1, 1, 1, 1},
                {1, 2, 3},
                {3, 4, 6, 7}
        };

        int[] expectedResults = {
                3, 4, 4, 0, 7
        };

        // Run tests
        for (int i = 0; i < testCases.length; i++) {
            int result = validTriangleNumber(testCases[i]);
            boolean isPass = result == expectedResults[i];
            System.out.printf("Test Case #%d: Expected = %d, Got = %d --> %s%n",
                    i + 1, expectedResults[i], result, (isPass ? "PASS" : "FAIL"));
        }
    }

    /**
     * Placeholder method to simulate real-world interview.
     * Implement the optimal solution inside this method.
     */
    public static int validTriangleNumber(int[] nums) {
        int counter = 0;
        int firstIndex = nums[0];
        int secondIndex = nums[0];
        //return optimizedTwoPointerSolution(nums);
        return 0;
    }

    /**
     * Brute force approach - O(n^3) time complexity
     */
    public static int bruteForceSolution(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isTriangle(nums[i], nums[j], nums[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Helper method to check if three sides can form a triangle
     */
    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    /**
     * Optimized approach - O(n^2) time using sorting and two pointers
     */
    public static int optimizedTwoPointerSolution(int[] nums) {
        java.util.Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // all elements between i and j will form valid triangle
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
