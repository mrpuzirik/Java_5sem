package class_laba5;

import java.math.BigDecimal;

/**
 * Клас {@code Chamomile} представляє квітку типу "Ромашка".
 *
 * <p>Ромашка старіє повільніше порівняно з іншими квітами.
 */
public class Chamomile extends Flower {

    /**
     * Створює нову ромашку.
     *
     * @param freshnessLevel початковий рівень свіжості (0–10)
     * @param stemLength     довжина стебла у сантиметрах (>0)
     * @param price          ціна квітки (>0)
     */
    public Chamomile(int freshnessLevel, int stemLength, BigDecimal price) {
        super("Chamomile", freshnessLevel, stemLength, price);
    }

    @Override
    public void reduceFreshness(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("The number of days must be positive.");
        }
        int change = days / 2;
        if (change > 0) {
            decreaseFreshnessLevel(change);
        }
    }
}
