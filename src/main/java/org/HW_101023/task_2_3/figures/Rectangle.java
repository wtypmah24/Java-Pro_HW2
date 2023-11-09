package org.HW_101023.task_2_3.figures;


import org.HW_101023.task_2_3.features.IPrintable;

public class Rectangle extends Shape implements IPrintable {
    private final double firstSide;
    private final double secondSide;

    public Rectangle(double firstSide, double secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * firstSide + 2 * secondSide;
    }

    @Override
    public double calculateArea() {
        return firstSide * secondSide;
    }

    @Override
    public void print() {
        System.out.println("Behold the God damn Rectangle!\n" +
                "******\n" +
                "*    *\n" +
                "*    *\n" +
                "******\n" +
                " first side size: " + firstSide +
                ", second side size: " + secondSide +
                ", it has perimeter: " + calculatePerimeter() +
                " and area: " + calculateArea());
    }
}
