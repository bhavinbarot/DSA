package Recursion;

import java.util.*;

public class LeetCode_90_Subsets_II_Medium {

    /*
     * 1) DSA Problem Category:
     *    Arrays, Backtracking, Sorting
     *
     * 2) Problem Description:
     *    Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).
     *    The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     * 3) Examples:
     *    Example 1:
     *      Input: nums = [1,2,2]
     *      Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     *
     *    Example 2:
     *      Input: nums = [0]
     *      Output: [[], [0]]
     *
     * 4) Brute Force Approach:
     *    - Generate all subsets using bit manipulation or recursion.
     *    - Use a Set to eliminate duplicate subsets (by storing sorted subsets).
     *    - Time Complexity: O(2^n * n), Space: O(2^n)
     *
     * 5) Optimal Approach:
     *    - Sort the array first to bring duplicates together.
     *    - Use backtracking to explore all combinations while skipping duplicates intelligently.
     *    - Time Complexity: O(2^n), Space: O(n) for recursion stack.
     *
     * 6) Additional Hints:
     *    - Sorting the array is key to skipping duplicate elements in backtracking.
     *    - Use a boolean to track when to skip duplicates during recursion.
     */

    public static void main(String[] args) {
        // Test Cases
        int[][] testCases = {
                {1, 2, 2},
                {0},
                {1, 1},
                {4, 4, 4, 1, 4}
        };

        // Expected outputs for verification
        List<List<List<Integer>>> expectedOutputs = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(), Arrays.asList(1), Arrays.asList(1,2), Arrays.asList(1,2,2),
                        Arrays.asList(2), Arrays.asList(2,2)
                ),
                Arrays.asList(
                        Arrays.asList(), Arrays.asList(0)
                ),
                Arrays.asList(
                        Arrays.asList(), Arrays.asList(1), Arrays.asList(1, 1)
                ),
                Arrays.asList(
                        Arrays.asList(), Arrays.asList(1), Arrays.asList(4), Arrays.asList(1, 4),
                        Arrays.asList(4, 4), Arrays.asList(1, 4, 4), Arrays.asList(4, 4, 4),
                        Arrays.asList(1, 4, 4, 4), Arrays.asList(4, 4, 4, 4), Arrays.asList(1, 4, 4, 4, 4)
                )
        );

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            List<List<Integer>> expected = expectedOutputs.get(i);
            List<List<Integer>> actual = subsetsWithDup(testCase);

            boolean passed = compareListOfLists(expected, actual);
            System.out.println("Test Case " + (i + 1) + ": " + (passed ? "PASS ✅" : "FAIL ❌"));
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + actual);
            System.out.println("--------------------------------------------------");
        }
    }

    /**
     * Placeholder for implementation.
     * This method should return all possible subsets of the given array,
     * ensuring no duplicate subsets.
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupImpl(nums, 0, new ArrayList<>(), results);
        return results;
    }

    public static void subsetsWithDupImpl(int[] nums, int index, List<Integer> current, List<List<Integer>> results) {
        // Base case: if the index reaches the end of the array
        if (index == nums.length) {
            // Add a copy of the current subset to the results list
            results.add(new ArrayList<>(current));
            return; // Backtrack
        }
        // --- Include current element in the subset ---
        current.add(nums[index]);
        subsetsWithDupImpl(nums, index+1, current, results);

        // --- Backtrack and exclude the current element ---
        current.remove(current.size()-1); //Remove the last added element
        //{1,2,2,3,4} if current value is same as previous value. e.g.index = 2, then while backtracking, exclude all duplicate values.
        int idx = index+1;
        while(idx < nums.length && nums[idx] == nums[idx-1]){
            idx++;
        }
        subsetsWithDupImpl(nums, idx, current, results);

    }

    public static void subsetsWithDupImpl_chatGptSolution(int[] nums, int index, List<Integer> current, List<List<Integer>> results) {

        // Step 1: Add the current subset to the result list.
        // It's important to add a *copy* of the current list, since it will be modified later.
        results.add(new ArrayList<>(current));

        // Step 2: Iterate through the remaining elements starting from the given index.
        for (int i = index; i < nums.length; i++) {

            // Step 3: Skip duplicate elements at the same recursive level.
            // If nums[i] == nums[i - 1], and we’re at the same depth (i > index),
            // we've already processed the value at nums[i] in this level of recursion.
            if (i > index && nums[i] == nums[i - 1]) continue;

            // Step 4: Choose the current number (include nums[i] in the subset).
            current.add(nums[i]);

            // Step 5: Recurse with the next index (i + 1), building further subsets.
            subsetsWithDupImpl_chatGptSolution(nums, i + 1, current, results);

            // Step 6: Backtrack - remove the last added element to explore other combinations.
            current.remove(current.size() - 1);
        }
    }

    /**
     * Compares two lists of lists regardless of order.
     */
    private static boolean compareListOfLists(List<List<Integer>> l1, List<List<Integer>> l2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (List<Integer> list : l1) {
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            set1.add(sorted.toString());
        }

        for (List<Integer> list : l2) {
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            set2.add(sorted.toString());
        }

        return set1.equals(set2);
    }

    /**
     * OPTIMAL SOLUTION (UNCOMMENT THIS AFTER INTERVIEW PRACTICE)
     * Backtracking solution that avoids duplicates.
     */
    /*
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    */
}

