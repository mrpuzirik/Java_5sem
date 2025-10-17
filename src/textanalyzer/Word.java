package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word представляє слово як набір літер.
 */
class Word {
    private final List<Letter> letters = new ArrayList<>();

    public Word(StringBuffer wordBuffer) {
        for (int i = 0; i < wordBuffer.length(); i++) {
            letters.add(new Letter(wordBuffer.charAt(i)));
        }
    }

    public StringBuffer getValue() {
        StringBuffer sb = new StringBuffer();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb;
    }
}