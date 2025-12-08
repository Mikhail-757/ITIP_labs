import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path; // Импорт Path
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.io.File; // Убран неиспользуемый импорт

// 1. Класс CustomFileNotFoundException
class CustomFileNotFoundException extends IOException {
    public CustomFileNotFoundException(String fileName) {
        super("Файл не найден: " + fileName);
    }
}

// 2. Класс ExceptionLogger для логирования
class ExceptionLogger {
    private static final String LOG_FILE_NAME = "exception_log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(Throwable e) {
        // Убран synchronized, так как это учебный код, но в Production он был бы нужен
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(LOG_FILE_NAME), java.nio.charset.StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND))) {
            
            writer.println("---");
            writer.println("Время: " + LocalDateTime.now().format(FORMATTER));
            writer.println("Тип исключения: " + e.getClass().getName());
            writer.println("Сообщение: " + e.getMessage());
            
            // Запись стека вызовов (Рекомендация: можно заменить циклом на e.printStackTrace(writer))
            writer.println("Stack Trace:");
            for (StackTraceElement element : e.getStackTrace()) {
                writer.println("\t" + element.toString());
            }
            writer.println("---");
            
        } catch (IOException ioException) {
            System.err.println("ОШИБКА: Не удалось записать лог в файл: " + ioException.getMessage());
        }
    }
}

// 3. Основной класс программы
public class FileProcessor {
    
    // Метод использует современное NIO.2 API для проверки существования файла
    public static void readFile(String fileName) throws CustomFileNotFoundException {
        Path path = Paths.get(fileName); // Используем Path
        
        if (Files.notExists(path)) { // Используем Files.notExists()
            // Если файл не существует, выбрасываем наше кастомное исключение
            throw new CustomFileNotFoundException(fileName);
        }
        
        // В реальном коде здесь было бы чтение файла
        System.out.println("Файл '" + fileName + "' успешно прочитан.");
    }

    public static void main(String[] args) {
        String nonExistentFile = "non_existent_data.txt";

        try {
            System.out.println("Попытка чтения файла: " + nonExistentFile);
            readFile(nonExistentFile); // Вызывает исключение
            
        } catch (CustomFileNotFoundException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
            ExceptionLogger.log(e);
            System.out.println("Информация об исключении записана в файл 'exception_log.txt'.");
            
        } catch (Exception e) {
            System.err.println("Произошла неожиданная ошибка: " + e.getMessage());
            ExceptionLogger.log(e);
        }
    }
}