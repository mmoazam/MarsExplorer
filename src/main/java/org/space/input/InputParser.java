package org.space.input;

import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;

import java.util.List;

public class InputParser {


    private static void ifNullOrEmptyThenThrow(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    public static PlateauSize parsePlateauSize(String input) {
        ifNullOrEmptyThenThrow(input);

        String[] parts = input.split(" ");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid plateau size format. Should like: 2 3 ");
        }

        try {
            int width = Integer.parseInt(parts[0]);
            int height = Integer.parseInt(parts[1]);
            if (width < 0 || height < 0) {
                throw new IllegalArgumentException("Invalid plateau cannot be negative");
            }
            return new PlateauSize(width, height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid plateau size dimensions,I expect 2 positive integers like: 2 3 ");
        }
    }

    public static Instruction[] parseInstruction(String input) {
        ifNullOrEmptyThenThrow(input);
        Instruction[] instructions = new Instruction[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char instructionChar = input.charAt(i);
            switch (instructionChar) {
                case 'L':
                    instructions[i] = Instruction.L;
                    break;
                case 'R':
                    instructions[i] = Instruction.R;
                    break;
                case 'M':
                    instructions[i] = Instruction.M;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction letter. Allowed only L R M " + instructionChar);
            }
        }
        return instructions;
    }

    public static CompassDirection parseCompassDirection(String input) {
        ifNullOrEmptyThenThrow(input);
        return switch (input) {
            case "N" -> CompassDirection.N;
            case "E" -> CompassDirection.E;
            case "S" -> CompassDirection.S;
            case "W" -> CompassDirection.W;
            default -> throw new IllegalArgumentException("Invalid direction: should be one of N E S W given: " + input);
        };
    }

    public static Position parsePosition(String input, PlateauSize plateauSize) {
        ifNullOrEmptyThenThrow(input);

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid position format. should be:  2 3 N");
        }

        List<String> compassPoints = List.of(new String[]{"N", "E", "S", "W"});
        String faceTo = parts[2].toUpperCase();
        if (!compassPoints.contains(parts[2])) {
            throw new IllegalArgumentException("Compass point is not one of N, E, S, W given:-> " + parts[2]);
        }

        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            if (x < 0 || y < 0 || x >= plateauSize.getWidth() || y >= plateauSize.getHeight()) {
                throw new IllegalArgumentException("The value given is not in plateau bounds " + input);
            }
            CompassDirection facing = parseCompassDirection(parts[2]);
            return new Position(x, y, facing);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid position coordinates. Should be within Plateau size");
        }
    }
}
