package Array_String;

/**
 * Category: Arrays, Binary Search
 *
 * LeetCode Problem: 852. Peak Index in a Mountain Array (Easy)
 *
 * Description:
 * An array arr is a mountain if the following properties hold:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 *     arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *     arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * Given a mountain array `arr`, return the index `i` such that arr[i] is the peak.
 *
 * Examples:
 * Input: arr = [0,1,0]
 * Output: 1
 *
 * Input: arr = [0,2,1,0]
 * Output: 1
 *
 * Input: arr = [0,10,5,2]
 * Output: 1
 *
 * Brute Force Approach:
 * - Traverse the array from index 1 to arr.length - 2.
 * - Check for condition arr[i-1] < arr[i] && arr[i] > arr[i+1].
 * - Time Complexity: O(n)
 *
 * Optimal Approach:
 * - Use Binary Search:
 * - If arr[mid] < arr[mid+1] then the peak is to the right.
 * - Else, the peak is at mid or to the left.
 * - Time Complexity: O(log n)
 *
 * Additional Hints:
 * - This is a classic application of binary search with a twist for unimodal arrays.
 */

public class LeetCode_852_PeakIndexInMountainArray_Easy {

    public static void main(String[] args) {
        runTests();
    }

    /**
     * Placeholder for the actual implementation.
     * This would simulate a real interview environment.
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length - 2;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid-1] < arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    /**
     * Runs all test cases and prints PASS/FAIL based on expected output.
     */
    private static void runTests() {
        test(new int[]{0, 1, 0}, 1);
        test(new int[]{0, 2, 1, 0}, 1);
        test(new int[]{0, 10, 5, 2}, 1);
        test(new int[]{3, 4, 5, 1}, 2);
        test(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}, 4);
    }

    /**
     * Utility method to run a test case and print result
     */
    private static void test(int[] arr, int expected) {
        int result = peakIndexInMountainArray(arr);
        if (result == expected) {
            System.out.println("PASS: Input = " + arrayToString(arr) + ", Expected = " + expected + ", Got = " + result);
        } else {
            System.out.println("FAIL: Input = " + arrayToString(arr) + ", Expected = " + expected + ", Got = " + result);
        }
    }

    /**
     * Helper method to convert array to string
     */
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * This is the optimal solution using Binary Search
     * Uncomment this and comment the placeholder for actual results
     */
    /*
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    */
}
