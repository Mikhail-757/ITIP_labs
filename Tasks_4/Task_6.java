import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String input = scanner.next();
            int[] counts = new int[10];
            
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= '0' && c <= '9') {
                    counts[c - '0']++;
                }
            }
            
            System.out.print("[");
            for (int i = 0; i < 10; i++) {
                System.out.print(counts[i]);
                if (i < 9) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}