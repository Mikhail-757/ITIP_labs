import java.util.Scanner;

public class task_1 { 

    public static double toFahrenheit(double celsius) {
        return celsius * (9.0 / 5.0) + 32; 
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        
        System.out.print("Введите Цельсий: ");
        
        if (inp.hasNextDouble()) {
            double num = inp.nextDouble();
            System.out.printf("Результат: %.1f °F\n", toFahrenheit(num));
        } else {
             System.out.println("Ошибка: введите число.");
        }
        
        inp.close();
    }
}