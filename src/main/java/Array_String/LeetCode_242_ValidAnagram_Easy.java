package Array_String;

/**
 * Leetcode Problem 242: Valid Anagram
 *
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters.
 *  * Approach:
 *  * 1. If lengths differ, return false.
 *  * 2. Use a frequency counter (e.g., int[26]) to count letters in s and subtract for t.
 *  * 3. If all counts are zero, they are anagrams.
 */

public class LeetCode_242_ValidAnagram_Easy {

    // Implementing the solution
    //Optimum Solution
    public boolean isAnagram(String s, String t) {
        // If the lengths are not the same, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count the frequency of each character
        int[] count = new int[26];

        // Iterate through both strings
        for (int i = 0; i < s.length(); i++) {
            // Increment count for character in s
            count[s.charAt(i) - 'a']++;
            // Decrement count for character in t
            count[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, the strings are anagrams
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    //My solution
    public boolean isAnagram_MySolution(String s, String t) {
        int frequency[] = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            frequency[ch - 'a']++;
        }
        for(int j=0;j<t.length();j++){
            char ch = t.charAt(j);
            frequency[ch - 'a']--;
        }
        for(int k=0;k<frequency.length;k++){
            if(frequency[k] != 0) return false;
        }
        return true;
    }

    // Test cases
    public static void main(String[] args) {
        LeetCode_242_ValidAnagram_Easy solution = new LeetCode_242_ValidAnagram_Easy();


        System.out.println("Test Case 1: " + solution.isAnagram("anagram", "nagaram") + " Expected: true"); // Expected: true
        System.out.println("Test Case 2: " + solution.isAnagram("rat", "car") + " Expected: false");         // Expected: false
        System.out.println("Test Case 3: " + solution.isAnagram("a", "a") + " Expected: true");             // Expected: true
        System.out.println("Test Case 4: " + solution.isAnagram("ab", "ba") + " Expected: true");           // Expected: true
        System.out.println("Test Case 5: " + solution.isAnagram("abcde", "abcd")+ " Expected: false");        // Expected: false
        System.out.println("Test Case 5: " + solution.isAnagram("abc", "abcd") + " Expected: false");// Expected: false


    }
}
