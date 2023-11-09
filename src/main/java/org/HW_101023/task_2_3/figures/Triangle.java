package org.HW_101023.task_2_3.figures;


import org.HW_101023.task_2_3.features.IPrintable;

public class Triangle extends Shape implements IPrintable {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double calculatePerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
    }

    @Override
    public void print() {
        System.out.println("Behold the Triangle!\n" +
                "   *\n" +
                        "  * *\n" +
                        " *   *\n" +
                        "*******\n" +
                " first side size: " + firstSide +
                ", second side size: " + secondSide +
                ", third side size: " + thirdSide +
                ", it has perimeter: " + calculatePerimeter() +
                " and area: " + calculateArea());

    }
}
