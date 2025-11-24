package laba6;

import java.util.Collection;

/**
 * Інтерфейс {@code MyList} описує набір базових операцій,
 * подібних до можливостей інтерфейсу {@link java.util.List}.
 *
 * @param <T> тип елементів, що зберігаються у колекції
 */
public interface MyList<T> {

    /**
     * Додає елемент у кінець списку.
     *
     * @param element елемент для додавання
     */
    void add(T element);

    /**
     * Вставляє елемент у вказану позицію списку.
     *
     * @param index   індекс вставки (0 ≤ index ≤ size)
     * @param element елемент для вставки
     */
    void add(int index, T element);

    /**
     * Повертає елемент за заданим індексом.
     *
     * @param index позиція елемента
     * @return елемент списку
     */
    T get(int index);

    /**
     * Видаляє елемент із колекції за індексом.
     *
     * @param index позиція елемента
     * @return видалений елемент
     */
    T remove(int index);

    /**
     * Видаляє перше входження вказаного елемента.
     *
     * @param element елемент для видалення
     * @return true, якщо елемент було знайдено та видалено
     */
    boolean removeElement(T element);

    /**
     * Перевіряє, чи міститься елемент у списку.
     *
     * @param element елемент для перевірки
     * @return true, якщо елемент знайдено
     */
    boolean contains(T element);

    /**
     * Повертає індекс першої появи елемента.
     *
     * @param element елемент для пошуку
     * @return індекс або -1, якщо не знайдено
     */
    int indexOf(T element);

    /**
     * Повертає індекс останньої появи елемента.
     *
     * @param element елемент пошуку
     * @return індекс або -1
     */
    int lastIndexOf(T element);

    /**
     * Додає всі елементи зі стандартної колекції.
     *
     * @param collection вхідна колекція
     */
    void addAll(Collection<T> collection);

    /**
     * Очищає колекцію від усіх елементів.
     */
    void clear();

    /**
     * Перевіряє, чи колекція порожня.
     *
     * @return true, якщо список не містить елементів
     */
    boolean isEmpty();

    /**
     * Повертає кількість елементів у колекції.
     *
     * @return розмір списку
     */
    int size();

    /**
     * Повертає масив елементів колекції.
     *
     * @return масив об’єктів
     */
    Object[] toArray();
}
