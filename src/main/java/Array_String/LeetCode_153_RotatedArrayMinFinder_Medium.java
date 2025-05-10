package Array_String;
import java.util.Arrays;

public class LeetCode_153_RotatedArrayMinFinder_Medium {

    /**
     * Finds the minimum element in a rotated sorted array.
     * Must run in O(log n) time.
     * @param nums The rotated sorted array
     * @return The minimum element
     */

    public int findMin(int[] nums) {
        // Initialize left and right pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        // Continue searching as long as left pointer is less than right pointer
        while (left < right) {
            // Calculate the mid index to divide the array
            int mid = left + (right - left) / 2;

            // Check if the middle element is greater than the rightmost element
            // This means the minimum element must be on the right side of mid
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Move the left pointer to mid + 1
            } else {
                // If nums[mid] <= nums[right], then the minimum is either mid or to the left of mid
                right = mid; // Move the right pointer to mid
            }
        }

        // After the loop ends, left == right and will point to the minimum element
        return nums[left];
    }

    public int findMin_my_slution(int[] nums) {
        // Handle edge case: if array is empty, return 0 (can also throw exception depending on requirement)
        if (nums.length == 0) return 0;

        int min = nums[0]; // Initialize min as first element

        // Check if array is already sorted and not rotated
        // If first element is less than last, array is in ascending order
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0]; // Return first element as minimum
        } else {
            // Array is rotated → start with last element as candidate minimum
            min = nums[nums.length - 1];

            // Iterate backward from last element towards the beginning
            for (int i = nums.length - 1; i > 0; i--) {
                // If we find an element greater than current min,
                // it means we’ve crossed the point of rotation, so stop
                if (nums[i] > min) {
                    break;
                } else {
                    // Else update min (current element is smaller or equal)
                    min = nums[i];
                }
            }
            return min; // Return the minimum found
        }
    }

    public static void main(String[] args) {
        LeetCode_153_RotatedArrayMinFinder_Medium finder = new LeetCode_153_RotatedArrayMinFinder_Medium();

        int[][] testCases = {
                {3, 4, 5, 1, 2},       // Expected: 1
                {4, 5, 6, 7, 0, 1, 2}, // Expected: 0
                {11, 13, 15, 17}       // Expected: 11
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = finder.findMin(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Input = " + Arrays.toString(testCases[i]));
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}

