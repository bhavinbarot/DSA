package Stack;

/**
 * Problem Category: Stack, Arrays, Monotonic Stack
 *
 * LeetCode Problem Number: 739
 * Title: Daily Temperatures
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the i-th day to get a warmer temperature. If there is no future day for which
 * this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Bruteforce Approach:
 * - For each day, check all future days to find a warmer temperature.
 * - Time Complexity: O(n^2)
 * - Space Complexity: O(n)
 *
 * Optimal Approach:
 * - Use a monotonic decreasing stack to keep track of indices.
 * - When a warmer temperature is found, pop the stack and calculate the days waited.
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 *
 * Additional Hints:
 * - Consider how to use a stack to keep track of indices.
 * - When a warmer temperature is found, calculate the difference in indices.
 */

public class LeetCode_739_DailyTemperatures_Medium {

    // Placeholder for interview-style coding implementation
    public int[] dailyTemperatures(int[] temperatures) {
        // Create an array to store the result (number of days to wait for a warmer temperature)
        int tempGap[] = new int[temperatures.length];

        // Loop through each day except the last one (no future days to compare for the last)
        for(int i = 0; i < temperatures.length - 1; i++) {

            // Initialize the index to the next day
            int nextIndex = i + 1;

            // Flag to indicate if a warmer day is found
            boolean isItWarmer = false;

            // Store the current day's temperature
            int currentTemp = temperatures[i];

            // Store the next day's temperature (used in loop below)
            int nextTemp = temperatures[nextIndex];

            // Iterate over future days to find the next warmer temperature
            while (nextIndex < temperatures.length) {
                // Re-fetch values in case nextIndex changed (note: currentTemp remains the same, so reassigning is redundant)
                currentTemp = temperatures[i];
                nextTemp = temperatures[nextIndex];

                // Check if we've found a warmer day
                if (nextTemp > currentTemp) {
                    isItWarmer = true;
                    break;
                }

                // Move to the next future day
                nextIndex++;
            }

            // If a warmer day was found, store the number of days to wait
            if (isItWarmer) {
                int difference = nextIndex - i;
                tempGap[i] = difference;
            } else {
                // Otherwise, set to 0 (no warmer day found)
                tempGap[i] = 0;
            }
        }

        // The last element will remain 0 as initialized, since there's no future day
        return tempGap;
    }


    // Main method for testing the implementation
    public static void main(String[] args) {
        LeetCode_739_DailyTemperatures_Medium solution = new LeetCode_739_DailyTemperatures_Medium();

        // Test cases
        int[][] testInputs = {
                {73,74,75,71,69,72,76,73},
                {30,40,50,60},
                {30,60,90},
                {90,80,70,60},  // strictly decreasing
                {70,70,70,70}   // all same
        };
        int[][] expectedOutputs = {
                {1,1,4,2,1,1,0,0},
                {1,1,1,0},
                {1,1,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        for (int i = 0; i < testInputs.length; i++) {
            int[] actual = solution.dailyTemperatures(testInputs[i]);
            int[] expected = expectedOutputs[i];
            boolean passed = compareArrays(actual, expected);
            System.out.println("Test Case " + (i+1) + ": " + (passed ? "PASS" : "FAIL"));
            System.out.println("Expected: " + arrayToString(expected));
            System.out.println("Actual  : " + arrayToString(actual));
            System.out.println();
        }
    }

    /**
     * Optimal method using a monotonic decreasing stack.
     */
    public int[] optimalDailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }

    /**
     * Utility method to compare two integer arrays.
     */
    private static boolean compareArrays(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    /**
     * Utility method to convert an array to a string for printing.
     */
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
