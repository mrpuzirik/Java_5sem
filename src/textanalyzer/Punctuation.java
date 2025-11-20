package textanalyzer;

/**
 * Клас {@code Punctuation} представляє розділовий знак у тексті.
 * <p>
 * Обʼєкт зберігає один символ пунктуації у вигляді {@link StringBuffer},
 * що забезпечує потенційну можливість модифікації символу.
 */
class Punctuation {

    /** Буфер, що містить один символ пунктуації. */
    private final StringBuffer mark;

    /**
     * Створює новий об’єкт пунктуації на основі переданого символу.
     *
     * @param c символ, який представляє розділовий знак
     */
    public Punctuation(char c) {
        this.mark = new StringBuffer().append(c);
    }

    /**
     * Повертає символ пунктуації у вигляді {@link StringBuffer}.
     *
     * @return буфер символів із розділовим знаком
     */
    public StringBuffer getMark() {
        return mark;
    }
}
