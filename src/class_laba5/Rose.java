package class_laba5;

import java.math.BigDecimal;

/**
 * Клас {@code Rose} представляє квітку типу "Роза".
 *
 * <p>Реалізує власну швидкість втрати свіжості: троянда старіє швидше,
 * ніж інші квіти.
 */
public class Rose extends Flower {

    /**
     * Створює нову троянду.
     *
     * @param freshnessLevel початковий рівень свіжості (0–10)
     * @param stemLength     довжина стебла у сантиметрах (>0)
     * @param price          ціна квітки (>0)
     */
    public Rose(int freshnessLevel, int stemLength, BigDecimal price) {
        super("Rose", freshnessLevel, stemLength, price);
    }

    @Override
    public void reduceFreshness(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("The number of days must be positive.");
        }
        decreaseFreshnessLevel(days * 2);
    }
}
