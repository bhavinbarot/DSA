package LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList myLinkedList = new LinkedList(4);
        System.out.println("Create a new Constructor");
        myLinkedList.printAll();

        System.out.println("Make it empty");
        myLinkedList.makeEmpty();
        myLinkedList.printAll();

        System.out.println("Adding few more");
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.printAll();


        System.out.println("\nRemove Last");
        myLinkedList.removeLast();
        myLinkedList.printAll();

        myLinkedList.removeLast();
        myLinkedList.printAll();

        myLinkedList.removeLast();
        myLinkedList.printAll();

        myLinkedList.removeLast();
        myLinkedList.printAll();

        System.out.println("\nPrepend 0");
        myLinkedList.prepend(0);
        myLinkedList.printAll();

        myLinkedList.prepend(2);
        myLinkedList.printAll();

        System.out.println("\nRemove First");
        myLinkedList.removeFirst();
        myLinkedList.printAll();
        myLinkedList.removeFirst();
        myLinkedList.printAll();


        System.out.println("\nGet Index");
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.printAll();
        myLinkedList.get(-1);
        myLinkedList.get(0);
        myLinkedList.get(1);
        myLinkedList.get(2);
        myLinkedList.get(3);
        myLinkedList.get(5);


        System.out.println("\nSet Index");
        myLinkedList.set(1,22);
        myLinkedList.printAll();

        System.out.println("\nInsert at Index");
        myLinkedList.insert(1,23);
        myLinkedList.printAll();

        System.out.println("\nRemove at Index");
        myLinkedList.remove(2);
        myLinkedList.printAll();

        System.out.println("\nReverse");
        myLinkedList.reverse();
        myLinkedList.printAll();


        System.out.println("\nLeet Code - Find Middle Node");
        System.out.println("Make it empty");
        myLinkedList.makeEmpty();
        myLinkedList.printAll();

        System.out.println("Adding odd records");
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.printAll();
        myLinkedList.findMiddleNode();

        System.out.println("Adding even records");
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.printAll();
        myLinkedList.findMiddleNode();

        System.out.println("Adding No records");
        myLinkedList.makeEmpty();
        myLinkedList.findMiddleNode();

        System.out.println("Find Kth Node from End");
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.printAll();
        myLinkedList.findKthFromEnd(3);

        System.out.println("Remove Duplicates");
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(1);
        myLinkedList.append(4);
        myLinkedList.append(2);
        myLinkedList.append(5);
        myLinkedList.printAll();
        myLinkedList.removeDuplicates_On2();
        myLinkedList.printAll();


        System.out.println("Remove Duplicates using HashSet");
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(1);
        myLinkedList.append(4);
        myLinkedList.append(2);
        myLinkedList.append(5);
        myLinkedList.printAll();
        myLinkedList.removeDuplicates_On1();
        myLinkedList.printAll();


        System.out.println("Partition List at a number");
        myLinkedList.makeEmpty();
        myLinkedList.append(3);
        myLinkedList.append(5);
        myLinkedList.append(8);
        myLinkedList.append(10);
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.printAll();
        myLinkedList.partitionList(5);
        myLinkedList.printAll();


        System.out.println("Binary to Decimal");
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(0);
        myLinkedList.append(0);
        myLinkedList.append(0);
        myLinkedList.printAll();
        System.out.println("Decimal Number - "+myLinkedList.binaryToDecimal());



    }
}
