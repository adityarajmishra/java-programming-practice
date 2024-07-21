package com.chatter.platform;

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
    public void testRegisterUserSuccess() {
        String input = "REGISTER Alice\nEXIT";
        String expectedOutput = "SUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testRegisterUserUsernameAlreadyExists() {
        String input = "REGISTER Alice\nREGISTER Alice\nEXIT";
        String expectedOutput = "SUCCESS\nUSERNAME_ALREADY_EXISTS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testRegisterUserInvalidUsernameWithSpace() {
        String input = "REGISTER Alice Brown\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testRegisterUserInvalidUsernameWithSemiColon() {
        String input = "REGISTER Alice;Brown\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLoginUserSuccess() {
        String input = "REGISTER Alice\nLOGIN Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLoginUnregisteredUser() {
        String input = "LOGIN Bob\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLoginAlreadyLoggedInUser() {
        String input = "REGISTER Alice\nLOGIN Alice\nLOGIN Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nUSERNAME_ALREADY_ONLINE\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testCreateChatRoomSuccess() {
        String input = "CREATE_ROOM General\nEXIT";
        String expectedOutput = "SUCCESS\nUser Count: 0\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testCreateChatRoomNameAlreadyExists() {
        String input = "CREATE_ROOM General\nCREATE_ROOM General\nEXIT";
        String expectedOutput = "SUCCESS\nROOM_NAME_ALREADY_EXISTS\nUser Count: 0\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testCreateChatRoomInvalidNameWithSpace() {
        String input = "CREATE_ROOM General Room\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToChatRoomSuccess() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nADD Alice TO General\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToChatRoomUsernameNotFound() {
        String input = "CREATE_ROOM General\nADD Bob TO General\nEXIT";
        String expectedOutput = "SUCCESS\nUSERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToChatRoomRoomNameNotFound() {
        String input = "REGISTER Alice\nLOGIN Alice\nADD Alice TO RandomRoom\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nROOM_NAME_NOT_FOUND\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }


}
