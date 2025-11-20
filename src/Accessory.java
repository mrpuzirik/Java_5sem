import java.math.BigDecimal;

/**
 * Клас {@code Accessory} описує аксесуари для букета
 * (обгортка, стрічка, декоративні елементи тощо).
 */
public class Accessory {

    /**
     * Назва аксесуара.
     */
    private final String name;

    /**
     * Ціна аксесуара у гривнях.
     */
    private BigDecimal price;

    /**
     * Створює новий аксесуар.
     *
     * @param name  назва аксесуара
     * @param price початкова ціна аксесуара (≥0)
     * @throws IllegalArgumentException якщо дані некоректні
     */
    public Accessory(String name, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The accessory name cannot be empty.");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The price of an accessory cannot be negative.");
        }
        this.name = name;
        this.price = price;
    }

    /**
     * Повертає назву аксесуара.
     *
     * @return назва аксесуара
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає поточну ціну аксесуара.
     *
     * @return ціна аксесуара
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Встановлює нову ціну аксесуара.
     *
     * @param newPrice нова ціна (≥0)
     * @throws IllegalArgumentException якщо ціна некоректна
     */
    public void setPrice(BigDecimal newPrice) {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The price of an accessory cannot be negative.");
        }
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return name + " | the price of the accessory: " + price + " hrn";
    }
}
