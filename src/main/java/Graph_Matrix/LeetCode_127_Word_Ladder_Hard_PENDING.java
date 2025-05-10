package Graph_Matrix;

/**
 * LeetCode_127_Word_Ladder_Medium
 *
 * Problem Category: Graph Search / BFS
 *
 * Problem Statement:
 * Given two words (beginWord and endWord), and a dictionary's word list, return the length of the shortest transformation sequence from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list.
 * Note that beginWord is not a transformed word.
 *
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One possible transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> "cog", which is 5 words long.
 *
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in the word list, so no transformation is possible.
 *
 * Brute Force Approach:
 * - Generate all possible words by changing one letter at a time.
 * - Check if each generated word exists in the word list.
 * - Recursively explore all possible transformations.
 * - This approach is inefficient due to redundant calculations and lack of pruning.
 *
 * Optimal Approach:
 * - Use Breadth-First Search (BFS) to explore the shortest transformation sequence.
 * - Start from beginWord and explore all valid transformations level by level.
 * - Use a queue to manage the BFS and a set to track visited words.
 * - This ensures the shortest path is found efficiently.
 *
 * Additional Hints:
 * - Treat each word as a node in a graph.
 * - An edge exists between two nodes if their words differ by exactly one letter.
 * - BFS is ideal for finding the shortest path in an unweighted graph.
 */

import java.util.*;

public class LeetCode_127_Word_Ladder_Hard_PENDING {

    // Placeholder for the implementation method
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Implement the BFS approach here
        return 0;
    }

    public static void main(String[] args) {
        LeetCode_127_Word_Ladder_Hard_PENDING solution = new LeetCode_127_Word_Ladder_Hard_PENDING();

        // Test Case 1
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord1 = "hit";
        String endWord1 = "cog";
        int result1 = solution.ladderLength(beginWord1, endWord1, wordList1);
        System.out.println("Test Case 1: " + (result1 == 5 ? "PASS" : "FAIL"));

        // Test Case 2
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        String beginWord2 = "hit";
        String endWord2 = "cog";
        int result2 = solution.ladderLength(beginWord2, endWord2, wordList2);
        System.out.println("Test Case 2: " + (result2 == 0 ? "PASS" : "FAIL"));
    }

    /**
     * Helper method to generate all possible words by changing one letter at a time.
     * @param word The current word.
     * @param wordList The dictionary of words.
     * @return A list of valid transformations.
     */
    private List<String> getNextWords(String word, Set<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordList.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
            chars[i] = originalChar;
        }
        return nextWords;
    }
}

