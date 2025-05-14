package Array_String;

/*
 * LeetCode Problem: 435 - Non-overlapping Intervals (Medium)
 *
 * 1) DSA Category:
 *    - Greedy Algorithm
 *    - Sorting
 *
 * 2) Problem Statement:
 *    Given an array of intervals `intervals` where intervals[i] = [starti, endi],
 *    return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * 3) Examples:
 *    Example 1:
 *      Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 *      Output: 1
 *      Explanation: Remove [1,3] then the rest of the intervals are non-overlapping.
 *
 *    Example 2:
 *      Input: intervals = [[1,2],[1,2],[1,2]]
 *      Output: 2
 *      Explanation: You need to remove two [1,2] to make the rest non-overlapping.
 *
 *    Example 3:
 *      Input: intervals = [[1,2],[2,3]]
 *      Output: 0
 *
 * 4) Brute Force Approach:
 *    - Try removing every possible combination of intervals and check if the remaining are non-overlapping.
 *    - Time Complexity: O(2^n)
 *
 * 5) Optimal Approach:
 *    - Sort intervals by end time.
 *    - Use a greedy strategy: always keep the interval with the smallest end time that doesn't overlap with the previous.
 *    - Count and remove overlapping intervals.
 *    - Time Complexity: O(n log n) for sorting + O(n) for traversal.
 *
 * 6) Additional Hints:
 *    - This is similar to the activity selection problem.
 *    - Sorting by end time helps ensure we leave room for future intervals.
 *
 * 7) Test Cases Execution:
 *    - The main method includes multiple test cases and prints PASS/FAIL based on the expected output.
 */

import java.util.*;

public class LeetCode_435_NonOverlappingIntervals_Medium_PENDING {

    // === Placeholder for implementation method ===
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: if the input is null, return 0 (no intervals to process)
        if (intervals == null) return 0;

        // Step 1: Sort the intervals by their end times in ascending order
        // This helps us always choose the interval that ends earliest, maximizing room for future intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Step 2: Initialize the count of non-overlapping intervals we can keep
        // Start with the first interval, so count is 1
        int count = 1;

        // Step 3: Track the index of the last interval added to our non-overlapping set
        int previousIndex = 0;

        // Step 4: Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts after or when the previous one ends, it's non-overlapping
            if (intervals[i][0] >= intervals[previousIndex][1]) {
                count++; // We can keep this interval
                previousIndex = i; // Update previous index to current one
            }
            // Else: current interval overlaps with the previous one, so we skip it (consider it removed)
        }

        // Step 5: Total intervals - count of non-overlapping intervals gives the number of intervals to remove
        return intervals.length - count;
    }


    // === Main Method with Test Cases ===
    public static void main(String[] args) {
        LeetCode_435_NonOverlappingIntervals_Medium_PENDING solver = new LeetCode_435_NonOverlappingIntervals_Medium_PENDING();

        runTest(solver, new int[][]{{1,2},{2,3},{3,4},{1,3}}, 1);
        runTest(solver, new int[][]{{1,2},{1,2},{1,2}}, 2);
        runTest(solver, new int[][]{{1,2},{2,3}}, 0);
        runTest(solver, new int[][]{{1,100},{11,22},{1,11},{2,12}}, 2);
    }

    // === Helper Method to Run and Validate Tests ===
    private static void runTest(LeetCode_435_NonOverlappingIntervals_Medium_PENDING solver, int[][] input, int expected) {
        int result = solver.eraseOverlapIntervals(input);
        if (result == expected) {
            System.out.println("Test Passed ✅ | Expected: " + expected + ", Got: " + result);
        } else {
            System.out.println("Test Failed ❌ | Expected: " + expected + ", Got: " + result);
        }
    }

    // === (Optional) Utility Method: Sorting and Debugging Intervals ===
    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}
