package com.meshveliani.giorgi.calculation.impl;

import com.meshveliani.giorgi.calculation.DivisionCalculatorInterface;
import com.meshveliani.giorgi.output.DivisionInColumnConsoleWriterInterface;

public class DivisionCalculator implements DivisionCalculatorInterface {
    private final DivisionInColumnConsoleWriterInterface divisionInOutput;

    public DivisionCalculator(DivisionInColumnConsoleWriterInterface divisionInOutput) {
        this.divisionInOutput = divisionInOutput;
    }

    @Override
    public void makeDivision(String dividend, String divisor) {
        char[] divisionChars = dividend.toCharArray();

        StringBuilder currentNumberBuilder = new StringBuilder();
        StringBuilder divisionResult = new StringBuilder();

        int divisorNumber = Integer.parseInt(divisor);

        for (char divisionChar : divisionChars) {
            currentNumberBuilder.append(divisionChar);

            int dividendNumber = Integer.parseInt(currentNumberBuilder.toString());

            if (dividendNumber < divisorNumber) {
                if (divisionResult.length() > 0) {
                    divisionResult.append("0");
                }
                continue;
            }

            int currentDivisionResult = dividendNumber / divisorNumber;
            int stepResult = currentDivisionResult * divisorNumber;

            divisionResult.append(currentDivisionResult);

            currentNumberBuilder.setLength(0);
            currentNumberBuilder.append(dividendNumber - stepResult);

            divisionInOutput.populateDivisionStep(dividendNumber, stepResult);
        }

        divisionInOutput.printDivisionResult(currentNumberBuilder.toString(), divisionResult.toString());

    }
}
