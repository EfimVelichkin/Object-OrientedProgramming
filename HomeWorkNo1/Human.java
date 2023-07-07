package org.example;

import java.util.Random;

public class Human {
    public int maxRunLength;
    public int maxJumpHeight;

    public Human(int maxRunLength, int maxJumpHeight) {
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run() {
        System.out.println("Человек бегает");
    }

    public void jump() {
        System.out.println("Человек прыгает");
    }
}