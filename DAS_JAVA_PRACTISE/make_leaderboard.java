import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        String[] names = new String[size];
        int[] scores = new int[size];
        
        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().trim().split(" ");
            names[i] = input[0];
            scores[i] = Integer.parseInt(input[1]);
        }
        make_leaderboard(size, names, scores);	
        scanner.close();
    }
    
    public static void make_leaderboard(int n, String[] names, int[] scores) {
        // Create a list of name-score pairs
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(scores[i], names[i]));
        }

        // Sort the list by score in descending order and by name in ascending order
        list.sort((a, b) -> {
            if (b.score != a.score) {
                return Integer.compare(b.score, a.score);
            } else {
                return a.name.compareTo(b.name);
            }
        });

        // Print the leaderboard with ranks
        int currentRank = 1;
        int lastScore = list.get(0).score;
        System.out.println(currentRank + " " + list.get(0).name);

        for (int i = 1; i < list.size(); i++) {
            Pair currentPair = list.get(i);
            if (currentPair.score != lastScore) {
                currentRank = i + 1;
            }
            System.out.println(currentRank + " " + currentPair.name);
            lastScore = currentPair.score;
        }
    }

    // Helper class to store name-score pairs
    static class Pair {
        int score;
        String name;
        
        Pair(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }
}
