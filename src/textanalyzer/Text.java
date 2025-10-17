package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Text представляє текст як набір речень.
 */
class Text {
    private final List<Sentence> sentences = new ArrayList<>();

    public Text(StringBuffer textBuffer) {
        StringBuffer cleaned = normalizeSpaces(textBuffer);
        StringBuffer current = new StringBuffer();

        for (int i = 0; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            current.append(c);

            if (c == '.' || c == '!' || c == '?') {
                sentences.add(new Sentence(new StringBuffer(current)));
                current.setLength(0);
            }
        }

        if (!current.isEmpty()) {
            sentences.add(new Sentence(current));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Замінює послідовності пробілів та табуляцій одним пробілом.
     */
    private static StringBuffer normalizeSpaces(StringBuffer sb) {
        StringBuffer result = new StringBuffer();
        boolean spaceSeen = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!spaceSeen) {
                    result.append(' ');
                    spaceSeen = true;
                }
            } else {
                result.append(c);
                spaceSeen = false;
            }
        }
        return new StringBuffer(result.toString().trim());
    }
}