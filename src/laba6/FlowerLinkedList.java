package laba6;

import java.util.Collection;
import class_laba5.Flower;

/**
 * Клас {@code FlowerLinkedList} реалізує типізовану колекцію
 * квітів на основі двозв’язного списку.
 *
 * <p>Реалізація відповідає вимогам лабораторної роботи №6:
 * <ul>
 *     <li>Тип елементів — клас {@link Flower} з ЛР5;</li>
 *     <li>Структура даних — двозв’язний список;</li>
 *     <li>Реалізовано більшість базових операцій інтерфейсу List;</li>
 *     <li>Додано три конструктори: порожній, з одним елементом,
 *         та з колекції.</li>
 * </ul>
 * </p>
 */
public class FlowerLinkedList implements MyList<Flower> {

    /**
     * Внутрішній клас вузла двозв’язного списку.
     * Містить значення та посилання на попередній і наступний вузол.
     */
    private static class Node {
        Flower value;
        Node next;
        Node prev;

        Node(Flower value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Створює порожній список.
     */
    public FlowerLinkedList() {}

    /**
     * Створює список, що містить один елемент.
     *
     * @param flower квітка, яку необхідно додати
     */
    public FlowerLinkedList(Flower flower) {
        add(flower);
    }

    /**
     * Створює список на основі стандартної колекції.
     *
     * @param flowers колекція квітів
     */
    public FlowerLinkedList(Collection<Flower> flowers) {
        addAll(flowers);
    }

    /**
     * Додає елемент у кінець списку.
     *
     * @param flower квітка для додавання
     */
    @Override
    public void add(Flower flower) {
        Node node = new Node(flower);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    /**
     * Вставляє елемент у визначений індекс.
     *
     * @param index  позиція вставки (0 ≤ index ≤ size)
     * @param flower квітка для вставки
     * @throws IndexOutOfBoundsException якщо індекс некоректний
     */
    @Override
    public void add(int index, Flower flower) {
        checkIndexForAdd(index);

        if (index == size) {
            add(flower);
            return;
        }

        Node current = getNode(index);
        Node newNode = new Node(flower);
        Node prev = current.prev;

        newNode.next = current;
        newNode.prev = prev;
        current.prev = newNode;

        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }

        size++;
    }

    /**
     * Повертає елемент за індексом.
     *
     * @param index позиція елемента
     * @return квітка за індексом
     * @throws IndexOutOfBoundsException якщо індекс некоректний
     */
    @Override
    public Flower get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    /**
     * Видаляє елемент за індексом.
     *
     * @param index позиція елемента
     * @return видалена квітка
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі
     */
    @Override
    public Flower remove(int index) {
        checkIndex(index);

        Node node = getNode(index);
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) prev.next = next;
        else head = next;

        if (next != null) next.prev = prev;
        else tail = prev;

        size--;
        return node.value;
    }

    /**
     * Видаляє перше входження елемента.
     *
     * @param element квітка для видалення
     * @return true, якщо елемент знайдено і видалено
     */
    @Override
    public boolean removeElement(Flower element) {
        Node cur = head;

        while (cur != null) {
            if (cur.value.equals(element)) {

                Node prev = cur.prev;
                Node next = cur.next;

                if (prev != null) prev.next = next;
                else head = next;

                if (next != null) next.prev = prev;
                else tail = prev;

                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Перевіряє, чи міститься елемент у списку.
     *
     * @param element елемент для пошуку
     * @return true, якщо знайдено
     */
    @Override
    public boolean contains(Flower element) {
        return indexOf(element) != -1;
    }

    /**
     * Повертає індекс першого входження елемента.
     *
     * @param element елемент пошуку
     * @return індекс або -1, якщо не знайдено
     */
    @Override
    public int indexOf(Flower element) {
        Node cur = head;
        int i = 0;

        while (cur != null) {
            if (cur.value.equals(element)) return i;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    /**
     * Повертає індекс останнього входження елемента.
     *
     * @param element елемент пошуку
     * @return індекс або -1
     */
    @Override
    public int lastIndexOf(Flower element) {
        Node cur = tail;
        int i = size - 1;

        while (cur != null) {
            if (cur.value.equals(element)) return i;
            cur = cur.prev;
            i--;
        }
        return -1;
    }

    /**
     * Додає всі елементи зі стандартної колекції.
     *
     * @param collection колекція квітів
     */
    @Override
    public void addAll(Collection<Flower> collection) {
        for (Flower f : collection) {
            add(f);
        }
    }

    /**
     * Видаляє всі елементи зі списку.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Перевіряє, чи список порожній.
     *
     * @return true, якщо size == 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Повертає кількість елементів.
     *
     * @return кількість елементів
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перетворює список у масив.
     *
     * @return масив елементів
     */
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node cur = head;
        int i = 0;

        while (cur != null) {
            arr[i++] = cur.value;
            cur = cur.next;
        }
        return arr;
    }

    /**
     * Повертає вузол за індексом.
     * <p>Оптимізовано: якщо індекс у першій половині — рух з head,
     * якщо в другій — з tail.</p>
     *
     * @param index позиція вузла
     * @return вузол за індексом
     */
    private Node getNode(int index) {
        if (index < size / 2) {
            Node n = head;
            for (int i = 0; i < index; i++) n = n.next;
            return n;
        } else {
            Node n = tail;
            for (int i = size - 1; i > index; i--) n = n.prev;
            return n;
        }
    }

    /**
     * Перевіряє коректність індексу для операцій get/remove.
     *
     * @param index індекс для перевірки
     * @throws IndexOutOfBoundsException якщо index < 0 або index ≥ size
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Індекс: " + index);
    }

    /**
     * Перевіряє коректність індексу для add(index).
     *
     * @param index індекс для перевірки
     * @throws IndexOutOfBoundsException якщо index < 0 або index > size
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Індекс: " + index);
    }
}
