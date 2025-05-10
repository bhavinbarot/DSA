package Array_String;

/**
 * LeetCode Problem 49 - Group Anagrams
 *
 * Problem Statement:
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original letters exactly once.
 *
 * Examples:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Approach:
 * - Iterate over each string and sort the characters in it. Use the sorted string as a key.
 * - Group all strings with the same sorted key using a HashMap.
 * - Return the values of the HashMap as the result.
 *
 * Time Complexity: O(n * k log k), where n = number of strings, k = max length of a string.
 * Space Complexity: O(n * k)
 */

import java.util.*;

public class LeetCode_49_GroupAnagrams_Medium {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // Step 1: Convert string to char array
            char[] chars = str.toCharArray();

            // Step 2: Sort the characters
            Arrays.sort(chars);

            // Step 3: Create a new string from sorted char array
            String sorted = new String(chars);

            // Step 4: Add original string to its anagram group
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new ArrayList<>(Arrays.asList(str)));
            }
        }

        // Step 5: Return grouped anagrams
        return new ArrayList<>(map.values());
    }

    // Helper method to print the list of grouped anagrams
    private static void printGroupedAnagrams(List<List<String>> result) {
        System.out.print("[");
        for (List<String> group : result) {
            System.out.print(group + ", ");
        }
        System.out.println("]");
    }

    // Test Cases
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1 Input: " + Arrays.toString(input));
        System.out.println("Expected Output: [[bat], [nat, tan], [ate, eat, tea]] (order may vary)");
        List<List<String>> result = groupAnagrams(input);
        printGroupedAnagrams(result);
    }

    private static void test2() {
        String[] input = {""};
        System.out.println("Test 2 Input: " + Arrays.toString(input));
        System.out.println("Expected Output: [[\"\"]]");
        List<List<String>> result = groupAnagrams(input);
        printGroupedAnagrams(result);
    }

    private static void test3() {
        String[] input = {"a"};
        System.out.println("Test 3 Input: " + Arrays.toString(input));
        System.out.println("Expected Output: [[\"a\"]]");
        List<List<String>> result = groupAnagrams(input);
        printGroupedAnagrams(result);
    }
}
