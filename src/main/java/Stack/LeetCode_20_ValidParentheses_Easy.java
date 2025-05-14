package Stack;

import java.util.Stack;

public class LeetCode_20_ValidParentheses_Easy {

    // Problem: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid. An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    //
    // Approach: Use a stack to match pairs of parentheses.

    public boolean isValid(String s) {
        // Placeholder method for solving the problem.
        // We will use a stack to check if the parentheses are valid.

        Stack<Character> stack = new Stack<>();

        // Iterate through each character of the string.
        for (char ch : s.toCharArray()) {
            // Check if character is an opening bracket
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check if character is a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty or the top of the stack doesn't match the current closing bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop(); //This should be corresponding opening bracket.

                // Check if the top of the stack matches the corresponding opening bracket
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // After processing all characters, the stack should be empty if all parentheses matched correctly.
        return stack.isEmpty();
    }

    // Test cases
    public static void main(String[] args) {
        LeetCode_20_ValidParentheses_Easy solution = new LeetCode_20_ValidParentheses_Easy();

        // Test case 1
        System.out.println(solution.isValid("()") + "// true");  // true
        // Test case 2
        System.out.println(solution.isValid("()[]{}") + "// true");  // true
        // Test case 3
        System.out.println(solution.isValid("(]") + "// false");  // false
        // Test case 4
        System.out.println(solution.isValid("([)]") + "// false");  // false
        // Test case 5
        System.out.println(solution.isValid("{[]}") + "// true");  // true
        // Test case 6 (Empty string)
        System.out.println(solution.isValid("") + "// true (Empty string is considered valid)");  // true (Empty string is considered valid)
    }
}
