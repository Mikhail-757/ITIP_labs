import java.util.Scanner;

public class Clamp {
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        
        int value = Integer.parseInt(parts[0].trim());
        int min = Integer.parseInt(parts[1].trim());
        int max = Integer.parseInt(parts[2].trim());
        
        int result = clamp(value, min, max);
        System.out.println(result);
        
        scanner.close();
    }
}