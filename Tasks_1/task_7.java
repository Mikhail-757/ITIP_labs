import java.util.Scanner;

public class task_7 {
    public static double average(double a, double b, double c) {
        return (a + b + c) / 3;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        double result = average(num1, num2, num3);
        System.out.println(result);
        scanner.close();
    }
}