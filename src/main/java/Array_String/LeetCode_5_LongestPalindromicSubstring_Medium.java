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
        System.out.println("\n\n"+s);
        String longestPelimdrom= s.substring(0,1);
        int longestPelimdromLength = 1;
        for(int i=0;i<s.length();i++){
            int startIndex = i;
            int endIndex = s.length()-1;
            if(startIndex == endIndex) return s;

            boolean matchFound = true;
            int matchEndIndex = 0;
            while(startIndex < endIndex){
                if(s.charAt(startIndex) == s.charAt(endIndex)){
                    matchFound = true;
                    matchEndIndex = Math.max(matchEndIndex, endIndex);
                    startIndex++;
                    endIndex--;
                }
                else{
                    endIndex--;
                    matchFound = false;
                }
            }
            if(matchFound){
                longestPelimdromLength = Math.max(longestPelimdromLength, longestPelimdrom.length());
                if(s.substring(i, matchEndIndex+1).length() > longestPelimdromLength){
                    System.out.printf("\nMatch found at index - %d %d - %s", startIndex, matchEndIndex, s.substring(i, matchEndIndex+1));
                    longestPelimdrom = s.substring(i, matchEndIndex+1);
                }
            }
        }
        return longestPelimdrom;
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
