package org.HW_101023.task_2_3.figures;


import org.HW_101023.task_2_3.features.IPrintable;

public class Circle extends Shape implements IPrintable {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void print() {
        System.out.println("Behold the Circle\n" +
                "   ***\n" +
                " *     *\n" +
                " *     *\n" +
                "   ***\n" +
                "with radius: " + radius +
                ", perimeter: " + calculatePerimeter() +
                " and area: " + calculateArea());
    }
}
