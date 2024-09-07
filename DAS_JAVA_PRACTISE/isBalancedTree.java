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
      
     System.out.println( isBalanced(root));
       
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
    public static boolean isBalanced(TreeNode root) {
        // write your code here
        if(root==null){
            return true;
        }
        int leftDepth= caculateDepth(root.left);
        int rightDepth= caculateDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int caculateDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= caculateDepth(root.left);
        int right= caculateDepth(root.right);

        return 1+Math.max(left,right);
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


