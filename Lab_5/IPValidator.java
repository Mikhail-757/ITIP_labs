import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPValidator {

    public static void main(String[] args) {
        String ip = (args.length > 0) ? args[0] : "192.168.0.1";
        
        String octet = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        String regex = "^(" + octet + "\\.){3}" + octet + "$";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP корректен: " + ip);
            } else {
                System.out.println("IP некорректен: " + ip);
            }

        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
