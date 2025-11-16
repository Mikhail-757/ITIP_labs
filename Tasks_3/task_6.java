import java.util.Scanner;
import java.util.Arrays;

public class FilterEvenNumbers {
    public static int[] filterEven(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }
        
        int[] result = new int[count];
        int index = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        input = input.replace("[", "").replace("]", "");
        String[] parts = input.split(", ");
        int[] numbers = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        
        int[] evenNumbers = filterEven(numbers);
        System.out.println(Arrays.toString(evenNumbers));
    }
}