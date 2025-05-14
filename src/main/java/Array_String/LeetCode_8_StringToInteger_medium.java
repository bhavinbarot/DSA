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

        String str = "Hello, World!";
        int length = str.length();            // Get string length
        boolean isEmpty = str.isEmpty();      // Check if string is empty
        //String ➜ char[] (Character Array)
        char[] charArray = str.toCharArray();
        //char[] ➜ String
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(charArray);
        //Comparison
        str.equals("Hello");                  // Case-sensitive comparison
        str.equalsIgnoreCase("hello");        // Case-insensitive comparison
        str.compareTo("World");               // Lexicographical comparison
        //Searching
        str.contains("World");                // true
        str.indexOf("o");                     // First index of 'o'
        str.lastIndexOf("o");                 // Last index of 'o'
        str.startsWith("Hello");             // true
        str.endsWith("!");                   // true
        //Substrings & Characters
        str.charAt(1);                        // 'e'
        str.substring(7);                     // "World!"
        str.substring(7, 12);                 // "World"
        //Modification
        str.toLowerCase();                    // "hello, world!"
        str.toUpperCase();                    // "HELLO, WORLD!"
        str.trim();                           // Removes leading/trailing spaces
        str.replace("World", "Java");         // "Hello, Java!"
        str.replaceAll("\\s+", " ");          // Regex-based replace
        //Splitting & Joining
        String[] words = str.split(", ");     // ["Hello", "World!"]
        String joined = String.join("-", words); // "Hello-World!"
        //Conversion
        String.valueOf(123);                  // "123"
        Integer.parseInt("123");              // 123


    }

    public static int myAtoi(String s) {
        // Convert the input string into a character array for easier access to individual characters
        char[] chars = s.toCharArray();

        int sign = 1;   // To track if the number is positive or negative (default is positive)
        int index = 0;  // To iterate over the character array
        int total = 0;  // To store the resulting integer value

        // Step 1: Remove leading whitespaces
        while (index < chars.length && chars[index] == ' ') {
            index++;  // Skip over leading spaces
        }

        // Step 2: Check for the sign (+ or -)
        if (index < chars.length && (chars[index] == '+' || chars[index] == '-')) {
            sign = (chars[index] == '+') ? 1 : -1;  // Set sign to 1 if '+' or -1 if '-'
            index++;  // Move past the sign character
        }

        // Step 3: Convert the characters to a number
        while (index < chars.length) {
            char c = chars[index];
            // If the character is not a digit, break out of the loop
            if (c < '0' || c > '9') {
                break;
            }

            // Convert the character to a digit (e.g., '3' -> 3)
            int digit = c - '0';

            // Step 4: Handle potential overflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                // If adding the digit causes an overflow, return the appropriate boundary value
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update the total value (shift the previous total by 10 and add the new digit)
            total = total * 10 + digit;
            index++;  // Move to the next character
        }

        // Step 5: Apply the sign and return the final result
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

