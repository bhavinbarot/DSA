package Stack;

import java.util.Stack;

/**
 * 1) DSA Category:
 *    - Dynamic Programming
 *    - Stack
 *    - String Manipulation
 *
 * 2) Problem Statement:
 *    Given a string containing just the characters '(' and ')', find the length of the longest valid
 *    (well-formed) parentheses substring.
 *
 * 3) Examples:
 *    Example 1:
 *      Input: s = "(()"
 *      Output: 2
 *      Explanation: The longest valid parentheses substring is "()"
 *
 *    Example 2:
 *      Input: s = ")()())"
 *      Output: 4
 *      Explanation: The longest valid parentheses substring is "()()"
 *
 *    Example 3:
 *      Input: s = ""
 *      Output: 0
 *
 * 4) Brute-force Approach:
 *    - Try all substrings of the input.
 *    - Check each substring whether it is valid.
 *    - Time Complexity: O(n^3)
 *    - Space Complexity: O(n)
 *
 * 5) Optimal Approach:
 *    - Use Stack or Dynamic Programming.
 *    - Stack Approach:
 *        * Use a stack to store indices of characters.
 *        * Track the base for valid parentheses using an initial -1.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 *
 * 6) Additional Hints:
 *    - Consider what information needs to be retained at each character.
 *    - Think about what makes a substring valid.
 *    - How can you "remember" where a valid substring started?
 *
 * 7) Output:
 *    - For each test case, print input, actual output, expected output, and PASS/FAIL.
 */

public class LeetCode_32_Longest_Valid_Parentheses_Hard {

    public static void main(String[] args) {
        // Test cases
        runTest("(()", 2);
        runTest(")()())", 4);
        runTest("", 0);
        runTest("()(()", 2);
        runTest("()(())", 6);
        runTest("())((())", 4);
        runTest("()(()", 2);
        runTest("(()(((()", 2);
    }

    /**
     * Placeholder method for implementation.
     * This simulates a real-world interview scenario where you're expected to implement this.
     */
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int top=0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(top);
            } else {
                //If Stack is empty and we are trying to add closing bracket ')' , ignore it.
                if (stack.isEmpty()){
                    //Ignore it
                }
                else{
                    //Stack is not empty
                    stack.pop();
                    top++;
                    if (stack.isEmpty()){
                        //If stack is empty now. Update maxLen
                        maxLen = maxLen + top;
                        top = 0;
                    }else{
                        maxLen = Math.max(maxLen, top);
                    }
                }
            }
        }

        return maxLen*2;
    }

    /**
     * This helper method runs a test case and prints PASS/FAIL.
     */
    private static void runTest(String input, int expected) {
        int actual = longestValidParentheses(input);
        System.out.printf("Input: %-10s | Expected: %-3d | Actual: %-3d | %s\n",
                "\"" + input + "\"", expected, actual,
                (actual == expected ? "PASS" : "FAIL"));
    }

    /**
     * Optional: Brute-force implementation (not efficient for long strings)
     * Can be used for validation or educational purposes.
     */
    public static int bruteForceLongestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    /**
     * Utility method to check if a string has valid parentheses.
     */
    private static boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    /**
     * Actual optimal implementation using Stack.
     */
    public static int optimalUsingStack(String s) {
        int maxLen = 0;
        int top=0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //If Stack is empty and we are trying to add closing bracket ')' , ignore it.
                if (stack.isEmpty()){
                    //Ignore it
                }
                else{
                    //Stack is not empty
                    stack.pop();
                    top++;
                    if (stack.isEmpty()){
                        //If stack is empty now. Update maxLen
                        maxLen = maxLen + top;
                        top = 0;
                    }
                }
            }
        }

        return maxLen;
    }

    // You can switch the implementation method in runTest() for validation or comparison
}
