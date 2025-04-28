package BinarySearchTree;

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
        Node newNode = new Node(value);
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

    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) {
            return new Node(value);
        }else if(currentNode.value == value){
            return currentNode;
        }else if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
            return currentNode;
        }
        else{
            currentNode.right = rInsert(currentNode.right, value);
            return currentNode;
        }

    }
    public Node rInsert(int value){
        if(root == null) root = new Node(value);
        return rInsert(root, value);
    }

    private Node rDeleteNode(Node currentNode, int value){
        if(currentNode == null){
            return null;
        }else  if(value < currentNode.value){
            currentNode.left = rDeleteNode(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = rDeleteNode(currentNode.right, value);
        }
        else //(currentNode.value == value)
        {
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            }else if(currentNode.left == null){
                currentNode = currentNode.right;
            }else if (currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = rDeleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void rDeleteNode(int value){
        if(root == null) return;
         rDeleteNode(root, value);
    }


}