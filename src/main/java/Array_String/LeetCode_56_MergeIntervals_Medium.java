package Array_String;

// LeetCode Problem 56 - Merge Intervals [Medium]
// DSA Category: Arrays / Sorting / Greedy

/*
1) DSA Problem Category:
   - Arrays
   - Sorting
   - Greedy

2) Problem Description:
   Given an array of intervals where intervals[i] = [start_i, end_i],
   merge all overlapping intervals, and return an array of the non-overlapping intervals
   that cover all the intervals in the input.

3) Examples:
   Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
   Output: [[1,6],[8,10],[15,18]]

   Input: intervals = [[1,4],[4,5]]
   Output: [[1,5]]

4) Brute Force Approach:
   - Compare each interval with every other interval to check if they overlap.
   - Merge them if they do, and repeat until no more overlapping intervals exist.
   - Time Complexity: O(n^2), inefficient for large inputs.

5) Optimal Approach:
   - Sort the intervals by starting time.
   - Iterate through the sorted list, merging overlapping intervals by comparing end times.
   - Time Complexity: O(n log n) due to sorting, and O(n) for the merge process.

6) Additional Hints:
   - Sorting is key to make this problem easier.
   - Think about how you would draw overlapping intervals on a timeline.

7) The program prints:
   - Actual outputs
   - Expected outputs
   - Comparison of both with PASS/FAIL status
*/

import java.util.*;

public class LeetCode_56_MergeIntervals_Medium {

    public static void main(String[] args) {
        // Test cases
        int[][][] testCases = {
                {{1,3}, {2,6}, {8,10}, {15,18}},
                {{1,4}, {4,5}},
                {{1,4}, {2,3}},
                {{1,4}, {0,2}, {3,5}},
                {{1,4}, {5,6}}
        };

        int[][][] expectedResults = {
                {{1,6}, {8,10}, {15,18}},
                {{1,5}},
                {{1,4}},
                {{0,5}},
                {{1,4}, {5,6}}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[][] result = merge(testCases[i]); // Placeholder for implementation
            boolean pass = compareResults(result, expectedResults[i]);
            System.out.println("Test Case " + (i + 1) + ": " + (pass ? "PASS ✅" : "FAIL ❌"));
            System.out.println("Expected: " + Arrays.deepToString(expectedResults[i]));
            System.out.println("Actual  : " + Arrays.deepToString(result));
            System.out.println("----------------------------------------------------");
        }
    }

    /**
     * Implementation method for merging intervals.
     * This is the method you would implement in a real-world coding interview.
     *
     * @param intervals Array of intervals to be merged
     * @return Merged intervals
     */
    public static int[][] merge(int[][] intervals) {
        // Create a dynamic list to store the merged intervals
        ArrayList<int[]> results = new ArrayList();

        // Sort the intervals based on the starting value of each interval
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Initialize the first interval as the starting point for merging
        int previousStartIndex = intervals[0][0];
        int previousEndIndex = intervals[0][1];

        // Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentStartIndex = intervals[i][0];
            int currentEndIndex = intervals[i][1];

            // If the previous interval ends before the current one starts,
            // there is no overlap, so add the previous interval to the result
            if (previousEndIndex < currentStartIndex) {
                int temp[] = {previousStartIndex, previousEndIndex};
                results.add(temp); // Save the previous interval

                // Update the tracking variables to the current interval
                previousStartIndex = currentStartIndex;
                previousEndIndex = currentEndIndex;

            } else {
                // If intervals overlap, merge them by updating the end to the maximum
                previousEndIndex = Math.max(previousEndIndex, currentEndIndex);
            }
        }

        // After the loop, add the last merged interval
        int temp[] = {previousStartIndex, previousEndIndex};
        results.add(temp);

        // Convert the list of arrays back to a 2D array and return it
        return results.toArray(new int[results.size()][]);
    }


    /**
     * Helper method to compare two 2D arrays irrespective of internal order
     *
     * @param a First 2D array
     * @param b Second 2D array
     * @return true if both arrays represent the same set of intervals
     */
    private static boolean compareResults(int[][] a, int[][] b) {
        if (a.length != b.length) return false;

        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(b, Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < a.length; i++) {
            if (a[i][0] != b[i][0] || a[i][1] != b[i][1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Actual implementation method for optimal approach (can be filled in later)
     */
    public static int[][] mergeIntervalsOptimal(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping interval, add to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
