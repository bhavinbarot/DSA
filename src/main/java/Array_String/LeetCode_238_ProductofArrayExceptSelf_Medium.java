import java.util.Arrays;

public class LeetCode_238_ProductofArrayExceptSelf_Medium {

    /**
     * Returns an array where each element is the product of all other elements except itself.
     * Must run in O(n) time without using division.
     * @param nums The input integer array
     * @return The product array
     */

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Compute prefix products
        // answer[i] will hold product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
            // Example: answer[2] = nums[1] * answer[1] => product of elements before index 2
        }

        // Step 2: Compute suffix products and multiply with prefix products
        int rightProduct = 1; // Represents product of all elements to the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
            // Example: rightProduct accumulates product of nums[i+1] * nums[i+2] * ...
        }

        return answer;
    }
    public int[] productExceptSelf_bruteForce(int[] nums) {
        int answer[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int mul = 1;
            for(int j=0;j<nums.length;j++){
                if(nums[j]!=nums[i]){
                    mul = mul * nums[j];
                }
            }
            answer[i] = mul;
        }
        return answer;
    }

    public static void main(String[] args) {
        LeetCode_238_ProductofArrayExceptSelf_Medium solver = new LeetCode_238_ProductofArrayExceptSelf_Medium();

        // Test cases
        int[][] testCases = {
                {1, 2, 3, 4},        // Expected: [24,12,8,6]
                {-1, 1, 0, -3, 3}    // Expected: [0,0,9,0,0]
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solver.productExceptSelf(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Input = " + Arrays.toString(testCases[i]));
            System.out.println("Output: " + Arrays.toString(result));
        }
    }

    /**
     * LeetCode Problem 371: Sum of Two Integers
     * Difficulty: Medium
     *
     * Problem Statement:
     * Given two integers a and b, return the sum of the two integers
     * without using the operators + and -.
     *
     * Example 1:
     * Input: a = 1, b = 2
     * Output: 3
     *
     * Example 2:
     * Input: a = 2, b = 3
     * Output: 5
     *
     * Constraints:
     * -1000 <= a, b <= 1000
     */

    public static class Leetcode371_SumOfTwoIntegers_Medium {

        /**
         * Returns the sum of two integers without using '+' or '-' operators.
         *
         * You can use bit manipulation. A basic approach is:
         *  - XOR (^) gives sum without carry
         *  - AND (&) followed by left shift gives the carry
         *  - Repeat until carry is zero
         */
        public static int getSum(int a, int b) {
            // TODO: Implement this method using bit manipulation
            while (b != 0) {
                int carry = (a & b) << 1; // Calculate carry
                a = a ^ b;                // Sum without carry
                b = carry;                // Prepare carry for next iteration
            }
            return a;
        }

        // Sample test cases
        public static void main(String[] args) {
            System.out.println("Test Case 1: getSum(1, 2) = " + getSum(1, 2));     // Expected: 3
            System.out.println("Test Case 2: getSum(2, 3) = " + getSum(2, 3));     // Expected: 5
            System.out.println("Test Case 3: getSum(-1, 1) = " + getSum(-1, 1));   // Expected: 0
            System.out.println("Test Case 4: getSum(-5, -3) = " + getSum(-5, -3)); // Expected: -8
            System.out.println("Test Case 5: getSum(0, 0) = " + getSum(0, 0));     // Expected: 0
        }
    }
}
