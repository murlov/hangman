package group;

public class MysteryWord {
    private String nameOfWord;
    private boolean wordWasUsed;
    private StringBuilder hiddenVersionOfWord;

    public MysteryWord(String nameOfWord) {
        this.nameOfWord = nameOfWord;
        this.wordWasUsed = false;
    }

    public String getName() {
        return nameOfWord;
    }

    public boolean wasUsed() {
        return wordWasUsed;
    }

    public void setHiddenVersion() {
        this.hiddenVersionOfWord = new StringBuilder("_".repeat(nameOfWord.length()));
    }

    public String getHiddenVersion() {
        return hiddenVersionOfWord.toString();
    }

    public boolean isLetterInWord(char letter) {
        return (nameOfWord.indexOf(letter) >= 0);
    }

    public void updateHiddenVersion(char letter) {
        int fromIndex = 0;
        int index;
        while (nameOfWord.indexOf(letter, fromIndex) >= 0) {
            index = nameOfWord.indexOf(letter, fromIndex);
            hiddenVersionOfWord.setCharAt(index, letter);
            ++fromIndex;
        }
    }

    public boolean isGuessed() {
        return !(hiddenVersionOfWord.toString().contains("_"));
    }
}
