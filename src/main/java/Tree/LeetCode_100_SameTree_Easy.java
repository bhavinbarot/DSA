package Tree;

/**
 * LeetCode Problem 100: Same Tree
 *
 * Problem Statement:
 * Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Examples:
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Approach:
 * - Recursively check if the current nodes are equal:
 *   - If both nodes are null, return true.
 *   - If one is null and the other isn't, return false.
 *   - If values are not equal, return false.
 *   - Recursively check left and right subtrees.
 */

public class LeetCode_100_SameTree_Easy {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to determine if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null: trees match at this branch
        if (p == null && q == null) {
            return true;
        }

        // One node is null but the other isn't: structure differs
        if (p == null || q == null) {
            return false;
        }

        // Node values differ
        if (p.val != q.val) {
            return false;
        }

        // Recursively compare left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Test cases
    public static void main(String[] args) {
        LeetCode_100_SameTree_Easy solution = new LeetCode_100_SameTree_Easy();

        // Test Case 1: Both trees are the same
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Test Case 1: " + solution.isSameTree(p1, q1)); // Expected: true

        // Test Case 2: Different structure
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Test Case 2: " + solution.isSameTree(p2, q2)); // Expected: false

        // Test Case 3: Same structure, different values
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Test Case 3: " + solution.isSameTree(p3, q3)); // Expected: false
    }
}
