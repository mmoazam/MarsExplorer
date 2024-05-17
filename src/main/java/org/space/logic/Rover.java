package org.space.logic;

import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;
import org.space.input.InputParser;

public class Rover {

    Position position;

    public Rover(Position position, PlateauSize plateauSize) {
        this.position = position;
    }

    public void rotate(Instruction instruction) {

        var currentlyFacing = position.getFacing();

        if (instruction == Instruction.L) {
            position.setFacing(rotateLeft(currentlyFacing));
        } else if (instruction == Instruction.R) {
            position.setFacing(rotateRight(currentlyFacing));
        }
    }

    private CompassDirection rotateLeft(CompassDirection currentlyFacing) {
        switch (currentlyFacing) {
            case N:
                currentlyFacing = CompassDirection.W;
                break;
            case E:
                currentlyFacing = CompassDirection.N;
                break;
            case S:
                currentlyFacing = CompassDirection.E;
                break;
            case W:
                currentlyFacing = CompassDirection.S;
                break;
        }
        return currentlyFacing;
    }

    private CompassDirection rotateRight(CompassDirection currentlyFacing) {
        switch (currentlyFacing) {
            case N:
                currentlyFacing = CompassDirection.E;
                break;
            case E:
                currentlyFacing = CompassDirection.S;
                break;
            case S:
                currentlyFacing = CompassDirection.W;
                break;
            case W:
                currentlyFacing = CompassDirection.N;
                break;
        }
        return currentlyFacing;
    }

    public void move(String moveInstructionString) {

        if(moveInstructionString.isEmpty()) return;

        Instruction[] instructions = InputParser.parseInstruction(moveInstructionString);

        for (int i = 0; i < instructions.length; i++) {
            Instruction doThis = instructions[i];
            if (doThis == Instruction.R || doThis == Instruction.L) {
                rotate(doThis);
            } else if (doThis == Instruction.M) {
                moveForward(doThis);
            }
        }
    }

    private void moveForward(Instruction instruction) {
        var currentFacingDirection = position.getFacing();
        switch (currentFacingDirection) {
            case N -> position.setY(position.getY() + 1);
            case E -> position.setX(position.getX() + 1);
            case S -> position.setY(position.getY() - 1);
            case W -> position.setX(position.getX() - 1);
            default -> {
                return;
            }
        }
    }

    //private boolean isMoveSafe(Instruction instruction){
    //    PlateauSize
    //    var currentFacingDirection = position.getFacing();
    //    switch (currentFacingDirection) {
    //        case N -> position.setY(position.getY() + 1);
    //        case E -> position.setX(position.getX() + 1);
    //        case S -> position.setY(position.getY() - 1);
    //        case W -> position.setX(position.getX() - 1);
    //        default -> {
    //            return false;
    //        }
    //    }
    //}
}
