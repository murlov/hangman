package group;

public class MysteryWord {
    private String nameOfWord;
    private boolean wordWasUsed;
    private StringBuilder hiddenVersionOfWord;

    public MysteryWord(String nameOfWord) {
        this.nameOfWord = nameOfWord;
        this.wordWasUsed = false;
    }

    public String getNameOfWord() {
        return nameOfWord;
    }

    public boolean isWordWasUsed () {
        return wordWasUsed;
    }

    public void setHiddenVersionOfWord() {
        this.hiddenVersionOfWord = new StringBuilder("_".repeat(nameOfWord.length()));
    }

    public String getHiddenVersionOfWord() {
        return hiddenVersionOfWord.toString();
    }
}
