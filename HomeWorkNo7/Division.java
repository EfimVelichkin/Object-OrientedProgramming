package org.example;

public class Division implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return a.divide(b);
    }
}
