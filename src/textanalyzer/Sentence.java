package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Sentence} представляє речення, яке складається зі слів
 * ({@link Word}) та розділових знаків ({@link Punctuation}).
 * <p>
 * Об’єкт будується на основі переданого буфера символів, який аналізується
 * посимвольно. Під час розбору виділяються слова (набір літер/цифр)
 * та пунктуаційні символи, які зберігаються у списку елементів у тому
 * порядку, у якому вони зустрічаються в тексті.
 */
class Sentence {

    /**
     * Список елементів речення.
     * <p>
     * Може містити об’єкти двох типів:
     * <ul>
     *     <li>{@code Word} — слово</li>
     *     <li>{@code Punctuation} — розділовий знак</li>
     * </ul>
     */
    private final List<Object> elements = new ArrayList<>();

    /**
     * Створює нове речення на основі переданого буфера символів.
     * <p>
     * Алгоритм:
     * <ol>
     *     <li>Посимвольно читає вхідний буфер.</li>
     *     <li>Буквено-цифрові символи накопичуються у тимчасове слово.</li>
     *     <li>При зустрічі розділового знаку або пробілу сформоване слово
     *     додається у список як {@link Word}.</li>
     *     <li>Розділові знаки додаються як {@link Punctuation}.</li>
     * </ol>
     *
     * @param sentenceBuffer буфер, що містить текстове представлення речення
     */
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

    /**
     * Повертає речення у вигляді одного рядка.
     * <p>
     * Слова розділяються пробілом, пунктуаційні знаки додаються без пробілів.
     *
     * @return рядкове представлення речення
     */
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
