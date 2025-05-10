package Array_String;

// LeetCode Problem #8: String to Integer (atoi)
// Category: Strings, Parsing

/*
1) Problem Category:
   - This problem falls under the category of Strings. It involves parsing and converting substrings into integer values, handling edge cases like overflow, whitespaces, signs, and invalid characters.

2) Problem Statement:
   - Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).
   - The algorithm should:
     - Discard all leading whitespaces
     - Consider the optional '+' or '-' sign
     - Read in the next characters until a non-digit is encountered
     - Convert those digits into an integer
     - Clamp the result within the 32-bit signed integer range [-2^31, 2^31 - 1]

3) Examples:
   - Input: "42"                -> Output: 42
   - Input: "   -42"            -> Output: -42
   - Input: "4193 with words"   -> Output: 4193
   - Input: "words and 987"     -> Output: 0
   - Input: "-91283472332"      -> Output: -2147483648 (Clamped to Integer.MIN_VALUE)

4) Brute Force Approach:
   - Strip whitespaces manually
   - Check for '+' or '-' signs
   - Traverse the rest of the characters
   - Stop on non-digit and manually construct the number
   - Check for overflow by using long or BigInteger

5) Optimal Approach:
   - Single-pass parsing
   - Constant space
   - Carefully use integer arithmetic to avoid overflow
   - Stop parsing when a non-digit is found

6) Additional Hints:
   - Use a long or multiply before adding digits to detect overflow
   - Check integer overflow using bounds before actual conversion

7) The program should print the actual and expected outputs for sample inputs

*/

public class LeetCode_8_StringToInteger_medium {

    public static void main(String[] args) {
        // Test cases
        runTest("42", 42);
        runTest("   -42", -42);
        runTest("4193 with words", 4193);
        runTest("words and 987", 0);
        runTest("-91283472332", Integer.MIN_VALUE);
        runTest("91283472332", Integer.MAX_VALUE);
        runTest("+-12", 0);
        runTest("", 0);
        runTest("   +0 123", 0);
    }

    // Method to run and print test case
    private static void runTest(String input, int expected) {
        int result = myAtoi(input);
        System.out.println("Input: \"" + input + "\" | Expected: " + expected + " | Actual: " + result);
    }

    // Placeholder for implementation (simulate real-world coding interview)
    public static int myAtoi(String s) {
        int sign = 1;
        int index = 0;
        int total = 0;
        //Step 1 : Remove white spaces
        while(index < s.length() && s.charAt(index) ==' ' ){
            index++;
        }

        //Step 2 : Track the + or - sign
        while(index < s.length() && (s.charAt(index) =='+' || s.charAt(index) =='-')){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        //Step 3 : Find out equivalent number
        while(index < s.length()){
            char c = s.charAt(index);
            if (c<'0' || c>'9') break;  //Break while loop and return total*sign

            int digit = c - '0';

            //If Total is way too big, it would overflow. prevent it before it happens in the next step.
            if(total > (Integer.MAX_VALUE - digit)/10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }
        total = total * sign;
        return total;
    }

    /*
     * Below is the correct implementation of the atoi conversion
     * (This would typically be revealed after interview simulation or for comparison.)
     */
    public static int myAtoiOptimal(String s) {
        int index = 0, sign = 1, total = 0;
        int length = s.length();

        // 1. Remove leading whitespaces
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Handle sign
        if (index < length && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 3. Convert number and avoid overflow
        while (index < length) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') break; //If you encounter a character, then break the while loop and return whatever total you have so far (*sign).

            int digit = c - '0'; //This is how you convert a string '1' to a digit 1;

            // Check overflow/underflow before it happens
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}

