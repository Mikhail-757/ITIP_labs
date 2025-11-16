import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopier {

    public static void copyFileContents(String sourcePath, String destinationPath) 
            throws IOException {
        
        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destinationPath)) {
            
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println(" Копирование завершено успешно!");

        } catch (IOException e) {
            throw e; 
        }
    }
}