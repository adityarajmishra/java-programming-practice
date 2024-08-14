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
    public static boolean detectPalindrome(Node head){
    
    // write your code here which will return boolean
        if (head == null || head.next == null) {
            return true; // A single element or empty list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalf = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        Node firstHalf = head;
        Node secondHalfCopy = secondHalf; // To restore the list later
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: (Optional) Restore the list
        reverseList(secondHalfCopy);

        return true;
    }

    // Helper function to reverse a linked list
    public static Node reverseList(Node head) {
        Node prev = null, next = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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

           
            boolean detectPalindromeResult = Solution.detectPalindrome(head);

           System.out.println(detectPalindromeResult ? "true" : "false");
        
    }

   
}

Approach:
Find the middle of the linked list: Using the fast and slow pointer technique, we can find the middle of the linked list. The slow pointer will reach the middle when the fast pointer reaches the end.
Reverse the second half of the linked list: Once the middle is found, reverse the second half of the linked list.
Compare the first half with the reversed second half: Check if the first half and the reversed second half of the linked list are identical.
Restore the linked list (optional): To maintain the original structure of the list, you can reverse the second half back to its original order.

