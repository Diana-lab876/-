//package first_level;
import java.util.Scanner;
public class five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите true или false:");
        boolean a = sc.nextBoolean();
        System.out.println("Введите true или false:");
        boolean b = sc.nextBoolean();
        //boolean c = a&&b;
        System.out.println("Ответ - " + (a&&b));
    }
}
