package Strings;

/**
 * LeetCode Problem 5: Longest Palindromic Substring
 *
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s.
 *
 * A palindrome is a string that reads the same backward as forward.
 *
 * Examples:
 * - Input: s = "babad"
 *   Output: "bab" or "aba"
 *
 * - Input: s = "cbbd"
 *   Output: "bb"
 *
 * - Input: s = "a"
 *   Output: "a"
 *
 * - Input: s = "ac"
 *   Output: "a" or "c"
 *
 * Approach:
 * There are multiple approaches to solve this problem:
 *
 * 1. **Expand Around Center (Recommended)**
 *    - For each character, expand around it to find the longest palindrome.
 *    - Time Complexity: O(n^2), Space Complexity: O(1)
 *
 * 2. **Dynamic Programming**
 *    - Use a 2D boolean table to keep track of palindromes.
 *    - Time Complexity: O(n^2), Space Complexity: O(n^2)
 *
 * 3. **Manacher's Algorithm (Advanced)**
 *    - Optimized to O(n), but complex to implement.
 */

public class LeetCode5_LongestPalindromicSubstring {

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
        LeetCode5_LongestPalindromicSubstring solver = new LeetCode5_LongestPalindromicSubstring();

        // Test Cases
        System.out.println("Test 1: " + solver.longestPalindrome("babad")); // Expected: "bab" or "aba"
        System.out.println("Test 2: " + solver.longestPalindrome("cbbd"));  // Expected: "bb"
        System.out.println("Test 3: " + solver.longestPalindrome("a"));     // Expected: "a"
        System.out.println("Test 4: " + solver.longestPalindrome("ac"));    // Expected: "a" or "c"
        System.out.println("Test 5: " + solver.longestPalindrome("racecar"));// Expected: "racecar"
    }
}
