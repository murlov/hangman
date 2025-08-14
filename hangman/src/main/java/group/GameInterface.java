package group;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInterface {

    public void printMenu() {
        System.out.println("Меню:\n1.Старт\n2.Выход");
    }

    public int getUserChoice() {

        int number = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                number = scanner.nextInt();
                if (number != 1 && number != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, попробуйте ещё раз.");
            } catch(IllegalArgumentException e) {
                System.out.println("Такой пункт отсутствует, попробуйте ещё раз.");
            }

        } while (number != 1 && number != 2);

        return number;
    }

    public void printGallows (int remainingAttempts) {
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

    public void printBadResult () {
        System.out.println("Коньки отбросили! Попытай удачу ещё раз!\n\n");
    }

    public void printGoodResult () {
        System.out.println("Новый День Рождения! Попытай удачу ещё раз!\n\n");
    }
}
