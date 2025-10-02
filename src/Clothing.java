import java.math.BigDecimal;
import java.util.Objects;

/**
 * Клас Clothing представляє об'єкт одягу з базовими характеристиками.
 * Має гетери та сетери для доступу і зміни полів.
 */
public class Clothing {
    private String type;      // Тип одягу (наприклад: футболка, штани)
    private String size;      // Розмір (наприклад: S, M, L)
    private String color;     // Колір
    private BigDecimal price; // Ціна
    private String brand;     // Бренд

    /**
     * Конструктор для створення об'єкта Clothing.
     *
     * @param type  тип одягу
     * @param size  розмір
     * @param color колір
     * @param price ціна
     * @param brand бренд
     */
    public Clothing(String type, String size, String color,
                    BigDecimal price, String brand) {
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    //  Гетери
    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    // Сетери
    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** Порівнює два об'єкти Clothing на рівність за всіма полями. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // один і той самий об’єкт
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // різні класи
        }
        Clothing clothing = (Clothing) obj;
        return Objects.equals(type, clothing.type)
                && Objects.equals(size, clothing.size)
                && Objects.equals(color, clothing.color)
                && Objects.equals(price, clothing.price)
                && Objects.equals(brand, clothing.brand);
    }

    /** Повертає рядкове представлення об'єкта Clothing. */
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