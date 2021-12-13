package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    // --- attributes ---------------------------------------------------------

    private List<String> words;

    // --- constructors -------------------------------------------------------

    public Words() {
        words = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<String> getWords() { return words; }

    // --- public methods -----------------------------------------------------

    public void addWord(String word) {
        validateWord(word);
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> auxList = new ArrayList<>();
        for (String word : words) {
            if (!auxList.contains(word)) {
                auxList.add(word);
            } else {
                return true;
            }
        }
        return false;
    }

    // --- private methods ----------------------------------------------------

    private void validateWord(String word) {
        for (char character : word.toCharArray()) {
            validateCharacter(character);
        }
    }

    private void validateCharacter(char character) {
        if (Character.isUpperCase(character)) {
            throw new IllegalArgumentException("Word should be lower case!");
        } else if (Character.isWhitespace(character)) {
            throw new IllegalArgumentException("It should be one word!");
        }
    }
}