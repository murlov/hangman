package group;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SqlToBinConverter {
    public static void main(String[] args) {
        ArrayList<MysteryWord> dictionaryOfMysteryWords = new ArrayList<>();
        String regExp = "\\(\\d+, '([^']{6,})'";
        Pattern pattern = Pattern.compile(regExp);
    }
}
