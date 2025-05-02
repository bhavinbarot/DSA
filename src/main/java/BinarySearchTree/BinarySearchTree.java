package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        //If BST is null, set new node as Root node
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            //New Node is same as Root Node (or current node), in this case, return False. We cannot add the node again.
            if (newNode.value == temp.value){
                return false;
            }
            else {
                //If new node is less than root node
                if(newNode.value < temp.value){
                    if(temp.left == null){
                        temp.left = newNode;
                        return true;
                    }else {
                        temp = temp.left;
                    }
                }else {
                    if(temp.right == null){
                        temp.right = newNode;
                        return true;
                    }else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    public boolean contains(int value){

        if (root == null){
            return false;
        }
        Node temp = root;

        while (temp!=null){
            if(temp.value == value) return true;
            if(value < temp.value){
                temp = temp.left;
            }
            else if(value > temp.value){
                temp = temp.right;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;

        if(currentNode.value == value) return true;
        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }
    }

    public boolean rcontains(int value) {
        return rContains(root, value);
    }

    private Node rInsert(Node current, int value) {
        // Base case: If current node is null, we've found the spot to insert
        if (current == null) {
            return new Node(value);
        }

        // If the value is less than the current node, go left
        if (value < current.value) {
            current.left = rInsert(current.left, value);
        }
        // If the value is greater than the current node, go right
        else if (value > current.value) {
            current.right = rInsert(current.right, value);
        }
        // If the value is equal, do nothing (duplicates are not inserted)
        // You could add logic here to allow duplicates if needed

        return current;  // Return the (possibly updated) current node
    }

    public Node rInsert(int value){
        if(root == null) root = new Node(value);
        return rInsert(root, value);
    }

    // Recursive helper method to delete a node
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null; // Value not found in tree
        }

        if (value < current.value) {
            // Go left if value is smaller
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.value) {
            // Go right if value is larger
            current.right = deleteRecursive(current.right, value);
        } else {
            // Node with the value found

            // Case 1: Node has no children (leaf node)
            if (current.left == null && current.right == null) {
                return null; // Simply remove it
            }

            // Case 2: Node has only one child
            if (current.left == null) {
                return current.right; // Replace with right child
            } else if (current.right == null) {
                return current.left; // Replace with left child
            }

            // Case 3: Node has two children
            // Find the smallest value in the right subtree (in-order successor)
            int minValue = findMinValue(current.right);
            current.value = minValue; // Replace current node's value with successor's value
            // Delete the in-order successor
            current.right = deleteRecursive(current.right, minValue);
        }

        return current; // Return the updated subtree
    }

    // Helper to find the minimum value in a subtree
    public int findMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public void rDeleteNode(int value){
        if(root == null) return;
        deleteRecursive(root, value);
    }

    //Create a method to convert a sorted array into heigh-balanced binary search tree
    //This method is private and used internally within the class
    //It uses recursion to construct a BST

    //Parameters:
    //nums : sorted array of integers
    //left : Starting Index for the current segment of the array
    //right : Ending Index for the current segment of the array

    //Tips:
    //The middle element of the current segment is chosen as the root to ensure the BST is height balanced.
    //The method recursively builds the left and right subtrees by calling itself with adjusted left and right indices to work on sub-segments of the array

    // Public method to initiate the conversion from sorted array to BST
    public void sortedArrayToBST(int[] nums) {
        root = buildBSTFromSortedArray(nums, 0, nums.length - 1);
    }
    private Node buildBSTFromSortedArray(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: no elements to process
        }

        int mid = left + (right - left) / 2; // Avoids potential overflow
        Node node = new Node(nums[mid]);     // Middle element becomes the root

        // Recursively build the left subtree from left part of array
        node.left = buildBSTFromSortedArray(nums, left, mid - 1);

        // Recursively build the right subtree from right part of array
        node.right = buildBSTFromSortedArray(nums, mid + 1, right);

        return node; // Return the constructed node
    }



//   | - Inverts a binary tree by swapping the left and  right children of all nodes in the tree.        |
//   | - This method is private and intended for internal use within the class.                           |
//   | - It operates recursively, visiting each node and |swapping its children.                          |     |
//   | Parameters:                                       |
//   | - node: The current node to process.              |     |
//   | Return:                                           |
//   | - The node after its subtree has been inverted.
//   | Tips:
//   | - The base case for the recursion is when the method encounters a null node.
//   | - A temporary node is used to facilitate the swap of the left and right children.
    public void invert(){
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) {
            return null; // Base case: If node is null, nothing to invert
        }

        // Recursively invert left and right subtrees
        Node leftInverted = invertTree(node.left);
        Node rightInverted = invertTree(node.right);

        // Swap the left and right children
        node.left = rightInverted;
        node.right = leftInverted;

        return node; // Return the node after inversion
    }




    //BFS - Breadth First Search
    public ArrayList<Integer> BFS() {
        // Create a list to store the result of the breadth-first traversal
        ArrayList<Integer> results = new ArrayList<>();

        // If the tree is empty, return the empty list
        if (root == null) {
            return results;
        }

        // Use Java's built-in Queue interface with a LinkedList implementation
        Queue<Node> queue = new LinkedList<>();

        // Start with the root node
        queue.add(root);

        // Continue processing until the queue is empty
        while (!queue.isEmpty()) {
            // Remove the node at the front of the queue
            Node currentNode = queue.remove();

            // Visit the current node and add its value to the results list
            results.add(currentNode.value);

            // If the current node has a left child, enqueue it
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // If the current node has a right child, enqueue it
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        // Return the list of node values in BFS order
        return results;
    }

    public ArrayList<Integer> DFSPreOrder_old() {
        // Create a list to store the result of pre-order traversal
        ArrayList<Integer> results = new ArrayList<>();

        // Define a local inner class for the recursive traversal
        class Traverse {
            // Constructor that performs the traversal starting from the given node
            Traverse(Node currentNode) {
                // Visit the current node and add its value to the results list
                results.add(currentNode.value);

                // If the current node has a left child, recursively traverse it
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                // If the current node has a right child, recursively traverse it
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        // Start the traversal from the root node
        new Traverse(root);

        // Return the list of values collected in pre-order
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        if(root!=null) DFSPreOrderHelper(root, results);
        return results;
    }

    void DFSPreOrderHelper(Node currentNode, ArrayList<Integer> results){
        //Pre Order - Adding Current Node comes first
        results.add(currentNode.value);
        if(currentNode.left != null) DFSPreOrderHelper(currentNode.left, results);
        if(currentNode.right != null) DFSPreOrderHelper(currentNode.right, results);
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        if(root!=null) DFSPostOrderHelper(root, results);
        return results;
    }

    void DFSPostOrderHelper(Node currentNode, ArrayList<Integer> results){
        if(currentNode.left != null) DFSPostOrderHelper(currentNode.left, results);
        if(currentNode.right != null) DFSPostOrderHelper(currentNode.right, results);
        //Post Order - Adding Current Node comes last
        results.add(currentNode.value);
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        if(root!=null) DFSPostOrderHelper(root, results);
        return results;
    }

    void DFSInOrderHelper(Node currentNode, ArrayList<Integer> results){
        if(currentNode.left != null) DFSInOrderHelper(currentNode.left, results);
        //In Order - Adding Current Node comes in the middle
        results.add(currentNode.value);
        if(currentNode.right != null) DFSInOrderHelper(currentNode.right, results);
    }

    public boolean isValidBST(){
        ArrayList<Integer> results = DFSInOrder();
        for(int i=0;i<results.size()-1;i++){
            if(results.get(i) >= results.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public Integer kthSmallest(int k) {
        // Stack to simulate the in-order traversal (iterative approach)
        Stack<Node> stack = new Stack<>();

        // Start with the root node of the BST
        Node node = this.root;

        // Continue as long as there are nodes to visit
        while (!stack.isEmpty() || node != null) {

            // Go as far left as possible (in-order: left -> root -> right)
            while (node != null) {
                stack.push(node);      // Push current node to stack before going left
                node = node.left;      // Move to the left child
            }

            // Node is null here, so backtrack to the most recent node
            node = stack.pop();        // Process the node at the top of the stack
            k--;                       // Decrement k (we've found the next smallest element)

            // If k reaches 0, we've found the kth smallest element
            if (k == 0) {
                return node.value;     // Return the value of the kth smallest node
            }

            // Move to the right subtree to continue in-order traversal
            node = node.right;
        }

        // If k is larger than the number of nodes, return null (not found)
        return null;
    }



}