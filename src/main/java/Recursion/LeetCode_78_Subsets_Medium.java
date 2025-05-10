package Recursion;

/**
 * 1) Category: Backtracking, Bit Manipulation, Arrays
 *
 * 2) Problem Statement:
 *    Given an integer array `nums` of unique elements, return all possible subsets (the power set).
 *    The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * 3) Examples:
 *    Input: nums = [1,2,3]
 *    Output: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *
 *    Input: nums = [0]
 *    Output: [[], [0]]
 *
 * 4) Brute Force Approach:
 *    - Generate all possible combinations using nested loops or by recursive inclusion/exclusion of elements.
 *    - Time Complexity: O(2^n * n) where n is the number of elements in nums.
 *
 * 5) Optimal Approach:
 *    - Use backtracking to explore all subset possibilities.
 *    - Alternatively, use iterative bit masking from 0 to 2^n - 1 to generate subsets.
 *
 * 6) Additional Hints:
 *    - Think recursively: At each step, decide whether to include or exclude the current element.
 *    - Total subsets of a set with n elements is 2^n.
 */

import java.util.*;

public class LeetCode_78_Subsets_Medium {

    public static void main(String[] args) {
        // Sample test cases
        int[][] testCases = {
                {1, 2, 3},
                {0}
        };

        List<List<List<Integer>>> expectedResults = List.of(
                List.of(
                        List.of(), List.of(1), List.of(2), List.of(3),
                        List.of(1, 2), List.of(1, 3), List.of(2, 3),
                        List.of(1, 2, 3)
                ),
                List.of(
                        List.of(), List.of(0)
                )
        );

        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];
            List<List<Integer>> actualOutput = subsets(input);
            List<List<Integer>> expectedOutput = expectedResults.get(i);
            boolean result = compareListOfLists(actualOutput, expectedOutput);
            System.out.println("Test case " + (i + 1) + ": " + (result ? "PASS" : "FAIL"));
            System.out.println("Input: " + Arrays.toString(input));
            System.out.println("Expected: " + expectedOutput);
            System.out.println("Actual: " + actualOutput);
            System.out.println();
        }
    }

    /**
     * Placeholder for subset implementation.
     * Replace this method during a real-world coding interview or self-practice.
     */
    // Method to generate all subsets of the input array
    public static List<List<Integer>> subsets(int[] nums) {
        // List to store all the resulting subsets
        List<List<Integer>> results = new ArrayList<>();

        // Call the helper method starting from index 0 with an empty current list
        subsetsHelper(nums, 0, new ArrayList<>(), results);

        // Return the final list of all subsets
        return results;
    }

    // Recursive helper method to build subsets
    public static void subsetsHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> results) {
        // Base case: if the index reaches the end of the array
        if (index == nums.length) {
            // Add a copy of the current subset to the results list
            results.add(new ArrayList<>(current));
            return; // Backtrack
        }

        // --- Include current element in the subset ---
        current.add(nums[index]); // Add nums[index] to the current subset
        subsetsHelper(nums, index + 1, current, results); // Recurse with next index

        // --- Backtrack and exclude the current element ---
        current.remove(current.size() - 1); // Remove the last added element
        subsetsHelper(nums, index + 1, current, results); // Recurse without including nums[index]
    }

    /**
     * Utility method to compare two lists of lists (ignoring order).
     */
    private static boolean compareListOfLists(List<List<Integer>> a, List<List<Integer>> b) {
        if (a.size() != b.size()) return false;

        Set<Set<Integer>> setA = new HashSet<>();
        Set<Set<Integer>> setB = new HashSet<>();

        for (List<Integer> list : a) setA.add(new HashSet<>(list));
        for (List<Integer> list : b) setB.add(new HashSet<>(list));

        return setA.equals(setB);
    }

    /**
     * Actual implementation using backtracking (Uncomment and replace placeholder to test)
     */
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(0, nums, new ArrayList<>(), result);
//        return result;
//    }
//
//    private static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
//        result.add(new ArrayList<>(current));
//        for (int i = start; i < nums.length; i++) {
//            current.add(nums[i]);
//            backtrack(i + 1, nums, current, result);
//            current.remove(current.size() - 1);
//        }
//    }
}
