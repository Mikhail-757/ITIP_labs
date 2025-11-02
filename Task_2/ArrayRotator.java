import java.util.Scanner;

public class ArrayRotator {
    public static int[] rotateRight(int[] arr, int k) {
        if (arr.length == 0) return arr;
        
        k = k % arr.length;
        if (k == 0) return arr;
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i + k) % arr.length] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        
        int lastBracket = input.lastIndexOf(']');
        if (lastBracket == -1) {
            System.out.println("[]");
            scanner.close();
            return;
        }
        
        String arrayStr = input.substring(0, lastBracket + 1);
        String kStr = input.substring(lastBracket + 1).trim();
        
        if (kStr.startsWith(",")) {
            kStr = kStr.substring(1).trim();
        }
        
        int k = Integer.parseInt(kStr);
        
        int[] numbers;
        if (arrayStr.equals("[]")) {
            numbers = new int[0];
        } else {
            String content = arrayStr.substring(1, arrayStr.length() - 1);
            String[] numberStrings = content.split(",");
            numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }
        }
        
        int[] result = rotateRight(numbers, k);
        
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        scanner.close();
    }
}