package org.space.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;

class RoverTest {

   PlateauSize plateauSize = new PlateauSize(5,5);

    @Test
    @DisplayName("start facing north and rotate left")
    void rotateLeft() {
        Position position = new Position(1, 0, CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 1);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and rotate left")
    void rotateLeftFromWest() {
        Position position = new Position(0, 0, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
    }

    @Test
    @DisplayName("start facing south and rotate left")
    void rotateLeftFromSouth() {
        Position position = new Position(0, 0, CompassDirection.S);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
    }

    @Test
    @DisplayName("start facing east and rotate left")
    void rotateLeftFromEast() {
        Position position = new Position(0, 0, CompassDirection.E);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.L);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
    }


    @Test
    @DisplayName("start facing north and rotate right")
    void rotateRightFromNorth() {
        Position position = new Position(0, 0, CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
    }

    @Test
    @DisplayName("start facing east and rotate right")
    void rotateRightFromEast() {
        Position position = new Position(0, 0, CompassDirection.E);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
    }

    @Test
    @DisplayName("start facing south and rotate right")
    void rotateRightFromSouth() {
        Position position = new Position(0, 0, CompassDirection.S);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and rotate right")
    void rotateRightFromWest() {
        Position position = new Position(0, 0, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.R);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
    }

    @Test
    @DisplayName("start facing west and Instruction.M should not change direction")
    void rotateRightFromWestAndGetInstructionM() {
        Position position = new Position(0, 0, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(Instruction.M);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    @Test
    @DisplayName("start facing west and passed null should not change direction")
    void rotateRightFromWestAndNull() {
        Position position = new Position(0, 0, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);

        rover.rotate(null);

        Assertions.assertEquals(rover.position.getX(), 0);
        Assertions.assertEquals(rover.position.getY(), 0);
        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
    }

    // Move tests
    @Test
    @DisplayName("move north returns updated position")
    void moveOnceFacingNorthUpdatesPosition() {
        Position position = new Position(0, 0, CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "M";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
        Assertions.assertEquals(0, rover.position.getX());
        Assertions.assertEquals(1, rover.position.getY());
    }

    @Test
    @DisplayName("move east returns updated position")
    void moveOnceFacingEastUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.E);
        Rover rover = new Rover(position,plateauSize);
        String input = "M";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
        Assertions.assertEquals(4, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());
    }

    @Test
    @DisplayName("move south returns updated position")
    void moveOnceFacingSouthUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.S);
        Rover rover = new Rover(position,plateauSize);
        String input = "M";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
        Assertions.assertEquals(3, rover.position.getX());
        Assertions.assertEquals(2, rover.position.getY());
    }

    @Test
    @DisplayName("move west returns updated position")
    void moveOnceFacingWestUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);
        String input = "M";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
        Assertions.assertEquals(2, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());
    }

    // move twice
    @Test
    @DisplayName("move north twice returns updated position")
    void moveTwiceFacingNorthUpdatesPosition() {
        Position position = new Position(0, 0, CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
        Assertions.assertEquals(0, rover.position.getX());
        Assertions.assertEquals(2, rover.position.getY());
    }

    @Test
    @DisplayName("move east twice returns updated position")
    void moveTwiceFacingEastUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.E);
        Rover rover = new Rover(position,plateauSize);
        String input = "MM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
        Assertions.assertEquals(5, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());
    }

    @Test
    @DisplayName("move south twice returns updated position")
    void moveTwiceFacingSouthUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.S);
        Rover rover = new Rover(position,plateauSize);
        String input = "MM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
        Assertions.assertEquals(3, rover.position.getX());
        Assertions.assertEquals(1, rover.position.getY());
    }

    @Test
    @DisplayName("move west returns updated position")
    void moveTwiceFacingWestUpdatesPosition() {
        Position position = new Position(3, 3, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);
        String input = "MM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
        Assertions.assertEquals(1, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());
    }

    @Test
    @DisplayName("empty move does not update position")
    void emptyMoveDoesNotUpdatePosition() {
        Position position = new Position(3, 3, CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);
        String input = "";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
        Assertions.assertEquals(3, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());
    }

    // Implement out of bounds rover stops moving.
    @Test
    @DisplayName("Moving out of bounds stops the rover")
    void movingNorthOutOfBoundsStopsTheRover() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(4,4,CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MMMM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.N);
        Assertions.assertEquals(4, rover.position.getX());
        Assertions.assertEquals(5, rover.position.getY());

    }

    @Test
    @DisplayName("Moving east out of bounds stops the rover")
    void movingEastOutOfBoundsStopsTheRover() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(4,4,CompassDirection.E);
        Rover rover = new Rover(position,plateauSize);
        String input = "MMMM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.E);
        Assertions.assertEquals(5, rover.position.getX());
        Assertions.assertEquals(4, rover.position.getY());

    }

    @Test
    @DisplayName("Moving south out of bounds stops the rover")
    void movingSouthOutOfBoundsStopsTheRover() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(4,4,CompassDirection.S);
        Rover rover = new Rover(position,plateauSize);
        String input = "MMMMM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.S);
        Assertions.assertEquals(4, rover.position.getX());
        Assertions.assertEquals(0, rover.position.getY());

    }

    @Test
    @DisplayName("Moving west out of bounds stops the rover")
    void movingWestOutOfBoundsStopsTheRover() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(4,4,CompassDirection.W);
        Rover rover = new Rover(position,plateauSize);
        String input = "MMMMM";

        rover.move(input);

        Assertions.assertEquals(rover.position.getFacing(), CompassDirection.W);
        Assertions.assertEquals(0, rover.position.getX());
        Assertions.assertEquals(4, rover.position.getY());

    }

    @Test
    @DisplayName("Moving with left rotation inside boundary")
    void movingWithLeftRotationInsideBoundary() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(3,3,CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MLM";

        rover.move(input);

        Assertions.assertEquals(CompassDirection.W, rover.position.getFacing() );
        Assertions.assertEquals(2, rover.position.getX());
        Assertions.assertEquals(4, rover.position.getY());

    }

    @Test
    @DisplayName("Moving with right rotation inside boundary")
    void movingRightRotationInsideBoundary() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(3,3,CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MRM";

        rover.move(input);

        Assertions.assertEquals(CompassDirection.E, rover.position.getFacing());
        Assertions.assertEquals(4, rover.position.getX());
        Assertions.assertEquals(4, rover.position.getY());

    }

    @Test
    @DisplayName("Moving with right right rotation inside boundary")
    void movingRightRightRotationInsideBoundary() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(3,3,CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MRRM";

        rover.move(input);

        Assertions.assertEquals(CompassDirection.S, rover.position.getFacing());
        Assertions.assertEquals(3, rover.position.getX());
        Assertions.assertEquals(3, rover.position.getY());

    }

    // OUT OF BOUNDS TESTS
    @Test
    @DisplayName("Moving with right rotation outside boundary stops the rover")
    void movingRightRotationOutsideBoundary() {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position position = new Position(3,3,CompassDirection.N);
        Rover rover = new Rover(position,plateauSize);
        String input = "MRMMMMM";

        rover.move(input);

        Assertions.assertEquals(CompassDirection.E, rover.position.getFacing());
        Assertions.assertEquals(5, rover.position.getX());
        Assertions.assertEquals(4, rover.position.getY());

    }
}
