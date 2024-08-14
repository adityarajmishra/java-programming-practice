import java.util.*;

class Main{

	public static void nextGreaterElement(int[] arr,int n){
	// Write Your Code here 
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element on the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element onto the stack
            stack.push(arr[i]);
        }

        // Print the result array
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
		
	}



	public static void main(String[] args){

     	Scanner sc=new Scanner(System.in);
            
            
                int n = sc.nextInt();
                int [] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }                
           nextGreaterElement(arr,n);

	}
}




To solve the problem of finding the next greater element for each element in the array, we can use a stack. The idea is to iterate through the array from right to left, and for each element, we maintain a stack that stores elements in decreasing order. Here's how the solution can be implemented:

Steps:
Initialize an empty stack.
Traverse the array from the last element to the first.
For each element:
Pop elements from the stack while the top of the stack is less than or equal to the current element.
If the stack becomes empty, it means there is no greater element on the right, so set the next greater element as -1.
Otherwise, the top of the stack is the next greater element.
Push the current element onto the stack.
Finally, print the array of next greater elements.

