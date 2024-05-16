package org.space.input;

import org.space.CompassDirection;
import org.space.Instruction;
import org.space.PlateauSize;
import org.space.Position;

public class InputParser {


    private static void ifNullOrEmptyThenThrow(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    public static PlateauSize parsePlateauSize(String input){
        ifNullOrEmptyThenThrow(input);

        String[] parts = input.split(" ");

        if(parts.length != 2){
            throw new IllegalArgumentException("Invalid plateau size format");
        }

        try {
            int width = Integer.parseInt(parts[0]);
            int height = Integer.parseInt(parts[1]);
            if(width < 0 || height < 0){
                throw new IllegalArgumentException("Invalid plateau cannot be negative");
            }
            return new PlateauSize(width, height);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid plateau size dimensions");
        }
    }

    public static Instruction[] parseInstruction(String input){
        ifNullOrEmptyThenThrow(input);
        Instruction[] instructions = new Instruction[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char instructionChar = Character.toUpperCase(input.charAt(i));
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
                    throw new IllegalArgumentException("Invalid instruction" + instructionChar);
            }
        }
        return instructions;
    }

    public  static CompassDirection parseCompassDirection(String input){
        ifNullOrEmptyThenThrow(input);
        return switch (input) {
            case "N" -> CompassDirection.N;
            case "E" -> CompassDirection.E;
            case "S" -> CompassDirection.S;
            case "W" -> CompassDirection.W;
            default -> throw new IllegalArgumentException("Invalid direction: " + input);
        };
    }

    public static Position parsePosition(String input){
        return null;
    }

}
