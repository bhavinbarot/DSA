package Array_String;

import java.util.HashMap;

public class LeetCode_1_TwoSum_Easy {
    public static void main(String[] args){

        // Example input array and target sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the brute force solution and print result
        int[] result_bruteForce = twoSum_bruteforce(nums, target);
        System.out.println("Brute Force Result: [" + result_bruteForce[0] + ", " + result_bruteForce[1] + "]");

        // Call the optimized solution and print result
        int[] result_optimized = twoSum_optimized(nums, target);
        System.out.println("Optimized Result: [" + result_optimized[0] + ", " + result_optimized[1] + "]");
    }

    /**
     * Brute Force Solution
     * Time Complexity: O(n^2)
     * @param nums - input array of integers
     * @param target - the sum we're looking to match
     * @return an array containing the indices of the two numbers that add up to target
     */
    public static int[] twoSum_bruteforce(int[] nums, int target) {
        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check each element that comes after the current one
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the current pair adds up to the target
                if (nums[i] + nums[j] == target) {
                    // Return their indices if they do
                    return new int[]{i, j};
                }
            }
        }
        // Return an empty array if no solution is found (should not happen if input is valid)
        return new int[]{};
    }

    /**
     * Optimized Solution using HashMap
     * Time Complexity: O(n)
     * @param nums - input array of integers
     * @param target - the sum we're looking to match
     * @return an array containing the indices of the two numbers that add up to target
     */
    public static int[] twoSum_optimized(int[] nums, int target) {
        // Create a hashmap to store number as key and its index as value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for(int i = 0; i < nums.length; i++) {
            // Calculate the complement (what we need to reach the target)
            int complement = target - nums[i];

            // If complement exists in map, we've found a valid pair
            if(map.containsKey(complement)) {
                // Return the index of complement and current index
                return new int[] {map.get(complement), i};
            }

            // If not found, store the current number with its index in map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found (should not happen with valid input)
        return new int[]{};
    }
}
