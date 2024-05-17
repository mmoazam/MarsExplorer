package org.space;

import org.space.logic.Rover;

public class Main {

    public static void main(String[] args) {
        PlateauSize plateauSize = new PlateauSize(5,5);
        Position roverLandingPosition = new Position(1,2,CompassDirection.N);
        Rover rover = new Rover(roverLandingPosition,plateauSize);
        rover.printPosition();
        String instructions = "LMLMLMLMM";
        rover.move(instructions);
        rover.printPosition();

        Position roverLandingPosition2 = new Position(3,3,CompassDirection.E);
        Rover rover2 = new Rover(roverLandingPosition2,plateauSize);
        rover2.printPosition();
        String instructions2 = "MMRMMRMRRM";
        rover2.move(instructions2);
        rover2.printPosition();
    }
}