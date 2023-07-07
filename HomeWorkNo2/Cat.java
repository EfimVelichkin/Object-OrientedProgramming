package org.example;

import java.util.Random;

public class Cat {
    public int maxRunLength;
    public int maxJumpHeight;

    public Cat(int maxRunLength, int maxJumpHeight) {
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run() {
        System.out.println("Кот бегает");
    }

    public void jump() {
        System.out.println("Кот прыгает");
    }
}
