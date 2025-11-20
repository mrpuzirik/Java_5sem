package textanalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Text} представляє текст як послідовність речень.
 * <p>
 * Текст отримується у вигляді {@link StringBuffer}, після чого очищається
 * від зайвих пробілів та розбивається на речення за допомогою розділових знаків:
 * <ul>
 *     <li>'.' — крапка</li>
 *     <li>'!' — знак оклику</li>
 *     <li>'?' — знак питання</li>
 * </ul>
 * Кожне виявлене речення зберігається у вигляді об’єкта {@link Sentence}.
 */
class Text {

    /**
     * Список речень, з яких складається текст.
     * Порядок речень відповідає їхньому порядку у вихідному тексті.
     */
    private final List<Sentence> sentences = new ArrayList<>();

    /**
     * Створює новий об’єкт {@code Text} на основі переданого буфера тексту.
     * <p>
     * Алгоритм роботи:
     * <ol>
     *     <li>Видаляються зайві пробіли та табуляції.</li>
     *     <li>Посимвольно формується речення у тимчасовому буфері.</li>
     *     <li>При досягненні кінця речення ('.', '!', '?') створюється новий
     *     об’єкт {@link Sentence}.</li>
     *     <li>Останній фрагмент тексту також додається як речення,
     *     якщо він не є порожнім.</li>
     * </ol>
     *
     * @param textBuffer сирцевий текст у вигляді {@link StringBuffer}
     */
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

        // Додаємо залишкове речення, якщо таке є
        if (!current.isEmpty()) {
            sentences.add(new Sentence(current));
        }
    }

    /**
     * Повертає список усіх речень, що містяться у тексті.
     *
     * @return список об’єктів {@link Sentence}
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Нормалізує пробіли у тексті: замінює будь-яку послідовність
     * пробілів або табуляцій одним пробілом.
     * <p>
     * Використовується як підготовчий етап перед розбиттям на речення.
     *
     * @param sb вхідний буфер тексту
     * @return новий {@link StringBuffer} з нормалізованими пробілами
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
