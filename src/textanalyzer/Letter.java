package textanalyzer;

/**
 * Клас {@code Letter} представляє окрему літеру тексту.
 * <p>
 * Літера зберігається у вигляді об'єкта {@link StringBuffer}, що дозволяє
 * за потреби модифікувати її значення.
 */
class Letter {

    /** Буфер символів, який містить одну літеру. */
    private final StringBuffer value;

    /**
     * Створює новий об’єкт літери на основі переданого символу.
     *
     * @param c символ, який представляє літера
     */
    public Letter(char c) {
        this.value = new StringBuffer().append(c);
    }

    /**
     * Повертає значення літери у вигляді {@link StringBuffer}.
     *
     * @return літеру як буфер символів
     */
    public StringBuffer getValue() {
        return value;
    }
}
