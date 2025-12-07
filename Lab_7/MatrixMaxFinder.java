import java.util.Arrays;
import java.util.Random;

public class MatrixMaxFinder {

    // Класс для поиска максимума в строке матрицы
    static class RowMaxFinder implements Runnable {
        private final int[] row;
        private int rowMax;

        public RowMaxFinder(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            // Если строка пустая, максимум = минимальное значение int
            rowMax = (row.length == 0) ? Integer.MIN_VALUE : row[0];
            for (int value : row) {
                if (value > rowMax) {
                    rowMax = value;
                }
            }
        }

        public int getRowMax() {
            return rowMax;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Создаем тестовую матрицу 4x4
        int rows = 4;
        int cols = 4;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // числа от 0 до 99
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        // Создаем массив потоков и обработчиков строк
        Thread[] threads = new Thread[rows];
        RowMaxFinder[] finders = new RowMaxFinder[rows];

        // Создаем и запускаем потоки для каждой строки
        for (int i = 0; i < rows; i++) {
            finders[i] = new RowMaxFinder(matrix[i]);
            threads[i] = new Thread(finders[i]);
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Находим общий максимум в главном потоке
        int overallMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int rowMax = finders[i].getRowMax();
            System.out.println("Максимум в строке " + i + ": " + rowMax);
            if (rowMax > overallMax) {
                overallMax = rowMax;
            }
        }

        System.out.println("\nНаибольший элемент в матрице: " + overallMax);
    }
}