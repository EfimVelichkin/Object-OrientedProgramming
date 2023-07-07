package org.example;

public class Treadmill {
    public int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public boolean run(int maxRunLength) {
        if (maxRunLength >= length) {
            System.out.println("Успешно пробежал");
            return true;
        } else {
            System.out.println("Не смог пробежать");
            return false;
        }
    }
}
