import java.util.Scanner;

public class DiagonalSum {
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        
        if (input.equals("[]")) {
            System.out.println(0);
            scanner.close();
            return;
        }
        
        String rows = input.substring(1, input.length() - 1);
        String[] rowArrays = rows.split("],\\[");
        
        int n = rowArrays.length;
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String row = rowArrays[i];
            if (row.startsWith("[")) row = row.substring(1);
            if (row.endsWith("]")) row = row.substring(0, row.length() - 1);
            
            String[] numbers = row.split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j].trim());
            }
        }
        
        int result = diagonalSum(matrix);
        System.out.println(result);
        
        scanner.close();
    }
}