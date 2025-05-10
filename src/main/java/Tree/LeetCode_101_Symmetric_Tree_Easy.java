package Tree;

/**
 * 1) Category: Binary Tree, Depth-First Search, Breadth-First Search, Recursion
 *
 * 2) Problem Description:
 *    Leetcode 101 - Symmetric Tree
 *    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * 3) Examples:
 *    Example 1:
 *        Input: [1,2,2,3,4,4,3]
 *        Output: true
 *
 *    Example 2:
 *        Input: [1,2,2,null,3,null,3]
 *        Output: false
 *
 * 4) Brute Force Approach:
 *    - Traverse the left and right subtree separately and store the structure and values.
 *    - Then compare whether the left and right subtrees are mirror images in terms of structure and values.
 *    - Time Complexity: O(n), but uses more space for storing traversal.
 *
 * 5) Optimal Approach:
 *    - Use a recursive function to check if two trees are mirrors of each other.
 *    - For root node `r`, check if `r.left` is a mirror of `r.right`.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(h), where h is the height of the tree (due to recursive stack).
 *
 * 6) Additional Hints:
 *    - A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
 *    - Think of recursion — compare nodes and their children in mirrored order.
 */

public class LeetCode_101_Symmetric_Tree_Easy {

    public static void main(String[] args) {
        // Test Case 1: Symmetric Tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        validateTestCase(root1, true, 1);

        // Test Case 2: Not Symmetric
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        validateTestCase(root2, false, 2);
    }

    /**
     * Placeholder for actual implementation method.
     * This simulates a real-world coding interview.
     * Implement this method to check if the tree is symmetric.
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    /**
     * Actual implementation for checking if two trees are mirrors.
     * Compares left of one tree with right of another and vice versa.
     */
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * Helper method to validate and print test results.
     */
    private static void validateTestCase(TreeNode root, boolean expected, int testCaseNumber) {
        boolean actual = isSymmetric(root);
        if (actual == expected) {
            System.out.println("Test Case " + testCaseNumber + ": PASS");
        } else {
            System.out.println("Test Case " + testCaseNumber + ": FAIL (Expected: " + expected + ", Got: " + actual + ")");
        }
    }



    /**
     * TreeNode class to define nodes of the binary tree.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }
}
