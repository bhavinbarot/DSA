package Recursion;

/**
 * LeetCode Problem: 704 - Binary Search - Easy
 *
 * 1) DSA Problem Category:
 *    - Arrays
 *    - Binary Search
 *
 * 2) Problem Description:
 *    Given an array of integers nums which is sorted in ascending order, and an integer target,
 *    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *    You must write an algorithm with O(log n) runtime complexity.
 *
 * 3) Examples:
 *    Example 1:
 *    Input: nums = [-1,0,3,5,9,12], target = 9
 *    Output: 4
 *
 *    Example 2:
 *    Input: nums = [-1,0,3,5,9,12], target = 2
 *    Output: -1
 *
 *    Example 3:
 *    Input: nums = [1, 2, 3, 4, 5], target = 1
 *    Output: 0
 *
 * 4) Brute Force Approach:
 *    - Traverse the array linearly.
 *    - Compare each element to the target.
 *    - Time Complexity: O(n)
 *
 * 5) Optimum Approach:
 *    - Use Binary Search on the sorted array.
 *    - Divide and conquer by checking mid element each time.
 *    - Time Complexity: O(log n)
 *
 * 6) Additional Hints:
 *    - Binary search should be applied since the array is sorted.
 *    - Carefully update your left and right pointers to avoid infinite loop.
 *
 * 7) The program will print actual vs expected answers and PASS/FAIL status for each test case.
 */

public class LeetCode_704_BinarySearch_Easy {

    // === Placeholder for the implementation method ===
    public static int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length-1);
    }

    public static int searchHelper(int[] nums, int target, int startIndex, int endIndex) {
        if(startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex)/2;
        if(nums[midIndex] ==  target){
            return midIndex;
        }

        if(nums[midIndex] > target){
            return searchHelper(nums, target, startIndex, midIndex-1);
        }else{
            return searchHelper(nums, target, midIndex+1, endIndex);
        }

    }


    // === Driver method to test different cases ===
    public static void main(String[] args) {
        runTest(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4);       // PASS
        runTest(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1);      // PASS
        runTest(new int[]{1, 2, 3, 4, 5}, 1, 0);            // PASS
        runTest(new int[]{1, 2, 3, 4, 5}, 5, 4);            // PASS
        runTest(new int[]{1, 2, 3, 4, 5}, 0, -1);           // PASS
    }

    /**
     * Utility method to test the search function
     */
    private static void runTest(int[] nums, int target, int expected) {
        int result = search(nums, target);
        String status = (result == expected) ? "PASS" : "FAIL";
        System.out.printf("Input: target=%d, Output: %d, Expected: %d --> %s%n", target, result, expected, status);
    }

    /**
     * Below this line, you can add helper methods if needed
     */
}
