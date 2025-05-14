package Array_String;

/*
 * LeetCode Problem: 394. Decode String
 *
 * 1) DSA Problem Category:
 *    - Strings
 *    - Stack
 *    - Recursion (sometimes used in optimal solutions)
 *
 * 2) Problem Description:
 *    Given an encoded string, return its decoded string.
 *    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 *    is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 *    repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * 3) Examples and Expected Answers:
 *    - Input: "3[a]2[bc]"        -> Output: "aaabcbc"
 *    - Input: "3[a2[c]]"         -> Output: "accaccacc"
 *    - Input: "2[abc]3[cd]ef"    -> Output: "abcabccdcdcdef"
 *    - Input: "abc3[cd]xyz"      -> Output: "abccdcdcdxyz"
 *
 * 4) Brute Force Approach:
 *    - Recursively scan for the pattern `k[encoded_string]`.
 *    - For every `k`, extract the substring within brackets, decode it, and repeat `k` times.
 *    - This method may use StringBuilder/String concatenation and nested loops but is inefficient with nested encodings.
 *
 * 5) Optimal Approach:
 *    - Use a Stack to process characters.
 *    - Maintain a stack for integers (multipliers) and one for strings.
 *    - For each character:
 *        - If digit, build the number.
 *        - If `[`, push current string and number to stack.
 *        - If `]`, pop from stack and repeat substring.
 *        - If character, append to current string.
 *    - This method handles nested and multi-digit cases efficiently.
 *
 * 6) Additional Hints:
 *    - Use stacks to handle nested patterns.
 *    - Pay attention to multi-digit numbers and proper bracket matching.
 *    - Avoid unnecessary string concatenations by using StringBuilder.
 */

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_394_DecodeString_Medium {

    public static void main(String[] args) {
        test("3[a]2[bc]", "aaabcbc");
        test("3[a2[c]]", "accaccacc");
        test("2[abc]3[cd]ef", "abcabccdcdcdef");
        test("abc3[cd]xyz", "abccdcdcdxyz");
        test("10[a]", "aaaaaaaaaa"); // edge case with double digit multiplier
    }

    /**
     * Placeholder for the method to decode string.
     * Simulates a coding interview environment.
     */
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> countStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] >= '0' && chars[i]<='9'){
                num = num*10 + chars[i] - '0';
            }else if(chars[i] == '['){
                //Push Number to stack
                countStack.push(num);
                //Push String to Stack
                stringStack.push(sb);
                //Reset Num
                num = 0;
                //Reset String Builder
                sb = new StringBuilder();
            }else if(chars[i] == ']'){
                //Pop String
                StringBuilder tempString = stringStack.pop();
                //Pop Number
                int tempCount = countStack.pop();
                while(tempCount > 0){
                    tempString.append(sb);
                    tempCount--;
                }
                sb = tempString;
            }else{
                sb.append(chars[i]);
            }

        }

        return sb.toString();
    }

    /**
     * Test utility to validate the decodeString implementation.
     */
    private static void test(String input, String expected) {
        String result = decodeString(input);
        boolean pass = result.equals(expected);
        System.out.printf("Input: %-20s | Output: %-20s | Expected: %-20s | %s\n",
                input, result, expected, pass ? "PASS" : "FAIL");
    }

    /**
     * Final working implementation of decodeString using Stack.
     */
    public static String decodeStringSolution(String s) {
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0'; // handle multi-digit numbers
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                while (count-- > 0) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    /**
     * Test the final implementation to ensure it's working correctly.
     */
    public static void runFinalSolutionTests() {
        System.out.println("\nRunning final implementation tests:");
        testWithSolution("3[a]2[bc]", "aaabcbc");
        testWithSolution("3[a2[c]]", "accaccacc");
        testWithSolution("2[abc]3[cd]ef", "abcabccdcdcdef");
        testWithSolution("abc3[cd]xyz", "abccdcdcdxyz");
        testWithSolution("10[a]", "aaaaaaaaaa");
    }

    private static void testWithSolution(String input, String expected) {
        String result = decodeStringSolution(input);
        boolean pass = result.equals(expected);
        System.out.printf("Input: %-20s | Output: %-20s | Expected: %-20s | %s\n",
                input, result, expected, pass ? "PASS" : "FAIL");
    }
}
