package Recursion;

import java.util.*;

    public class LeetCode_46_Permutations_Medium_for_String {

        /**
         * ========================================================================================================
         * PROBLEM CATEGORY:
         * This is a Strings + Backtracking problem.
         * ========================================================================================================
         *
         * PROBLEM DESCRIPTION:
         * Given a string s consisting of unique characters, return all possible permutations of the characters.
         * You can return the answer in any order.
         *
         * ========================================================================================================
         * EXAMPLES:
         * Example 1:
         * Input: "abc"
         * Output: ["abc","acb","bac","bca","cab","cba"]
         *
         * Example 2:
         * Input: "ab"
         * Output: ["ab","ba"]
         *
         * Example 3:
         * Input: "a"
         * Output: ["a"]
         * ========================================================================================================
         *
         * BRUTE FORCE APPROACH:
         * - Generate all combinations using recursion without pruning or optimization.
         * - For each character, try placing it at every position in a growing result.
         *
         * OPTIMAL APPROACH:
         * - Use Backtracking:
         *   -> Maintain a temporary list representing the current permutation path.
         *   -> Track which characters have been used using a boolean array.
         *   -> Recursively build all combinations.
         *
         * TIME COMPLEXITY: O(n!) where n = length of the string
         * SPACE COMPLEXITY: O(n!) for the output list + O(n) for recursion stack
         *
         * ========================================================================================================
         * ADDITIONAL HINTS:
         * - Convert the input string to a character array to simplify processing.
         * - Use a visited array to track used characters during recursion.
         * - Make a deep copy of the current list when storing results.
         * ========================================================================================================
         */

        // =========================== PLACEHOLDER FOR IMPLEMENTATION ===========================
        public List<String> permuteString(String s) {
            List<String> results = new ArrayList<String>();
            char[] chars = s.toCharArray();
            permuteStringHelper(chars, 0, results);
            return results;
        }

        void permuteStringHelper(char[] chars, int index, List<String> results){
            if(index == chars.length){
                results.add(new String(chars));
                return;
            }

            for(int i=index;i<chars.length;i++){
                swap(chars, index, i);
                permuteStringHelper(chars, index+1,results);
                swap(chars, index, i);
            }
        }

        public static void swap(char[] chars, int i, int j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        // =========================== MAIN METHOD FOR TESTING ===========================
        public static void main(String[] args) {
            LeetCode_46_Permutations_Medium_for_String solver = new LeetCode_46_Permutations_Medium_for_String();

            // Test Case 1
            String input1 = "abc";
            List<String> expected1 = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
            validate(solver.permuteString(input1), expected1, "Test Case 1");

            // Test Case 2
            String input2 = "ab";
            List<String> expected2 = Arrays.asList("ab", "ba");
            validate(solver.permuteString(input2), expected2, "Test Case 2");

            // Test Case 3
            String input3 = "a";
            List<String> expected3 = Arrays.asList("a");
            validate(solver.permuteString(input3), expected3, "Test Case 3");
        }

        // =========================== VALIDATION METHOD ===========================
        private static void validate(List<String> actual, List<String> expected, String testName) {
            Set<String> actualSet = new HashSet<>(actual);
            Set<String> expectedSet = new HashSet<>(expected);
            if (actualSet.equals(expectedSet)) {
                System.out.println(testName + ": PASS");
            } else {
                System.out.println(testName + ": FAIL");
                System.out.println("Expected: " + expectedSet);
                System.out.println("Actual  : " + actualSet);
            }
        }

        // =========================== BACKTRACKING IMPLEMENTATION ===========================
        // Use this after removing the placeholder above if you want a complete version.
    /*
    public List<String> permuteString(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), new boolean[s.length()], new StringBuilder(), result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            sb.append(chars[i]);

            backtrack(chars, used, sb, result);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
    */
    }
