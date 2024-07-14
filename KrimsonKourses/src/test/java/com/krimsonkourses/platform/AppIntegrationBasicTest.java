package com.krimsonkourses.platform;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationBasicTest {

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
    public void testAddCourseSuccess() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nEXIT";
        String expectedOutput = "SUCCESS\nCourse count: 1\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddCourseInvalidSequence() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 0\nEXIT";
        String expectedOutput = "COURSE_SEQUENCE_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddCourseDuplicateName() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_COURSE NAME Mathematics SEQUENCE 2\nEXIT";
        String expectedOutput = "SUCCESS\nCOURSE_NAME_ALREADY_EXIST\nCourse count: 1\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddCourseOutOfSequence() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_COURSE NAME Physics SEQUENCE 3\nEXIT";
        String expectedOutput = "SUCCESS\nADD_COURSE_IN_SEQUENCE\nCourse count: 1\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddCourseDuplicateSequence() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_COURSE NAME Physics SEQUENCE 1\nEXIT";
        String expectedOutput = "SUCCESS\nCOURSE_SEQUENCE_ALREADY_EXIST\nCourse count: 1\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddCourseInvalidPattern() {
        String input = "ADD_COURSE NAME Mathematics\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddStudentSuccess() {
        String input = "ADD_STUDENT NAME John Doe ID 101\nEXIT";
        String expectedOutput = "SUCCESS\nCourse count: 0\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddStudentInvalidID() {
        String input = "ADD_STUDENT NAME John Doe ID -5\nEXIT";
        String expectedOutput = "STUDENT_ID_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddStudentDuplicateID() {
        String input = "ADD_STUDENT NAME John Doe ID 101\nADD_STUDENT NAME Jane Doe ID 101\nEXIT";
        String expectedOutput = "SUCCESS\nSTUDENT_ID_ALREADY_EXIST\nCourse count: 0\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddStudentInvalidPattern() {
        String input = "ADD_STUDENT NAME John Doe\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseSuccess() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_STUDENT NAME John Doe ID 101\nCOURSE_ASSIGN STUDENT 101 COURSE 1\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nCourse count: 1\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseInvalidSequence() {
        String input = "COURSE_ASSIGN STUDENT 101 COURSE 0\nEXIT";
        String expectedOutput = "COURSE_SEQUENCE_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseInvalidStudentID() {
        String input = "COURSE_ASSIGN STUDENT -1 COURSE 1\nEXIT";
        String expectedOutput = "STUDENT_ID_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseStudentNotExist() {
        String input = "COURSE_ASSIGN STUDENT 999 COURSE 1\nEXIT";
        String expectedOutput = "STUDENT_NOT_EXIST\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseNotExist() {
        String input = "ADD_STUDENT NAME John Doe ID 101\nCOURSE_ASSIGN STUDENT 101 COURSE 1\nEXIT";
        String expectedOutput = "SUCCESS\nCOURSE_NOT_EXIST\nCourse count: 0\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCoursePrerequisitesNotCompleted() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_COURSE NAME Physics SEQUENCE 2\nADD_COURSE NAME Chemistry SEQUENCE 3\nADD_STUDENT NAME John Doe ID 101\nCOURSE_ASSIGN STUDENT 101 COURSE 3\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nPRE_REQUISITES_NOT_COMPLETED\nCourse count: 3\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseAlreadyAssigned() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nADD_STUDENT NAME John Doe ID 101\nCOURSE_ASSIGN STUDENT 101 COURSE 1\nCOURSE_ASSIGN STUDENT 101 COURSE 1\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nCOURSE_ALREADY_ASSIGNED\nCourse count: 1\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAssignCourseInvalidPattern() {
        String input = "COURSE_ASSIGN STUDENT 101\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintStudentDetailsSuccess() {
        String input = "ADD_STUDENT NAME John Doe ID 101\nSTUDENT_DETAIL 101\nEXIT";
        String expectedOutput = "SUCCESS\nName: John Doe\nID: 101\nCourse count: 0\nCourse count: 0\nStudent count: 1\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintStudentDetailsInvalidID() {
        String input = "STUDENT_DETAIL -1\nEXIT";
        String expectedOutput = "STUDENT_ID_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintStudentDetailsNotExist() {
        String input = "STUDENT_DETAIL 999\nEXIT";
        String expectedOutput = "STUDENT_NOT_EXIST\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintStudentDetailsInvalidPattern() {
        String input = "STUDENT_DETAIL\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintCourseDetailsSuccess() {
        String input = "ADD_COURSE NAME Mathematics SEQUENCE 1\nCOURSE_DETAIL 1\nEXIT";
        String expectedOutput = "SUCCESS\nName: Mathematics\nSequence: 1\nCourse count: 1\nStudent count: 0\nAdios!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintCourseDetailsInvalidSequence() {
        String input = "COURSE_DETAIL 0\nEXIT";
        String expectedOutput = "COURSE_SEQUENCE_NOT_VALID\nCourse count: 0\nStudent count: 0\nAdios!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintCourseDetailsNotExist() {
        String input = "COURSE_DETAIL 999\nEXIT";
        String expectedOutput = "COURSE_NOT_EXIST\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintCourseDetailsInvalidPattern() {
        String input = "COURSE_DETAIL\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nCourse count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testExit() {
        String input = "EXIT";
        String expectedOutput = "Course count: 0\nStudent count: 0\nAdios!\n";

        assertAppOutput(input, expectedOutput);
    }
}
