public class task_1 {

    public static double toFahrenheit(double celsius) {
        return celsius * (9.0 / 5.0) + 32;
    }

    public static void main(String[] args) {
        System.out.println(toFahrenheit(0)); 
        System.out.println(toFahrenheit(25));
        System.out.println(toFahrenheit(-10));
    }
}