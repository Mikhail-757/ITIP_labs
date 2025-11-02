import java.util.Scanner;
import java.util.HashSet;

public class DuplicateChecker {
    public static boolean hasDuplicates(int[] numbers) {
        HashSet<Integer> seen = new HashSet<>();
        for (int number : numbers) {
            if (!seen.add(number)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numberStrings = input.split(",");
        int[] numbers = new int[numberStrings.length];
        
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }
        
        boolean result = hasDuplicates(numbers);
        System.out.println(result);
        scanner.close();
    }
}