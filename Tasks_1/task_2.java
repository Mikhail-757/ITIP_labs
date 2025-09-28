import java.util.Scanner;

public class task_2 {
    
    public static double rectangleArea(double length, double width) {
        return length * width;
    }
    
    public static double rectangleArea(double length, double width, double height) {
        return 2 * (length * width + length * height + width * height);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double param1 = scanner.nextDouble();
        double param2 = scanner.nextDouble();
        
        if (scanner.hasNextDouble()) {
            double param3 = scanner.nextDouble();
            double result = rectangleArea(param1, param2, param3);
            System.out.println(result);
        } else {
            double result = rectangleArea(param1, param2);
            System.out.println(result);
        }
        
        scanner.close();
    }
}