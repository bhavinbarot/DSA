package Tree;

/*
 * Problem Statement:
 * Given a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Explanation: The binary tree is:
 *        3
 *       / \
 *      9  20
 *         /  \
 *        15   7
 * The maximum depth is 3.
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * Explanation: The binary tree is:
 *    1
 *     \
 *      2
 * The maximum depth is 2.
 *
 * Approach:
 * We can solve this problem using a recursive depth-first search (DFS) approach.
 * For each node, we calculate the depth of its left and right subtrees and return the maximum of the two depths plus one (for the current node).
 * If the node is null, we return a depth of 0.
 *
 * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
 * The space complexity is O(h), where h is the height of the tree, due to the recursion stack.
 */

class Solution {

    // Placeholder method for the actual implementation
    public int maxDepth(TreeNode root) {
        // Base case: If the tree is empty, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursive case: Calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth between the left and right subtrees plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Test the method with some test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Binary tree: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Maximum depth of tree 1: " + solution.maxDepth(root1) + "(Expected output: 3)"); // Expected output: 3

        // Test case 2: Binary tree: [1,null,2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println("Maximum depth of tree 2: " + solution.maxDepth(root2) + "(Expected output: 2)"); // Expected output: 2

        // Test case 3: Binary tree: [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println("Maximum depth of tree 3: " + solution.maxDepth(root3) + "(Expected output: 1)"); // Expected output: 1

        // Test case 4: Empty tree
        System.out.println("Maximum depth of tree 4: " + solution.maxDepth(null) + "(Expected output: 0)"); // Expected output: 0
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a new TreeNode
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
