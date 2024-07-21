import java.util.*;

// Enum for course type
enum CourseType {
    ONLINE, OFFLINE
}

// Enum for course specialization
enum CourseSpecialization {
    NODEJS, JAVA
}

// Base class for Course
class Course {
    private String courseId;
    private String courseName;
    private CourseType type;
    private CourseSpecialization specialization;

    public Course(String courseId, String courseName, CourseType type, CourseSpecialization specialization) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.type = type;
        this.specialization = specialization;
    }

    // Getters
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public CourseType getType() { return type; }
    public CourseSpecialization getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return String.format("Course: %s (ID: %s), Type: %s, Specialization: %s", 
                             courseName, courseId, type, specialization);
    }
}

// Instructor class
class Instructor {
    private String instructorId;
    private String name;

    public Instructor(String instructorId, String name) {
        this.instructorId = instructorId;
        this.name = name;
    }

    // Getters
    public String getInstructorId() { return instructorId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return String.format("Instructor: %s (ID: %s)", name, instructorId);
    }
}

// Abstract base class for Learner
abstract class Learner {
    protected String learnerId;
    protected String name;
    protected int xp;

    public Learner(String learnerId, String name) {
        this.learnerId = learnerId;
        this.name = name;
        this.xp = 0;
    }

    // Getters and setters
    public String getLearnerId() { return learnerId; }
    public String getName() { return name; }
    public int getXp() { return xp; }
    public void addXp(int points) { this.xp += points; }

    public abstract CourseSpecialization getSpecialization();

    @Override
    public String toString() {
        return String.format("Learner: %s (ID: %s), XP: %d, Specialization: %s", 
                             name, learnerId, xp, getSpecialization());
    }
}

// NodeJS Learner class
class NodeJSLearner extends Learner {
    public NodeJSLearner(String learnerId, String name) {
        super(learnerId, name);
    }

    @Override
    public CourseSpecialization getSpecialization() {
        return CourseSpecialization.NODEJS;
    }
}

// Java Learner class
class JavaLearner extends Learner {
    public JavaLearner(String learnerId, String name) {
        super(learnerId, name);
    }

    @Override
    public CourseSpecialization getSpecialization() {
        return CourseSpecialization.JAVA;
    }
}

// Cohort class
class Cohort {
    private String cohortId;
    private Course course;
    private Instructor instructor;
    private List<Learner> learners;

    public Cohort(String cohortId, Course course, Instructor instructor) {
        this.cohortId = cohortId;
        this.course = course;
        this.instructor = instructor;
        this.learners = new ArrayList<>();
    }

    // Getters
    public String getCohortId() { return cohortId; }
    public Course getCourse() { return course; }
    public Instructor getInstructor() { return instructor; }
    public List<Learner> getLearners() { return learners; }

    // Add a learner to the cohort
    public void addLearner(Learner learner) {
        if (learner.getSpecialization() == course.getSpecialization()) {
            learners.add(learner);
        } else {
            System.out.println("Error: Learner specialization does not match course specialization.");
        }
    }

    // Calculate average XP of learners in the cohort
    public double calculateAverageXp() {
        if (learners.isEmpty()) return 0;
        int totalXp = learners.stream().mapToInt(Learner::getXp).sum();
        return (double) totalXp / learners.size();
    }

    @Override
    public String toString() {
        return String.format("Cohort: %s\n  %s\n  %s\n  Learners: %d\n  Average XP: %.2f", 
                             cohortId, course, instructor, learners.size(), calculateAverageXp());
    }
}

// LearnerManagementSystem class
class LearnerManagementSystem {
    private List<Course> courses;
    private List<Instructor> instructors;
    private List<Cohort> cohorts;

    public LearnerManagementSystem() {
        courses = new ArrayList<>();
        instructors = new ArrayList<>();
        cohorts = new ArrayList<>();
    }

    // Create a new course
    public Course createCourse(String courseId, String courseName, CourseType type, CourseSpecialization specialization) {
        Course course = new Course(courseId, courseName, type, specialization);
        courses.add(course);
        return course;
    }

    // Create a new instructor
    public Instructor createInstructor(String instructorId, String name) {
        Instructor instructor = new Instructor(instructorId, name);
        instructors.add(instructor);
        return instructor;
    }

    // Create a new cohort
    public Cohort createCohort(String cohortId, Course course, Instructor instructor) {
        Cohort cohort = new Cohort(cohortId, course, instructor);
        cohorts.add(cohort);
        return cohort;
    }

    // Create a new learner
    public Learner createLearner(String learnerId, String name, CourseSpecialization specialization) {
        switch (specialization) {
            case NODEJS:
                return new NodeJSLearner(learnerId, name);
            case JAVA:
                return new JavaLearner(learnerId, name);
            default:
                throw new IllegalArgumentException("Invalid specialization");
        }
    }

    // Display all details
    public void displayAllDetails() {
        System.out.println("Courses:");
        courses.forEach(System.out::println);
        
        System.out.println("\nInstructors:");
        instructors.forEach(System.out::println);
        
        System.out.println("\nCohorts:");
        cohorts.forEach(cohort -> {
            System.out.println(cohort);
            System.out.println("  Learners:");
            cohort.getLearners().forEach(learner -> System.out.println("    " + learner));
        });
    }
}

// Main class to demonstrate the functionality
public class SkillovillaLMS {
    public static void main(String[] args) {
        LearnerManagementSystem lms = new LearnerManagementSystem();

        // Create courses
        Course nodeJsOnline = lms.createCourse("NJO1", "Node.js Basics Online", CourseType.ONLINE, CourseSpecialization.NODEJS);
        Course javaOffline = lms.createCourse("JO1", "Java Fundamentals Offline", CourseType.OFFLINE, CourseSpecialization.JAVA);

        // Create instructors
        Instructor nodeInstructor = lms.createInstructor("INS1", "John Doe");
        Instructor javaInstructor = lms.createInstructor("INS2", "Jane Smith");

        // Create cohorts
        Cohort nodeJsCohort = lms.createCohort("COH1", nodeJsOnline, nodeInstructor);
        Cohort javaCohort = lms.createCohort("COH2", javaOffline, javaInstructor);

        // Create and enroll learners
        Learner nodeLearner1 = lms.createLearner("NL1", "Alice", CourseSpecialization.NODEJS);
        Learner nodeLearner2 = lms.createLearner("NL2", "Bob", CourseSpecialization.NODEJS);
        Learner javaLearner1 = lms.createLearner("JL1", "Charlie", CourseSpecialization.JAVA);
        Learner javaLearner2 = lms.createLearner("JL2", "David", CourseSpecialization.JAVA);

        nodeJsCohort.addLearner(nodeLearner1);
        nodeJsCohort.addLearner(nodeLearner2);
        javaCohort.addLearner(javaLearner1);
        javaCohort.addLearner(javaLearner2);

        // Add some XP to learners
        nodeLearner1.addXp(100);
        nodeLearner2.addXp(150);
        javaLearner1.addXp(120);
        javaLearner2.addXp(180);

        // Display all details
        lms.displayAllDetails();
    }
}