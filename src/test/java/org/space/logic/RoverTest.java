package org.space.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.space.CompassDirection;
import org.space.Instruction;
import org.space.Position;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("start facing north and rotate left 4 times")
    void rotateLeft() {
        Position position = new Position(0,0, CompassDirection.N);
        Rover rover = new Rover(position);

        // Start now and rotate left
        Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.L));
        Assertions.assertEquals(CompassDirection.S, rover.rotate(Instruction.L));
        Assertions.assertEquals(CompassDirection.E, rover.rotate(Instruction.L));
        Assertions.assertEquals(CompassDirection.N, rover.rotate(Instruction.L));
    }

    @Test
    @DisplayName("start facing north and rotate right 4 times")
    void rotateRight() {
        Position position = new Position(0,0, CompassDirection.N);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.E, rover.rotate(Instruction.R));
        Assertions.assertEquals(CompassDirection.S, rover.rotate(Instruction.R));
        Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.R));
        Assertions.assertEquals(CompassDirection.N, rover.rotate(Instruction.R));
    }
}