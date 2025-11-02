import java.util.Scanner;

public class PositiveSum {
    public static int sumOfPositives(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number > 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numberStrings = input.split(",");
        int[] numbers = new int[numberStrings.length];
        
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i].trim());
        }
        
        int result = sumOfPositives(numbers);
        System.out.println(result);
        scanner.close();
    }
}