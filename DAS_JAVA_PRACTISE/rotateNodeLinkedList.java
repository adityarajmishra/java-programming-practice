import java.util.Scanner;

class Solution {
    public static Node rotateNode(Node head,int k){
        // write your code here 
       //You can refer the node class defination given below
        if (head == null || head.next == null || k == 0) {
            return head; // No need to rotate if list is empty or has only one element or no rotations needed
        }

        // Step 1: Find the length of the linked list and connect tail to head
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Connect the tail to the head to form a circular linked list
        current.next = head;

        // Step 2: Calculate the actual number of rotations needed (if k >= length)
        k = k % length;
        int stepsToNewHead = length - k; // The new head is at this position

        // Step 3: Find the new tail (which is stepsToNewHead - 1 from the start)
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 4: The new head is the next of the new tail
        Node newHead = newTail.next;

        // Break the circular connection
        newTail.next = null;

        return newHead;
    }
}

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



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
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
		int k=scanner.nextInt();
            // Reverse the linked list
            Node raotatedNode = Solution.rotateNode(head, k);

            printLinkedList(raotatedNode);
        }
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


To rotate the linked list by k positions, we can break down the process into the following steps:

Find the length of the linked list: This helps us calculate the effective rotations if k is greater than the length.
Connect the tail of the list to the head: This converts the list into a circular linked list temporarily.
Find the new tail and head: After rotating, the new tail will be at position (length - k % length) and the new head will be at the next node.
Break the circular connection: The node that becomes the new tail will have its next pointer set to null.


Explanation:
Find Length and Form Circle: We first traverse the list to find its length and then connect the tail back to the head, forming a circular linked list.
Effective Rotations: If k is greater than the length, k % length gives us the effective rotations needed.
Find New Tail and Head: The new tail is the (length - k)-th node from the start, and its next node will be the new head.
Break Circle: We break the circle by setting the next pointer of the new tail to null.
