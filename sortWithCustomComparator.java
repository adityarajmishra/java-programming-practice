import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputElements = input.substring(1, input.length() - 1).split("(?<=\\}),\\s*(?=\\{)");

        List<Student> students = new ArrayList<>();
        for (String element : inputElements) {
            element = element.trim().substring(1, element.length() - 1); // Remove curly braces
            String[] parts = element.split(",\\s*");
            String name = parts[0].substring(1, parts[0].length() - 1); // Remove quotes
            int grade = Integer.parseInt(parts[1]);
            students.add(new Student(name, grade));
        }

        List<Student> sortedStudents = sortWithCustomComparator(students);

        System.out.println(sortedStudents.toString());

        scanner.close();
    }

    public static List<Student> sortWithCustomComparator(List<Student> students) {
       //Write your code here
        students.sort(Comparator.comparingInt((Student s) -> s.grade)
        .thenComparing(s -> s.name));
        return students;
       
    }
}
