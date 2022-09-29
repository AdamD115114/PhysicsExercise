package com.example.project;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BicycleTest {
    
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final PrintStream originalOut = System.out;

    // Setup console streams
    @BeforeEach
    public void setupStreams(){
        System.setOut(new PrintStream(outContent));
    }
    // Revert Setup
    @AfterEach
    public void restoreStreams() {
        outContent.reset();
        System.setOut(originalOut);
    }

    @Test
    void testMain() {
        Bicycle.main(new String[]{});
        for (String line : outContent.toString().split(System.lineSeparator())) {
            if(line.contains("90")) {
                assertEquals(" ", line);
            }else{
                assertEquals("", line);
            }
        }
    }
}
