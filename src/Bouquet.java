import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Клас {@code Bouquet} представляє букет, що складається з партій квітів
 * (FlowerItem) та аксесуарів.
 */
public class Bouquet {

    private final FlowerItem[] items;
    private final Accessory[] accessories;

    public Bouquet(FlowerItem[] items, Accessory[] accessories) {
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("Bouquet must contain at least one flower batch.");
        }
        this.items = items;
        this.accessories = accessories;
    }

    /**
     * Загальна вартість: квіти + аксесуари.
     */
    public BigDecimal getTotalPrice() {
        BigDecimal sum = BigDecimal.ZERO;

        for (FlowerItem item : items) {
            sum = sum.add(item.getTotalPrice());
        }

        if (accessories != null) {
            for (Accessory accessory : accessories) {
                sum = sum.add(accessory.getPrice());
            }
        }

        return sum;
    }

    /**
     * Моделює старіння всіх партій квітів.
     */
    public void ageBouquet(int days) {
        for (FlowerItem item : items) {
            item.reduceFreshness(days);
        }
    }

    /**
     * Застосовує знижку до квітів.
     */
    public void discountFlower(BigDecimal percent) {
        for (FlowerItem item : items) {
            item.applyDiscount(percent);
        }
    }

    /**
     * Сортування партій квітів за свіжістю у зворотному порядку —
     * від найбільш свіжих до найстаріших.
     */
    public void sortByFreshness() {
        Arrays.sort(items, (a, b) ->
                Integer.compare(b.getFlower().getFreshnessLevel(),
                        a.getFlower().getFreshnessLevel()));
    }

    /**
     * Пошук квітів з певним діапазоном довжин стебла.
     */
    public void findByLength(int min, int max) {
        System.out.println("Flower batches with stem length between " + min + "–" + max + " cm:");
        for (FlowerItem item : items) {
            int len = item.getFlower().getStemLength();
            if (len >= min && len <= max) {
                System.out.println(item);
            }
        }
    }

    /**
     * Друк повного складу букета.
     */
    public void printBouquet() {
        System.out.println("Flower batches");
        for (FlowerItem item : items) {
            System.out.println(item);
        }

        if (accessories != null && accessories.length > 0) {
            System.out.println("Accessories");
            for (Accessory accessory : accessories) {
                System.out.println(accessory);
            }
        }
    }
}
