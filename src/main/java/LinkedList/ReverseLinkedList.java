package LinkedList;

/*
 * Problem Statement:
 * ------------------
 * Write a Java program to reverse a singly linked list.
 * The program should include:
 * - A definition for a singly linked list node.
 * - A method to reverse the linked list.
 * - A method to print the linked list.
 * - A few test cases demonstrating the reversal of different linked lists.
 */

public class ReverseLinkedList {

    // Definition for singly-linked list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse the linked list (to be implemented)
    // Function to reverse a singly linked list
    public static ListNode reverseList(ListNode head) {
        // Base case: If the list is empty, just return null
        if (head == null) return null;

        // 'before' will eventually become the new tail (initially null)
        ListNode before = null;

        // 'after' will temporarily hold the node ahead of 'temp' to prevent losing reference
        ListNode after = null;

        // 'temp' is the current node being processed
        ListNode temp = head;

        System.out.printf("\ntemp.val - %d", temp.val); // Print initial node value

        // Loop until we reach the last node
        while (temp.next != null) {

            // Save the next node so we don’t lose access after changing temp.next
            System.out.printf("\n\n1. temp.next.val - %d --> Assign it to 'after'", temp.next.val);
            after = temp.next;

            // Reverse the current node’s pointer
            // This effectively detaches it from the forward list and points it backward
            System.out.printf("\n2. before.val - %d --> Assign it to temp.next", before != null ? before.val : 0);
            temp.next = before;

            // Move 'before' one step forward to 'temp'
            System.out.printf("\n3. temp.val - %d --> Assign it to 'before'", temp.val);
            before = temp;

            // Move 'temp' one step forward to 'after'
            System.out.printf("\n4. after.val - %d --> Assign it to 'temp'", after.val);
            temp = after;
        }

        // At this point, 'temp' is at the last node; link it to the last reversed node
        temp.next = before;

        System.out.printf("\nFinal temp.val (new head) - %d", temp.val);

        // Return the new head of the reversed list
        return temp;
    }


    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Utility function to create a linked list from an array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test Case 1: Multiple elements
        int[] values1 = {1, 2, 3, 4, 5};
        ListNode head1 = createList(values1);
        System.out.println("Original List 1:");
        printList(head1);
        head1 = reverseList(head1);
        System.out.println("Reversed List 1:");
        printList(head1);

        // Test Case 2: Single element
        int[] values2 = {42};
        ListNode head2 = createList(values2);
        System.out.println("\nOriginal List 2:");
        printList(head2);
        head2 = reverseList(head2);
        System.out.println("Reversed List 2:");
        printList(head2);

        // Test Case 3: Empty list
        int[] values3 = {};
        ListNode head3 = createList(values3);
        System.out.println("\nOriginal List 3:");
        printList(head3);
        head3 = reverseList(head3);
        System.out.println("Reversed List 3:");
        printList(head3);
    }
}
