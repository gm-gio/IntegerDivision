package com.meshveliani.giorgi;

import com.meshveliani.giorgi.calculation.impl.DivisionCalculator;
import com.meshveliani.giorgi.output.impl.DivisionInColumnConsoleWriter;

import java.util.Scanner;
import java.util.logging.Logger;

public class IntegerDivision {
    private static final Logger LOGGER = Logger.getLogger(IntegerDivision.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Enter the Dividend");
        String division = scanner.nextLine();

        LOGGER.info("Enter the Divisor");
        String divider = scanner.nextLine();

        LOGGER.info("Result Of Division");

        DivisionInColumnConsoleWriter consoleWriter = new DivisionInColumnConsoleWriter(division, divider);

        DivisionCalculator calculator = new DivisionCalculator(consoleWriter);
        calculator.makeDivision(division, divider);

        scanner.close();
    }
}