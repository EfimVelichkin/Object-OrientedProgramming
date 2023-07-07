package org.example;

import java.util.Random;

public class Robot {
    public int maxRunLength;
    public int maxJumpHeight;

    public Robot(int maxRunLength, int maxJumpHeight) {
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run() {
        System.out.println("Робот бегает");
    }

    public void jump() {
        System.out.println("Робот прыгает");
    }
}

