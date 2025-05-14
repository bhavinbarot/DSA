package Array_String;

import java.util.HashSet;

/**
 * Leetcode Problem 3: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 */

public class LeetCode_3_LongestSubstringWithoutRepeating_Medium {

    public static int lengthOfLongestSubstring(String s) {
        // Handle simple edge cases: empty string returns 0, single character returns 1
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int leftIndex = 0;       // Left pointer of the sliding window
        int rightIndex = 0;      // Right pointer of the sliding window
        int maxLength = 0;       // Tracks the maximum length of substring without repeating characters

        // Convert the input string to a character array for faster access
        char chars[] = s.toCharArray();

        // HashSet to store characters in the current window
        // It helps in quickly checking for duplicates
        HashSet<Character> charSet = new HashSet<>();

        // Expand the window with the right pointer
        while (rightIndex < chars.length) {
            // If the character at rightIndex is not already in the set,
            // it's safe to include in the current window
            if (!charSet.contains(chars[rightIndex])) {
                // Add character to the set
                charSet.add(chars[rightIndex]);

                // Move the right pointer to expand the window
                rightIndex++;

                // Update the maximum length if current window is larger
                maxLength = Math.max(maxLength, rightIndex - leftIndex);
            } else {
                // If duplicate is found, remove the character at leftIndex
                // and move the left pointer to shrink the window
                charSet.remove(chars[leftIndex]);
                leftIndex++;
            }
        }

        //Another approach - Does not work
        /*
        maxLength = 1;
        int tempCounter = 1;
        System.out.println(chars);
        for(int i=1;i<chars.length;i++){
            //Mark the first index
            //Start at i=1
            //If char[i] != char[i-1]
            //Increase the counter.
            //Set maxLength = Max(maxLength, counter)
            //else (char[i] != char[i-1])
            //reset the counter
            boolean tempBoolean = chars[i]!=chars[i-1];
            System.out.printf("chars[i]=%c vs chars[i-1]=%c tempBoolean=%b\n",chars[i], chars[i-1], tempBoolean);
            if(chars[i]!=chars[i-1]){
                tempCounter++;
                maxLength = Math.max(maxLength, tempCounter);
            }else{
                tempCounter = 1;
            }

        }
        */

        // Return the maximum length of substring found without repeating characters
        return maxLength;
    }


    public static void main(String[] args) {
        // Test cases
        String[] testInputs = {"","a","aa","ab","abcabcbb", "bbbbb", "pwwkew", "", "abcdefg", "aab", "dvdf"};
        int[] expectedOutputs = {0,1,1,2,3, 1, 3, 0, 7, 2, 3};

        for (int i = 0; i < testInputs.length; i++) {
            int result = lengthOfLongestSubstring(testInputs[i]);
            System.out.println("Input: \"" + testInputs[i] + "\"");
            System.out.println("Expected: " + expectedOutputs[i] + ", Got: " + result);
            System.out.println(result == expectedOutputs[i] ? "PASS\n" : "FAIL\n");
        }
    }
}
