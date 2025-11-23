import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalAfterLower {

    public static void main(String[] args) {
        String text = "aBcdefGhijK";
        String regex = "([a-z])([A-Z])";
        String result = "";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            result = matcher.replaceAll("$1!$2!");
            
            System.out.println("Исходный текст: " + text);
            System.out.println("Результат: " + result);

        } catch (Exception e) {
            System.err.println("Ошибка обработки: " + e.getMessage());
        }
    }
}
