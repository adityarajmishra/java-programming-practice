import java.util.*;

public class Main {

    public static Node pairSwapping(Node head){
		//write your code here
     // Create a dummy node to simplify edge cases
    Node dummy = new Node(0);
    dummy.next = head;
    
    Node prev = dummy;
    Node current = head;
    
    // Iterate through the list
    while (current != null && current.next != null) {
        // Nodes to be swapped
        Node first = current;
        Node second = current.next;
        
        // Swapping
        prev.next = second;
        first.next = second.next;
        second.next = first;
        
        // Move prev and current pointers forward
        prev = first;
        current = first.next;
    }
    
    // Return the new head node
    return dummy.next;
}

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);	
        Node head = null;
        Node tail = null;

        while(sc.hasNext()){
            
        int data = sc.nextInt();
        if(data == -1)break;

                    Node newNode = new Node(data);
            if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next= newNode;
            tail = tail.next;
        }
        }
            printLinkedList(pairSwapping(head));
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

class Node{
    int data;
    Node next;

    public Node(int data){
        this.next = null;
        this.data = data;
    }

    public Node(int data, Node next){
        this.next = next;
        this.data = data;
    }

    public Node(){
        this.data = 0;
        this.next = null;
    }

}


To implement the pairSwapping function for swapping adjacent nodes in a linked list, you can follow these steps:

Initialize a dummy node: This helps handle edge cases like an empty list or a list with only one node more cleanly.

Iterate through the list: Swap each pair of adjacent nodes.

Adjust the pointers: Ensure the pointers are correctly updated after each swap.

Explanation:
Dummy Node: We start with a dummy node pointing to the original head. This makes it easier to handle swaps involving the head node.

Iteration: We use a while loop to iterate through the list, swapping nodes as long as there are at least two nodes to swap.

Swapping Nodes:

first is the current node.
second is the next node to be swapped with first.
Update prev.next to point to second.
Update first.next to point to second.next (the node after second).
Update second.next to point to first (making second the new head of the swapped pair).
Move Forward:

Move prev to first (now the last node in the swapped pair).
Move current to first.next (which is the next pair to be swapped).
Return: Finally, return dummy.next as the new head of the modified list.

This code will correctly swap every pair of adjacent nodes in the linked list and print the updated list as required.
