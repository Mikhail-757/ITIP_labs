import java.util.Scanner;

public class SumOfDigits {
    public static int sumOfDigits(int number) {
        int sum = 0;
        int num = Math.abs(number);
        
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(sumOfDigits(number));
    }
}