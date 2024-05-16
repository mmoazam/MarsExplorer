package org.space.logic;

import org.space.CompassDirection;
import org.space.Instruction;
import org.space.Position;

public class Rover {
Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public CompassDirection rotate(Instruction instruction){

        var currentlyFacing = position.getFacing();
        CompassDirection nextDirection;
        if(instruction == Instruction.M || instruction == null)
            return currentlyFacing;
        else if (instruction == Instruction.L) {
            nextDirection = rotateLeft(currentlyFacing);
        }else {
            nextDirection = rotateRight(currentlyFacing);
        }
        return nextDirection;
    }

    private CompassDirection rotateLeft(CompassDirection currentlyFacing){
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

    private CompassDirection rotateRight(CompassDirection currentlyFacing){
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
}
