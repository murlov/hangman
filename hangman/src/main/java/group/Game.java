package group;

import java.io.FileNotFoundException;

public class Game {
    public void startGame () throws FileNotFoundException {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        int remainingAttempts;

        Dictionary dictionary = new Dictionary();
        dictionary.readWords();

        GameInterface gameInterface = new GameInterface();
        int choice = gameInterface.Menu();

        while (choice != 2) {
            MysteryWord mysteryWord = dictionary.getRandomWord();
            mysteryWord.setHiddenVersionOfWord();
            System.out.println(mysteryWord.getHiddenVersionOfWord() + "/" + mysteryWord.getNameOfWord());

            choice = gameInterface.Menu();
        }
    }
}
