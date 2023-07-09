package org.example;

public interface Game {
    void start(int wordLength, int attempts);
    Answer inputValue(String input);
    GameStatus getGameStatus();
}