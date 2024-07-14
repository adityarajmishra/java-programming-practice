package com.krimsonkourses.platform;

public class CommandHandler {
    private final CourseManager courseManager;
    private final StudentManager studentManager;

    public CommandHandler() {
        courseManager = new CourseManager();
        studentManager = new StudentManager();
    }

    public String handleCommand(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) {
            return "REQUEST_PATTERN_INVALID";
        }

        return switch (parts[0]) {
            case "ADD_COURSE" -> handleAddCourse(parts);
            case "ADD_STUDENT" -> handleAddStudent(parts);
            case "COURSE_ASSIGN" -> handleCourseAssign(parts);
            case "STUDENT_DETAIL" -> handleStudentDetail(parts);
            case "COURSE_DETAIL" -> handleCourseDetail(parts);
            case "EXIT" -> handleExit(parts);
            default -> "REQUEST_NOT_SUPPORTED";
        };
    }

    private String handleAddCourse(String[] parts) {
        if (parts.length < 5 || !parts[1].equals("NAME") || !parts[parts.length - 2].equals("SEQUENCE")) {
            return "REQUEST_PATTERN_INVALID";
        }
        try {
            int sequence = Integer.parseInt(parts[parts.length - 1]);
            String name = String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length - 2));
            return courseManager.addCourse(name, sequence);
        } catch (NumberFormatException e) {
            return "COURSE_SEQUENCE_NOT_VALID";
        }
    }

    private String handleAddStudent(String[] parts) {
        if (parts.length < 5 || !parts[1].equals("NAME") || !parts[parts.length - 2].equals("ID")) {
            return "REQUEST_PATTERN_INVALID";
        }
        try {
            int id = Integer.parseInt(parts[parts.length - 1]);
            String name = String.join(" ", java.util.Arrays.copyOfRange(parts, 2, parts.length - 2));
            return studentManager.addStudent(name, id);
        } catch (NumberFormatException e) {
            return "STUDENT_ID_NOT_VALID";
        }
    }

    private String handleCourseAssign(String[] parts) {
        if (parts.length != 5 || !parts[1].equals("STUDENT") || !parts[3].equals("COURSE")) {
            return "REQUEST_PATTERN_INVALID";
        }
        try {
            int studentId = Integer.parseInt(parts[2]);
            int courseSequence = Integer.parseInt(parts[4]);

            if (studentId < 0) {
                return "STUDENT_ID_NOT_VALID";
            }
            if (courseSequence < 1) {
                return "COURSE_SEQUENCE_NOT_VALID";
            }
            if (!studentManager.studentExists(studentId)) {
                return "STUDENT_NOT_EXIST";
            }
            if (!courseManager.courseExists(courseSequence)) {
                return "COURSE_NOT_EXIST";
            }

            Student student = studentManager.getStudent(studentId);
            Course course = courseManager.getCourse(courseSequence);

            for (int i = 1; i < courseSequence; i++) {
                if (!student.hasCourse(courseManager.getCourse(i))) {
                    return "PRE_REQUISITES_NOT_COMPLETED";
                }
            }

            if (student.hasCourse(course)) {
                return "COURSE_ALREADY_ASSIGNED";
            }

            student.addCourse(course);
            return "SUCCESS";
        } catch (NumberFormatException e) {
            return "REQUEST_PATTERN_INVALID";
        }
    }

    private String handleStudentDetail(String[] parts) {
        if (parts.length != 2) {
            return "REQUEST_PATTERN_INVALID";
        }
        try {
            int studentId = Integer.parseInt(parts[1]);
            if (studentId < 0) {
                return "STUDENT_ID_NOT_VALID";
            }
            if (!studentManager.studentExists(studentId)) {
                return "STUDENT_NOT_EXIST";
            }
            Student student = studentManager.getStudent(studentId);
            return String.format("Name: %s\nID: %d\nCourse count: %d",
                    student.getName(), student.getId(), student.getCourseCount());
        } catch (NumberFormatException e) {
            return "STUDENT_ID_NOT_VALID";
        }
    }

    private String handleCourseDetail(String[] parts) {
        if (parts.length != 2) {
            return "REQUEST_PATTERN_INVALID";
        }
        try {
            int courseSequence = Integer.parseInt(parts[1]);
            if (courseSequence < 1) {
                return "COURSE_SEQUENCE_NOT_VALID";
            }
            if (!courseManager.courseExists(courseSequence)) {
                return "COURSE_NOT_EXIST";
            }
            Course course = courseManager.getCourse(courseSequence);
            return String.format("Name: %s\nSequence: %d", course.getName(), course.getSequence());
        } catch (NumberFormatException e) {
            return "COURSE_SEQUENCE_NOT_VALID";
        }
    }

    private String handleExit(String[] parts) {
        if (parts.length != 1) {
            return "REQUEST_PATTERN_INVALID";
        }
        return String.format("Course count: %d\nStudent count: %d\nAdios!",
                courseManager.getCourseCount(), studentManager.getStudentCount());
    }
}