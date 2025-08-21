package group;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameInterface {

    public void printMenu() {
        System.out.println("Меню:\n1.Старт\n2.Выход");
    }

    public int getUserChoice() {

        int number = 0;
        Scanner scanner = new Scanner(System.in);

        while (number != 1 && number != 2) {
            try {
                number = scanner.nextInt();
                if (number != 1 && number != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, попробуйте ещё раз.");
                scanner.nextLine();
            } catch(IllegalArgumentException e) {
                System.out.println("Такой пункт отсутствует, попробуйте ещё раз.");
            }

        }

        return number;
    }

    public void printGallows(int remainingAttempts) {
        switch (remainingAttempts) {
            case 0:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    " /|\\  |\n" +
                                    " / \\  |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 1:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    " /|\\  |\n" +
                                    " /    |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 2:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    " /|\\  |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 3:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    " /|   |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 4:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    "  |   |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 5:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "  O   |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            case 6:
                System.out.println( "  +---+\n" +
                                    "  |   |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "      |\n" +
                                    "=======\n");
                break;
            default:
                System.out.println("Ошибка! Не удалось вывести рисунок виселицы!");
                break;
        }
    }

    public void printBadResult(MysteryWord mysteryWord) {
        System.out.println("Проигрыш! Попытай удачу ещё раз!\n" +
                           "Загаданное слово - " + mysteryWord.getName() + "\n");
    }

    public void printGoodResult() {
        System.out.println("Ты отгадал слово! Попытай удачу ещё раз!\n\n");
    }

    public void printUsedLetters(StringBuilder usedLetters) {
        if (usedLetters.isEmpty()) {
            return;
        }
        System.out.println("Буквы, которые вы уже использовали:");
        for (int i = 0; i < usedLetters.length(); ++i) {
            System.out.print(usedLetters.charAt(i) + " ");
        }
        System.out.println();
    }

    public void printRemainingAttempts(int remainingAttempts) {
        System.out.println("Осталось попыток: " + remainingAttempts);
    }

    public void printHiddenVersionOfWord(String mysteryWord) {
        System.out.println("Загаданное слово: " + mysteryWord);
    }

    public void printTextForInputLetter() {
        System.out.print("Введите желаемую букву: ");
    }

    public Character getLetter(StringBuilder usedLetters) {
        Scanner scanner = new Scanner(System.in);
        String buffer;
        char letter = '0';

        while (letter == '0'){
            try {
                buffer = scanner.nextLine();
                letter = Character.toLowerCase(buffer.charAt(0));

                if (Game.alphabet.indexOf(letter) == -1) {
                    throw new IllegalArgumentException("Такой буквы нет в алфавите, попробуйте ещё раз!");
                } else if (buffer.length() > 1) {
                    throw new IllegalArgumentException("Введите, пожалуйста, одну букву из русского алфавита!");
                } else if (usedLetters.indexOf(String.valueOf(letter)) != -1) {
                    throw new IllegalArgumentException("Вы уже использовали данную букву, попробуйте ещё раз!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, попробуйте ещё раз!");
                scanner.nextLine();
                letter = '0';
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                letter = '0';
            }
        }

        return letter;
    }
}
