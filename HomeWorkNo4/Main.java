package org.example.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> listInt = new ArrayList<>();
        List<Float> listFloat = new ArrayList<>();
        List<Number> listNum = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            listInt.add(i);
            listFloat.add(((float) i));
            listNum.add(i);
        }
        System.out.println("listNum = " + calculator.sum(listFloat));
        System.out.println("calculator.mult(listFloat) = " + calculator.mult(listInt));
        System.out.println("calculator.divis(listFloat) = " + calculator.divis(listNum));
    }
}
