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

        rover.rotate(Instruction.L);
        //Assertions.assertEquals(CompassDirection.W, rover.rotate(Instruction.L));
        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and rotate left")
    void rotateLeftFromWest() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);
        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
    }

    @Test
    @DisplayName("start facing south and rotate left")
    void rotateLeftFromSouth() {
        Position position = new Position(0,0, CompassDirection.S);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
    }

    @Test
    @DisplayName("start facing east and rotate left")
    void rotateLeftFromEast() {
        Position position = new Position(0,0, CompassDirection.E);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
    }


    @Test
    @DisplayName("start facing north and rotate right")
    void rotateRightFromNorth() {
        Position position = new Position(0,0, CompassDirection.N);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
    }

    @Test
    @DisplayName("start facing east and rotate right")
    void rotateRightFromEast() {
        Position position = new Position(0,0, CompassDirection.E);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
    }

    @Test
    @DisplayName("start facing south and rotate right")
    void rotateRightFromSouth() {
        Position position = new Position(0,0, CompassDirection.S);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and rotate right")
    void rotateRightFromWest() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
    }

    @Test
    @DisplayName("start facing west and Instruction.M should not change direction")
    void rotateRightFromWestAndGetInstructionM() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);

        rover.rotate(Instruction.M);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and passed null should not change direction")
    void rotateRightFromWestAndNull() {
        Position position = new Position(0,0, CompassDirection.W);
        Rover rover = new Rover(position);

        rover.rotate(null);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }
}