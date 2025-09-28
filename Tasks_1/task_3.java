import java.util.Scanner;

public class task_3 {
    public static int digitSum(int number) {
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
        int result = digitSum(number);
        System.out.println(result);
        scanner.close();
    }
}