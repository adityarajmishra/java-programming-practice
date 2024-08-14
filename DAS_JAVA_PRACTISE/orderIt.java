import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr1 =  new int[n];
            int[] arr2 =  new int[n];         
            int temp;
            for(int i=0; i<n; i++){
                arr1[i] = sc.nextInt();
                
            }
            
            for(int i=0; i<n; i++){
                arr2[i] = sc.nextInt();
            }
            
            orderIt(n,arr1,arr2);

    }

    public static void orderIt(int n, int[] arr1, int[] arr2){
        //write your code here
        int time = 0;
        int i = 0; // Pointer for arr2 (ideal order)
        
        Queue<Integer> queue = new LinkedList<>();
        for (int num : arr1) {
            queue.add(num);
        }
        
        while (i < n) {
            if (queue.peek() == arr2[i]) {
                queue.poll(); // Remove the process from the queue
                i++; // Move to the next process in the ideal order
            } else {
                queue.add(queue.poll()); // Move the process to the end of the queue
            }
            time++; // Increment time for each operation
        }
        
        System.out.println(time);
    }

}


Goal
The goal is to determine the total time required to reorder the processes according to the ideal order. You can:

Execute a process, which takes 1 unit of time.
Skip a process, move it to the end of the queue, and this also takes 1 unit of time.
Approach
Start with the first process in arr1.
Compare it with the first process in arr2.
If they are the same, execute the process, and move to the next in both arrays.
If they are different, move the process from the front of arr1 to the end and increment the time.
Repeat this until all processes are executed in the ideal order.