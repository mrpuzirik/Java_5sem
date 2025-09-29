import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Клас Matrix виконує:
 * 1. Генерацію випадкової матриці char.
 * 2. Транспонування матриці (матриця C = B^T).
 * 3. Обчислення суми максимальних елементів парних рядків
 *    та мінімальних елементів непарних рядків матриці C.
 * 4. Вивід початкової, транспонованої матриці та результату.
 */
public class Matrix {

    // Logger для всього класу
    private static final Logger logger = Logger.getLogger(Matrix.class.getName());

    public static void main(String[] args) {
        Random rand = new Random();
        int rows = rand.nextInt(10) + 1;  // від 1 до 10
        int cols = rand.nextInt(10) + 1;  // від 1 до 10

        try {
            // Перевірка на не додатні розміри (захист на випадок вводу значень користувачем)
            if (rows <= 0 || cols <= 0) {
                throw new NegativeArraySizeException("Розмір рядків або стовпців має бути додатнє число");
            }

            // Генерація матриці чисел
            char[][] matrixB = generateMatrix(rows, cols);

            // Транспонування матриця C
            char[][] matrixC = transposeMatrix(matrixB);

            // Обчислення суми за правилами (max парні, min непарні)
            int resultSum = computeExtremeSum(matrixC);

            // Вивід
            System.out.println("Generated matrix B:");
            printMatrix(matrixB);

            System.out.println("Transposed matrix C:");
            printMatrix(matrixC);

            System.out.println("Result sum = " + resultSum);

        } catch (NegativeArraySizeException e) {
            logger.log(Level.SEVERE, "Некоректний розмір масиву", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Спроба доступу до неіснуючого елемента масиву", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Несподівана помилка при роботі з матрицею", e);
        }
    }

    /** Генерує випадкову матрицю char розміром rows x cols */
    private static char[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (char) ('A' + rand.nextInt(26));
            }
        }
        return matrix;
    }

    /** Транспонує матрицю (матриця C = A^T) */
    private static char[][] transposeMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] transposed = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    /** Обчислює суму max-елементів парних та min-елементів непарних рядків */
    private static int computeExtremeSum(char[][] matrix) {
        int sum = 0;
        boolean useMax = true; // парний рядок → max, непарний → min

        for (char[] row : matrix) {
            if (useMax) {
                sum += findMax(row);
            } else {
                sum += findMin(row);
            }
            useMax = !useMax;
        }
        return sum;
    }

    /** Вивід матриці на екран */
    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Пошук максимального символу в рядку */
    private static char findMax(char[] row) {
        char max = row[0];
        for (char c : row) {
            if (c > max) {
                max = c;
            }
        }
        return max;
    }

    /** Пошук мінімального символу в рядку */
    private static char findMin(char[] row) {
        char min = row[0];
        for (char c : row) {
            if (c < min) {
                min = c;
            }
        }
        return min;
    }
}
