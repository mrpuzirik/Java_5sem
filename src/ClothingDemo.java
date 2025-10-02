import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Демонстраційний клас, що створює масив об'єктів Clothing,
 * сортує його та виконує пошук ідентичних об'єктів.
 */
public class ClothingDemo {

    public static void main(String[] args) {
        // Створення масиву одягу
        Clothing[] clothes = {
                new Clothing("T-Shirt", "M", "Black", new BigDecimal("499.99"), "Nike"),
                new Clothing("T-Shirt", "S", "White", new BigDecimal("299.99"), "Adidas"),
                new Clothing("Pants", "L", "Blue", new BigDecimal("899.50"), "Puma"),
                new Clothing("T-Shirt", "L", "Red", new BigDecimal("599.00"), "Nike"),
                new Clothing("Jacket", "M", "Green", new BigDecimal("1999.99"), "Reebok")
        };

        // Вивід початкового масиву
        System.out.println("\nInitial array:");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }

        // Сортування:
        // Спершу за типом (зростанням), якщо тип однаковий — за ціною (спаданням)
        Arrays.sort(clothes, Comparator
                .comparing(Clothing::getType)
                .thenComparing(Clothing::getPrice, Comparator.reverseOrder()));

        // Вивід відсортованого масиву
        System.out.println("\nSorted array:");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }

        // Об'єкти для пошуку
        Clothing[] target = {
                new Clothing("T-Shirt", "S", "White",
                        new BigDecimal("299.99"), "Adidas"),
                new Clothing("T-Shirt", "XL", "White",
                        new BigDecimal("299.99"), "Adidas"),
                new Clothing("T-Shirt", "S", "White",
                        new BigDecimal("300.00"), "Adidas")
        };

        // Перевірка наявності кожного об'єкта у масиві
        for (Clothing clothing : target) {
            boolean found = Arrays.asList(clothes).contains(clothing);

            System.out.println("\nSearching for object: " + clothing);
            if (found) {
                System.out.println("Object found in array!");
            } else {
                System.out.println("Object not found in array.");
            }
        }
    }
}
