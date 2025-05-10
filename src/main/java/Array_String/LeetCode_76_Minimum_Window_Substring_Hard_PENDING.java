package Array_String;

// 1) Category: Strings, Sliding Window, HashMap
// 2) Problem Statement:
//    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
//    such that every character in t (including duplicates) is included in the window.
//    If there is no such substring, return the empty string "".
//
//    The test cases will be generated such that the answer is unique.
//
// 3) Examples:
//    Example 1:
//    Input: s = "ADOBECODEBANC", t = "ABC"
//    Output: "BANC"
//
//    Example 2:
//    Input: s = "a", t = "a"
//    Output: "a"
//
//    Example 3:
//    Input: s = "a", t = "aa"
//    Output: ""
//
// 4) Brute Force Approach:
//    - Generate all substrings of s.
//    - Check if the substring contains all characters from t.
//    - Time complexity is O(n^3) due to substring generation and validation.
//
// 5) Optimum Approach:
//    - Use Sliding Window technique with HashMaps to track character frequencies.
//    - Expand and contract window to find the minimum valid window.
//    - Time complexity: O(n + m)
//
// 6) Additional Hints:
//    - Use two pointers to create a sliding window.
//    - Use HashMap to count characters in t and current window in s.
//    - Keep a count of how many required characters are satisfied in the current window.
//
// 7) The program will print actual vs expected results with PASS/FAIL status.

public class LeetCode_76_Minimum_Window_Substring_Hard_PENDING {

    public static void main(String[] args) {
        runTests();
    }

    /**
     * Placeholder for the actual implementation.
     * Implement this method to return the minimum window substring from s that contains all characters from t.
     */
    public static String minWindow(String s, String t) {
        // TODO: Implement this method as per the optimal sliding window approach
        return "";
    }

    /**
     * Runs test cases and validates the implementation.
     */
    private static void runTests() {
        test("ADOBECODEBANC", "ABC", "BANC");
        test("a", "a", "a");
        test("a", "aa", "");
        test("ab", "b", "b");
        test("ab", "a", "a");
        test("abc", "ac", "abc");
    }

    /**
     * Helper method to run a single test case.
     */
    private static void test(String s, String t, String expected) {
        String result = minWindow(s, t);
        boolean passed = result.equals(expected);
        System.out.println("Input: s = \"" + s + "\", t = \"" + t + "\"");
        System.out.println("Expected: \"" + expected + "\", Got: \"" + result + "\" -> " + (passed ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------");
    }

    /**
     * Sliding Window Optimal Implementation (Uncomment this and copy it into minWindow to test.)
     */
//    public static String minWindow(String s, String t) {
//        if (s == null || t == null || s.length() < t.length()) return "";
//
//        Map<Character, Integer> targetFreq = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
//        }
//
//        int left = 0, right = 0;
//        int minLeft = 0, minLen = Integer.MAX_VALUE;
//        int matched = 0;
//
//        Map<Character, Integer> windowFreq = new HashMap<>();
//
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
//
//            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
//                matched++;
//            }
//
//            while (matched == targetFreq.size()) {
//                if (right - left + 1 < minLen) {
//                    minLeft = left;
//                    minLen = right - left + 1;
//                }
//
//                char leftChar = s.charAt(left);
//                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
//                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
//                    matched--;
//                }
//                left++;
//            }
//            right++;
//        }
//
//        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
//    }
}
