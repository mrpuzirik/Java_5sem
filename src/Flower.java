import java.math.BigDecimal;

/**
 * Абстрактний клас {@code Flower} описує спільні властивості та поведінку
 * всіх видів квітів у системі.
 *
 * <p>Кожна квітка має:
 * <ul>
 *     <li>Назву виду;</li>
 *     <li>Рівень свіжості (0 – зав'яла, 10 – свіжа);</li>
 *     <li>Довжину стебла у сантиметрах;</li>
 *     <li>Ціну, представлену через {@link BigDecimal}.</li>
 * </ul>
 *
 * <p>Конкретні підкласи повинні реалізувати метод {@link #reduceFreshness(int)},
 * що визначає, як саме даний тип квітки втрачає свіжість з часом.
 */
public abstract class Flower {

    /**
     * Назва виду квітки.
     */
    private final String name;

    /**
     * Рівень свіжості квітки: 0 – зав'яла, 10 – свіжа.
     */
    private int freshnessLevel;

    /**
     * Довжина стебла у сантиметрах.
     */
    private final int stemLength;

    /**
     * Ціна квітки у гривнях.
     */
    private BigDecimal price;

    /**
     * Створює новий об'єкт квітки.
     *
     * @param name           назва виду квітки
     * @param freshnessLevel початковий рівень свіжості (0–10)
     * @param stemLength     довжина стебла у сантиметрах (>0)
     * @param price          початкова ціна квітки (>0)
     * @throws IllegalArgumentException якщо параметри некоректні
     */
    public Flower(String name, int freshnessLevel, int stemLength, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("\n" + "The flower name cannot be empty.");
        }
        if (freshnessLevel < 1 || freshnessLevel > 10) {
            throw new IllegalArgumentException("\n" + "The freshness level should be in the range of 0–10.");
        }
        if (stemLength <= 0) {
            throw new IllegalArgumentException("\n" + "The stem length must be positive.");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The price must be positive.");
        }

        this.name = name;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
        this.price = price;
    }

    /**
     * Встановлює нову ціну квітки.
     *
     * @param newPrice нове значення ціни (>0)
     * @throws IllegalArgumentException якщо ціна некоректна
     */
    public void setPrice(BigDecimal newPrice) {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The price must be positive.");
        }
        this.price = newPrice;
    }

    /**
     * Застосовує знижку до поточної ціни квітки.
     *
     * @param percent відсоток знижки (1–90)
     * @throws IllegalArgumentException якщо розмір знижки виходить за межі
     */
    public void applyDiscount(BigDecimal percent) {
        if (percent == null) {
            throw new IllegalArgumentException("\n" + "The discount amount cannot be null.");
        }
        if (percent.compareTo(BigDecimal.ZERO) < 1
                || percent.compareTo(new BigDecimal("90")) > 0) {
            throw new IllegalArgumentException("\n" + "The discount should be in the range of 1–90%.");
        }

        BigDecimal multiplier = BigDecimal.ONE.subtract(
                percent.divide(BigDecimal.valueOf(100))
        );
        price = price.multiply(multiplier);
    }

    /**
     * Зменшує свіжість квітки з урахуванням кількості днів.
     * Конкретна реалізація залежить від типу квітки.
     *
     * @param days кількість днів, що минула (має бути > 0)
     * @throws IllegalArgumentException якщо кількість днів некоректна
     */
    public abstract void reduceFreshness(int days);

    /**
     * Допоміжний метод для збільшення числового значення рівня свіжості.
     * Використовується підкласами для реалізації власної логіки старіння.
     *
     * @param value збільшення рівня свіжості (може бути 0 або додатним)
     */
    protected void decreaseFreshnessLevel(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("\n" + "The change in freshness cannot be negative.");
        }
        freshnessLevel = Math.max(0, freshnessLevel - value);
    }

    /**
     * Повертає назву виду квітки.
     *
     * @return назва виду
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає поточний рівень свіжості.
     *
     * @return рівень свіжості (1–10)
     */
    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    /**
     * Повертає довжину стебла у сантиметрах.
     *
     * @return довжина стебла
     */
    public int getStemLength() {
        return stemLength;
    }

    /**
     * Повертає поточну ціну квітки.
     *
     * @return ціна квітки
     */
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name
                + " | " + "freshness: " + freshnessLevel
                + " | length: " + stemLength + " cm"
                + " | price: " + price + " hrn";
    }
}
