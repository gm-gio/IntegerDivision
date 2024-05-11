package com.meshveliani.giorgi.test;

import com.meshveliani.giorgi.output.impl.DivisionInColumnConsoleWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionColumnConsoleWriterTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printDivisionResultAndDivisionStep_shouldPrintDivisionResultsAndStep() {
        DivisionInColumnConsoleWriter printResult = new DivisionInColumnConsoleWriter("1234", "4");

        printResult.populateDivisionStep(12, 12);
        printResult.printDivisionResult("0", "308");

        String expectedOutput = "_1234|4\n 12  |-----\n -    |308\n0";

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
