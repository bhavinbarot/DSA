package Array_String;

public class LeetCode_189_RotateArray_Medium {

    /**
     * Rotates the given array to the right by k steps.
     * @param nums The input array
     * @param k The number of steps to rotate
     */
    public void rotate(int[] nums, int k) {
        int start = 0;
        int end = 0;

        // Normalize k in case it is greater than the array length
        k = k % nums.length;

        /*
         * Step 1: Reverse the first part of the array: from index 0 to nums.length - k - 1
         * For example, if nums = [1, 2, 3, 4, 5, 6, 7] and k = 3,
         * nums.length = 7, so end = 7 - 3 - 1 = 3
         * This reverses the subarray [1, 2, 3, 4] => [4, 3, 2, 1]
         * Resulting array after this loop: [4, 3, 2, 1, 5, 6, 7]
         */
        start = 0;
        end = nums.length - k - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        /*
         * Step 2: Reverse the second part of the array: from index nums.length - k to nums.length - 1
         * Continuing with the example, we reverse [5, 6, 7] => [7, 6, 5]
         * The array now becomes: [4, 3, 2, 1, 7, 6, 5]
         */
        start = nums.length - k;
        end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        /*
         * Step 3: Reverse the entire array: from index 0 to nums.length - 1
         * We now reverse [4, 3, 2, 1, 7, 6, 5] => [5, 6, 7, 1, 2, 3, 4]
         * This is the final rotated array, shifted right by k = 3 steps.
         */
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        LeetCode_189_RotateArray_Medium rotator = new LeetCode_189_RotateArray_Medium();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array:");
        printArray(nums);

        rotator.rotate(nums, k);

        System.out.println("Rotated array:");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
