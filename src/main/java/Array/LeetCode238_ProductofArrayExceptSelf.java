import java.util.Arrays;

public class LeetCode238_ProductofArrayExceptSelf {

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
        LeetCode238_ProductofArrayExceptSelf solver = new LeetCode238_ProductofArrayExceptSelf();

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
}
