import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Программа для копирования содержимого одного файла в другой
 * с обработкой ошибок при открытии/закрытии и чтении/записи.
 */
public class FileCopy {

    public static void main(String[] args) {
        // Пути к исходному и целевому файлам
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // Вызываем метод копирования с обработкой ошибок
        copyFile(sourceFile, destinationFile);
    }

    /**
     * Копирует содержимое одного файла в другой.
     * Обрабатывает ошибки при открытии/закрытии файлов и при чтении/записи.
     *
     * @param sourcePath      путь к исходному файлу
     * @param destinationPath путь к целевому файлу
     */
    public static void copyFile(String sourcePath, String destinationPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Попытка открыть файлы для чтения и записи (вариант 1: ошибки открытия)
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(destinationPath);

            // Буфер для чтения данных
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Чтение и запись данных (вариант 2: ошибки чтения/записи)
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            // Обработка ошибок при открытии, чтении или записи файлов
            System.err.println("Произошла ошибка при работе с файлами: " + e.getMessage());
        } finally {
            // Закрытие потоков с обработкой возможных ошибок (вариант 1: ошибки закрытия)
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии исходного файла: " + e.getMessage());
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии целевого файла: " + e.getMessage());
            }
        }
    }
}