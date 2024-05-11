package com.meshveliani.giorgi.output.impl;

import com.meshveliani.giorgi.output.DivisionInColumnConsoleWriterInterface;

public class DivisionInColumnConsoleWriter implements DivisionInColumnConsoleWriterInterface {
    private static final String OUTPUT_TEMPLATE_HEADER = "_%s|%s\n %s%s|-----\n";
    private static final String OUTPUT_TEMPLATE_RESULT_LINE = " -%s|%s\n";
    private static final String OUTPUT_TEMPLATE = "%s_%s\n %s%s\n%s%s\n";

    private static final char SPACE_CHAR = ' ';
    private static final char DASH_CHAR = '-';
    private static final int INDENTATION_LEVEL = 1;

    private final String division;
    private final String divider;

    private final StringBuilder divisionResult;
    private final StringBuilder divisionHeaderResult;
    private int currentIndentationLevel;

    public DivisionInColumnConsoleWriter(String division, String divider) {
        this.division = division;
        this.divider = divider;

        this.divisionResult = new StringBuilder();
        this.divisionHeaderResult = new StringBuilder();
        currentIndentationLevel = 0;
    }

    @Override
    public void populateDivisionStep(int subtracted, int subtract) {
        if (divisionHeaderResult.length() == 0) {
            populateDivisionHeader(subtract);
            return;
        }

        String indentLevelSpaces = provideSpaceString(currentIndentationLevel);
        String dashes = provideDashString(String.valueOf(subtract).length());

        divisionResult.append(String.format(OUTPUT_TEMPLATE, indentLevelSpaces, subtracted, indentLevelSpaces, subtract,
                indentLevelSpaces, dashes));

        currentIndentationLevel += INDENTATION_LEVEL;
    }

    private void populateDivisionHeader(int subtract) {
        String spaces = provideSpaceString(division.length() - String.valueOf(subtract).length());

        divisionHeaderResult.append(String.format(OUTPUT_TEMPLATE_HEADER, division, divider, subtract, spaces));
    }

    private String provideDashString(int length) {
        return provideRepeatableString(DASH_CHAR, length);
    }

    private String provideSpaceString(int length) {
        return provideRepeatableString(SPACE_CHAR, length);
    }

    private String provideRepeatableString(char repeatChar, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(repeatChar);
        }
        return result.toString();
    }

    @Override
    public void printDivisionResult(String divisionRest, String divisionResult) {
        String spaces = provideSpaceString(division.length());
        final String resultLine = String.format(OUTPUT_TEMPLATE_RESULT_LINE, spaces, divisionResult);

        populateDivisionRestNumber(divisionRest);

        System.out.println(divisionHeaderResult + resultLine + this.divisionResult);
    }

    private void populateDivisionRestNumber(String theRest) {
        String spaces = provideSpaceString(currentIndentationLevel);

        divisionResult.append(spaces).append(theRest);
    }
}
