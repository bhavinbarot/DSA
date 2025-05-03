package Binary;

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

public class Leetcode371_SumOfTwoIntegers {

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
