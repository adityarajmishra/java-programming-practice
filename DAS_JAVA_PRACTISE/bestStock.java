import java.util.*;

class Main{

	public static void bestStock(int[] arr,int n){
	// Write Your Code here 
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            // Update the minimum price encountered so far
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }

            // Calculate profit if sold at the current price
            int profit = arr[i] - minPrice;

            // Update the maximum profit if the current profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Print the maximum profit
        System.out.println(maxProfit);
		
	}



	public static void main(String[] args){

     	Scanner sc=new Scanner(System.in);
             
            
                int n = sc.nextInt();
                int [] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }                
           bestStock(arr,n);

	}
}



To solve the problem of finding the maximum profit that can be obtained from buying and selling a stock given the prices for n days, the idea is to find the smallest buying price and the largest selling price after that day.

Steps:
Initialize variables to keep track of the minimum price encountered so far (minPrice) and the maximum profit (maxProfit).
Iterate through the price array:
Update minPrice if the current price is lower than the minPrice.
Calculate the profit by subtracting minPrice from the current price.
Update maxProfit if the calculated profit is higher than the maxProfit.
After the loop, maxProfit will contain the maximum profit that can be achieved.


Explanation:
minPrice: Tracks the lowest price encountered as we iterate through the array. This is the best price to buy the stock.
maxProfit: Tracks the maximum profit that can be obtained by selling the stock after buying it at minPrice.
Time Complexity: The algorithm runs in O(n) time, where n is the length of the array.



Solved USING STACK:

import java.util.*;

class Main {

    public static void bestStock(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            // Ensure the stack only has indices of prices in increasing order
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                // Calculate profit as the difference between current price and price at stack top
                int profit = arr[i] - arr[stack.peek()];
                maxProfit = Math.max(maxProfit, profit);
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }

        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bestStock(arr, n);
    }
}

