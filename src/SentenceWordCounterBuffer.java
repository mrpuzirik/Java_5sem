import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Клас SentenceWordCounterBuffer підраховує,
 * у скількох реченнях зустрічаються задані слова.
 * Використовуються лише StringBuffer для роботи з рядками.
 */
public class SentenceWordCounterBuffer {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // Введення тексту користувачем
            System.out.println("Введіть текст:");
            StringBuffer text = new StringBuffer(scanner.nextLine());

            // Введення слів для пошуку
            System.out.println("Введіть слова для пошуку (через пробіл):");
            String line = scanner.nextLine();

            if (line.trim().isEmpty()) {
                throw new IllegalArgumentException("Список слів не може бути порожнім!");
            }

            String[] inputWords = line.split("\\s+");
            StringBuffer[] words = new StringBuffer[inputWords.length];
            for (int i = 0; i < inputWords.length; i++) {
                words[i] = new StringBuffer(inputWords[i]);
            }

            // Виконуємо підрахунок
            Map<StringBuffer, Integer> result = countWordOccurrences(text, words);

            // Виводимо результат
            System.out.println("Результат:");
            for (StringBuffer word : words) {
                System.out.println(word.toString() + " → " + result.get(word) + " речень");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася непередбачена помилка при введенні даних.");
        }
    }

    /**
     * Підраховує кількість речень, у яких зустрічається кожне слово.
     */
    public static Map<StringBuffer, Integer> countWordOccurrences(
            StringBuffer text, StringBuffer[] words) {

        // Карта для результатів
        Map<StringBuffer, Integer> wordCounts = new HashMap<>();
        for (StringBuffer word : words) {
            wordCounts.put(word, 0);
        }

        // Розбиваємо текст на речення
        List<StringBuffer> sentences = splitIntoSentences(text);

        // Перевіряємо кожне речення
        for (StringBuffer sentence : sentences) {
            // Робимо речення в нижньому регістрі + прибираємо пробіли
            StringBuffer loweredSentence = toLowerCase(trim(sentence));

            // Перевіряємо кожне слово в реченні
            for (StringBuffer word : words) {
                if (contains(loweredSentence, toLowerCase(word))) {
                    // Збільшуємо лічильник
                    wordCounts.put(word, wordCounts.get(word) + 1);
                }
            }
        }
        return wordCounts;
    }

    // Розбиває текст на речення за розділовими знаками (.!?)
    private static List<StringBuffer> splitIntoSentences(StringBuffer text) {
        List<StringBuffer> sentences = new ArrayList<>();
        StringBuffer current = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            current.append(c);

            // Кінець речення
            if (c == '.' || c == '!' || c == '?') {
                sentences.add(new StringBuffer(current));
                current.setLength(0); // очищаємо буфер
            }
        }
        // Якщо залишився "хвіст" без крапки
        if (!current.isEmpty()) {
            sentences.add(new StringBuffer(current));
        }
        return sentences;
    }

    // Прибирає пробіли на початку і в кінці рядка
    private static StringBuffer trim(StringBuffer sb) {
        int start = 0;
        int end = sb.length() - 1;

        while (start <= end && Character.isWhitespace(sb.charAt(start))) {
            start++;
        }
        while (end >= start && Character.isWhitespace(sb.charAt(end))) {
            end--;
        }

        StringBuffer result = new StringBuffer();
        for (int i = start; i <= end; i++) {
            result.append(sb.charAt(i));
        }
        return result;
    }

    // Перетворює всі символи на нижній регістр
    private static StringBuffer toLowerCase(StringBuffer sb) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            result.append(Character.toLowerCase(sb.charAt(i)));
        }
        return result;
    }

    // Перевіряє, чи містить text підрядок word (аналог contains)
    private static boolean contains(StringBuffer text, StringBuffer word) {
        int n = text.length();
        int m = word.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == word.charAt(j)) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }
}
