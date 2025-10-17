package textanalyzer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Основний клас-виконавець.
 * Виконує підрахунок, у скількох реченнях зустрічається кожне задане слово.
 */
public class SentenceWordCounter {

    /** Основний метод запуску програми. */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Input text:");
            StringBuffer textInput = new StringBuffer(scanner.nextLine());
            if (trim(textInput).isEmpty()) {
                throw new IllegalArgumentException("The text cannot be empty!");
            }

            System.out.println("Enter search terms (separated by a space):");
            StringBuffer wordLine = new StringBuffer(scanner.nextLine());
            if (trim(wordLine).isEmpty()) {
                throw new IllegalArgumentException("The word list cannot be empty!");
            }

            List<Word> searchWords = parseWords(wordLine);
            Text text = new Text(textInput);

            Map<Word, Integer> results = countWordOccurrences(text, searchWords);

            System.out.println("\nResult:");
            for (Word word : searchWords) {
                System.out.println(word.getValue() + " -> " + results.get(word) + " sentence(s)");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
        }
    }

    /** Підраховує кількість речень, у яких зустрічається кожне слово. */
    private static Map<Word, Integer> countWordOccurrences(Text text, List<Word> searchWords) {
        Map<Word, Integer> counts = new HashMap<>();
        for (Word w : searchWords) {
            counts.put(w, 0);
        }

        for (Sentence s : text.getSentences()) {
            StringBuffer loweredSentence = toLowerCase(s.getValue());
            for (Word w : searchWords) {
                if (contains(loweredSentence, toLowerCase(w.getValue()))) {
                    counts.put(w, counts.get(w) + 1);
                }
            }
        }
        return counts;
    }

    /** Розбиває рядок на слова. */
    private static List<Word> parseWords(StringBuffer lineBuffer) {
        List<Word> words = new ArrayList<>();
        StringBuffer currentWord = new StringBuffer();

        for (int i = 0; i < lineBuffer.length(); i++) {
            char c = lineBuffer.charAt(i);
            if (Character.isWhitespace(c)) {
                if (!currentWord.isEmpty()) {
                    words.add(new Word(new StringBuffer(currentWord)));
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(c);
            }
        }

        if (!currentWord.isEmpty()) {
            words.add(new Word(new StringBuffer(currentWord)));
        }
        return words;
    }

    /** Видаляє пробіли на початку і в кінці рядка. */
    private static StringBuffer trim(StringBuffer sb) {
        int start = 0, end = sb.length() - 1;
        while (start <= end && Character.isWhitespace(sb.charAt(start))) start++;
        while (end >= start && Character.isWhitespace(sb.charAt(end))) end--;
        StringBuffer result = new StringBuffer();
        for (int i = start; i <= end; i++) {
            result.append(sb.charAt(i));
        }
        return result;
    }

    /** Перетворює всі символи рядка в нижній регістр. */
    private static StringBuffer toLowerCase(StringBuffer sb) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            result.append(Character.toLowerCase(sb.charAt(i)));
        }
        return result;
    }

    /** Перевіряє, чи містить text підрядок word. */
    private static boolean contains(StringBuffer text, StringBuffer word) {
        int n = text.length();
        int m = word.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && text.charAt(i + j) == word.charAt(j)) {
                j++;
            }
            if (j == m) return true;
        }
        return false;
    }
}
