package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);
        myBST.insert(27);
        System.out.println(myBST.root.left.right.value);
        System.out.println("Root: " + myBST.root);  // Should print: Root: null
        System.out.println(myBST.rcontains(82));
        System.out.println(myBST.rcontains(822));

        BinarySearchTree rBST = new BinarySearchTree();
        rBST.insert(47);
        rBST.insert(21);
        rBST.insert(76);
        rBST.insert(18);
        rBST.insert(27);
        rBST.insert(52);
        rBST.insert(82);
        System.out.println(rBST.findMinValue(rBST.root));
        System.out.println(rBST.findMinValue(rBST.root.right));

        System.out.println("Testing Delete Node");
        BinarySearchTree rBST1 = new BinarySearchTree();
        rBST1.insert(2);
        rBST1.insert(1);
        rBST1.insert(3);
        System.out.println("Before Delete");
        System.out.println(rBST1.root.value);
        System.out.println(rBST1.root.left.value);
        System.out.println(rBST1.root.right.value);
        rBST1.rDeleteNode(2);
        System.out.println("After Delete");
        System.out.println(rBST1.root.value);
        System.out.println(rBST1.root.left.value);
        System.out.println(rBST1.root.right);

        System.out.println("\n\n\ntestInvertBinarySearchTree");
        testInvertBinarySearchTree();


        //BFS
        System.out.println("\n\n\nBFS- Breadth First Search");
        BinarySearchTree myBFS = new BinarySearchTree();
        myBFS.insert(47);
        myBFS.insert(21);
        myBFS.insert(76);
        myBFS.insert(18);
        myBFS.insert(27);
        myBFS.insert(52);
        myBFS.insert(82);
        System.out.println(myBFS.BFS());

    }



    private static void performTest(String description, int[] insertValues, Integer[] expectedValues, boolean doubleInversion) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int value : insertValues) {
            bst.insert(value);
        }
        if (doubleInversion) {
            bst.invert(); // First inversion
        }
        bst.invert(); // Perform inversion (or second inversion for the specific case)


        ArrayList<Integer> resultList = bst.BFS();

        // Use Arrays.asList for compatibility with older Java versions
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(expectedValues));

        System.out.println(description + ": " + (expectedList.equals(resultList) ? "Pass" : "Fail"));
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual:   " + resultList);
    }

    private static void testInvertBinarySearchTree() {
        System.out.println("--- Testing Inversion of Binary Search Tree ---");


        performTest("Invert an empty tree", new int[]{}, new Integer[]{}, false);
        performTest("Invert a tree with a single node", new int[]{1}, new Integer[]{1}, false);
        performTest("Invert a tree with only a left child", new int[]{2, 1}, new Integer[]{2, null, 1}, false);
        performTest("Invert a tree with only a right child", new int[]{1, 2}, new Integer[]{1, 2}, false);
        performTest("Invert a full binary tree", new int[]{2, 1, 3}, new Integer[]{2, 3, 1}, false);
        performTest("Invert a more complex binary tree", new int[]{4, 2, 6, 1, 3, 5, 7}, new Integer[]{4, 6, 2, 7, 5, 3, 1}, false);
        performTest("Double inversion returns original", new int[]{3, 1, 4}, new Integer[]{3, 1, 4}, true);
    }



}