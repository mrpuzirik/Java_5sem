package laba6;

import java.math.BigDecimal;
import java.util.Arrays;

import class_laba5.Flower;
import class_laba5.Rose;
import class_laba5.Tulip;
import class_laba5.Chamomile;

/**
 * Основний клас-виконавець для демонстрації роботи колекції {@link FlowerLinkedList}.
 */
public class Main {

    public static void main(String[] args) {

        Flower rose = new Rose(10, 40, new BigDecimal("50"));
        Flower tulip = new Tulip(9, 30, new BigDecimal("25.50"));
        Flower chamomile = new Chamomile(8, 22, new BigDecimal("12"));

        System.out.println("Конструктор 1: порожній список");
        FlowerLinkedList emptyList = new FlowerLinkedList();
        System.out.println("Розмір: " + emptyList.size());
        System.out.println();

        System.out.println("Конструктор 2: список з одним елементом");
        FlowerLinkedList singleList = new FlowerLinkedList(rose);
        printList(singleList);
        System.out.println();

        System.out.println("Конструктор 3: список зі стандартної колекції");
        FlowerLinkedList fromCollection =
                new FlowerLinkedList(Arrays.asList(rose, tulip, chamomile));
        printList(fromCollection);
        System.out.println();

        System.out.println("Основна демонстрація роботи");

        FlowerLinkedList flowers = new FlowerLinkedList();
        flowers.add(rose);
        flowers.add(tulip);
        flowers.add(chamomile);

        System.out.println("\nПочатковий список:");
        printList(flowers);

        Flower rose2 = new Rose(9, 35, new BigDecimal("45"));
        flowers.add(1, rose2);

        System.out.println("\nПісля вставки:");
        printList(flowers);

        System.out.println("\nПошук:");
        System.out.println("Містить tulip? " + flowers.contains(tulip));
        System.out.println("indexOf chamomile: " + flowers.indexOf(chamomile));

        Flower removed = flowers.remove(2);
        System.out.println("\nВидалено елемент: " + removed);
        printList(flowers);

        Flower tulip2 = new Tulip(7, 28, new BigDecimal("20"));
        Flower chamomile2 = new Chamomile(6, 18, new BigDecimal("9"));

        flowers.addAll(Arrays.asList(tulip2, chamomile2));

        System.out.println("\nПісля addAll:");
        printList(flowers);

        System.out.println("\nObject[] масив:");
        for (Object obj : flowers.toArray()) {
            System.out.println(obj);
        }

        flowers.clear();
        System.out.println("\nПісля clear():");
        System.out.println("Розмір: " + flowers.size());
        System.out.println("Порожній: " + flowers.isEmpty());
    }

    /**
     * Допоміжний метод для виводу всіх елементів колекції.
     *
     * @param list колекція квітів
     */
    private static void printList(FlowerLinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + i + "] " + list.get(i));
        }
    }
}
