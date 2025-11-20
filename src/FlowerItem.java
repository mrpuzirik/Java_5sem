import java.math.BigDecimal;

/**
 * Клас {@code FlowerItem} групу однакових квітів.
 *
 * <p>Використовується для моделювання ситуації, коли букет містить кілька
 * однакових квітів з однаковими характеристиками та ціною.
 *
 * <p>FlowerItem дозволяє:
 * <ul>
 *     <li>Зберігати кількість квіток у групі;</li>
 *     <li>Обчислювати ціну партії;</li>
 *     <li>Застосовувати уцінку;</li>
 *     <li>Моделювати старіння партії;</li>
 *     <li>Використовувати логіку конкретного виду квітки (поліморфізм).</li>
 * </ul>
 */
public class FlowerItem {

    /**
     * Об'єкт квітки (описує вид, свіжість, довжину, ціну однієї квітки).
     */
    private final Flower flower;

    /**
     * Кількість однакових квітів у партії.
     */
    private int quantity;

    /**
     * Створює нову партію квітів.
     *
     * @param flower   об'єкт квітки
     * @param quantity кількість квітів у партії (має бути > 0)
     */
    public FlowerItem(Flower flower, int quantity) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("The number of colors must be positive.");
        }
        this.flower = flower;
        this.quantity = quantity;
    }

    /**
     * Повертає вартість партії.
     *
     * @return загальна вартість (ціна однієї квітки × кількість)
     */
    public BigDecimal getTotalPrice() {
        return flower.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    /**
     * Зменшує свіжість усіх квітів у партії.
     *
     * @param days кількість днів
     */
    public void reduceFreshness(int days) {
        flower.reduceFreshness(days);
    }

    /**
     * Застосовує знижку до всієї групи.
     *
     * @param percent відсоток уцінки
     */
    public void applyDiscount(BigDecimal percent) {
        flower.applyDiscount(percent);
    }

    public Flower getFlower() {
        return flower;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Додає квіти до створеної групи.
     *
     * @param count кількість квітів для додавання (>0)
     */
    public void addFlowers(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("The number of colors must be positive.");
        }
        this.quantity += count;
    }

    @Override
    public String toString() {
        return flower.toString() +
                " | quantity: " + quantity +
                " | total price: " + getTotalPrice() + " hrn";
    }
}
