import java.util.Scanner;

/**
 * Программа для вычисления среднего арифметического элементов массива
 * с обработкой ошибок выхода за границы массива и некорректных данных.
 */
public class ArrayAverage {
    
    /**
     * Метод для получения элемента массива по индексу.
     * Может выбросить ArrayIndexOutOfBoundsException при неверном индексе.
     */
    public static Object getElementAtIndex(Object[] array, int index) {
        // Это может вызвать ArrayIndexOutOfBoundsException
        return array[index];
    }
    
    public static void main(String[] args) {
        // Массив, содержащий числа и строки
        Object[] arr = {1, 2, "3", "4.5", "abc", 5};
        
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;   // Сумма элементов
        int count = 0;      // Количество корректных числовых элементов
        
        System.out.println("Массив содержит " + arr.length + " элементов (индексы 0-" + (arr.length-1) + ")");
        System.out.println("Введите количество элементов для обработки (может превышать размер массива):");
        
        try {
            int elementsToProcess = scanner.nextInt();
            
            // Обрабатываем элементы вручную с возможным выходом за границы
            for (int i = 0; i < elementsToProcess; i++) {
                try {
                    // Пытаемся получить элемент - может возникнуть ArrayIndexOutOfBoundsException
                    Object element = getElementAtIndex(arr, i);
                    
                    double numericValue;
                    
                    // Преобразуем элемент в число
                    if (element instanceof Number) {
                        numericValue = ((Number) element).doubleValue();
                    } else {
                        numericValue = Double.parseDouble(element.toString());
                    }
                    
                    // Успешное преобразование
                    sum += numericValue;
                    count++;
                    
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Реальная обработка выхода за границы массива
                    System.out.println("Ошибка: попытка доступа к индексу " + i + 
                                     " (допустимые индексы: 0-" + (arr.length-1) + ")");
                } catch (NumberFormatException e) {
                    // Обработка некорректного преобразования строки в число
                    System.out.println("Ошибка: элемент по индексу " + i + 
                                     " не является числом (значение: \"" + 
                                     (i < arr.length ? arr[i] : "не существует") + "\")");
                }
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка ввода: введите целое число.");
        } finally {
            scanner.close();
        }
        
        // Вычисляем и выводим результат
        if (count > 0) {
            double average = sum / count;
            System.out.println("\nУспешно обработано элементов: " + count);
            System.out.println("Среднее арифметическое корректных элементов: " + average);
        } else {
            System.out.println("Нет корректных числовых элементов для вычисления среднего.");
        }
    }
}