package edu.trincoll.game.demo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameDemoTest {

    @Test
    void gameDemoMainRunsWithoutErrorsAndPrintsHeaderAndFooter() {
        // Capture System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(outContent));

            // Run the demo
            GameDemo.main(new String[0]);

        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }

        String output = outContent.toString();

        // Basic sanity checks: did the demo at least start and finish?
        assertTrue(output.contains("DESIGN PATTERNS GAME DEMO"),
                "Output should contain the demo header");
        assertTrue(output.contains("Demo complete! All patterns working together."),
                "Output should contain the demo footer");
    }
}