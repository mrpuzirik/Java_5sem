package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Sentence складається зі списку слів і розділових знаків.
 */
class Sentence {
    private final List<Object> elements = new ArrayList<>();

    public Sentence(StringBuffer sentenceBuffer) {
        StringBuffer currentWord = new StringBuffer();
        for (int i = 0; i < sentenceBuffer.length(); i++) {
            char c = sentenceBuffer.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                if (!currentWord.isEmpty()) {
                    elements.add(new Word(new StringBuffer(currentWord)));
                    currentWord.setLength(0);
                }
                if (!Character.isWhitespace(c)) {
                    elements.add(new Punctuation(c));
                }
            }
        }
        if (!currentWord.isEmpty()) {
            elements.add(new Word(new StringBuffer(currentWord)));
        }
    }

    public StringBuffer getValue() {
        StringBuffer sb = new StringBuffer();
        for (Object e : elements) {
            if (e instanceof Word) {
                sb.append(((Word) e).getValue()).append(" ");
            } else if (e instanceof Punctuation) {
                sb.append(((Punctuation) e).getMark());
            }
        }
        return new StringBuffer(sb.toString().trim());
    }
}