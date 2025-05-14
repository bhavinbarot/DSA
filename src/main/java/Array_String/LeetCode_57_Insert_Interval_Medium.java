package Array_String;

import java.util.ArrayList;

/**
 * LeetCode_57_Insert_Interval_Medium
 *
 * Problem Category: Arrays
 *
 * Problem Statement:
 * Given a set of non-overlapping intervals sorted by their start times, and a new interval,
 * insert the new interval into the intervals (merge if necessary). The intervals are sorted by their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * Brute Force Approach:
 * 1. Insert the new interval into the sorted list of intervals.
 * 2. Merge overlapping intervals by iterating through the list and combining intervals that overlap.
 * 3. Return the merged list of intervals.
 *
 * Optimal Approach:
 * 1. Initialize an empty list to store the result.
 * 2. Iterate through the intervals:
 *    - Add all intervals that end before the new interval starts.
 *    - Merge all intervals that overlap with the new interval.
 *    - Add all intervals that start after the new interval ends.
 * 3. Return the result.
 *
 * Additional Hints:
 * - The input intervals are sorted by their start times.
 * - The new interval may overlap with one or more existing intervals.
 * - Ensure that the final list of intervals is sorted and non-overlapping.
 *
 * The program will print the expected and actual outputs for each test case and indicate whether the test passed or failed.
 */

public class LeetCode_57_Insert_Interval_Medium {

    public static void main(String[] args) {
        // Test cases
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] expected1 = {{1, 5}, {6, 9}};
        runTest(intervals1, newInterval1, expected1);

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] expected2 = {{1, 2}, {3, 10}, {12, 16}};
        runTest(intervals2, newInterval2, expected2);
    }

    // Placeholder for the insert method implementation
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null) return null;

        ArrayList<int []> results = new ArrayList<>();

        int i = 0;
            while(i < intervals.length){
                int currentStart = intervals[i][0];
                int currentEnd = intervals[i][1];
                int targetStart = newInterval[0];
                int targetEnd = newInterval[1];
                //If non overlapping
                if(currentEnd < targetStart || currentStart > targetEnd){
                    //Add to final array
                    results.add(new int[]{currentStart, currentEnd});
                    i++;
                }else{
                    //If it is overlapping
                    //Keep the Left Interval and Right Interval
                    int left = currentStart;
                    int right = Math.max(currentEnd, targetEnd);
                    boolean overlapFound = false;
                    while(intervals[i][1] >= targetStart && intervals[i][0] <= targetEnd){  //Overlapping condition while tempEnd > targetStart OR tempStart < targetEnd
                        left = Math.min(left, intervals[i][0]);
                        right = Math.max(right, intervals[i][1]);
                        i++;
                        overlapFound = true;
                    }
                    int tempOverlap[] = {left, right};
                    results.add(tempOverlap);
                    if(!overlapFound){
                        i++;
                    }
                }
            }



        return results.toArray(new int[results.size()][]);
    }

    // Helper method to run a test case
    private static void runTest(int[][] intervals, int[] newInterval, int[][] expected) {
        int[][] result = insert(intervals, newInterval);
        if (arraysEqual(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected: " + arrayToString(expected));
            System.out.println("Actual: " + arrayToString(result));
        }
    }

    // Helper method to compare two 2D arrays
    private static boolean arraysEqual(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i][0] != arr2[i][0] || arr1[i][1] != arr2[i][1]) {
                return false;
            }
        }
        return true;
    }

    // Helper method to convert a 2D array to a string
    private static String arrayToString(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("[").append(arr[i][0]).append(", ").append(arr[i][1]).append("]");
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
