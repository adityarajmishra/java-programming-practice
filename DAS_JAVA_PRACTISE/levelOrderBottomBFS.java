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
      
     System.out.println( levelOrderBottom(root));
       
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
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> ans = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                ans.add(currentNode.val);

                if(currentNode.left!= null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!= null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(ans);

        }
        Collections.reverse(result);
        return result;
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

