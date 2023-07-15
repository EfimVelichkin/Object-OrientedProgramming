package org.example.Calculator;

import java.util.List;

public class Calculator {

    public double sum(List<? extends Number> numbers){
        double sum = 0.0;

        for (Number number : numbers) {
            sum += Math.floor(number.doubleValue());
        }
        return sum;
    }

    public double mult(List<? extends Number> numbers) {
        double mult = 1.0;

        for (Number number : numbers) {
            mult *= Math.floor(number.doubleValue());
        }
        return mult;
    }

    public double divis(List<? extends Number> numbers) {
        double divis = 1.0;

        for (Number number : numbers) {
            divis /= Math.floor(number.doubleValue());
        }
        return divis;
    }
}

