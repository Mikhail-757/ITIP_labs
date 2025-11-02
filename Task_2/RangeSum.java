import java.util.Scanner;

public class RangeSum {
    public static long sumRange(int a, int b) {
        long first = a;
        long last = b;
        long count = last - first + 1;
        return (first + last) * count / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        int a = Integer.parseInt(numbers[0].trim());
        int b = Integer.parseInt(numbers[1].trim());
        long result = sumRange(a, b);
        System.out.println(result);
        scanner.close();
    }
}