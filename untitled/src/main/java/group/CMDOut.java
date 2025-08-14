package group;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    public int printMenu() {

        int number = 0;

        do {
            System.out.println("Меню:\n1.Старт\n2.Выход");

            Scanner scanner = new Scanner(System.in);

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
}
