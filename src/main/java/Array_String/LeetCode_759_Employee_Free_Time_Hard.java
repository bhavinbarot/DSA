package Array_String;

/*
 * LeetCode_759_Employee_Free_Time_Hard.java
 *
 * Problem Category: Intervals, Sorting, Merging Intervals
 *
 * Problem Statement:
 * Given a list of employees' schedules, each containing a list of non-overlapping intervals representing their working hours,
 * return the list of intervals during which all employees are free.
 *
 * Example 1:
 * Input: [[[1,2],[5,6]],[[1,3]],[[2,4]]]
 * Output: [[3,5]]
 *
 * Example 2:
 * Input: [[[1,3],[6,7]],[[2,4]],[[2,3],[9,12]]]
 * Output: [[4,6],[7,9]]
 *
 * Brute Force Approach:
 * 1. Flatten the list of intervals from all employees.
 * 2. Sort the intervals by start time.
 * 3. Merge overlapping intervals.
 * 4. Identify gaps between merged intervals as free time.
 *
 * Optimal Approach:
 * 1. Use a priority queue (min-heap) to efficiently merge intervals.
 * 2. Track the end time of the last merged interval.
 * 3. Identify gaps between intervals as free time.
 *
 * Time Complexity:
 * - Sorting intervals: O(N log N), where N is the total number of intervals.
 * - Merging intervals: O(N).
 * Total: O(N log N).
 *
 * Space Complexity:
 * - O(N) for storing intervals.
 *
 * The following code implements the optimal approach.
 */

import java.util.*;

public class LeetCode_759_Employee_Free_Time_Hard {

    // Definition for an interval.
    public static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    // Placeholder for the implementation method
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> freeIntervals = new ArrayList<>();
        List<Interval> availableIntervals = new ArrayList<>();
        for(int i=0; i<schedule.size();i++){
            for(int j=0;j<schedule.get(i).size();j++){
                availableIntervals.add(schedule.get(i).get(j));
            }
        }
        availableIntervals.sort(Comparator.comparingInt(a -> a.start));

        int prevStartIndex = availableIntervals.get(0).start;
        int prevEndIndex = availableIntervals.get(0).end;
        for(int k=1;k<availableIntervals.size();k++){
            int currentStartIndex = availableIntervals.get(k).start;
            int currentEndIndex = availableIntervals.get(k).end;
            if(currentStartIndex > prevEndIndex){ //New time
                freeIntervals.add(new Interval(prevEndIndex,currentStartIndex));
                prevStartIndex = currentStartIndex;
                prevEndIndex = currentEndIndex;
            }else{
                prevStartIndex = Math.min(prevStartIndex, currentStartIndex);
                prevEndIndex = Math.max(prevEndIndex, currentEndIndex);
            }

        }

        return freeIntervals;
    }

    // Method to flatten the list of intervals from all employees
    private List<Interval> flattenSchedule(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> employeeSchedule : schedule) {
            intervals.addAll(employeeSchedule);
        }
        return intervals;
    }

    // Method to sort intervals by start time
    private void sortIntervals(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
    }

    // Method to merge overlapping intervals
    private List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        if (intervals.isEmpty()) {
            return merged;
        }

        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);
        return merged;
    }

    // Method to find free time intervals
    private List<Interval> findFreeTime(List<Interval> mergedIntervals) {
        List<Interval> freeTime = new ArrayList<>();
        for (int i = 1; i < mergedIntervals.size(); i++) {
            Interval prev = mergedIntervals.get(i - 1);
            Interval curr = mergedIntervals.get(i);
            if (prev.end < curr.start) {
                freeTime.add(new Interval(prev.end, curr.start));
            }
        }
        return freeTime;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        LeetCode_759_Employee_Free_Time_Hard solution = new LeetCode_759_Employee_Free_Time_Hard();

        // Test case 1
        List<List<Interval>> schedule1 = Arrays.asList(
                Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)),
                Arrays.asList(new Interval(2, 4))
        );
        List<Interval> result1 = solution.employeeFreeTime(schedule1);
        System.out.println("Test Case 1:");
        printIntervals(result1);

        // Test case 2
        List<List<Interval>> schedule2 = Arrays.asList(
                Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                Arrays.asList(new Interval(2, 4)),
                Arrays.asList(new Interval(2, 3), new Interval(9, 12))
        );
        List<Interval> result2 = solution.employeeFreeTime(schedule2);
        System.out.println("Test Case 2:");
        printIntervals(result2);
    }

    // Helper method to print intervals
    private static void printIntervals(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            System.out.println("No free time available.");
        } else {
            for (Interval interval : intervals) {
                System.out.println("[" + interval.start + ", " + interval.end + "]");
            }
        }
    }
}
