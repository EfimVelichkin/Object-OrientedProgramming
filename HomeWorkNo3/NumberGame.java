package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberGame extends AbstractGame {
    private List<String> history;

    public NumberGame() {
        history = new ArrayList<>();
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language (1 - English, 2 - Russian):");
        int languageChoice = scanner.nextInt();
        scanner.nextLine();
        if (languageChoice == 1) {
            game.setLanguage(Language.ENGLISH);
        } else if (languageChoice == 2) {
            game.setLanguage(Language.RUSSIAN);
        } else {
            System.out.println("Invalid choice. Defaulting to English.");
            game.setLanguage(Language.ENGLISH);
        }
        System.out.println("Enter the word length:");
        int wordLength = scanner.nextInt();
        System.out.println("Enter the number of attempts:");
        int tryCount = scanner.nextInt();
        scanner.nextLine();
        game.start(wordLength, tryCount);

        boolean isFinish = false;
        boolean isWin = false;

        while (!(isFinish || isWin)) {
            System.out.println("Enter your guess:");
            String input = scanner.nextLine();
            Answer answer = game.inputValue(input);
            if (answer != null) {
                System.out.println("Answer: " + answer);
            }
            isFinish = game.getGameStatus() == GameStatus.FINISH;
            isWin = game.getGameStatus() == GameStatus.WIN;
        }

        if (isWin) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("You lost...");
        }

        System.out.println("Would you like to view the game history? (Y/N)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            game.printHistory();
        }

        System.out.println("Would you like to play again? (Y/N)");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            game.reset();
            main(args);
        }
    }

    @Override
    public List<String> generateCharList() {
        List<String> charList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            charList.add(Integer.toString(i));
        }
        return charList;
    }

    @Override
    public void start(int wordLength, int attempts) {
        super.start(wordLength, attempts);
        history.clear();
    }

    @Override
    public Answer inputValue(String input) {
        Answer answer = super.inputValue(input);
        history.add(input + " - " + answer);
        return answer;
    }

    public void printHistory() {
        System.out.println("Game History:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }

    public void reset() {
        wordLength = 0;
        tryCount = 0;
        word = null;
        status = GameStatus.INIT;
        history.clear();
    }
}