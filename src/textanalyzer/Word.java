package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Word} представляє слово, яке складається з окремих літер.
 * <p>
 * Кожна літера зберігається як об’єкт {@link Letter}. Слово формується
 * із символів переданого буфера {@link StringBuffer}.
 */
class Word {

    /**
     * Список літер, з яких складається слово.
     * <p>
     * Кожен символ вихідного слова перетворюється у окремий об’єкт {@link Letter}.
     */
    private final List<Letter> letters = new ArrayList<>();

    /**
     * Створює новий об’єкт {@code Word} на основі переданого буфера.
     *
     * @param wordBuffer буфер, що містить символи слова
     */
    public Word(StringBuffer wordBuffer) {
        for (int i = 0; i < wordBuffer.length(); i++) {
            letters.add(new Letter(wordBuffer.charAt(i)));
        }
    }

    /**
     * Повертає слово у вигляді рядка {@link StringBuffer}.
     * <p>
     * Усі літери об’єднуються у єдиний буфер у тому порядку,
     * у якому вони зберігаються у слові.
     *
     * @return рядкове представлення слова
     */
    public StringBuffer getValue() {
        StringBuffer sb = new StringBuffer();
        for (Letter l : letters) {
            sb.append(l.getValue());
        }
        return sb;
    }
}
