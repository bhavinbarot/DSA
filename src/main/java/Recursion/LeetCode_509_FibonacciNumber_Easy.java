package Recursion;

/**
 * Problem Category: Dynamic Programming
 *
 * LeetCode Problem 509: Fibonacci Number
 *
 * Description:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * That is:
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Examples:
 * Input: n = 2  => Output: 1
 * Input: n = 3  => Output: 2
 * Input: n = 10 => Output: 55
 *
 * Brute Force Approach:
 * - Use recursion to compute F(n)
 * - Time Complexity: Exponential O(2^n)
 * - Inefficient for larger values of n
 *
 * Optimal Approach:
 * - Use Dynamic Programming (Bottom-Up or Memoization)
 * - Time Complexity: O(n)
 * - Space Complexity: O(1) for Bottom-Up
 *
 * Additional Hints:
 * - Recognize the overlapping subproblems and optimal substructure properties
 * - Use a loop with two variables to hold the previous two Fibonacci numbers
 */

public class LeetCode_509_FibonacciNumber_Easy {

    public static void main(String[] args) {
        // Test Cases
        testFibonacci(0, 0);
        testFibonacci(1, 1);
        testFibonacci(2, 1);
        testFibonacci(3, 2);
        testFibonacci(10, 55);
        testFibonacci(20, 6765);
    }

    private static int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    /**
     * Placeholder for actual implementation. Simulates a real interview environment.
     * @param n - index in Fibonacci sequence
     * @return - nth Fibonacci number
     */
    public static int fib_slow(int n) {
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2); // Placeholder return
    }

    /**
     * Method to test the Fibonacci output against expected value and print results
     */
    private static void testFibonacci(int input, int expected) {
        int actual = fibOptimized(input);
        if (actual == expected) {
            System.out.println("Input: " + input + " | Output: " + actual + " | Expected: " + expected + " | PASS");
        } else {
            System.out.println("Input: " + input + " | Output: " + actual + " | Expected: " + expected + " | FAIL");
        }
    }

    /**
     * Optimized Dynamic Programming implementation (Bottom-Up approach)
     * Time: O(n), Space: O(1)
     */
    private static int fibOptimized(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /**
     * Brute-force recursive implementation (inefficient)
     * Time: O(2^n)
     */
    private static int fibBruteForce(int n) {
        if (n <= 1) return n;
        return fibBruteForce(n - 1) + fibBruteForce(n - 2);
    }
}
