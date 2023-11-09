package org.HW_101023.task_2_3.parser;


import org.HW_101023.task_2_3.figures.Circle;
import org.HW_101023.task_2_3.figures.Rectangle;
import org.HW_101023.task_2_3.figures.Shape;
import org.HW_101023.task_2_3.figures.Triangle;

import java.util.Locale;

public class Parser {
    public static Shape parsToFigure(String input){
        String [] parts = input.split(" ");
        String figureName = parts[0].toUpperCase(Locale.ROOT);

        switch (figureName) {
            case "CIRCLE" -> {
                if (parts.length != 2){
                    throw new IllegalArgumentException("Circle contains only one argument radius");
                }
                if(Double.parseDouble(parts[1]) < 0){
                    throw new IllegalArgumentException("Radius can't be less than 0");
                }
                double radius = Double.parseDouble(parts[1]);
                return new Circle(radius);
            }
            case "TRIANGLE" -> {
                if (parts.length != 4){
                    throw new IllegalArgumentException("Triangle contains 3 arguments");
                }
                if(Double.parseDouble(parts[1]) < 0 || Double.parseDouble(parts[2]) < 0 || Double.parseDouble(parts[3]) < 0){
                    throw new IllegalArgumentException("Sides can't be less than 0");
                }
                double firstSide = Double.parseDouble(parts[1]);
                double secondSide = Double.parseDouble(parts[2]);
                double thirdSide = Double.parseDouble(parts[3]);
                return new Triangle(firstSide, secondSide, thirdSide);
            }
            case "RECTANGLE" -> {
                if (parts.length != 3){
                    throw new IllegalArgumentException("Rectangle contains 2 arguments");
                }
                if(Double.parseDouble(parts[1]) < 0 || Double.parseDouble(parts[2]) < 0){
                    throw new IllegalArgumentException("Sides can't be less than 0");
                }
                double firstSideRectangle = Double.parseDouble(parts[1]);
                double secondSideRectangle = Double.parseDouble(parts[2]);
                return new Rectangle(firstSideRectangle, secondSideRectangle);
            }
            default -> throw new IllegalArgumentException("Unknown figure: " + figureName);
        }
    }
}
