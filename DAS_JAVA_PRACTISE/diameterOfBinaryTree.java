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
      
     System.out.println( diameterOfBinaryTree(root));
       
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
    public static int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        // Update the diameter if the path through the current node is longer
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
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




Alternate solution :

public static void diameterOfBinaryTree(TreeNode root) {
        // write your code here
        if(root==null) return ;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        max = Math.max(max, leftHeight+rightHeight);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
    }
    private static int calculateHeight(TreeNode node){
        if(node ==null) return 0;
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);
        return 1+Math.max(left,right);
    }
