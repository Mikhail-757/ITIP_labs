import java.util.Scanner;
import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] parts = input.replace("\"", "").split(",");
            if (parts.length == 2) {
                String text = parts[0].trim();
                String key = parts[1].trim();
                int[] result = Decode(text, key);
                System.out.println(Arrays.toString(result));
            }
        }
    }

    public static int[] Decode(String text, String key) {
        int[] result = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i) ^ key.charAt(i % key.length());
        }
        return result;
    }
}