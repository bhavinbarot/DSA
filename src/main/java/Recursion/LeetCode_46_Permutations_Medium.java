package Recursion;

/**
 * 1) DSA Problem Category:
 *    Arrays, Backtracking
 *
 * 2) Problem Statement (Leetcode #46 - Permutations):
 *    Given an array nums of distinct integers, return all the possible permutations.
 *    You can return the answer in any order.
 *
 * 3) Examples:
 *    Input: nums = [1,2,3]
 *    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *    Input: nums = [0,1]
 *    Output: [[0,1],[1,0]]
 *
 *    Input: nums = [1]
 *    Output: [[1]]
 *
 * 4) Brute Force Approach:
 *    Generate all possible arrangements using recursion and list tracking.
 *    Check if the element has already been used before adding to the current list.
 *
 * 5) Optimal Approach:
 *    Use backtracking by swapping elements in place to reduce memory usage and overhead.
 *    For each position, swap with all following elements and recurse.
 *
 * 6) Additional Hints:
 *    - Backtracking is a classic technique used for such problems.
 *    - Use a visited boolean array or in-place swapping to track used elements.
 *    - Use a helper function for recursion with current state and results.
 */

import java.util.*;

public class LeetCode_46_Permutations_Medium {

    public static void main(String[] args) {
        testPermutations();
    }

    /**
     * Placeholder for the real implementation.
     * This simulates a real-world interview scenario where you'd need to implement this method.
     */
    public List<List<Integer>> permute(int[] nums) {
        // TODO: Implement your backtracking logic here.
        List<List<Integer>> results = new ArrayList<>();
        permuteHelper(nums, 0,results);

        return results;
    }

    public void permuteHelper(int[] nums, int index, List<List<Integer>> results) {
        printCurrentArray(nums,"Calling permuteHelper with Index="+index);
        if(index == nums.length){
            printCurrentArray(nums,"Base Condition met. Adding this to Results:::::::::::");
            ArrayList<Integer> subArray = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                subArray.add(nums[j]);
            }
            results.add(subArray);
            return;
        }

        for(int i=index ; i<nums.length;i++){
            swap(nums,index, i);
            printCurrentArray(nums,">>PreSWAP : Index="+index + " i="+i);
            permuteHelper(nums, index+1,results);
            swap(nums,index, i);
            printCurrentArray(nums,"<<PostSWAP : Index="+index + " i="+i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void printCurrentArray(int nums[], String comment){
        System.out.printf(comment);
        System.out.printf(" : nums -> ");
        for(int i=0;i<nums.length;i++){
            System.out.printf("%d->", nums[i]);
        }
        System.out.printf("\n");
    }


    /**
     * Testing helper to validate actual output with expected output
     */
    private static void testPermutations() {
        LeetCode_46_Permutations_Medium solver = new LeetCode_46_Permutations_Medium();

        int[][] testCases = {
                {1, 2, 3},
                {0, 1},
                {1}
        };

        List<List<List<Integer>>> expectedResults = new ArrayList<>();
        expectedResults.add(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));
        expectedResults.add(Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 0)
        ));
        expectedResults.add(Arrays.asList(
                Arrays.asList(1)
        ));

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            List<List<Integer>> expected = expectedResults.get(i);
            List<List<Integer>> actual = solver.permute(testCase);

            boolean passed = comparePermutations(expected, actual);
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
            System.out.println(passed ? "PASS ✅" : "FAIL ❌");
            System.out.println("--------------------------");
        }
    }

    /**
     * Compares two permutation lists (ignoring order of inner lists).
     */
    private static boolean comparePermutations(List<List<Integer>> expected, List<List<Integer>> actual) {
        Set<String> expectedSet = new HashSet<>();
        Set<String> actualSet = new HashSet<>();

        for (List<Integer> perm : expected) {
            expectedSet.add(perm.toString());
        }
        for (List<Integer> perm : actual) {
            actualSet.add(perm.toString());
        }
        return expectedSet.equals(actualSet);
    }
}
