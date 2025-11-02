import java.util.Scanner;
import java.util.TreeSet;

public class ArrayMerger {
    public static int[] mergeUniqueSorted(int[] a, int[] b) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) result[index++] = num;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        
        String[] arrays = input.split("\\], \\[");
        
        int[] a = parseArray(arrays[0].replace("[", "").replace("]", ""));
        int[] b = parseArray(arrays[1].replace("[", "").replace("]", ""));
        
        int[] result = mergeUniqueSorted(a, b);
        
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(",");
        }
        System.out.println("]");
        
        scanner.close();
    }
    
    private static int[] parseArray(String str) {
        if (str.isEmpty()) return new int[0];
        String[] parts = str.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}