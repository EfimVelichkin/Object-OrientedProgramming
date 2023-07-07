package org.example;

import java.util.Random;

public class Wall {
    public int height;

    public Wall(int height) {
        this.height = height;
    }

    public boolean jump(int maxJumpHeight) {
        if (maxJumpHeight >= height) {
            System.out.println("Успешно перепрыгнул");
            return true;
        } else {
            System.out.println("Не смог перепрыгнуть");
            return false;
        }
    }
}