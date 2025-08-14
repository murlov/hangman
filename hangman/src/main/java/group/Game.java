package group;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void startGame () throws FileNotFoundException {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        Dictionary dictionary = new Dictionary();
        dictionary.readWords();

        GameInterface gameInterface = new GameInterface();
        gameInterface.printMenu();
        int choice = gameInterface.getUserChoice();

        while (choice != 2) {
            MysteryWord mysteryWord = dictionary.getRandomWord();
            mysteryWord.setHiddenVersionOfWord();

            List<Character> usedLetters = new ArrayList<>();
            int remainingAttempts = 6;

            while (remainingAttempts != 0) {
                gameInterface.printGallows(remainingAttempts);
                remainingAttempts -= 1;
            }

            if (remainingAttempts <= 0) {
                gameInterface.printGallows(0);
                gameInterface.printBadResult();
            } else {
                gameInterface.printGoodResult();
            }


            gameInterface.printMenu();
            choice = gameInterface.getUserChoice();
        }
    }
}
