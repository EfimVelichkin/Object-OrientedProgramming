package org.example;

public class Addition implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return a.add(b);
    }
}
