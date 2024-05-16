package org.space.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.space.PlateauSize;

class InputParserTest {

    @org.junit.jupiter.api.Test
    void parsePlateauSize() {
        String input = "5 7";

        PlateauSize plateauSize = InputParser.parsePlateauSize(input);

        Assertions.assertNotNull(plateauSize);
        Assertions.assertEquals(5,plateauSize.getWidth());
        Assertions.assertEquals(7, plateauSize.getHeight());

    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_InvalidFormat(){
        String input = "5";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {InputParser.parsePlateauSize(input);});
    }

    @Test
    @DisplayName("PlateauSize given invalid format should throw IllegalArgumentException")
    void testParsePlateauSize_NonNumericInput(){
        String input = "5 a";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {InputParser.parsePlateauSize(input);});
    }

    @org.junit.jupiter.api.Test
    void parseInstruction() {
    }

    @org.junit.jupiter.api.Test
    void parseCompassDirection() {
    }

    @org.junit.jupiter.api.Test
    void parsePosition() {
    }
}