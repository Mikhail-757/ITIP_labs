import java.util.*;

public class Task_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] words = input.toLowerCase().split("[^a-zа-я0-9]+");
            Map<String, Integer> frequencyMap = new LinkedHashMap<>();
            
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
            
            StringBuilder result = new StringBuilder("{");
            int count = 0;
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                result.append(entry.getKey()).append(": ").append(entry.getValue());
                count++;
                if (count < frequencyMap.size()) {
                    result.append(", ");
                }
            }
            result.append("}");
            System.out.println(result.toString());
        } else {
            System.out.println("{}");
        }
    }
}