package Array;

public class Leetcode53_MaxSubarraySolver {

    /**
     * Finds the sum of the contiguous subarray with the largest sum.
     * @param nums The input array
     * @return The largest sum
     */

    public int maxSubarray(int[] nums) {
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
        Leetcode53_MaxSubarraySolver solver = new Leetcode53_MaxSubarraySolver();

        int[][] testCases = {
                { -2, 1, 2, 3},   // Expected: 6 (subarray: [1,2,3])
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
