package Array_String;



import java.util.*;

public class Leetcode_15_ThreeSumProblem_Medium {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Step 1: Sort the array to simplify duplicate handling and two-pointer logic

        for (int i = 0; i < nums.length - 2; i++) { // Loop till third-last element
            if (i > 0 && nums[i] == nums[i - 1]) {
                // Skip duplicate values for 'i' to avoid duplicate triplets
                continue;
            }

            int left = i + 1; // Left pointer starts right after 'i'
            int right = nums.length - 1; // Right pointer starts at the end
            int target = -nums[i]; // We want two numbers such that nums[left] + nums[right] == -nums[i]

            while (left < right) { // Continue until pointers meet
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a triplet: nums[i], nums[left], nums[right]
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left pointer to next different number to skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Move right pointer to previous different number to skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward after adding result
                    left++;
                    right--;
                } else if (sum < target) {
                    // Sum too small, need bigger number → move left pointer right
                    left++;
                } else {
                    // Sum too big, need smaller number → move right pointer left
                    right--;
                }
            }
        }

        return result; // Return the list of unique triplets
    }

    public static List<List<Integer>> threeSum_bruteForce(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        results.add(temp);
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] test0 = {-1, 0, 1};
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        int[] test2 = {0, 1, 1};
        int[] test3 = {0, 0, 0};
        int[] test4 = {-2, 0, 1, 1, 2};

        System.out.println("Test 0: " + threeSum(test0));
        System.out.println("Test 1: " + threeSum(test1));
        System.out.println("Test 2: " + threeSum(test2));
        System.out.println("Test 3: " + threeSum(test3));
        System.out.println("Test 4: " + threeSum(test4));
    }

    /*
    * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    * Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
    * */
}
