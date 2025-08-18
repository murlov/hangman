package group;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void startGame () throws FileNotFoundException {

        Dictionary dictionary = new Dictionary();
        dictionary.readWords();

        GameInterface gameInterface = new GameInterface();
        gameInterface.printMenu();
        int choice = gameInterface.getUserChoice();

        while (choice != 2) {
            MysteryWord mysteryWord = dictionary.getRandomWord();
            mysteryWord.setHiddenVersion();

            List<Character> usedLetters = new ArrayList<>();
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
                usedLetters.add(letter);
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
}
