package Tree;

/**
 * LeetCode 226: Invert Binary Tree
 *
 * Problem Statement:
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example:
 * Input:
 *      4
 *     / \
 *    2   7
 *   / \ / \
 *  1  3 6  9
 * Output:
 *      4
 *     / \
 *    7   2
 *   / \ / \
 *  9  6 3  1
 *
 * Approach:
 * - This is a classic tree traversal problem.
 * - You can use recursion (DFS) to swap the left and right subtrees at each node.
 * - Alternatively, you could use BFS with a queue for an iterative approach.
 */

public class LeetCode_226_InvertBinaryTree_Easy {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }


    // Placeholder for the invertTree method
    public TreeNode invertTree_bruteForce(TreeNode root) {
        if(root == null) return null;
        //Base condition
        if(root.left == null && root.right == null) return root;

        TreeNode tempNode;
        TreeNode leftNode =  invertTree_bruteForce(root.left);
        TreeNode rightNode = invertTree_bruteForce(root.right);

        tempNode = leftNode;
        leftNode = rightNode;
        rightNode = tempNode;
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    // Helper method to print tree in-order
    private static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    // Helper method to construct the sample tree from the example
    private static TreeNode createExampleTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        return root;
    }

    // Main method to run some test cases
    public static void main(String[] args) {
        LeetCode_226_InvertBinaryTree_Easy solver = new LeetCode_226_InvertBinaryTree_Easy();

        TreeNode root = createExampleTree();
        System.out.println("Original tree (in-order): ");
        printInOrder(root);

        TreeNode inverted = solver.invertTree(root);
        System.out.println("\nInverted tree (in-order): ");
        printInOrder(inverted);

        // Additional test case: null input
        System.out.println("\n\nTest with null input:");
        TreeNode nullTree = solver.invertTree(null);
        System.out.println("Expected: null, Actual: " + nullTree);
    }
}
