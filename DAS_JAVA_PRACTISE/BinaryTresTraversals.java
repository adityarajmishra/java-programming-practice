import java.util.*;


 public class Main {
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
      
       

      traverse(root);
       
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

    public static void traverse(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair pair = st.pop();
            if (pair.second == 1) {
                preorder.add(pair.first.val);
                st.push(new Pair(pair.first, pair.second + 1));
                if (pair.first.left != null) {
                    st.push(new Pair(pair.first.left, 1));
                }
            } else if (pair.second == 2) {
                inorder.add(pair.first.val);
                st.push(new Pair(pair.first, pair.second + 1));
                if (pair.first.right != null) { // traverse the right child
                    st.push(new Pair(pair.first.right, 1));
                }
            } else if (pair.second == 3) {
                postorder.add(pair.first.val);
            }
        }

        System.out.print("Preorder traversal: ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i) + " ");
        }
        System.out.println();

        System.out.print("Inorder traversal: ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }
        System.out.println();

        System.out.print("Postorder traversal: ");
        for (int i = 0; i < postorder.size(); i++) {
            System.out.print(postorder.get(i) + " ");
        }
        System.out.println();

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