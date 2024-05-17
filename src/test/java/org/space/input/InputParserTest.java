package org.space.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @org.junit.jupiter.api.Test
    void parsePlateauSize() {
        String input = "5 7";

        PlateauSize plateauSize = InputParser.parsePlateauSize(input);

        assertNotNull(plateauSize);
        assertEquals(5, plateauSize.getWidth());
        assertEquals(7, plateauSize.getHeight());

    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_InvalidFormat() {
        String input = "5";

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(input);
        });
    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_NonNumericInput() {
        String input = "5 a";

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(input);
        });
    }

    @Test
    @DisplayName("PlateauSize given negative number should throw IllegalArgumentException")
    void testParsePlateauSize_NegativeInput() {
        String inputHeight = "5 -7";
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePlateauSize(inputHeight);
        });

        String inputWidth = "-5 7";
        assertThrows(IllegalArgumentException.class, () -> {
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

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with lowercase string")
    void parseInstruction_LowercaseInput() {
        String input = "lmlmmr";

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with empty input")
    void parseInstruction_EmptyInput() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }

    @org.junit.jupiter.api.Test
    @DisplayName("parseInstruction with null input")
    void parseInstruction_NullInput() {
        String input = null;

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInstruction(input);
        });
    }


    @Test
    @DisplayName("ParseCompassDirection valid compass direction string")
    public void testParseCompassDirection_ValidInput() {
        // Arrange & Act
        CompassDirection directionN = InputParser.parseCompassDirection("N");
        CompassDirection directionE = InputParser.parseCompassDirection("E");
        CompassDirection directionS = InputParser.parseCompassDirection("S");
        CompassDirection directionW = InputParser.parseCompassDirection("W");

        // Assert
        assertEquals(CompassDirection.N, directionN);
        assertEquals(CompassDirection.E, directionE);
        assertEquals(CompassDirection.S, directionS);
        assertEquals(CompassDirection.W, directionW);
    }

    @Test
    @DisplayName("ParseCompassDirection lowercase compass direction string")
    public void testParseCompassDirection_LowerCaseInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCompassDirection("n");
        });
    }


    @Test
    @DisplayName("ParseCompassDirection null input string by throwing an exception.")
    public void testParseCompassDirection_NullInput() {
        // Arrange
        String input = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCompassDirection(input);
        });
    }

    @Test
    @DisplayName("ParseCompassDirection empty input string  throws exception")
    public void testParseCompassDirection_EmptyInput() {
        // Arrange
        String input = "";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCompassDirection(input);
        });
    }

    @Test
    @DisplayName("ParseCompassDirection invalid input")
    public void testParseCompassDirection_InvalidInput() {
        // Arrange
        String input = "X"; // Invalid direction

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseCompassDirection(input);
        });
    }

    @Test
    public void testParsePosition_ValidInput() {
        // Arrange
        String input = "2 3 N";
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act
        Position position = InputParser.parsePosition(input, plateauSize);

        // Assert
        assertNotNull(position);
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
        assertEquals(CompassDirection.N, position.getFacing());
    }

    @Test
    public void testParsePosition_NullInput() {
        // Arrange
        String input = null;
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePosition(input, plateauSize);
        });
    }

    @Test
    public void testParsePosition_EmptyInput() {
        // Arrange
        String input = "";
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePosition(input, plateauSize);
        });
    }

    @Test
    public void testParsePosition_InvalidFormat() {
        // Arrange
        String input = "2 3 N E"; // Invalid format
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePosition(input, plateauSize);
        });
    }

    @Test
    public void testParsePosition_OutOfBounds() {
        // Arrange
        String input = "6 3 N"; // Out of bounds
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePosition(input, plateauSize);
        });
    }

    @Test
    public void testParsePosition_InvalidDirection() {
        // Arrange
        String input = "2 3 X"; // Invalid direction
        PlateauSize plateauSize = new PlateauSize(5, 5);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parsePosition(input, plateauSize);
        });
    }
}