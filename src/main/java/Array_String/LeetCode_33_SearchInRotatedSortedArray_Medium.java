package Array_String;

/**
 * Category: Arrays, Binary Search
 *
 * LeetCode Problem 33: Search in Rotated Sorted Array (Medium)
 *
 * ------------------------------
 * Description:
 * ------------------------------
 * There is an integer array `nums` sorted in ascending order (with distinct values),
 * which is **rotated at an unknown pivot index** k (0 <= k < nums.length) such that the
 * resulting array is:
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]].
 *
 * Given the array `nums` after the rotation and an integer `target`, return the index of
 * `target` if it is in `nums`, or -1 if it is not in `nums`.
 *
 * You must write an algorithm with **O(log n)** runtime complexity.
 *
 * ------------------------------
 * Examples:
 * ------------------------------
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * ------------------------------
 * Brute Force Approach:
 * ------------------------------
 * - Iterate through the array linearly and compare each element with the target.
 * - Time Complexity: O(n)
 *
 * ------------------------------
 * Optimal Approach:
 * ------------------------------
 * - Use modified Binary Search.
 * - Even though the array is rotated, one half is always sorted.
 * - Decide which half to explore based on whether the target lies in the sorted portion.
 * - Time Complexity: O(log n)
 *
 * ------------------------------
 * Additional Hints:
 * ------------------------------
 * - Pay attention to edge cases like small arrays or not found cases.
 * - Make sure to handle left/right pointers properly to avoid infinite loops.
 */

public class LeetCode_33_SearchInRotatedSortedArray_Medium {

    // Placeholder method to implement
    //Option 1 : {4,5,6,7,0,1,2} // If Left is Smaller than Mid,
     //AND if target is outside Left-Mid range(4,5,6,7),  i.e. target <nums[start] or target>nums[mid]
         // then (your number is in right range (7,0,1,2)
            //make left = mid+1,
        // Else, (your number is in left range {4,5,6,7}
            //right = mid-1


    //Option 2 : {7,8,0,1,2,3,4} //If Left is Bigger than mid,
    // AND if target is outside left-Mid range {2,3,4}, i.e. target > nums[mid]  or target < nums[mid]
    // left = mid + 1
    //else target is inside left-mid range 7,8,0,1
    //right = mid-1

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(target == nums[mid]) return mid;

            if(nums[left] < nums[mid]){ //Check if Left side is Sorted?
                //Option 1 : {4,5,6,7,0,1,2} //Left half is sorted
                if(target < nums[left] || target > nums[mid]){
                    //Case : Target is 1 (Answer is in right side)
                    left = mid + 1;
                }
                else{
                    //Case : Target is 5 (Answer is in left side)
                    right = mid -1;
                }
            }else{
                //Option 2 : {7,8,0,1,2,3,4} //Right half is sorted
                if(target > nums[left] || target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }

            }

        }

        return -1; // Default return for placeholder
    }
    // Placeholder method to implement
    public int search_bruteForce(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        if(Math.abs(target-start) < Math.abs(target-end)){
            for(int i=start;i<end;i++){
                if(nums[i] == target){
                    return i;
                }
            }
        }
        else{
            for(int i=end;i>start;i--){
                if(nums[i] == target){
                    return i;
                }
            }
        }
        return -1; // Default return for placeholder
    }

    public static void main(String[] args) {
        LeetCode_33_SearchInRotatedSortedArray_Medium solution = new LeetCode_33_SearchInRotatedSortedArray_Medium();

        // Test case 1
        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        System.out.println("Test case 1: Expected: 4, Actual: " + solution.search(nums1, target1));

        // Test case 2
        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        System.out.println("Test case 2: Expected: -1, Actual: " + solution.search(nums2, target2));

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Test case 3: Expected: -1, Actual: " + solution.search(nums3, target3));

        // Additional test case 4
        int[] nums4 = {1};
        int target4 = 1;
        System.out.println("Test case 4: Expected: 0, Actual: " + solution.search(nums4, target4));

        // Additional test case 5
        int[] nums5 = {5,6,7,0,1,2,3,4};
        int target5 = 3;
        System.out.println("Test case 5: Expected: 6, Actual: " + solution.search(nums5, target5));
    }
}
