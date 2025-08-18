package group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {

    List<MysteryWord> words = new ArrayList<>();

    void readWords () throws FileNotFoundException {
        String separator = File.separator;
        String path = "." + separator + "data" + separator + "russian-nouns-clean.txt";
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            words.add(new MysteryWord(word));
        }

        scanner.close();
    }

    MysteryWord getRandomWord() {
        Random random = new Random();
        MysteryWord word;
        do {
            word = words.get(random.nextInt(words.size()));
        } while(word.wasUsed());

        return word;
    }
}
