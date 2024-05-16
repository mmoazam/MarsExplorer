package org.space.input;

import org.junit.jupiter.api.Assertions;
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