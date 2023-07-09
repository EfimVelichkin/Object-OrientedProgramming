package org.example;

public class Answer {
    private int bulls;
    private int cows;

    public Answer() {
    }

    public Answer(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    @Override
    public String toString() {
        if (Language.ENGLISH.equals(NumberGame.language)) {
            return "Bulls = " + bulls + ", Cows = " + cows;
        } else if (Language.RUSSIAN.equals(NumberGame.language)) {
            return "Быки = " + bulls + ", Коровы = " + cows;
        } else {
            return "Bulls = " + bulls + ", Cows = " + cows;
        }
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }
}
