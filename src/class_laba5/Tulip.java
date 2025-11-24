package class_laba5;

import java.math.BigDecimal;

/**
 * Клас {@code Tulip} представляє квітку типу "Тюльпан".
 *
 * <p>Тюльпан старіє помірними темпами.
 */
public class Tulip extends Flower {

    /**
     * Створює новий тюльпан.
     *
     * @param freshnessLevel початковий рівень свіжості (0–10)
     * @param stemLength     довжина стебла у сантиметрах (>0)
     * @param price          ціна квітки (>0)
     */
    public Tulip(int freshnessLevel, int stemLength, BigDecimal price) {
        super("Tulip", freshnessLevel, stemLength, price);
    }

    @Override
    public void reduceFreshness(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("The number of days must be positive.");
        }
        decreaseFreshnessLevel(days);
    }
}
