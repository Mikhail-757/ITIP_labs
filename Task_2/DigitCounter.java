import java.util.Scanner;

public class DigitCounter {
    public static int[] countEvenOddDigits(int n) {
        int evenCount = 0;
        int oddCount = 0;
        
        long num = Math.abs((long)n);
        
        if (num == 0) {
            return new int[]{1, 0};
        }
        
        while (num > 0) {
            int digit = (int)(num % 10);
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            num /= 10;
        }
        
        return new int[]{evenCount, oddCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] result = countEvenOddDigits(n);
        System.out.println(result[0] + ", " + result[1]);
        scanner.close();
    }
}