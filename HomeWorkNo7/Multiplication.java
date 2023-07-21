package org.example;

public class Multiplication implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return a.multiply(b);
    }
}
