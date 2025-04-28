package BinarySearchTree;

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
        System.out.println(rBST.minValue(rBST.root));
        System.out.println(rBST.minValue(rBST.root.right));

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

    }



}