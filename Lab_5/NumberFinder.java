import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price is 19.99, old price was 25, discount 5.5 and code 123.";
        String regex = "\\d+(\\.\\d+)?";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        }
    }
}
