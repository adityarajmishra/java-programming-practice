package com.chatter.platform;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationHiddenTest {

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
            String magentaColor = "\u001B[35m";
            String resetColor = "\u001B[0m";

            // Build the failure message with aligned columns
            StringBuilder failureMessage = new StringBuilder();
            failureMessage.append(redColor).append("Test Failed For:\n").append(resetColor);
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
    public void testRegisterMultipleUsers() {
        String input = "REGISTER Alice\nREGISTER Bob\nREGISTER Charlie\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nUser Count: 3\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testCreateMultipleRooms() {
        String input = "CREATE_ROOM General\nCREATE_ROOM Tech\nCREATE_ROOM Random\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nUser Count: 0\nChat Room Count: 3\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testUserLoginLogoutSequence() {
        String input = "REGISTER Alice\nLOGIN Alice\nLOGOUT Alice\nLOGIN Alice\nLOGOUT Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToMultipleRooms() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nCREATE_ROOM Tech\nADD Alice TO General\nADD Alice TO Tech\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 2\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testListRoomsAfterAddUser() {
        String input = "CREATE_ROOM General\nCREATE_ROOM Tech\nREGISTER Alice\nLOGIN Alice\nADD Alice TO General\nLISTROOMS\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nGeneral;Tech\nUser Count: 1\nChat Room Count: 2\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testComplexUserInteraction() {
        String input = "REGISTER Alice\nREGISTER Bob\nLOGIN Alice\nCREATE_ROOM General\nADD Alice TO General\nLOGIN Bob\nCREATE_ROOM Tech\nADD Bob TO Tech\nUSER_DETAIL Alice\nUSER_DETAIL Bob\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUsername: Alice\nLoggedIn: true\nChat Room: General\nUsername: Bob\nLoggedIn: true\nChat Room: Tech\nUser Count: 2\nChat Room Count: 2\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutRemovesFromRoom() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nADD Alice TO General\nLOGOUT Alice\nUSER_DETAIL Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUsername: Alice\nLoggedIn: false\nChat Room: null\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandIncorrectOrder() {
        String input = "LOGIN Alice\nREGISTER Alice\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nSUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testMultipleInvalidCommands() {
        String input = "REGISTER Alice Brown\nREGISTER Bob;Smith\nCREATE_ROOM General Room\nLOGIN Bob\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nREQUEST_PATTERN_INVALID\nREQUEST_PATTERN_INVALID\nUSERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToNonExistentRoom() {
        String input = "REGISTER Alice\nLOGIN Alice\nADD Alice TO NonExistentRoom\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nROOM_NAME_NOT_FOUND\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddNonLoggedInUserToRoom() {
        String input = "REGISTER Alice\nCREATE_ROOM General\nADD Alice TO General\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nUSERNAME_NOT_ONLINE\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutNonExistentUser() {
        String input = "LOGOUT Alice\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testListRoomsMultipleTimes() {
        String input = "CREATE_ROOM General\nCREATE_ROOM Tech\nLISTROOMS\nLISTROOMS\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nGeneral;Tech\nGeneral;Tech\nUser Count: 0\nChat Room Count: 2\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testUserDetailForNotRegisteredUser() {
        String input = "USER_DETAIL Bob\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandWithExtraCharacters() {
        String input = "REGISTER! Alice\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLoginAfterLogout() {
        String input = "REGISTER Alice\nLOGIN Alice\nLOGOUT Alice\nLOGIN Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandWithMixedCase() {
        String input = "Register Alice\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testMultipleRoomsWithSameName() {
        String input = "CREATE_ROOM General\nCREATE_ROOM General\nEXIT";
        String expectedOutput = "SUCCESS\nROOM_NAME_ALREADY_EXISTS\nUser Count: 0\nChat Room Count: 1\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutRemovesUserFromRoom() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nADD Alice TO General\nLOGOUT Alice\nUSER_DETAIL Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUsername: Alice\nLoggedIn: false\nChat Room: null\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";
        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToChatRoomUserNotOnline() {
        String input = "REGISTER Alice\nCREATE_ROOM General\nADD Alice TO General\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nUSERNAME_NOT_ONLINE\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToChatRoomUserAlreadyAdded() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nADD Alice TO General\nADD Alice TO General\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUSER_ALREADY_ADDED\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testAddUserToAnotherChatRoom() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM General\nCREATE_ROOM Tech\nADD Alice TO General\nADD Alice TO Tech\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 2\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintUserDetail() {
        String input = "REGISTER Alice\nLOGIN Alice\nCREATE_ROOM Tech\nADD Alice TO Tech\nUSER_DETAIL Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nUsername: Alice\nLoggedIn: true\nChat Room: Tech\nUser Count: 1\nChat Room Count: 1\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testPrintUserDetailUserNotFound() {
        String input = "USER_DETAIL Bob\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutUserSuccess() {
        String input = "REGISTER Alice\nLOGIN Alice\nLOGOUT Alice\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutUserNotOnline() {
        String input = "REGISTER Alice\nLOGOUT Alice\nEXIT";
        String expectedOutput = "SUCCESS\nUSERNAME_NOT_ONLINE\nUser Count: 1\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testLogoutUserNotFound() {
        String input = "LOGOUT Bob\nEXIT";
        String expectedOutput = "USERNAME_NOT_FOUND\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testListAllChatRoomsWhenNoneExist() {
        String input = "LISTROOMS\nEXIT";
        String expectedOutput = "NO_ROOM_AVAILABLE\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testListAllChatRooms() {
        String input = "CREATE_ROOM General\nCREATE_ROOM Tech\nLISTROOMS\nEXIT";
        String expectedOutput = "SUCCESS\nSUCCESS\nGeneral;Tech\nUser Count: 0\nChat Room Count: 2\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testExitApplication() {
        String input = "EXIT";
        String expectedOutput = "User Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandExtraSpaces() {
        String input = "REGISTER     Alice\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandIncorrectKeyword() {
        String input = "register Alice\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandAdditionalCharacters() {
        String input = "REGISTERS Alice\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testInvalidCommandIncompleteCommand() {
        String input = "ADD Alice Tech\nEXIT";
        String expectedOutput = "REQUEST_PATTERN_INVALID\nUser Count: 0\nChat Room Count: 0\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }


}
