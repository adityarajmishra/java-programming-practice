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
      
     System.out.println( bottomView(root));
       
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
    public static List<Integer> bottomView(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map= new TreeMap<>();

        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();

            map.put(pair.second,pair.first.val);
             if (pair.first.left != null) {
                    queue.add(new Pair(pair.first.left, pair.second-1));
                }
              if (pair.first.right != null) {
                    queue.add(new Pair(pair.first.right, pair.second+1));
                }
        }

        for(Integer n: map.values()){
            result.add(n);
        }

        return result;
    }

    public static class Pair {
        
        TreeNode first;
        Integer second;

        public Pair(TreeNode key, Integer val){
            this.first=key;
            this.second=val;
        }

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


