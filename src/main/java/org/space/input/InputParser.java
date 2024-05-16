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

    public static Instruction parseInstruction(String input){

        return null;
    }

    public  static CompassDirection parseCompassDirection(String input){
        return null;
    }

    public static Position parsePosition(String input){
        return null;
    }

}
