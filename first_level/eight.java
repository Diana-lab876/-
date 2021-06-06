//package first_level;
import java.util.Scanner;
public class eight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите prob:");
        double prob = sc.nextDouble();
        System.out.println("Введите prize:");
        double prize = sc.nextDouble();
        System.out.println("Введите pay:");
        double pay = sc.nextDouble();
        boolean profit;
        if (prob * prize > pay) {
            profit = true;
        }
        else {
            profit = false;
        }
        System.out.println("Ответ: " + profit);
    }
}
