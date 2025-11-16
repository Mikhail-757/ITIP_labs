import java.util.Scanner;
import java.util.Arrays;

public class AnagramChecker {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        String[] words = input.split(", ");
        String word1 = words[0];
        String word2 = words[1];
        
        System.out.println(isAnagram(word1, word2));
    }
}