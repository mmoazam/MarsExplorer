package org.space.logic;

import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;
import org.space.input.InputParser;

public class Rover {


    Position position;
    PlateauSize plateauSize;

    public Position getPosition() {
        System.out.println(position.getX() + " " + position.getY() + " " + position.getFacing());
        return position;
    }

    public void printPosition() {
        System.out.println(position.getX() + " " + position.getY() + " " + position.getFacing());
    }



    public Rover(Position position, PlateauSize plateauSize) {
        this.position = position;
        this.plateauSize = plateauSize;
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
                if (isMoveSafe()){
                    moveForward();
                } else {
                    System.out.println("Not safe to move forward. Stopping all movement");
                    return;
                }
            }
        }
    }

    private void moveForward() {
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

    private boolean isMoveSafe() {
        int maxWidth = plateauSize.getWidth();
        int maxHeight = plateauSize.getHeight();
        var currentFacingDirection = position.getFacing();
        switch (currentFacingDirection) {
            case N:
                if (position.getY() + 1 > maxHeight){
                    return false;
                }
                break;
            case E:
                if (position.getX() + 1 > maxWidth){
                    return false;
                }
                break;
            case S:
                if (position.getY() - 1 < 0) {
                    return false;
                }
                break;
            case W:
                if (position.getX() - 1 < 0){
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
