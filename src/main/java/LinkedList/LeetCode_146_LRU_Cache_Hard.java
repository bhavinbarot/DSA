package LinkedList;

import java.util.*;

/**
 * LeetCode_146_LRU_Cache_Hard
 *
 * Problem Category: Data Structures - Cache Implementation
 *
 * Problem Statement:
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations:
 * - get(key): Return the value of the key if the key exists, otherwise return -1.
 * - put(key, value): Insert or update the value of the key. When the cache reaches its capacity,
 *   it should invalidate the least recently used item before inserting a new item.
 *
 * Example:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * System.out.println(cache.get(1));       // returns 1
 * cache.put(3, 3);                        // evicts key 2
 * System.out.println(cache.get(2));       // returns -1 (not found)
 * cache.put(4, 4);                        // evicts key 1
 * System.out.println(cache.get(1));       // returns -1 (not found)
 * System.out.println(cache.get(3));       // returns 3
 * System.out.println(cache.get(4));       // returns 4
 *
 * Brute Force Approach:
 * - Use a HashMap to store key-value pairs.
 * - Use a LinkedList to maintain the order of access.
 * - On each get or put operation, traverse the list to update the order.
 * - This approach has O(n) time complexity for each operation due to list traversal.
 *
 * Optimal Approach:
 * - Use a HashMap to store key-node pairs.
 * - Use a Doubly Linked List to maintain the order of access.
 * - Move nodes to the head of the list on access.
 * - Remove the tail node when the capacity is exceeded.
 * - This approach has O(1) time complexity for both get and put operations.
 *
 * Additional Hints:
 * - A doubly linked list allows for efficient removal and insertion of nodes.
 * - A HashMap provides O(1) average time complexity for lookups.
 * - Combining these two data structures allows for an efficient LRU cache implementation.
 *
 * The following code implements the optimal approach using a HashMap and a Doubly Linked List.
 */

public class LeetCode_146_LRU_Cache_Hard {

    // Placeholder for the LRU Cache implementation
    public static void main(String[] args) {
        // Test cases to validate the implementation
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // Expected output: 1
        cache.put(3, 3);                        // Expected evicted key: 2
        System.out.println(cache.get(2));       // Expected output: -1
        cache.put(4, 4);                        // Expected evicted key: 1
        System.out.println(cache.get(1));       // Expected output: -1
        System.out.println(cache.get(3));       // Expected output: 3
        System.out.println(cache.get(4));       // Expected output: 4
    }

    // Placeholder for the LRUCache class implementation
    static class LRUCache {
        int capacity;
        HashMap<Integer, Node> map;
        Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node == null) return -1;
            //Move to head
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);

            if(node != null){ //Existing Node
                node.value = value;
                //Move to head
                moveToHead(node);
            }else{ //New Node
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                //Append Node
                append(newNode);

                //If Capacity is full (Remove LRU)
                if(map.size() > capacity){
                    Node tailNode = popTail();
                    map.remove(tailNode.key);
                }
            }
        }

        public void moveToHead(Node node){
            removeNode(node);
            append(node);
        }
        public void removeNode(Node node){
           Node prevNode = node.prev;
           Node nextNode = node.next;
           prevNode.next = nextNode;
           nextNode.prev = prevNode;
        }
        public void append(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        public Node popTail(){
            Node lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
    }

    // Placeholder for the Node class implementation
    static class Node {
        // Define the necessary fields and constructor here
        int key;
        int value;
        Node prev, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
