import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class WordsStartingWith {
    public static void main(String[] args) {
        String letter;
        if (args.length > 0 && args[0] != null && args[0].length() > 0) {
            letter = args[0].substring(0, 1);
        } else {
            letter = "a";
        }

        String text;
        if (args.length > 1) {
            try {
                text = Files.readString(Path.of(args[1]));
            } catch (Exception e) {
                System.err.println("Не удалось прочитать файл: " + e.getMessage());
                return;
            }
        } else {
            text = "Apple apricot banana Автомобиль абрикос Alpha beta a1 a-b a_c";
        }

        String regex = "\\b(?i:" + Pattern.quote(letter) + ")\\p{L}*\\b";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            boolean found = false;
            System.out.println("Ищем слова, начинающиеся с буквы: '" + letter + "'");
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("Совпадений не найдено.");
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Произошла ошибка при обработке: " + e.getMessage());
        }
    }
}
