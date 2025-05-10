package Recursion;

/*
 * -------------------------------------------------------------------------------------
 * 1) Problem Category:
 *    - This problem belongs to the "Backtracking" and "Recursion" categories.
 *    - It can also be applied to "Bit Manipulation" in non-recursive versions.
 *
 * 2) Problem Statement:
 *    - Given a set represented by an array of unique integers, print all possible subsets (the power set).
 *    - The subsets can be printed in any order.
 *    - Example: For input [1, 2], the subsets are [], [1], [2], [1, 2].
 *
 * 3) Examples:
 *    - Input: [1, 2]
 *      Output: [[], [1], [2], [1, 2]]
 *
 *    - Input: [1, 2, 3]
 *      Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
 *
 * 4) Brute Force Approach:
 *    - Generate all binary combinations of length `n` where each bit indicates inclusion/exclusion of an element.
 *    - Time Complexity: O(2^n), Space: O(2^n * n)
 *
 * 5) Optimum Approach:
 *    - Use recursion and backtracking.
 *    - At each index, decide whether to include the current element in the subset or not.
 *    - This avoids explicit bit manipulation and is easier to implement with recursion.
 *
 * 6) Additional Hints:
 *    - Think in terms of decision trees: for each element, you have two choices: include or exclude.
 *    - Base case occurs when you've processed all elements (i.e., index == array.length).
 *
 * 7) Verification:
 *    - The main method will compare actual vs expected output.
 *    - It will print PASS if outputs match, FAIL otherwise.
 * -------------------------------------------------------------------------------------
 */

import java.util.*;

public class PrintAllSubsets {

    // -------------------------------
    // Placeholder for recursive method
    // -------------------------------
    private static void findSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        //Base case
        if(index == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        findSubsets(nums,index+1,current, result);

        current.remove(current.size()-1);
        findSubsets(nums,index+1,current, result);
    }


    // ---------------------------------------------
    // Recursive implementation (actual logic below)
    // ---------------------------------------------
    private static void findSubsets_THEANSWER(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(nums[index]);
        findSubsets_THEANSWER(nums, index + 1, current, result);

        // Exclude the current element (backtrack)
        current.remove(current.size() - 1);
        findSubsets_THEANSWER(nums, index + 1, current, result);
    }

    // --------------------------
    // Helper to run a test case
    // --------------------------
    public static void runTestCase(int[] input, List<List<Integer>> expected) {
        List<List<Integer>> actual = new ArrayList<>();
        findSubsets(input, 0, new ArrayList<>(), actual);

        // Sort results for comparison
        sortList(actual);
        sortList(expected);

        boolean pass = actual.equals(expected);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Expected: " + expected);
        System.out.println("Actual  : " + actual);
        System.out.println(pass ? "Status : PASS ✅\n" : "Status : FAIL ❌\n");
    }

    // --------------------------
    // Helper to sort the subsets
    // --------------------------
    private static void sortList(List<List<Integer>> list) {
        for (List<Integer> sublist : list) {
            Collections.sort(sublist);
        }
        list.sort(Comparator.comparing(Object::toString));
    }

    // --------------------------
    // Main method to test cases
    // --------------------------
    public static void main(String[] args) {
        // Test Case 1
        runTestCase(new int[]{1, 2}, Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2)
        ));

        // Test Case 2
        runTestCase(new int[]{1, 2, 3}, Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        ));
    }
}
