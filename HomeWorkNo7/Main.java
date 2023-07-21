package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);
        calculator.calculate("+", a, b);
        calculator.calculate("*", a, b);
        calculator.calculate("/", a, b);
    }
}
