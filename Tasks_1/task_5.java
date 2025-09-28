import java.util.Scanner;

public class task_5 {
    public static String daysToWeeks(int days) {
        int weeks = days / 7;
        int remainingDays = days % 7;
        
        String weekStr = (weeks == 1) ? "неделя" : 
                        (weeks >= 2 && weeks <= 4) ? "недели" : "недель";
        
        String dayStr = (remainingDays == 1) ? "день" : 
                       (remainingDays >= 2 && remainingDays <= 4) ? "дня" : "дней";
        
        return weeks + " " + weekStr + " и " + remainingDays + " " + dayStr;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        String result = daysToWeeks(days);
        System.out.println(result);
        scanner.close();
    }
}