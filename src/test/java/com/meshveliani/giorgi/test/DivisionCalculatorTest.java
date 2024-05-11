package com.meshveliani.giorgi.test;

import com.meshveliani.giorgi.calculation.impl.DivisionCalculator;
import com.meshveliani.giorgi.output.DivisionInColumnConsoleWriterInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DivisionCalculatorTest {

    @Test
    void populateDivisionStepShouldCreateDivisionSteps() {

        DivisionInColumnConsoleWriterInterface divisionInOutputMock = mock(
                DivisionInColumnConsoleWriterInterface.class);

        DivisionCalculator calculator = new DivisionCalculator(divisionInOutputMock);

        calculator.makeDivision(String.valueOf(3272), String.valueOf(7));

        verify(divisionInOutputMock).populateDivisionStep(32, 28);
        verify(divisionInOutputMock).populateDivisionStep(47, 42);
        verify(divisionInOutputMock).populateDivisionStep(52, 49);

    }

    @ParameterizedTest
    @CsvSource({ "5680, 10, 0, 568", "7658, 33, 2, 232", "8795, 5, 0, 1759" })
    void printDivisionResultShouldDisplayDivisionResults(int dividend, int divisor, int expectedRemainder, int expectedResult)
            throws Exception {

        DivisionInColumnConsoleWriterInterface divisionInOutputMock = mock(
                DivisionInColumnConsoleWriterInterface.class);

        DivisionCalculator calculator = new DivisionCalculator(divisionInOutputMock);

        calculator.makeDivision(String.valueOf(dividend), String.valueOf(divisor));

        verify(divisionInOutputMock).printDivisionResult(String.valueOf(expectedRemainder),
                String.valueOf(expectedResult));
        verify(divisionInOutputMock).printDivisionResult(String.valueOf(expectedRemainder),
                String.valueOf(expectedResult));
        verify(divisionInOutputMock).printDivisionResult(String.valueOf(expectedRemainder),
                String.valueOf(expectedResult));

    }
}
