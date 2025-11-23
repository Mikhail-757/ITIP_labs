import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CapitalAfterLower {
    public static void main(String[] args) {
        String text = "abCdeFghIjK";

        String regex = "([a-z])([A-Z])";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$1$2!");

            System.out.println("Исходный текст: " + text);
            System.out.println("Результат: " + result);

        } catch (Exception e) {
            System.err.println("Ошибка обработки: " + e.getMessage());
        }
    }
}
