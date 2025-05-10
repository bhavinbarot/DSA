package Array_String;

// LeetCode Problem: #88 - Merge Sorted Array

/*
 * 1) DSA Problem Category:
 *    Arrays, Two Pointers, Sorting
 *
 * 2) Problem Statement:
 *    You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order,
 *    and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2`, respectively.
 *
 *    Merge `nums2` into `nums1` as one sorted array in-place.
 *
 *    Note:
 *    - The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`.
 *    - To accommodate this, `nums1` has a length of `m + n`, where the last `n` elements are set to 0 and should be ignored.
 *
 * 3) Examples:
 *
 *    Example 1:
 *    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *    Output: [1,2,2,3,5,6]
 *
 *    Example 2:
 *    Input: nums1 = [1], m = 1, nums2 = [], n = 0
 *    Output: [1]
 *
 *    Example 3:
 *    Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 *    Output: [1]
 *
 * 4) Brute Force Approach:
 *    - Copy elements from nums2 to the end of nums1.
 *    - Sort nums1 using a built-in sort function like Arrays.sort().
 *    - Time Complexity: O((m + n) log(m + n)), Space Complexity: O(1)
 *
 * 5) Optimal Approach:
 *    - Use a two-pointer approach, starting from the ends of both arrays.
 *    - Place the larger of the elements at the end of nums1 (from the back).
 *    - Time Complexity: O(m + n), Space Complexity: O(1)
 *
 * 6) Additional Hints:
 *    - Since nums1 has enough space, we can do the merge from the back to avoid overwriting values.
 *    - Always compare the current largest elements in nums1 and nums2 and fill from the end.
 */

public class LeetCode_88_MergeSortedArray_Easy {

    // Placeholder for implementation - mimic interview scenario
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int p1 = m-1;
       int p2 = n-1;
       int p = m+n-1;

       while(p1>=0 && p2>=0){
           if(nums1[p1] > nums2[p2]){
               nums1[p] = nums1[p1];
               p1--;
           }else{
               nums1[p]=nums2[p2];
               p2--;
           }
           p--;
       }
    }

    // Method to simulate the problem for testing
    public static void main(String[] args) {
        LeetCode_88_MergeSortedArray_Easy solution = new LeetCode_88_MergeSortedArray_Easy();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        System.out.println("Before merging:");
        printArray(nums1);

        solution.merge(nums1, m, nums2, n);

        System.out.println("After merging:");
        printArray(nums1);
    }

    // Utility method to print an array
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Uncomment and use this optimal solution once ready for actual implementation
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer for nums1
        int p2 = n - 1; // Pointer for nums2
        int p = m + n - 1; // Pointer for placement in nums1

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements from nums2, if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
    */
}
