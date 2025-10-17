package textanalyzer;

/**
 * Клас Letter представляє окрему літеру.
 */
class Letter {
    private final StringBuffer value;

    public Letter(char c) {
        this.value = new StringBuffer().append(c);
    }

    public StringBuffer getValue() {
        return value;
    }
}