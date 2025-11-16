import java.util.Scanner;

public class DifferenceMaxMin {
    public static int differenceMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max - min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        input = input.replace("[", "").replace("]", "");
        String[] parts = input.split(", ");
        int[] arr = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        System.out.println(differenceMaxMin(arr));
    }
}