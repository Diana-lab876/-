//package first_level;
import java.util.Scanner;
public class basketbol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество двухочковых: ");
        int a = sc.nextInt();
        int two = a*2;
        System.out.println("Введите количество трехочковых: ");
        int b = sc.nextInt();
        int three = b*3;
        int sum = two+three;
        System.out.println("Счет за матч = "+sum);
    }
}
