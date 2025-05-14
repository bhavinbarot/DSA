package Array_String;

public class LeetCode_53_MaxSubarraySolver_Hard {

    /**
     * Finds the sum of the contiguous subarray with the largest sum.
     * @param nums The input array
     * @return The largest sum
     */


    public int maxSubarray(int[] nums) {
        // Initialize maxSum to the smallest possible integer value.
        // This ensures that even if all numbers in the array are negative, we get the correct result.
        int maxSum = Integer.MIN_VALUE;

        // This variable keeps track of the current subarray sum as we iterate.
        int currentSum = 0;

        System.out.println("------------------------");

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current number to the running sum
            currentSum = currentSum + nums[i];

            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);

            // If currentSum becomes negative, reset it to 0
            // because continuing with a negative sum would reduce the sum of future subarrays
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum subarray sum found
        return maxSum;
    }


    public int maxSubarray_bruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        System.out.println("------------------------");
        for(int i=0;i<nums.length;i++){
            int tempSum = nums[i];
            maxSum = Math.max(maxSum, tempSum);
            System.out.println("i="+i + " nums[i]=" + nums[i]);
            for(int j=i+1;j<nums.length;j++){
                tempSum = tempSum + nums[j];
                maxSum = Math.max(maxSum, tempSum);
                System.out.println("j="+j + " nums[j]=" + nums[j] + " tempSum=" + tempSum + " maxSum=" + maxSum);
            }
        }
        return maxSum;
    }

    public int maxSubarray_Optimized(int[] nums) {
        // Initialize both currentMax and maxSoFar to the first element
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to:
            // (1) Extend the previous subarray by adding nums[i]
            // (2) Start a new subarray starting at nums[i]
            System.out.printf("\ni=%d -> nums[i] %d vs  currentMax %d+ nums[i] %d = %d", i, nums[i], currentMax, nums[i], currentMax + nums[i]);
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            System.out.printf("\ncurrentMax = %d", currentMax);

            // Update maxSoFar if currentMax is greater
            maxSoFar = Math.max(maxSoFar, currentMax);
            System.out.printf("\nmaxSoFar = %d", maxSoFar);
        }

        // After traversing all elements, maxSoFar holds the maximum sum
        return maxSoFar;
    }

    public static void main(String[] args) {
        LeetCode_53_MaxSubarraySolver_Hard solver = new LeetCode_53_MaxSubarraySolver_Hard();

        int[][] testCases = {
                { -2, 1, 2, 3},                      // Expected: 6 (subarray: [1,2,3])
                { -2, 1, -3, 4, -1, 2, 1, -5, 4 },   // Expected: 6 (subarray: [4,-1,2,1])
                { 1 },                               // Expected: 1
                { 5, 4, -1, 7, 8 },                  // Expected: 23 (subarray: [5,4,-1,7,8])
                { -1, -2, -3, -4 },                  // Expected: -1 (subarray: [-1])
                { 0, 0, 0, 0 },                      // Expected: 0
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solver.maxSubarray(testCases[i]);
            System.out.println("\nTest Case " + (i + 1) + ": Result = " + result);
        }
    }
}
