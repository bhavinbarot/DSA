package Array_String;
/*
 * ==========================================================================================
 * Problem Category: Arrays, Two Pointers
 *
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 * Difficulty: Easy
 *
 * ------------------------------------------------------------------------------------------
 * PROBLEM DESCRIPTION:
 * Given an integer array `nums` sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 *
 * Since it is in-place, do not allocate extra space for another array.
 * Instead, modify the input array in-place and return the new length.
 *
 * ------------------------------------------------------------------------------------------
 * EXAMPLES:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 * Note: The values after the new length do not matter.
 *
 * ------------------------------------------------------------------------------------------
 * BRUTE FORCE APPROACH:
 * - Use a HashSet to track seen elements (not allowed by the problem due to extra space).
 * - Copy the unique values to a new array and return length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) => Not accepted
 *
 * ------------------------------------------------------------------------------------------
 * OPTIMAL APPROACH (Two Pointers):
 * - Use a slow pointer to track the position of the next unique element.
 * - Iterate using a fast pointer and whenever a new unique number is found, move it forward.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ------------------------------------------------------------------------------------------
 * ADDITIONAL HINTS:
 * - Since the array is sorted, duplicates will be adjacent.
 * - Keep a pointer `i` where you write the next unique number.
 *
 * ==========================================================================================
 */

public class LeetCode_26_RemoveDuplicatesFromSortedArray_Easy {

    // ===========================
    // Placeholder for implementation method (simulate interview)
    // ===========================
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;

        //nums is atleast two
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[j] ==nums[j-1]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1; // placeholder return
    }

    // ===========================
    // Main method to test the implementation
    // ===========================
    public static void main(String[] args) {
        // Test case 1
        int[] test1 = {1, 1, 2};
        int expectedLength1 = 2;
        int[] expectedArray1 = {1, 2};

        runTestCase(test1, expectedLength1, expectedArray1);

        // Test case 2
        int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expectedLength2 = 5;
        int[] expectedArray2 = {0, 1, 2, 3, 4};

        runTestCase(test2, expectedLength2, expectedArray2);
    }

    // ===========================
    // Utility method to run and validate test cases
    // ===========================
    private static void runTestCase(int[] input, int expectedLength, int[] expectedOutput) {
        System.out.println("Input Array: ");
        printArray(input);

        int actualLength = removeDuplicates(input);
        System.out.println("Returned Length: " + actualLength);
        System.out.print("Modified Array: ");
        printArrayUpTo(input, actualLength);

        System.out.println("Expected Length: " + expectedLength);
        System.out.print("Expected Output: ");
        printArray(expectedOutput);
        System.out.println("Test " + (actualLength == expectedLength && arraysMatch(input, expectedOutput, actualLength) ? "PASSED" : "FAILED"));
        System.out.println("--------------------------------------------------\n");
    }

    // ===========================
    // Utility method to compare arrays up to a certain length
    // ===========================
    private static boolean arraysMatch(int[] actual, int[] expected, int length) {
        for (int i = 0; i < length; i++) {
            if (actual[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }

    // ===========================
    // Utility method to print an array
    // ===========================
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ===========================
    // Print array up to a specific length
    // ===========================
    private static void printArrayUpTo(int[] arr, int len) {
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            if (i < len - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
