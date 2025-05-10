package Tree;

/**
 * 1) DSA Problem Category:
 *    - Trees
 *    - Depth-First Search (DFS)
 *
 * 2) Problem Statement:
 *    LeetCode 104: Maximum Depth of Binary Tree
 *    Given the root of a binary tree, return its maximum depth.
 *    A binary tree's *maximum depth* is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * 3) Examples:
 *    Example 1:
 *        Input: [3,9,20,null,null,15,7]
 *        Output: 3
 *    Example 2:
 *        Input: [1,null,2]
 *        Output: 2
 *    Example 3:
 *        Input: []
 *        Output: 0
 *
 * 4) Brute Force Approach:
 *    - Use BFS with queue traversal, tracking depth level by level.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n) (queue usage)
 *
 * 5) Optimum Approach:
 *    - Use DFS recursion.
 *    - For each node, recursively compute the max depth of left and right subtree.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
 *
 * 6) Additional Hints:
 *    - Tree traversal can be done in several ways; DFS is naturally recursive and clean for this task.
 *    - If root is null, return 0 as base case.
 *    - Consider corner cases like a completely skewed tree.
 *
 * 7) Test Output Format:
 *    - Should print actual vs expected depth with a PASS/FAIL status.
 */

public class LeetCode_104_Maximum_Depth_of_Binary_Tree_Easy {

    // =============================
    // PLACEHOLDER: METHOD TO IMPLEMENT
    // =============================
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);   // Recursively find depth of left subtree
        int rightDepth = maxDepth(root.right); // Recursively find depth of right subtree

        return Math.max(leftDepth, rightDepth) + 1; // Add 1 for current node
    }

    // TreeNode definition as per LeetCode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // =============================
    // TESTING UTILITIES
    // =============================

    public static void main(String[] args) {
        LeetCode_104_Maximum_Depth_of_Binary_Tree_Easy solution = new LeetCode_104_Maximum_Depth_of_Binary_Tree_Easy();

        // Test Case 1
        TreeNode test1 = new TreeNode(3);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(20);
        test1.right.left = new TreeNode(15);
        test1.right.right = new TreeNode(7);
        test("Test Case 1", solution.maxDepth(test1), 3);

        // Test Case 2
        TreeNode test2 = new TreeNode(1);
        test2.right = new TreeNode(2);
        test("Test Case 2", solution.maxDepth(test2), 2);

        // Test Case 3
        TreeNode test3 = null;
        test("Test Case 3", solution.maxDepth(test3), 0);

        // Test Case 4: Single node tree
        TreeNode test4 = new TreeNode(42);
        test("Test Case 4", solution.maxDepth(test4), 1);
    }

    // Helper function to print test result
    private static void test(String testName, int actual, int expected) {
        if (actual == expected) {
            System.out.println(testName + ": PASS | Expected: " + expected + ", Got: " + actual);
        } else {
            System.out.println(testName + ": FAIL | Expected: " + expected + ", Got: " + actual);
        }
    }
}
