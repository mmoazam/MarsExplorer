package org.space.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.space.Instruction;
import org.space.PlateauSize;

class InputParserTest {

    @org.junit.jupiter.api.Test
    void parsePlateauSize() {
        String input = "5 7";

        PlateauSize plateauSize = InputParser.parsePlateauSize(input);

        Assertions.assertNotNull(plateauSize);
        Assertions.assertEquals(5, plateauSize.getWidth());
        Assertions.assertEquals(7, plateauSize.getHeight());

    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_InvalidFormat() {
        String input = "5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(input);
        });
    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_NonNumericInput() {
        String input = "5 a";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(input);
        });
    }

    @Test
    @DisplayName("PlateauSize given negative number should throw IllegalArgumentException")
    void testParsePlateauSize_NegativeInput() {
        String inputHeight = "5 -7";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(inputHeight);
        });

        String inputWidth = "-5 7";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(inputWidth);
        });
    }


    @org.junit.jupiter.api.Test
    @DisplayName("parseInstructions with valid string")
    void parseInstruction_ValidInput() {
        String input = "LRMML";
        Instruction[] expected = {
                Instruction.L,
                Instruction.R,
                Instruction.M,
                Instruction.M,
                Instruction.L
        };

        Instruction[] actual = InputParser.parseInstruction(input);

        Assertions.assertArrayEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with invalid string")
    void parseInstruction_InvalidInput() {
        String input = "LRQML";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with empty input")
    void parseInstruction_EmptyInput() {
        String input = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with null input")
    void parseInstruction_NullInput() {
        String input = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }


    @org.junit.jupiter.api.Test
    void parseCompassDirection() {
    }

    @org.junit.jupiter.api.Test
    void parsePosition() {
    }
}