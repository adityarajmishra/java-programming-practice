package com.krimsonkourses.platform;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationAdvanceTest {

    private void assertAppOutput(String input, String expectedOutput) {
        // Set up input stream
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Set up output stream
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Run the main method
        App.main(new String[]{});

        // Capture and process the output
        String actualOutput = out.toString().replaceAll("\\r\\n", "\n").trim();
        String formattedExpectedOutput = expectedOutput.replaceAll("\\r\\n", "\n").trim();

        if (!formattedExpectedOutput.equals(actualOutput)) {
            // Split the expected and actual outputs into lines
            String[] expectedLines = formattedExpectedOutput.split("\n");
            String[] actualLines = actualOutput.split("\n");

            // Determine the maximum length of the expected and actual output lines for proper alignment
            int maxExpectedLength = 0;
            int maxActualLength = 0;
            for (String line : expectedLines) {
                if (line.length() > maxExpectedLength) {
                    maxExpectedLength = line.length();
                }
            }
            for (String line : actualLines) {
                if (line.length() > maxActualLength) {
                    maxActualLength = line.length();
                }
            }

            // Determine the width of the header and format
            int columnWidth = Math.max(maxExpectedLength, maxActualLength) + 5;
            String expectedHeader = "===EXPECTED OUTPUT===";
            String actualHeader = "===ACTUAL OUTPUT===";
            String header = String.format("%-" + columnWidth + "s | %s", expectedHeader, actualHeader);

            // ANSI escape codes for coloring
            String redColor = "\u001B[31m";
//            String blue = "\u001B[34m";
            String magentaColor = "\u001B[35m";
            String resetColor = "\u001B[0m";

            // Build the failure message with aligned columns
            StringBuilder failureMessage = new StringBuilder();
            failureMessage.append(redColor).append("Test Failed For:\n").append(resetColor);
//            failureMessage.append(blue).append("====INPUT SEQUENCE====\n").append(input.trim()).append(resetColor).append("\n");
            failureMessage.append(magentaColor).append("====INPUT SEQUENCE====\n").append(resetColor).append(input.trim()).append("\n");
            failureMessage.append(magentaColor).append(header).append(resetColor).append("\n");

            int maxLines = Math.max(expectedLines.length, actualLines.length);
            for (int i = 0; i < maxLines; i++) {
                String expectedLine = i < expectedLines.length ? expectedLines[i] : "";
                String actualLine = i < actualLines.length ? actualLines[i] : "";

                // Add spaces to the expected line to align with the actual output column
                String formattedExpectedLine = String.format("%-" + columnWidth + "s", expectedLine);

                if (!expectedLine.equals(actualLine)) {
                    failureMessage.append(redColor).append(formattedExpectedLine).append(" | ").append(actualLine).append(resetColor).append("\n");
                } else {
                    failureMessage.append(formattedExpectedLine).append(" | ").append(actualLine).append("\n");
                }
            }

            Assertions.fail(failureMessage.toString());
        }

        // Assert equality with detailed message
        assertEquals(formattedExpectedOutput, actualOutput);
    }

    @Test
    public void testAddCourseAndExit() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\n" +
                "ADD_COURSE NAME History SEQUENCE 2\n" +
                "ADD_COURSE NAME Chemistry SEQUENCE 3\n" +
                "ADD_COURSE NAME Physics SEQUENCE 4\n" +
                "ADD_COURSE NAME Biology SEQUENCE 5\n" +
                "ADD_COURSE NAME Art SEQUENCE 6\n" +
                "ADD_COURSE NAME Literature SEQUENCE 7\n" +
                "ADD_COURSE NAME Mathematics SEQUENCE 8\n" +
                "ADD_COURSE NAME Chemistry SEQUENCE 7\n" +
                "ADD_COURSE NAME Geography SEQUENCE 9\n" +
                "ADD_COURSE NAME French\n" +
                "ADD_COURSE NAME Economics SEQUENCE 0\n" +
                "ADD_COURSE NAME Computer Science SEQUENCE 10\n" +
                "ADD_COURSE NAME Psychology SEQUENCE 11\n" +
                "ADD_COURSE NAME Sociology SEQUENCE 12\n" +
                "ADD_COURSE NAME Music SEQUENCE 13\n" +
                "ADD_COURSE NAME Music SEQUENCE 8\n" +
                "EXIT";

        String expectedOutput = "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "COURSE_NAME_ALREADY_EXIST\n" +
                "COURSE_NAME_ALREADY_EXIST\n" +
                "ADD_COURSE_IN_SEQUENCE\n" +
                "REQUEST_PATTERN_INVALID\n" +
                "COURSE_SEQUENCE_NOT_VALID\n" +
                "ADD_COURSE_IN_SEQUENCE\n" +
                "ADD_COURSE_IN_SEQUENCE\n" +
                "ADD_COURSE_IN_SEQUENCE\n" +
                "ADD_COURSE_IN_SEQUENCE\n" +
                "SUCCESS\n" +
                "Course count: 8\n" +
                "Student count: 0\n" +
                "Adios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddStudentAndExit() {
        String input = "ADD_STUDENT NAME Alice ID 101\n" +              // SUCCESS
                "ADD_STUDENT NAME Bob ID 102\n" +                // SUCCESS
                "ADD_STUDENT NAME Eve ID -1\n" +                 // STUDENT_ID_NOT_VALID
                "ADD_STUDENT NAME Alice ID 101\n" +             // STUDENT_ID_ALREADY_EXIST
                "ADD_STUDENT NAME Charlie\n" +                   // REQUEST_PATTERN_INVALID
                "ADD_STUDENT NAME David ID 103\n" +              // SUCCESS
                "ADD_STUDENT NAME Eve ID 104\n" +                // SUCCESS
                "ADD_STUDENT ID 105\n" +                         // REQUEST_PATTERN_INVALID
                "ADD_STUDENT NAME Frank ID 102\n" +              // STUDENT_ID_ALREADY_EXIST
                "ADD_STUDENT NAME George ID -2\n" +              // STUDENT_ID_NOT_VALID
                "ADD_STUDENT NAME Helen ID 106\n" +              // SUCCESS
                "ADD_STUDENT NAME Isabella ID 107\n" +           // SUCCESS
                "ADD_STUDENT NAME Isabella ID 104\n" +           // STUDENT_ID_ALREADY_EXIST
                "ADD_STUDENT NAME Jack ID 109\n" +               // SUCCESS
                "ADD_STUDENT NAME Kate ID 0\n" +                 // SUCCESS (ID can be 0)
                "EXIT";

        String expectedOutput = "SUCCESS\n" +                            // Alice added
                "SUCCESS\n" +                            // Bob added
                "STUDENT_ID_NOT_VALID\n" +               // Eve invalid ID
                "STUDENT_ID_ALREADY_EXIST\n" +          // Alice already exists
                "REQUEST_PATTERN_INVALID\n" +            // Missing ID for Charlie
                "SUCCESS\n" +                            // David added
                "SUCCESS\n" +                            // Eve added
                "REQUEST_PATTERN_INVALID\n" +            // Missing name for ID 105
                "STUDENT_ID_ALREADY_EXIST\n" +          // Bob's ID already exists
                "STUDENT_ID_NOT_VALID\n" +               // George invalid ID
                "SUCCESS\n" +                            // Helen added
                "SUCCESS\n" +                            // Isabella added
                "STUDENT_ID_ALREADY_EXIST\n" +          // Isabella's ID already exists
                "SUCCESS\n" +                            // Jack added
                "SUCCESS\n" +                            // Kate added
                "Course count: 0\n" +
                "Student count: 8\n" +
                "Adios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseToStudentAndExit() {
        String input = "ADD_STUDENT NAME Alice ID 101\n" +                   // SUCCESS: Adding student Alice
                "ADD_STUDENT NAME Bob ID 102\n" +                     // SUCCESS: Adding student Bob
                "ADD_COURSE NAME Math SEQUENCE 1\n" +                 // SUCCESS: Adding course Math
                "ADD_COURSE NAME Physics SEQUENCE 2\n" +              // SUCCESS: Adding course Physics
                "ADD_COURSE NAME Chemistry SEQUENCE 3\n" +            // SUCCESS: Adding course Chemistry
                "ADD_COURSE NAME Biology SEQUENCE 4\n" +              // SUCCESS: Adding course Biology
                "ADD_COURSE NAME English SEQUENCE 5\n" +              // SUCCESS: Adding course English
                "COURSE_ASSIGN STUDENT 101 COURSE 1\n" +              // SUCCESS: Alice assigned Math
                "COURSE_ASSIGN STUDENT 102 COURSE 1\n" +              // SUCCESS: Bob assigned Math
                "COURSE_ASSIGN STUDENT 102 COURSE 2\n" +              // SUCCESS: Bob assigned Physics
                "COURSE_ASSIGN STUDENT 101 COURSE 2\n" +              // SUCCESS: Alice assigned Physics
                "COURSE_ASSIGN STUDENT 101 COURSE 3\n" +              // SUCCESS: Alice assigned Chemistry
                "COURSE_ASSIGN STUDENT 102 COURSE 3\n" +              // SUCCESS: Bob assigned Chemistry
                "COURSE_ASSIGN STUDENT 101 COURSE 3\n" +              // COURSE_ALREADY_ASSIGNED: Alice already assigned Chemistry
                "COURSE_ASSIGN STUDENT 103 COURSE 6\n" +              // STUDENT_NOT_EXIST: Student 103 does not exist
                "COURSE_ASSIGN STUDENT 102 COURSE 6\n" +              // COURSE_NOT_EXIST: Course 4 does not exist
                "COURSE_ASSIGN STUDENT 101 COURSE 5\n" +              // PRE_REQUISITES_NOT_COMPLETED: Alice missing course 4
                "COURSE_ASSIGN STUDENT 101 COURSE -1\n" +             // COURSE_SEQUENCE_NOT_VALID: Invalid course sequence -1
                "COURSE_ASSIGN STUDENT 101 COURSE 0\n" +              // COURSE_SEQUENCE_NOT_VALID: Invalid course sequence 0
                "COURSE_ASSIGN STUDENT 101\n" +                       // REQUEST_PATTERN_INVALID: Missing course number
                "COURSE_ASSIGN STUDENT 104 COURSE 1\n" +              // STUDENT_NOT_EXIST: Student 104 does not exist
                "COURSE_ASSIGN STUDENT 101 COURSE 1 2\n" +            // REQUEST_PATTERN_INVALID: Extra arguments
                "EXIT";

        String expectedOutput = "SUCCESS\n" +                 // Add Alice
                "SUCCESS\n" +                                 // Add Bob
                "SUCCESS\n" +                                 // Add Math
                "SUCCESS\n" +                                 // Add Physics
                "SUCCESS\n" +                                 // Add Chemistry
                "SUCCESS\n" +                                 // Add Biology
                "SUCCESS\n" +                                 // Add English
                "SUCCESS\n" +                                 // Alice assigned Math
                "SUCCESS\n" +                                 // Bob assigned Math
                "SUCCESS\n" +                                 // Bob assigned Physics
                "SUCCESS\n" +                                 // Alice assigned Physics
                "SUCCESS\n" +                                 // Alice assigned Chemistry
                "SUCCESS\n" +                                 // Bob assigned Chemistry
                "COURSE_ALREADY_ASSIGNED\n" +                 // Alice already assigned Chemistry
                "STUDENT_NOT_EXIST\n" +                       // Student 103 does not exist
                "COURSE_NOT_EXIST\n" +                        // Course 4 does not exist
                "PRE_REQUISITES_NOT_COMPLETED\n" +           // Alice missing course 4
                "COURSE_SEQUENCE_NOT_VALID\n" +               // Invalid course sequence -1
                "COURSE_SEQUENCE_NOT_VALID\n" +               // Invalid course sequence 0
                "REQUEST_PATTERN_INVALID\n" +                 // Missing course number
                "STUDENT_NOT_EXIST\n" +                       // Student 104 does not exist
                "REQUEST_PATTERN_INVALID\n" +                 // Extra arguments
                "Course count: 5\n" +
                "Student count: 2\n" +
                "Adios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintStudentDetailsAndCourseDetails() {
        String input = "ADD_STUDENT NAME Alice ID 101\n" +                   // SUCCESS: Adding student Alice
                "ADD_STUDENT NAME Bob ID 102\n" +                     // SUCCESS: Adding student Bob
                "ADD_COURSE NAME Math SEQUENCE 1\n" +                 // SUCCESS: Adding course Math
                "ADD_COURSE NAME Physics SEQUENCE 2\n" +              // SUCCESS: Adding course Physics
                "COURSE_ASSIGN STUDENT 101 COURSE 1\n" +              // SUCCESS: Alice assigned Math
                "COURSE_ASSIGN STUDENT 102 COURSE 2\n" +              // SUCCESS: Bob assigned Physics
                "STUDENT_DETAIL 101\n" +                               // SUCCESS: Print details of student Alice
                "STUDENT_DETAIL 102\n" +                               // SUCCESS: Print details of student Bob
                "STUDENT_DETAIL 103\n" +                               // STUDENT_NOT_EXIST: Student 103 does not exist
                "STUDENT_DETAIL -1\n" +                                // STUDENT_ID_NOT_VALID: Invalid student ID -1
                "STUDENT_DETAIL\n" +                                   // REQUEST_PATTERN_INVALID: Missing student ID
                "COURSE_DETAIL 1\n" +                                  // SUCCESS: Print details of course Math
                "COURSE_DETAIL 2\n" +                                  // SUCCESS: Print details of course Physics
                "COURSE_DETAIL 3\n" +                                  // COURSE_NOT_EXIST: Course 3 does not exist
                "COURSE_DETAIL -1\n" +                                 // COURSE_SEQUENCE_NOT_VALID: Invalid course sequence -1
                "COURSE_DETAIL\n" +                                    // REQUEST_PATTERN_INVALID: Missing course sequence
                "EXIT";

        String expectedOutput = "SUCCESS\n" +                 // Add Alice
                "SUCCESS\n" +                                 // Add Bob
                "SUCCESS\n" +                                 // Add Math
                "SUCCESS\n" +                                // Add Physics
                "SUCCESS\n" +                                // Course Assign Alice
                "PRE_REQUISITES_NOT_COMPLETED\n" +                                // Course Assign Bob
                "Name: Alice\nID: 101\nCourse count: 1\n" +  // Details of student Alice
                "Name: Bob\nID: 102\nCourse count: 0\n" +    // Details of student Bob
                "STUDENT_NOT_EXIST\n" +                      // Student 103 does not exist
                "STUDENT_ID_NOT_VALID\n" +                   // Invalid student ID -1
                "REQUEST_PATTERN_INVALID\n" +                // Missing student ID
                "Name: Math\nSequence: 1\n" +                // Details of course Math
                "Name: Physics\nSequence: 2\n" +             // Details of course Physics
                "COURSE_NOT_EXIST\n" +                       // Course 3 does not exist
                "COURSE_SEQUENCE_NOT_VALID\n" +              // Invalid course sequence -1
                "REQUEST_PATTERN_INVALID\n" +                // Missing course sequence
                "Course count: 2\n" +
                "Student count: 2\n" +
                "Adios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAllCommands1() {

        String input =
                "ADD_COURSE NAME Math SEQUENCE 1\n" +
                        "ADD_COURSE NAME Physics SEQUENCE 2\n" +
                        "ADD_COURSE NAME Chemistry SEQUENCE 3\n" +
                        "ADD_COURSE NAME Biology SEQUENCE 1\n" +
                        "ADD_STUDENT NAME Alice ID 101\n" +
                        "ADD_STUDENT NAME Bob ID 102\n" +
                        "COURSE_ASSIGN STUDENT 101 COURSE 1\n" +
                        "COURSE_ASSIGN STUDENT 102 COURSE 2\n" +
                        "COURSE_ASSIGN STUDENT 101 COURSE 3\n" +
                        "COURSE_ASSIGN STUDENT 102 COURSE 1\n" +
                        "STUDENT_DETAIL 101\n" +
                        "STUDENT_DETAIL 102\n" +
                        "STUDENT_DETAIL 103\n" +
                        "STUDENT_DETAIL -1\n" +
                        "STUDENT_DETAIL\n" +
                        "COURSE_DETAIL 1\n" +
                        "COURSE_DETAIL 2\n" +
                        "COURSE_DETAIL 3\n" +
                        "COURSE_DETAIL 4\n" +
                        "COURSE_DETAIL -1\n" +
                        "COURSE_DETAIL\n" +
                        "EXIT\n";

        // Define the expected output based on the provided input commands
        String expectedOutput =
                "SUCCESS\n" +                      // Adding course Math
                        "SUCCESS\n" +                      // Adding course Physics
                        "SUCCESS\n" +                      // Adding course Chemistry
                        "COURSE_SEQUENCE_ALREADY_EXIST\n" + // Adding course Biology
                        "SUCCESS\n" +                      // Adding student Alice
                        "SUCCESS\n" +                      // Adding student Bob
                        "SUCCESS\n" +                      // Assigning course Math to Alice
                        "PRE_REQUISITES_NOT_COMPLETED\n" + // Assigning course Physics to Bob
                        "PRE_REQUISITES_NOT_COMPLETED\n" + // Assigning course Chemistry again to Alice
                        "SUCCESS\n" +                      // Assigning course Math again to Bob
                        "Name: Alice\nID: 101\nCourse count: 1\n" + // Details of student Alice
                        "Name: Bob\nID: 102\nCourse count: 1\n" +   // Details of student Bob
                        "STUDENT_NOT_EXIST\n" +            // Student 103 does not exist
                        "STUDENT_ID_NOT_VALID\n" +         // Invalid student ID -1
                        "REQUEST_PATTERN_INVALID\n" +      // Missing student ID
                        "Name: Math\nSequence: 1\n" +      // Details of course Math
                        "Name: Physics\nSequence: 2\n" +   // Details of course Physics
                        "Name: Chemistry\nSequence: 3\n" + // Details of course Chemistry
                        "COURSE_NOT_EXIST\n" +             // Course 4 does not exist
                        "COURSE_SEQUENCE_NOT_VALID\n" +    // Invalid course sequence -1
                        "REQUEST_PATTERN_INVALID\n" +      // Missing course sequence
                        "Course count: 3\n" +              // Course count before exit
                        "Student count: 2\n" +             // Student count before exit
                        "Adios!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAllCommands2() {
        String input = "ADD_COURSE NAME Math SEQUENCE 1\n" +
                "ADD_COURSE NAME Physics SEQUENCE 2\n" +
                "ADD_COURSE NAME Chemistry SEQUENCE 3\n" +
                "ADD_COURSE NAME Biology SEQUENCE 1\n" +
                "ADD_COURSE NAME English SEQUENCE 4\n" +
                "ADD_COURSE NAME History SEQUENCE 5\n" +
                "ADD_COURSE NAME Math SEQUENCE 2\n" +
                "ADD_COURSE NAME Physics SEQUENCE 4\n" +
                "ADD_COURSE NAME Chemistry SEQUENCE -1\n" +
                "ADD_STUDENT NAME Alice ID 101\n" +
                "ADD_STUDENT NAME Bob ID 102\n" +
                "ADD_STUDENT NAME Carol ID 103\n" +
                "ADD_STUDENT NAME Alice ID 101\n" +
                "COURSE_ASSIGN STUDENT 101 COURSE 1\n" +
                "COURSE_ASSIGN STUDENT 102 COURSE 2\n" +
                "COURSE_ASSIGN STUDENT 101 COURSE 3\n" +
                "COURSE_ASSIGN STUDENT 102 COURSE 1\n" +
                "COURSE_ASSIGN STUDENT 101 COURSE 1\n" +
                "COURSE_ASSIGN STUDENT 104 COURSE 1\n" +
                "COURSE_ASSIGN STUDENT 101 COURSE 7\n" +
                "STUDENT_DETAIL 101\n" +
                "STUDENT_DETAIL 102\n" +
                "STUDENT_DETAIL 103\n" +
                "STUDENT_DETAIL -1\n" +
                "STUDENT_DETAIL\n" +
                "COURSE_DETAIL 1\n" +
                "COURSE_DETAIL 2\n" +
                "COURSE_DETAIL 3\n" +
                "COURSE_DETAIL 4\n" +
                "COURSE_DETAIL 5\n" +
                "COURSE_DETAIL 6\n" +
                "COURSE_DETAIL -1\n" +
                "COURSE_DETAIL * _\n" +
                "COURSE_DETAIL 1 *\n" +
                "EXIT";

        String expectedOutput = "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "COURSE_SEQUENCE_ALREADY_EXIST\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "COURSE_NAME_ALREADY_EXIST\n" +
                "COURSE_NAME_ALREADY_EXIST\n" +
                "COURSE_SEQUENCE_NOT_VALID\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "SUCCESS\n" +
                "STUDENT_ID_ALREADY_EXIST\n" +
                "SUCCESS\n" +
                "PRE_REQUISITES_NOT_COMPLETED\n" +
                "PRE_REQUISITES_NOT_COMPLETED\n" +
                "SUCCESS\n" +
                "COURSE_ALREADY_ASSIGNED\n" +
                "STUDENT_NOT_EXIST\n" +
                "COURSE_NOT_EXIST\n" +
                "Name: Alice\nID: 101\nCourse count: 1\n" +
                "Name: Bob\nID: 102\nCourse count: 1\n" +
                "Name: Carol\nID: 103\nCourse count: 0\n" +
                "STUDENT_ID_NOT_VALID\n" +
                "REQUEST_PATTERN_INVALID\n" +
                "Name: Math\nSequence: 1\n" +
                "Name: Physics\nSequence: 2\n" +
                "Name: Chemistry\nSequence: 3\n" +
                "Name: English\nSequence: 4\n" +
                "Name: History\nSequence: 5\n" +
                "COURSE_NOT_EXIST\n" +
                "COURSE_SEQUENCE_NOT_VALID\n" +
                "REQUEST_PATTERN_INVALID\n" +
                "REQUEST_PATTERN_INVALID\n" +
                "Course count: 5\nStudent count: 3\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }
}
