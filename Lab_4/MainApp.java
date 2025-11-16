import java.io.File;
import java.io.IOException;

// УДАЛЕН import CustomAgeException;

public class MainApp {
    
    public static void main(String[] args) {
        System.out.println("=");
        System.out.println("ЛАБА: ИСКЛ");
        System.out.println("=");

        demoTask1();
        
        demoTask2();
        
        demoTask3();
    }
    
    private static void demoTask1() {
        System.out.println("\n- 1. Среднее арифметическое (с обработкой AIOOBE и NFE) ---");
        
        String[] data = {"10", "20", "30", "error", "50"};
        int expectedLength = 7; 
        
        System.out.printf("Исходный массив (длина %d): {10, 20, 30, 'error', 50}\n", data.length);
        System.out.printf("Попытка итерации до индекса: %d\n", expectedLength - 1);
        
        try {
            double average = ArrayHelper.calculateAverage(data, expectedLength);
            System.out.printf(" Итоговое среднее арифметическое (корректные числа): %.2f\n", average);
            
        } catch (IllegalArgumentException e) {
            System.err.println(" Ошибка использования: " + e.getMessage());
        } 
    }
    
    private static void demoTask2() {
        System.out.println("\n- 2. Копирование файла и IOException ---");
        
        String source = "source.txt";
        String dest = "destination.txt";

        createTestFile(source);
        
        try {
            FileCopier.copyFileContents(source, dest);
        } catch (IOException e) {
            System.err.println(" Критическая ошибка при копировании файла.");
            System.err.printf("   Тип ошибки: %s\n", e.getClass().getSimpleName());
            ExceptionLogger.log(e, "Копирование файла");
            System.out.println("-> Ошибка ввода-вывода записана в лог.");
        }
    }

    private static void demoTask3() {
        System.out.println("\n- 3. CustomAgeException и Логирование ---");
        
        int invalidAge = 150;
        
        try {
            System.out.printf("Попытка проверить недопустимый возраст: %d\n", invalidAge);
            AgeValidator.validateAge(invalidAge);
            
        } catch (CustomAgeException e) {
            System.err.println(" Обработана ошибка: " + e.getMessage());
            
            ExceptionLogger.log(e, "Проверка возраста пользователя: " + invalidAge);
            System.out.println("-> Информация об ошибке успешно записана в 'exception_log.txt'");

        }
    }
    
    private static void createTestFile(String path) {
        try (java.io.FileWriter writer = new java.io.FileWriter(path)) {
            writer.write("Это содержимое для копирования.");
            System.out.printf("Создан тестовый файл: %s\n", path);
        } catch (IOException e) {
            System.err.println("Не удалось создать тестовый файл.");
        }
    }
}