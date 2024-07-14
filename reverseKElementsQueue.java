import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        int k = scanner.nextInt();

        reverseKElements(queue, k);

        System.out.println(queue);

        scanner.close();
    }

    public static void reverseKElements(Queue<Integer> queue, int k) {
        //Write your code here
        queueAdd(queue , k);
        int s = queue.size() - k;
        while(s-- > 0){
            int x = queue.poll();
            queue.add(x);
        }
    }

    public static void queueAdd (Queue<Integer> queue, int k){
        if(k == 0) return;
        int e = queue.poll();
        queueAdd(queue , k-1);
        queue.add(e);
    }

}
