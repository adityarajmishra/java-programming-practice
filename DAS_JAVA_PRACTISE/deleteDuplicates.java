import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = 0;
        this.next = null;
    }
}

class Solution {
   public static Node deleteDuplicates(Node head) {
       // Create a dummy node that helps in handling edge cases
       Node dummy = new Node(0);
       dummy.next = head;
       Node prev = dummy; // Pointer to the node before the current node
       Node current = head; // Pointer to the current node

       while (current != null) {
           // Detect the end of duplicates sequence
           while (current.next != null && current.data == current.next.data) {
               current = current.next; // Skip the nodes with the same value
           }
           
           // Check if prev.next is still current, meaning no duplicates were skipped
           if (prev.next == current) {
               prev = prev.next; // Move the prev pointer forward
           } else {
               // Skip all duplicates
               prev.next = current.next;
           }
           
           current = current.next; // Move the current pointer forward
       }

       return dummy.next; // The modified list starts from dummy.next
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // Number of elements in the linked list
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Call the deleteDuplicates method
        Node modifiedHead = Solution.deleteDuplicates(head);

        // Print the modified list
        printList(modifiedHead);
    }

    public static void printList(Node node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) sb.append(" ");
        else {
            Node head = node;
            while (head != null) {
                sb.append(head.data + " ");
                head = head.next;
            }
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        System.out.println(sb.toString());
    }
}


To solve the problem of removing duplicates from a sorted linked list, you'll need to implement the deleteDuplicates method in the Solution class. Here's how you can approach it:

Explanation
Objective: Remove all elements from the linked list that have duplicates, leaving only distinct numbers.
Approach:
Use a dummy node to handle edge cases easily.
Iterate through the list and identify sequences of nodes with duplicate values.
Remove all nodes that have duplicate values, ensuring only unique values remain in the list.

How It Works:
Dummy Node: A dummy node is used at the start of the list to simplify edge case handling.
Two Pointers: prev points to the last node before the duplicates, and current scans through the list to find duplicates.
Logic: If current.next has the same value as current, it means duplicates are found, and current is moved forward until the end of duplicates. Then, prev.next is updated to skip all duplicates.
