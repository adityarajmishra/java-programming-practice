package evaluations.level1;

public class StringCounter {

    public void count(String first) {
        System.out.println("only one string provided");
    }

    public void count(String first, String second) {
        System.out.println("two strings provided");
    }

    public void count(String first, String second, String third) {
        System.out.println("three strings provided");
    }
}
