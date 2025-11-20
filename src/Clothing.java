import java.math.BigDecimal;
import java.util.Objects;

/**
 * Клас {@code Clothing} представляє елемент одягу з основними характеристиками,
 * такими як тип, розмір, колір, ціна та бренд.
 * <p>
 * Об’єкти цього класу можуть бути змінені через сетери та отримані через гетери.
 */
public class Clothing {

    /** Тип одягу (наприклад: футболка, штани, куртка). */
    private String type;

    /** Розмір одягу (наприклад: S, M, L, XL). */
    private String size;

    /** Колір одягу. */
    private String color;

    /** Ціна об’єкта одягу. */
    private BigDecimal price;

    /** Бренд виробника одягу. */
    private String brand;

    /**
     * Створює новий об’єкт {@code Clothing} з указаними характеристиками.
     *
     * @param type  тип одягу
     * @param size  розмір
     * @param color колір
     * @param price ціна
     * @param brand бренд виробника
     */
    public Clothing(String type, String size, String color,
                    BigDecimal price, String brand) {
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    /** @return тип одягу */
    public String getType() {
        return type;
    }

    /** @return розмір одягу */
    public String getSize() {
        return size;
    }

    /** @return колір одягу */
    public String getColor() {
        return color;
    }

    /** @return ціна одягу */
    public BigDecimal getPrice() {
        return price;
    }

    /** @return бренд одягу */
    public String getBrand() {
        return brand;
    }

     /**
     * Встановлює новий тип одягу.
     *
     * @param type нове значення типу
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Встановлює новий розмір одягу.
     *
     * @param size новий розмір
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Встановлює новий колір одягу.
     *
     * @param color новий колір
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Встановлює нову ціну одягу.
     *
     * @param price нова ціна
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Встановлює новий бренд одягу.
     *
     * @param brand назва бренду
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

     /**
     * Перевіряє рівність двох об’єктів {@code Clothing} за всіма характеристиками.
     *
     * @param obj інший об’єкт для порівняння
     * @return true, якщо всі поля збігаються; false — інакше
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Clothing clothing = (Clothing) obj;
        return Objects.equals(type, clothing.type)
                && Objects.equals(size, clothing.size)
                && Objects.equals(color, clothing.color)
                && Objects.equals(price, clothing.price)
                && Objects.equals(brand, clothing.brand);
    }

    /**
     * Повертає текстове представлення об’єкта {@code Clothing}.
     *
     * @return рядок із характеристиками одягу
     */
    @Override
    public String toString() {
        return "Clothing{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
