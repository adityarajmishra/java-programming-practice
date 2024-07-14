import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> courseEnrollment = new HashMap<>();

        int numberOfCourses = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfCourses; i++) {
            String courseName = scanner.nextLine();
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine();
            courseEnrollment.put(courseName, numberOfStudents);
        }

        String courseToCheck = scanner.nextLine();

        System.out.println(getEnrolledStudents(courseEnrollment, courseToCheck));

        scanner.close();
    }

    public static int getEnrolledStudents(HashMap<String, Integer> courseEnrollment, String courseName) {
        // Write your code here

        return courseEnrollment.getOrDefault(courseName, 0);
    }
}
