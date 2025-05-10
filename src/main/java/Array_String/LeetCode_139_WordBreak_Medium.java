package Array_String;

/**
 * Leetcode Problem 139: Word Break
 *
 * Problem Statement:
 * Given a string `s` and a dictionary of strings `wordDict`,
 * return true if `s` can be segmented into a space-separated sequence
 * of one or more dictionary words.
 *
 * Note:
 * - The same word in the dictionary may be reused multiple times in the segmentation.
 * - You may assume the dictionary does not contain duplicate words.
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * ---
 * Approach:
 * - Use Dynamic Programming.
 * - Define a boolean array dp where dp[i] is true if s[0...i) can be segmented using wordDict.
 * - Iterate over all positions and update dp accordingly.
 *
 * Time Complexity: O(n^2), where n is the length of the string s.
 */

import java.util.*;

public class LeetCode_139_WordBreak_Medium {
    public boolean wordBreak(String s, List<String> wordDict) {
        //leetcode  {"leet","code"}
        //s.substring(i,j)
        //i==1 j=0 j<i s.substring(j,i) (s.substring(0,1) = l (not in list)

        //i==2 j=0 j<i s.substring(j,i) (s.substring(0,2) = le (not in list)
        //i==2 j=1 j<i s.substring(j,i) (s.substring(1,2) =  e (not in list)

        //i==3 j=0 j<i s.substring(j,i) (s.substring(0,3) = lee (not in list)
        //i==3 j=1 j<i s.substring(j,i) (s.substring(1,3) =  ee (not in list)
        //i==3 j=2 j<i s.substring(j,i) (s.substring(2,3) =   e (not in list)

        //i==4 j=0 j<i s.substring(j,i) (s.substring(0,4) = leet (It is in the list) Make d[i]=true
        //i==4 j=1 j<i s.substring(j,i) (s.substring(1,4) =  eet (not in the list)
        //i==4 j=2 j<i s.substring(j,i) (s.substring(2,4) =   et (not in the list)
        //i==4 j=3 j<i s.substring(j,i) (s.substring(3,4) =    t (not in the list)

        //i==8 j=0 j<i s.substring(j,i) (s.substring(0,8) = leetcode (not in list)
        //i==8 j=1 j<i s.substring(j,i) (s.substring(1,8) =  eetcode (not in list)
        //i==8 j=2 j<i s.substring(j,i) (s.substring(2,8) =   etcode (not in list)
        //i==8 j=3 j<i s.substring(j,i) (s.substring(3,8) =    tcode (not in list)
        //i==8 j=4 j<i s.substring(j,i) (s.substring(4,8) =     code (This is in the list) Make d[8]=true


        //What is dp[i]?
        //dp[i] will be true if you can break the first i characters of the string into dictionary words.
        //So:
        //dp[0] means: "Can I break the empty string?" (Always true — base case)
        //dp[5] means: "Can I break the first 5 characters?" → "apple" → is that a valid word?
        //dp[8] means: "Can I break the first 8 characters?" → "applepen" → is that made of valid words?
        //Think of dp as checkpoints along a path (each index is a position in the string).
        //You start at dp[0] = true (the start of the string).
        //If you can reach dp[s.length()], it means you found a valid path all the way to the end using dictionary words.
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        //Conver the word dictionary to Hash Set so that it is easier to query contains
        HashSet<String> wordSet = new HashSet<>(wordDict);

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String word = s.substring(j,i);
                if(dp[j] && wordSet.contains(word)){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }




    public boolean wordBreakSolution(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true; //base case
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String word = s.substring(j,i);
                if(dp[j] && wordSet.contains(word)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //dp0-""
    //dp1-l
    //dp2-le
    //dp3-lee
    //dp4-leet - True
    //dp5-leetc
    //dp6-leetco
    //dp7-leetcod
    //dp8-leetcode

    public boolean wordBreakDebug(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // base case

        System.out.println("\n\n\n--------->Input String: " + s);
        System.out.println("Dictionary: " + wordSet);
        System.out.println("Starting DP evaluation...\n");

        for (int i = 1; i <= s.length(); i++) {
            System.out.println("Checking dp[" + i + "] (substring: \"" + s.substring(0, i) + "\")");

            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                System.out.println("  Trying j = " + j + ", i = " + i + " → substring \"" + word + "\"");

                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    System.out.println("    ✅ Match found: dp[" + j + "] = true and \"" + word + "\" is in dictionary");
                    System.out.println("    → Setting dp[" + i + "] = true");
                    break;
                } else {
                    if (!dp[j]) {
                        System.out.println("    ❌ dp[" + j + "] = false → cannot use this split");
                    }
                    if (!wordSet.contains(word)) {
                        System.out.println("    ❌ \"" + word + "\" not in dictionary");
                    }
                }
            }

            System.out.println("Result after i = " + i + ": dp[" + i + "] = " + dp[i] + "\n");
        }

        // Final DP array output
        System.out.println("Final DP table:");
        for (int k = 0; k < dp.length; k++) {
            System.out.println("dp[" + k + "] = " + dp[k]);
        }

        System.out.println("\nCan the string \"" + s + "\" be segmented? " + dp[s.length()]);
        return dp[s.length()];
    }





    // Test cases
    public static void main(String[] args) {
        LeetCode_139_WordBreak_Medium solution = new LeetCode_139_WordBreak_Medium();

        // Test Case 1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        boolean result1 = solution.wordBreak(s1, dict1);
        System.out.println("Test Case 1 - Expected: true, Got: " + result1);

        // Test Case 2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        boolean result2 = solution.wordBreak(s2, dict2);
        System.out.println("Test Case 2 - Expected: true, Got: " + result2);

        // Test Case 3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result3 = solution.wordBreak(s3, dict3);
        System.out.println("Test Case 3 - Expected: false, Got: " + result3);

        // Additional edge test case
        String s4 = "";
        List<String> dict4 = Arrays.asList("a");
        boolean result4 = solution.wordBreak(s4, dict4);
        System.out.println("Test Case 4 - Expected: true, Got: " + result4);
    }
}
