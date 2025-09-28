import java.util.Scanner;

public class Temperature {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double tempC = in.nextDouble();
        System.out.print((int)converter(tempC));
        in.close();
    }

    public static double converter(double tempC){
        return (tempC*9.0)/5.0 + 32;
    }
}