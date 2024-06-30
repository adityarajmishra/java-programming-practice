package evaluations.level10;

public class InvalidAgeException extends Exception {
    private final int age;

    public InvalidAgeException(int age, String message) {
        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getResolution() {
        return "Age must be 18 or older. Please provide a valid age.";
    }
}
