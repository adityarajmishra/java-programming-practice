import java.util.Scanner;

class Solution{
    public static boolean isCyclic(Node head){
		//write your code here
        ////You can refer the node class defination given below
        if (head == null || head.next == null) {
            return false; // A single node or empty list cannot have a cycle
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by one step
            fast = fast.next.next; // Move fast by two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle detected
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

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

	    int n = sc.nextInt();
        Node head = null;
        Node tail = null;
        for(int i=0; i<n; i++){
            int data = sc.nextInt();
            Node newNode = new Node(data);
	        if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next= newNode;
                tail = tail.next;
            }
        }
        int pos = sc.nextInt();

        if (pos > -1) {
            Node cycleStart = head;
            int count = 0;
            while (count < pos) {
                cycleStart = cycleStart.next;
                count++;
            }
            tail.next = cycleStart; // Creating a cycle
        }


        boolean ans =Solution.isCyclic(head);
        if(ans)System.out.println("Yes");
        else System.out.println("No");
    }

	
}


To solve the problem of detecting if a linked list has a cycle (is cyclic), we can use Floyd's Cycle Detection algorithm, also known as the "Tortoise and Hare" algorithm. This algorithm uses two pointers that move through the list at different speeds. If there is a cycle, the fast pointer will eventually meet the slow pointer. If there is no cycle, the fast pointer will reach the end of the list.

Approach:
Two Pointers (Slow and Fast):
The slow pointer moves one step at a time.
The fast pointer moves two steps at a time.
If the linked list contains a cycle, the fast pointer will eventually meet the slow pointer.
If the fast pointer reaches the end of the list, then there is no cycle.

