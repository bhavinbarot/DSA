package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    //Private variables that defines LinkedListClass
    private Node head;
    private Node tail;
    private int length;

    //Class Definition of Node for Linked List
    public class Node{
        int value;
        Node next;

        //Constructor for Node Class
        Node(int value){
            this.value = value;
        }
    }

    //Public Constructor for LinkedList Class
    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length=1;
    }

    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public int getLength(){
        return length;
    }

    public void printAll(){
        if(length == 0){
            System.out.println("Head:null, Tail:null, Length = 0");
        }else{
            System.out.printf("Head - %d , Tail - %d , Length - %d", head.value, tail.value, length);
        }
        System.out.println("\nPrinting LinkedList:");
        printList();
    }

    public void printList(){
        Node temp = head;
        if(length == 0){
            System.out.println("Linked list is Empty\n");
        }else
        {
            while(temp.next != null){
                System.out.printf("->"+temp.value);
                temp = temp.next;
            }
            System.out.println("->"+temp.value);
        }

    }

    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value){
        Node newNode = new Node(value);
        Node temp = head;
        if(length == 0){
            head = newNode;
            tail = newNode;
            length++;
        }else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            tail = newNode;
            length++;
        }

    }

    public Node removeLast(){
        Node temp = head;
        if(length == 0) return null;
        if(length == 1){
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        else{
            Node previousNode = temp;
            temp = temp.next;
            while(temp.next != null){
                previousNode =  temp;
                temp = temp.next;
            }
            tail = previousNode;
            tail.next = null;
            length--;
            return previousNode;
        }

    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if(length ==0){
            head = newNode;
            tail = newNode;
            length++;
        }else{
            newNode.next = head;
            head = newNode;
            length++;
        }

    }

    public void removeFirst() {
        if (length == 0) {
            System.out.println("List is empty. Cannot removeFirst.");
            return;
        }else if(length == 1){
            head = null;
            tail = null;
            length --;
        }else{
            head = head.next;
            length--;
        }
    }

    public Node get(int index){
        if(length == 0 || index > length || index < 0) {
            System.out.println("Value at Index : " + index + " is not available.");
            return null;
        }
        int currentIndex = 0;
        Node temp = head;
        while(currentIndex < index){
            temp = temp.next;
            currentIndex++;
        }
        System.out.println("Value at Index : " + index + " is " + temp.value);
        return temp;
    }

    public boolean set(int index, int value){
        if(length == 0 || index > length || index < 0){
            System.out.println("Cannot Set Value : " + value+" at Index : " + index);
            return false;
        }
        Node nodeAtIndex = get(index);
        nodeAtIndex.value = value;
        System.out.println("Setting Value : " + value+" at Index : " + index);
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            System.out.println("Cannot Insert Value : " + value+" at Index : " + index);
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = head;
        Node previousNode = head;
        temp = temp.next;
        while(temp.next !=null){
            previousNode = temp;
            temp = temp.next;
        }
        previousNode.next = newNode;
        newNode.next = temp;
        length++;
        return true;
    }


    public Node remove(int index){
        if(index < 0 || index > length){
            System.out.println("Cannot Remove Value at Index : " + index);
            return null;
        }
        if(index == 0){
            Node temp = head;
            head = head.next;
            length--;
            return temp;
        }

        Node previousNode = get(index-1);
        Node currentNode = previousNode.next;
        if(currentNode.next != null){
            previousNode.next = currentNode.next;
        }
        else{
            previousNode.next = null;
            tail = previousNode;
        }
        length--;
        return currentNode;
    }

    public void reverse(){
        if(length > 1){
            Node temp = head;
            head = tail;
            tail = temp;

            Node before = null;
            Node after = null;

            for(int i=0; i<length;i++){
                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;

            }
        }
    }


    public Node findMiddleNode(){
        if(head == null){
            System.out.println("There are no records");
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node is :" + slow.value);
        return slow;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;

        //Move fast pointer K step ahead
        for(int i=0;i<k;i++){
            if(fast == null){
                System.out.println("The linked is empty.");
                return null;
            }
            fast = fast.next;
        }
        //Fast pointer is already K steps ahead.
        //Increment both Fast and Slow Pointer one at a time.
        //When Fast pointer reaches end
        //Slow pointer is going to point at Kth node from the end.
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("The kth("+k+"th) node from end is = " + slow.value);
        return slow;
    }


    public void removeDuplicates_On2(){
        //O(n^2) method
        //1. Initialize a pointer current pointing to the head of the list
        //2. Start an Outer while loop that continues until current is NULL
            //a.Initialize a pointer runner pointing to the current node
            //b.Start an inner while loop that continues until runner.next is NULL
                //i.Check if the value of the runner.next node is equal to the value of the current node
                    //1.If it is, update the next pointer of the runner node to skip the duplicate node (i.e. runner.next = runner.next.next) and decrement the list length by 1
                //ii. if it is not, move the runner pointer one step ahead (runner = runner.next)
            //c.move current one step ahead (i.e. current = current.next)
        //3. When the outer while loop ends, all duplicate nodes will have been removed from the list.
        Node current = head;
        while(current!=null){
            Node runner = current;
            while(runner.next != null){
                if(runner.next.value == current.value){
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }

    public void removeDuplicates_On1() {
        //1.Create an empty HashSet called value to store the unique node values encountered in the linked list
        //2.Initialize two pointers: previous set to null, and current pointing to head of the list
        //3.Start while loop that continues until current is null
            //a.Check if values contains the value of the current node.
                //i.if it does, update the next pointer of the previous node to skip the current node (i.e. previous.next = current.next), and decrement the list length by 1.
            //b.If it does not,add the value of the current node to the values set and update the previous pointer to point to the current node
            //c.Move current one step ahead (i.e. current = current.next
        //4.When the while loop ends, all duplicate nodes will have been removed from the list

        //This algorithm uses a HashSet to keep track of unique values in the linked list and removes duplicates by updating the next pointers of the nodes as needed.

        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while(current!=null){
            if(values.contains(current.value)){
                previous.next = current.next;
                length--;
            }
            else{
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }

    }
    public void partitionList(int x){
        if(head ==null) return;

        //Create temporary placeholders
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;
        while(current !=null){
            if(current.value < x){
                prev1.next = current;
                prev1 = current;
            }
            else{
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;

    }

    public int binaryToDecimal(){
        int decimal = 0;
        Node temp = head;
        int weight = length-1;
        while(temp !=null){
            int weightOfTwo = 0;
            if(temp.value == 1){
                weightOfTwo = 1;
                for(int i=0 ; i<weight ; i++){
                    weightOfTwo = weightOfTwo*2;
                }
            }

            weight--;
            decimal = decimal + weightOfTwo;
            temp = temp.next;
        }
        return decimal;
    }
}
