import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {
    
    private static final String LOG_FILE = "exception_log.txt";
    private static final DateTimeFormatter FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(Throwable e, String operation) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
             
            String timestamp = LocalDateTime.now().format(FORMATTER);
            
            pw.printf("--- ИСКЛЮЧЕНИЕ --- %s\n", timestamp);
            pw.printf("Операция: %s\n", operation);
            pw.printf("Тип: %s\n", e.getClass().getName());
            pw.printf("Сообщение: %s\n", e.getMessage());
            pw.println("Трассировка стека:");
            e.printStackTrace(pw);
            pw.println("--------------------\n");
            
        } catch (IOException ioException) {
            System.err.println("Критическая ошибка: Не удалось записать лог.");
        }
    }
}