import java.util.Arrays;
import java.util.Random;

public class Task_2 {

    static class RowMaxFinder implements Runnable {
        private final int[] row;
        private int rowMax;

        public RowMaxFinder(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
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
        int rows = 4;
        int cols = 4;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        Thread[] threads = new Thread[rows];
        RowMaxFinder[] finders = new RowMaxFinder[rows];

        for (int i = 0; i < rows; i++) {
            finders[i] = new RowMaxFinder(matrix[i]);
            threads[i] = new Thread(finders[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

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