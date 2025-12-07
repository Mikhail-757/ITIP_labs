import java.util.Arrays;
import java.util.Random;

public class MultiThreadedSum {

    // Вспомогательный класс для вычисления суммы части массива в отдельном потоке
    static class PartialSumCalculator implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;
        private int partialSum;

        public PartialSumCalculator(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            partialSum = 0;
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }

        public int getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Создаем массив для примера
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10) + 1; // числа от 1 до 10
        }

        System.out.println("Массив: " + Arrays.toString(numbers));

        int mid = numbers.length / 2;
        
        // Создаем два потока для половин массива
        PartialSumCalculator firstHalf = new PartialSumCalculator(numbers, 0, mid);
        PartialSumCalculator secondHalf = new PartialSumCalculator(numbers, mid, numbers.length);

        Thread thread1 = new Thread(firstHalf);
        Thread thread2 = new Thread(secondHalf);

        // Запускаем потоки
        thread1.start();
        thread2.start();

        // Ждем завершения потоков
        thread1.join();
        thread2.join();

        // Суммируем результаты в главном потоке
        int totalSum = firstHalf.getPartialSum() + secondHalf.getPartialSum();

        System.out.println("Сумма первой половины: " + firstHalf.getPartialSum());
        System.out.println("Сумма второй половины: " + secondHalf.getPartialSum());
        System.out.println("Общая сумма: " + totalSum);
    }
}