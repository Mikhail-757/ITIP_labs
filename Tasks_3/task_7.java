import java.util.Scanner;

public class WordCounter {
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        
        String trimmed = input.trim();
        String[] words = trimmed.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(countWords(input));
    }
}