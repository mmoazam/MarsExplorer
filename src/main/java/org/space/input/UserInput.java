package org.space.input;

import org.space.PlateauSize;
import org.space.Position;
import org.space.logic.Rover;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {


        System.out.println("hello from the mission control");

        Scanner scanner = new Scanner(System.in);
        PlateauSize plateau = createPlateau(scanner);

        Position landingPosition = createPosition(scanner, plateau);
        Rover rover = createRover(landingPosition, plateau);

        String moveInstructions = getMoveInstructions(scanner);
        rover.move(moveInstructions);


        /// SECOND ROVER
        Position landingPosition2 = createPosition(scanner, plateau);
        Rover rover2 = createRover(landingPosition2, plateau);

        String moveInstructions2 = getMoveInstructions(scanner);
        rover2.move(moveInstructions2);

        // PRINT ROVER POSITIONS

        rover.printPosition();
        rover2.printPosition();

    }

    private static PlateauSize createPlateau(Scanner lineScanner){
        String plateauSize = lineScanner.nextLine();
        return InputParser.parsePlateauSize(plateauSize.trim());
    }

    private static Position createPosition(Scanner scanner, PlateauSize plateauSize){
        String roverLandingPosition = scanner.nextLine();
        return InputParser.parsePosition(roverLandingPosition, plateauSize);
    }

    private static Rover createRover(Position position, PlateauSize plateauSize){
        return new Rover(position, plateauSize);
    }

    private static String getMoveInstructions(Scanner lineScanner){
        return lineScanner.nextLine();
    }
}
