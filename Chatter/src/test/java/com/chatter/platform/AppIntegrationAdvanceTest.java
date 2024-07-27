package com.chatter.platform;

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
    public void testComplexInteractionWithMultipleUsersAndRooms() {
        String input = "REGISTER Alice\nREGISTER Bob\nREGISTER Charlie\nLOGIN Alice\nLOGIN Bob\nLOGIN Charlie\n" +
                "CREATE_ROOM General\nCREATE_ROOM Tech\nCREATE_ROOM Sports\n" +
                "ADD Alice TO General\nADD Bob TO Tech\nADD Charlie TO Sports\n" +
                "LOGOUT Alice\nLOGIN Alice\nADD Alice TO Sports\nLOGOUT Charlie\nLOGIN Charlie\n" +
                "CREATE_ROOM Music\nADD Bob TO Music\nLOGOUT Bob\nLOGIN Bob\n" +
                "ADD Bob TO General\nUSER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\n" +
                "LISTROOMS\nCREATE_ROOM Gaming\nADD Charlie TO Gaming\nADD Alice TO Gaming\n" +
                "LOGOUT Alice\nLOGIN Alice\nADD Alice TO Tech\nUSER_DETAIL Alice\n" +
                "LOGOUT Charlie\nADD Charlie TO Tech\nLOGOUT Charlie\nLOGIN Charlie\n" +
                "USER_DETAIL Charlie\nLISTROOMS\nLOGOUT Bob\nLOGIN Bob\nADD Bob TO Gaming\n" +
                "USER_DETAIL Bob\nEXIT";

        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: General\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: null\n" +
                "General;Tech;Sports;Music\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Tech\n" +
                "SUCCESS\nUSERNAME_NOT_ONLINE\nUSERNAME_NOT_ONLINE\nSUCCESS\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: null\n" +
                "General;Tech;Sports;Music;Gaming\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: Gaming\n" +
                "User Count: 3\nChat Room Count: 5\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testUserTransitionsBetweenMultipleRooms() {
        String input = "REGISTER Alice\nREGISTER Bob\nREGISTER Charlie\nREGISTER Dave\nREGISTER Eve\n" +
                "LOGIN Alice\nLOGIN Bob\nLOGIN Charlie\nLOGIN Dave\nLOGIN Eve\n" +
                "CREATE_ROOM General\nCREATE_ROOM Tech\nCREATE_ROOM Sports\nCREATE_ROOM Music\nCREATE_ROOM Gaming\n" +
                "ADD Alice TO General\nADD Bob TO Tech\nADD Charlie TO Sports\nADD Dave TO Music\nADD Eve TO Gaming\n" +
                "ADD Alice TO Tech\nADD Bob TO Sports\nADD Charlie TO Music\nADD Dave TO Gaming\nADD Eve TO General\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\nUSER_DETAIL Dave\nUSER_DETAIL Eve\n" +
                "LOGOUT Alice\nLOGOUT Bob\nLOGOUT Charlie\nLOGOUT Dave\nLOGOUT Eve\n" +
                "LOGIN Alice\nLOGIN Bob\nLOGIN Charlie\nLOGIN Dave\nLOGIN Eve\n" +
                "ADD Alice TO Sports\nADD Bob TO Music\nADD Charlie TO Gaming\nADD Dave TO General\nADD Eve TO Tech\n" +
                "LISTROOMS\nUSER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\nUSER_DETAIL Dave\nUSER_DETAIL Eve\n" +
                "LOGOUT Alice\nLOGOUT Bob\nLOGOUT Charlie\nLOGOUT Dave\nLOGOUT Eve\n" +
                "EXIT";

        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Tech\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: Music\n" +
                "Username: Dave\nLoggedIn: true\nChat Room: Gaming\n" +
                "Username: Eve\nLoggedIn: true\nChat Room: General\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "General;Tech;Sports;Music;Gaming\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: Music\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: Gaming\n" +
                "Username: Dave\nLoggedIn: true\nChat Room: General\n" +
                "Username: Eve\nLoggedIn: true\nChat Room: Tech\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "User Count: 5\nChat Room Count: 5\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testFrequentRoomSwitchingAndUserDetails() {
        String input = "REGISTER Alice\nREGISTER Bob\nREGISTER Charlie\nREGISTER Dave\n" +
                "LOGIN Alice\nLOGIN Bob\nLOGIN Charlie\nLOGIN Dave\n" +
                "CREATE_ROOM General\nCREATE_ROOM Tech\nCREATE_ROOM Sports\n" +
                "ADD Alice TO General\nADD Bob TO Tech\nADD Charlie TO Sports\nADD Dave TO General\n" +
                "ADD Alice TO Tech\nADD Bob TO Sports\nADD Charlie TO General\nADD Dave TO Tech\n" +
                "ADD Alice TO Sports\nADD Bob TO General\nADD Charlie TO Tech\nADD Dave TO Sports\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\nUSER_DETAIL Dave\n" +
                "LOGOUT Alice\nLOGOUT Bob\nLOGOUT Charlie\nLOGOUT Dave\n" +
                "LOGIN Alice\nLOGIN Bob\nLOGIN Charlie\nLOGIN Dave\n" +
                "ADD Alice TO General\nADD Bob TO Tech\nADD Charlie TO Sports\nADD Dave TO General\n" +
                "ADD Alice TO Sports\nADD Bob TO General\nADD Charlie TO Tech\nADD Dave TO Sports\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\nUSER_DETAIL Dave\n" +
                "LISTROOMS\nLOGOUT Alice\nLOGOUT Bob\nLOGOUT Charlie\nLOGOUT Dave\n" +
                "EXIT";

        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: General\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: Tech\n" +
                "Username: Dave\nLoggedIn: true\nChat Room: Sports\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: General\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: Tech\n" +
                "Username: Dave\nLoggedIn: true\nChat Room: Sports\n" +
                "General;Tech;Sports\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "User Count: 4\nChat Room Count: 3\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

    @Test
    public void testFrequentLoginsAndRoomTransitions() {
        String input = "REGISTER Alice\nREGISTER Bob\nREGISTER Charlie\n" +
                "LOGIN Alice\nLOGIN Bob\nLOGIN Charlie\n" +
                "CREATE_ROOM General\nCREATE_ROOM Tech\nCREATE_ROOM Sports\nCREATE_ROOM Music\n" +
                "ADD Alice TO General\nADD Bob TO Tech\nADD Charlie TO Sports\n" +
                "LOGOUT Alice\nLOGIN Alice\nADD Alice TO Music\nLOGOUT Bob\nLOGIN Bob\nADD Bob TO Sports\n" +
                "LOGOUT Charlie\nLOGIN Charlie\nADD Charlie TO General\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\n" +
                "LOGOUT Alice\nLOGIN Alice\nADD Alice TO Tech\nLOGOUT Bob\nLOGIN Bob\nADD Bob TO Music\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\n" +
                "LISTROOMS\nLOGOUT Charlie\nLOGIN Charlie\nADD Charlie TO Tech\n" +
                "LOGOUT Alice\nLOGIN Alice\nADD Alice TO Sports\n" +
                "LOGOUT Bob\nLOGIN Bob\nADD Bob TO General\n" +
                "USER_DETAIL Alice\nUSER_DETAIL Bob\nUSER_DETAIL Charlie\n" +
                "EXIT";

        String expectedOutput = "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Music\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: General\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Tech\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: Music\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: General\n" +
                "General;Tech;Sports;Music\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "SUCCESS\nSUCCESS\nSUCCESS\n" +
                "Username: Alice\nLoggedIn: true\nChat Room: Sports\n" +
                "Username: Bob\nLoggedIn: true\nChat Room: General\n" +
                "Username: Charlie\nLoggedIn: true\nChat Room: Tech\n" +
                "User Count: 3\nChat Room Count: 4\nGoodbye!\n";

        assertAppOutput(input, expectedOutput);
    }

}
