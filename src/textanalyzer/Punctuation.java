package textanalyzer;

/**
 * Клас Punctuation представляє розділовий знак.
 */
class Punctuation {
    private final StringBuffer mark;

    public Punctuation(char c) {
        this.mark = new StringBuffer().append(c);
    }

    public StringBuffer getMark() {
        return mark;
    }
}