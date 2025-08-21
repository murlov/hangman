package group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public final static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public void startGame () throws FileNotFoundException {

        Dictionary dictionary = new Dictionary();
        try {
            String separator = File.separator;
            dictionary.readWords("." + separator + "data" + separator + "russian-nouns-clean.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        GameInterface gameInterface = new GameInterface();
        gameInterface.printMenu();
        int choice = gameInterface.getUserChoice();

        while (choice != 2) {
            MysteryWord mysteryWord = dictionary.getRandomWord();
            mysteryWord.setHiddenVersion();

            StringBuilder usedLetters = new StringBuilder();
            int remainingAttempts = 6;
            Character letter;

            while (remainingAttempts != 0 && !mysteryWord.isGuessed()) {
                gameInterface.printGallows(remainingAttempts);
                gameInterface.printHiddenVersionOfWord(mysteryWord.getHiddenVersion());
                //System.out.println("(" + mysteryWord.getName() + ")"); //для теста
                gameInterface.printUsedLetters(usedLetters);
                gameInterface.printRemainingAttempts(remainingAttempts);

                gameInterface.printTextForInputLetter();
                letter = gameInterface.getLetter(usedLetters);
                addLetter(usedLetters, letter);
                if (mysteryWord.isLetterInWord(letter)) {
                    mysteryWord.updateHiddenVersion(letter);
                } else {
                    --remainingAttempts;
                }
            }

            if (remainingAttempts == 0) {
                gameInterface.printGallows(0);
                gameInterface.printBadResult(mysteryWord);
            } else {
                gameInterface.printGoodResult();
            }


            gameInterface.printMenu();
            choice = gameInterface.getUserChoice();
        }
    }

    private void addLetter (StringBuilder usedLetters, Character letter) {
        int firstSize = usedLetters.length();
        int i = 1;

        if (usedLetters.isEmpty()) {
            usedLetters.insert(0, letter);
        } else if (usedLetters.length() == 1) {
            if (Game.alphabet.indexOf(usedLetters.charAt(0)) < Game.alphabet.indexOf(letter)) {
                usedLetters.insert(1, letter);
            } else {
                usedLetters.insert(0, letter);
            }
        } else {
            while (usedLetters.length() == firstSize) {
                if (Game.alphabet.indexOf(usedLetters.charAt(0)) > Game.alphabet.indexOf(letter)) {
                    usedLetters.insert(0, letter);
                } else if (Game.alphabet.indexOf(usedLetters.charAt(usedLetters.length() - 1)) < Game.alphabet.indexOf(letter)) {
                    usedLetters.insert(usedLetters.length(), letter);
                } else if (Game.alphabet.indexOf(usedLetters.charAt(i - 1)) < Game.alphabet.indexOf(letter) && Game.alphabet.indexOf(usedLetters.charAt(i)) > Game.alphabet.indexOf(letter)) {
                    usedLetters.insert(i, letter);
                }
                ++i;
            }
        }
    }
}
