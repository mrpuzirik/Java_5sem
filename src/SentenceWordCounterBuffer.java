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
            System.out.println("Input text:");
            StringBuffer text = new StringBuffer(scanner.nextLine());

            if (trim(text).isEmpty()) {
                throw new IllegalArgumentException("The text cannot be empty!");
            }

            // Введення слів для пошуку
            System.out.println("Enter search terms (separated by a space):");
            StringBuffer lineBuffer = new StringBuffer(scanner.nextLine());

            if (trim(lineBuffer).isEmpty()) {
                throw new IllegalArgumentException("The word list cannot be empty!");
            }

            // Розбиваємо рядок на слова вручну
            List<StringBuffer> words = new ArrayList<>();
            StringBuffer currentWord = new StringBuffer();

            for (int i = 0; i < lineBuffer.length(); i++) {
                char c = lineBuffer.charAt(i);
                if (Character.isWhitespace(c)) {
                    if (!currentWord.isEmpty()) {
                        words.add(new StringBuffer(currentWord));
                        currentWord.setLength(0);
                    }
                }
                else {
                    currentWord.append(c);
                }
            }
            if (!currentWord.isEmpty()) {
                words.add(new StringBuffer(currentWord));
            }

            // Виконуємо підрахунок
            Map<StringBuffer, Integer> result = countWordOccurrences(text, words);

            // Виводимо результат
            System.out.println("Result:");
            for (StringBuffer word : words) {
                System.out.println(word.toString() + " -> " + result.get(word) + " sentence");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while entering data.");
        }
    }

    /** Підраховує кількість речень, у яких зустрічається кожне слово. */
    public static Map<StringBuffer, Integer> countWordOccurrences(
            StringBuffer text, List<StringBuffer> words) {

        Map<StringBuffer, Integer> wordCounts = new HashMap<>();
        for (StringBuffer word : words) {
            wordCounts.put(word, 0);
        }

        List<StringBuffer> sentences = splitIntoSentences(text);

        for (StringBuffer sentence : sentences) {
            StringBuffer loweredSentence = toLowerCase(trim(sentence));
            for (StringBuffer word : words) {
                if (contains(loweredSentence, toLowerCase(word))) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                }
            }
        }
        return wordCounts;
    }

    /** Розбиває текст на речення за розділовими знаками (.!?) */
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

    /** Прибирає пробіли на початку і в кінці рядка */
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

    /** Перетворює всі символи на нижній регістр */
    private static StringBuffer toLowerCase(StringBuffer sb) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            result.append(Character.toLowerCase(sb.charAt(i)));
        }
        return result;
    }

    /** Перевіряє, чи містить text підрядок word */
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
