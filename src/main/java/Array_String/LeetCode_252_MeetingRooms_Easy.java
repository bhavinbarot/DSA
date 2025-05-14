package Array_String;

// Category: Arrays, Sorting
//
// LeetCode Problem 252: Meeting Rooms
// Difficulty: Easy
//
// Problem Statement:
// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
//
// Examples:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: false
//
// Input: intervals = [[7,10],[2,4]]
// Output: true
//
// Brute Force Approach:
// - Compare every pair of intervals to check if they overlap.
// - Time Complexity: O(n^2)
//
// Optimal Approach:
// - Sort the intervals by start time.
// - Check if the current meeting starts before the previous one ends.
// - Time Complexity: O(n log n), Space Complexity: O(1)
//
// Additional Hints:
// - Focus on sorting the intervals to make comparisons easier.
// - Overlapping means that one meeting starts before the previous one ends.

import java.util.Arrays;

public class LeetCode_252_MeetingRooms_Easy {

    public static void main(String[] args) {
        // Test cases
        int[][][] testCases = {
                { {0, 30}, {5, 10}, {15, 20} },
                { {7, 10}, {2, 4} },
                { {1, 5}, {6, 10}, {11, 15} },
                { {1, 10}, {2, 6}, {5, 8} }
        };

        boolean[] expectedResults = {
                false,
                true,
                true,
                false
        };

        for (int i = 0; i < testCases.length; i++) {
            boolean actual = canAttendMeetings(testCases[i]);  // <- Placeholder for implementation
            boolean expected = expectedResults[i];
            System.out.println("Test Case " + (i + 1) + ": " +
                    (actual == expected ? "PASS" : "FAIL") +
                    " | Expected: " + expected + ", Actual: " + actual);
        }
    }

    /**
     * Determines if a person can attend all given meetings without overlaps.
     *
     * @param intervals - a 2D array of meeting intervals
     * @return true if a person can attend all meetings, false otherwise
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }

        return true;
    }

    /**
     * Helper function to print intervals - useful for debugging.
     */
    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }

    /**
     * Optional: Brute force method for reference or comparison.
     */
    public static boolean canAttendMeetingsBruteForce(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (isOverlapping(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if two intervals overlap.
     */
    private static boolean isOverlapping(int[] a, int[] b) {
        return Math.min(a[1], b[1]) > Math.max(a[0], b[0]);
    }
}
