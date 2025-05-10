package Tree;
import java.util.*;

/**
 * 1) DSA Category:
 *    Tree Traversal, Breadth-First Search (BFS), Binary Tree
 *
 * 2) Problem Description:
 *    Given the root of a binary tree, return the level order traversal of its nodes' values.
 *    (i.e., from left to right, level by level).
 *
 * 3) Examples:
 *    Input: root = [3,9,20,null,null,15,7]
 *    Output: [[3],[9,20],[15,7]]
 *
 *    Input: root = [1]
 *    Output: [[1]]
 *
 *    Input: root = []
 *    Output: []
 *
 * 4) Brute Force Approach:
 *    Use DFS and maintain a HashMap<Integer, List<Integer>> where key = level.
 *    Traverse using DFS and populate the map, then return values in order.
 *    Not space-efficient.
 *
 * 5) Optimal Approach:
 *    Use BFS with a queue.
 *    For each level, track number of nodes at that level, process them, and enqueue children.
 *    This gives us level-order traversal with O(n) time and O(n) space.
 *
 * 6) Additional Hints:
 *    - Use a Queue data structure for level order traversal (BFS).
 *    - Keep track of level size to group nodes by level.
 *
 * 7) The test cases below will print actual and expected outputs, along with PASS/FAIL status.
 */

public class LeetCode_102_BinaryTreeLevelOrderTraversal_Medium {

    // Placeholder for the actual method implementation
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Define Results Array
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;

        //Define Queue for BFS
        Queue<TreeNode> queue = new LinkedList();
        //Add root
        queue.add(root);
        ArrayList<Integer> rootVal = new ArrayList<>();
        rootVal.add(root.val);
        results.add(rootVal);

        while(!queue.isEmpty()){
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode currentNode = queue.poll();
                //currentLevel.add(currentNode.val);

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                    currentLevel.add(currentNode.left.val);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                    currentLevel.add(currentNode.right.val);
                }
            }
            if(currentLevel.size() > 0){
                results.add(currentLevel);
            }

        }
        return results;
    }

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Test harness
    public static void main(String[] args) {
        LeetCode_102_BinaryTreeLevelOrderTraversal_Medium solution = new LeetCode_102_BinaryTreeLevelOrderTraversal_Medium();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
        testLevelOrder(root1, expected1, solution, "Test Case 1");

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(1)
        );
        testLevelOrder(root2, expected2, solution, "Test Case 2");

        // Test case 3
        TreeNode root3 = null;
        List<List<Integer>> expected3 = new ArrayList<>();
        testLevelOrder(root3, expected3, solution, "Test Case 3");
    }

    // Helper method to test and compare results
    public static void testLevelOrder(TreeNode root, List<List<Integer>> expected,
                                      LeetCode_102_BinaryTreeLevelOrderTraversal_Medium solution, String testName) {
        List<List<Integer>> actual = solution.levelOrder(root);
        boolean pass = actual.equals(expected);
        System.out.println(testName + " - Expected: " + expected);
        System.out.println(testName + " - Actual:   " + actual);
        System.out.println(testName + " - " + (pass ? "PASS ✅" : "FAIL ❌"));
        System.out.println();
    }
}
