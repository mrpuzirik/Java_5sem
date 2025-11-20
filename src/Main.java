import java.math.BigDecimal;

/**
 * Основний клас-виконавець.
 * Виконує побудову букета, сортує квіти за свіжістю та
 * виводить квіти довжина стебла яких задовольняє певний діапазон.
 */
public class Main {

    public static void main(String[] args) {
        try {
            FlowerItem[] items = {
                    new FlowerItem(new Rose(10, 40, new BigDecimal("50")), 5),
                    new FlowerItem(new Tulip(9, 30, new BigDecimal("25.50")), 7),
                    new FlowerItem(new Chamomile(8, 20, new BigDecimal("12")), 12),
                    new FlowerItem(new Rose(7, 35, new BigDecimal("45")), 3)
            };

            Accessory[] accessories = {
                    new Accessory("Wrapper", new BigDecimal("10")),
                    new Accessory("Ribbon", new BigDecimal("5"))
            };

            Bouquet bouquet = new Bouquet(items, accessories);

            System.out.println("=== Initial bouquet ===");
            bouquet.printBouquet();
            System.out.println("\nTotal price: " + bouquet.getTotalPrice() + " hrn\n");

            System.out.println("Aging bouquet by 2 days...");
            bouquet.ageBouquet(2);
            bouquet.printBouquet();

            System.out.println("\nApplying 15% discount to bouquet...");
            bouquet.discountFlower(new BigDecimal("15"));
            bouquet.printBouquet();
            System.out.println("\nNew total price: " + bouquet.getTotalPrice() + " hrn\n");

            System.out.println("Sorting flowers by freshness (descending)...");
            bouquet.sortByFreshness();
            bouquet.printBouquet();

            System.out.println("\nSearching flowers with stem length between 30 and 35 cm:");
            bouquet.findByLength(30, 35);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
