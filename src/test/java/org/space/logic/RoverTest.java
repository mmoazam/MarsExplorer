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
    @DisplayName("start facing north and rotate left")
    void rotateLeft() {
        Position position = new Position(0,0, CompassDirection.N);
        Rover rover = new Rover(position);

        // Start now and rotate left
        Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.L));
    }

    @Test
    @DisplayName("start facing west and rotate left")
    void rotateLeftFromWest() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);

        // Start now and rotate left
        Assertions.assertEquals(CompassDirection.S, rover.rotate(Instruction.L));
    }

    @Test
    @DisplayName("start facing south and rotate left")
    void rotateLeftFromSouth() {
        Position position = new Position(0,0, CompassDirection.S);
        Rover rover = new Rover(position);

        // Start now and rotate left
        Assertions.assertEquals(CompassDirection.E, rover.rotate(Instruction.L));
    }

    @Test
    @DisplayName("start facing east and rotate left")
    void rotateLeftFromEast() {
        Position position = new Position(0,0, CompassDirection.E);
        Rover rover = new Rover(position);

        // Start now and rotate left
        Assertions.assertEquals(CompassDirection.N, rover.rotate(Instruction.L));
    }


    @Test
    @DisplayName("start facing north and rotate right")
    void rotateRightFromNorth() {
        Position position = new Position(0,0, CompassDirection.N);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.E, rover.rotate(Instruction.R));
    }

    @Test
    @DisplayName("start facing east and rotate right")
    void rotateRightFromEast() {
        Position position = new Position(0,0, CompassDirection.E);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.S, rover.rotate(Instruction.R));
    }

    @Test
    @DisplayName("start facing south and rotate right")
    void rotateRightFromSouth() {
        Position position = new Position(0,0, CompassDirection.S);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.R));
    }

    @Test
    @DisplayName("start facing west and rotate right")
    void rotateRightFromWest() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.N, rover.rotate(Instruction.R));
    }

    @Test
    @DisplayName("start facing west and Instruction.M should not change direction")
    void rotateRightFromWestAndGetInstructionM() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.M));
    }

    @Test
    @DisplayName("start facing west and passed null should not change direction")
    void rotateRightFromWestAndGetInsructionM() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);
        // Start north and rotate right
        Assertions.assertEquals(CompassDirection.W, rover.rotate(null));
    }
}