import java.util.Scanner;

public class CountVowels {
    public static int countVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(countVowels(input));
    }
}