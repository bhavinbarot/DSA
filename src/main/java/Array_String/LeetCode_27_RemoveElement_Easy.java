package Array_String;

/*
 * LeetCode Problem 27 - Remove Element (Easy)
 *
 * 1) DSA Category:
 *    Arrays, Two Pointers
 *
 * 2) Problem Statement:
 *    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 *    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *    It doesn't matter what you leave beyond the returned length.
 *
 * 3) Examples:
 *    Example 1:
 *      Input: nums = [3,2,2,3], val = 3
 *      Output: 2, nums = [2,2,_,_]
 *      Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 *
 *    Example 2:
 *      Input: nums = [0,1,2,2,3,0,4,2], val = 2
 *      Output: 5, nums = [0,1,4,0,3,_,_,_]
 *
 * 4) Brute Force Approach:
 *    - Use a temporary array to store elements not equal to `val`
 *    - Copy them back into the original array
 *    - Time Complexity: O(n), Space Complexity: O(n)
 *
 * 5) Optimal Approach:
 *    - Use the Two Pointers technique
 *    - One pointer iterates over the array
 *    - Another pointer keeps track of the position to overwrite
 *    - Time Complexity: O(n), Space Complexity: O(1)
 *
 * 6) Additional Hints:
 *    - You must do this in-place with O(1) extra memory.
 *    - The order of elements can be changed. It doesn't matter what you leave beyond the returned length.
 */

public class LeetCode_27_RemoveElement_Easy {

    /**
     * Placeholder for the main method that would be called in an interview setting.
     * The interviewer may ask you to implement this from scratch.
     */
    public int removeElement(int[] nums, int val) {
        // Initialize index `i` to track the position of the next valid element (not equal to `val`)
        int i = 0;

        // Loop through each element in the array using index `j`
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not equal to the value to be removed
            if (nums[j] != val) {
                // Copy the current element to the `i`th position in the array
                nums[i] = nums[j];
                // Increment `i` to point to the next position for a valid element
                i++;
            }
        }

        // Return the count of elements not equal to `val`
        // All valid elements are now in the first `i` positions of the array
        return i;
    }

    /**
     * This is the brute force solution for reference or testing purposes.
     * It uses extra space and is not optimal for interview purposes.
     */
    public int removeElementBruteForce(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                temp[index++] = num;
            }
        }
        // Copy back to original array
        for (int i = 0; i < index; i++) {
            nums[i] = temp[i];
        }
        return index;
    }

    /**
     * This is the optimal solution using two pointers.
     * It modifies the array in-place without using extra memory.
     */
    public int removeElementOptimal(int[] nums, int val) {
        int i = 0; // Pointer to overwrite values
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Helper method to print the array up to a specific length.
     */
    public void printArray(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // Test runner
    public static void main(String[] args) {
        LeetCode_27_RemoveElement_Easy solution = new LeetCode_27_RemoveElement_Easy();

        int[] nums1 = {3, 2, 2, 3};
        int len1 = solution.removeElementOptimal(nums1, 3);
        System.out.println("New length: " + len1);
        solution.printArray(nums1, len1); // Output should be: 2 2

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int len2 = solution.removeElementOptimal(nums2, 2);
        System.out.println("New length: " + len2);
        solution.printArray(nums2, len2); // Output could be: 0 1 3 0 4
    }
}
