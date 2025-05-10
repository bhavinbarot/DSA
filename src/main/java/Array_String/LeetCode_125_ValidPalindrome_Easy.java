package Array_String;

import static java.lang.Character.isLetterOrDigit;

/**
 * LeetCode Problem 125: Valid Palindrome
 *
 * Problem Statement:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Examples:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: After removing non-alphanumeric characters and converting to lowercase,
 * "amanaplanacanalpanama" is a palindrome.
 *
 * Input: s = "race a car"
 * Output: false
 *
 * Input: s = " "
 * Output: true
 *
 * Approach:
 * 1. Use two pointers (one at the start and one at the end).
 * 2. Skip non-alphanumeric characters.
 * 3. Compare the characters at both pointers (in lowercase).
 * 4. If all characters match, it's a palindrome.
 *
 * Alternatively, clean the string by filtering out non-alphanumeric characters and reversing it.
 * Then compare the cleaned string with its reversed version.
 *
 * Hint:
 * - Use Character.isLetterOrDigit(char c) to check for alphanumeric characters.
 * - Use Character.toLowerCase(char c) to convert characters.
 */

public class LeetCode_125_ValidPalindrome_Easy {

    // Placeholder for the actual solution
    public static boolean isPalindrome(String s) {
        // Print the input string (for debugging or inspection purposes)
        System.out.println("\n\n" + s);

        // Convert the string to lowercase to make the comparison case-insensitive
        s = s.toLowerCase();

        // Initialize two pointers: one at the beginning (startIndex) and one at the end (endIndex) of the string
        int startIndex = 0;
        int endIndex = s.length() - 1;

        // Loop until the startIndex is no longer less than endIndex (i.e., when pointers cross each other)
        while (startIndex < endIndex) {
            // Get the characters at the start and end indexes
            char startChar = s.charAt(startIndex);
            char endChar = s.charAt(endIndex);

            // If the character at startIndex is not a letter or digit, move startIndex forward
            if (!Character.isLetterOrDigit(startChar)) {
                startIndex++;  // Skip this character and move the startIndex to the next character
            }
            // If the character at endIndex is not a letter or digit, move endIndex backward
            else if (!Character.isLetterOrDigit(endChar)) {
                endIndex--;  // Skip this character and move the endIndex to the previous character
            }
            // If both characters are alphanumeric and match, move both pointers inward
            else if (startChar == endChar) {
                startIndex++;  // Move the startIndex forward
                endIndex--;    // Move the endIndex backward
            }
            // If the characters don't match, it's not a palindrome, so return false
            else {
                return false;
            }
        }

        // If all characters matched (or we have crossed pointers), the string is a palindrome
        return true;
    }


    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 0: " + isPalindrome("aba") + " // Expected: true");
        System.out.println("Test Case 0: " + isPalindrome("abc") + " // Expected: false");
        System.out.println("Test Case 1: " + isPalindrome("A man, a plan, a canal: Panama") + " // Expected: true");
        System.out.println("Test Case 2: " + isPalindrome("race a car") + " // Expected: false");
        System.out.println("Test Case 3: " + isPalindrome(" ") + " // Expected: true");
        System.out.println("Test Case 4: " + isPalindrome("No lemon, no melon") + " // Expected: true");
        System.out.println("Test Case 5: " + isPalindrome("0P") + " // Expected: false");
    }
}
