package Array_String;

/**
 * 1) Problem Category:
 *    - Strings
 *    - Dynamic Programming
 *    - Expand Around Center
 *
 * 2) Problem Statement (LeetCode #5: Longest Palindromic Substring):
 *    Given a string s, return the longest palindromic substring in s.
 *    A palindrome is a string that reads the same forward and backward.
 *
 * 3) Examples:
 *    Input: "babad"
 *    Output: "bab" (Note: "aba" is also a valid answer)
 *
 *    Input: "cbbd"
 *    Output: "bb"
 *
 *    Input: "a"
 *    Output: "a"
 *
 *    Input: "ac"
 *    Output: "a" (or "c")
 *
 * 4) Brute Force Approach:
 *    - Generate all possible substrings
 *    - Check each substring if it's a palindrome
 *    - Keep track of the longest palindrome found
 *    - Time Complexity: O(n^3) (since substring checking is O(n) inside two nested loops)
 *
 * 5) Optimal Approach:
 *    - Expand Around Center technique
 *    - For each character, expand around it (and between it and the next character) to find palindromes
 *    - Keep track of the longest palindrome found
 *    - Time Complexity: O(n^2), Space Complexity: O(1)
 *
 *    Alternative optimal approach (Dynamic Programming):
 *    - Use a 2D boolean table to keep track of palindromic substrings
 *    - Time Complexity: O(n^2), Space Complexity: O(n^2)
 *
 * 6) Additional Hints:
 *    - A palindrome mirrors around its center.
 *    - There are 2n - 1 centers (each char + between each pair of chars).
 *    - No need to generate all substrings explicitly.
 */

public class LeetCode_5_LongestPalindromicSubstring_Medium {

    /**
     * Returns the longest palindromic substring in the input string s.
     * @param s the input string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Convert the input string to a character array
        char[] chars = s.toCharArray();

        // Print the input string for debugging purposes
        System.out.println("\n\n" + s);

        // Initialize the longest palindrome to be the first character of the string
        String longestPalindrome = s.substring(0, 1);

        // Iterate over the string to find palindromes
        for (int i = 0; i < chars.length; i++) {
            // Initialize start and end indices for palindrome comparison
            int startIndex = i;
            int endIndex = chars.length - 1;

            // If the start and end indices are the same, we have a single character palindrome, return the string
            if (startIndex == endIndex) return s;

            boolean matchFound = true; // Flag to check if characters match and form a palindrome
            int matchEndIndex = 0; // Variable to store the last matching index in the palindrome

            // Compare characters from start and end until they no longer match
            while (startIndex < endIndex) {
                if (chars[startIndex] == chars[endIndex]) {
                    // If characters match, continue checking the next characters inward
                    matchFound = true;
                    matchEndIndex = Math.max(matchEndIndex, endIndex); // Track the farthest matching index
                    startIndex++;
                    endIndex--;
                } else {
                    // If characters do not match, move the end index inward and mark no match found
                    endIndex--;
                    matchFound = false;
                }
            }

            // If a palindrome match is found, check if it is the longest so far
            if (matchFound) {
                // Store the current palindrome as a substring
                String currentPalindrome = s.substring(i, matchEndIndex + 1);

                // Store the length of the current palindrome
                int currentPalindromeLength = currentPalindrome.length();

                // Check if the found palindrome is longer than the previously recorded longest palindrome
                if (currentPalindromeLength > longestPalindrome.length()) {
                    // Print match details for debugging
                    System.out.printf("\nMatch found at index - %d %d - %s", startIndex, matchEndIndex, currentPalindrome);

                    // Update the longest palindrome found so far
                    longestPalindrome = currentPalindrome;
                }
            }
        }

        // Return the longest palindrome found in the string
        return longestPalindrome;
    }


    public static void main(String[] args) {
        LeetCode_5_LongestPalindromicSubstring_Medium solver = new LeetCode_5_LongestPalindromicSubstring_Medium();

        // Test Cases
        System.out.println("Test 1: " + solver.longestPalindrome("babad")); // Expected: "bab" or "aba"
        System.out.println("Test 2: " + solver.longestPalindrome("cbbd"));  // Expected: "bb"
        System.out.println("Test 3: " + solver.longestPalindrome("a"));     // Expected: "a"
        System.out.println("Test 4: " + solver.longestPalindrome("ac"));    // Expected: "a" or "c"
        System.out.println("Test 5: " + solver.longestPalindrome("racecar"));// Expected: "racecar"
    }
}
