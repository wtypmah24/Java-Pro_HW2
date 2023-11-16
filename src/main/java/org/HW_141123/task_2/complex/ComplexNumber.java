package org.HW_141123.task_2.complex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public final class ComplexNumber {
    private int imaginaryPart;
    private int realPart;

    public double getModule() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    public ComplexNumber getSum(ComplexNumber input) {
        return new ComplexNumber(this.imaginaryPart + input.imaginaryPart,
                this.realPart + input.realPart);
    }

    public ComplexNumber multiply(ComplexNumber input) {
        int newReal = this.realPart * input.realPart - this.imaginaryPart * input.imaginaryPart;
        int newImaginary = this.realPart * input.imaginaryPart + this.imaginaryPart * input.realPart;
        return new ComplexNumber(newReal, newImaginary);
    }

}
