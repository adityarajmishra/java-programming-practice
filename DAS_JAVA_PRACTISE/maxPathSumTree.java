import java.util.*;
import java.io.*;

class Main {
   public static void main(String[] args) {
               
          Scanner sc = new Scanner(System.in);
          String line = sc.nextLine();
          
        String[] parts = line.split("\\s+");
        Integer[] array = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("null")) {
                array[i] = null;
            } else {
                array[i] = Integer.parseInt(parts[i]);
            }
        }

      TreeNode root = insertLevelOrder(array);
      
     System.out.println( maxPathSum(root));
       
    }
    
     public static TreeNode insertLevelOrder(Integer[] array) {
        if (array.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();

            // Insert left child
            if (i < array.length && array[i] != null) {
                TreeNode leftChild = new TreeNode(array[i]);
                current.left = leftChild;
                queue.offer(leftChild);
            }
            i++;

            // Insert right child
            if (i < array.length && array[i] != null) {
                TreeNode rightChild = new TreeNode(array[i]);
                current.right = rightChild;
                queue.offer(rightChild);
            }
            i++;
        }
        return root;
    }
    public static int maxPathSum(TreeNode root) {
        // write your code here
         int[] maxSum = new int[1]; // To keep track of the maximum path sum
        maxSum[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxSum);
        return maxSum[0];
    }

    private static int maxPathDown(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        int left = Math.max(0, maxPathDown(node.left, maxSum)); // If the path sum is negative, take 0
        int right = Math.max(0, maxPathDown(node.right, maxSum)); // If the path sum is negative, take 0

        maxSum[0] = Math.max(maxSum[0], left + right + node.val); // Update the maximum path sum

        return Math.max(left, right) + node.val; // Return the maximum path sum "through" the current node
    }

  
}


  class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

