package org.example;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<String, Operation> operations = new HashMap<>();

    public Calculator() {
        operations.put("+", new Addition());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public ComplexNumber calculate(String operator, ComplexNumber a, ComplexNumber b) {
        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Unknown operator: " + operator);
        }
        ComplexNumber result = operation.execute(a, b);
        System.out.println(a + " " + operator + " " + b + " = " + result);
        return result;
    }
}
