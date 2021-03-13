package first_level;
import java.util.Scanner;
public class ten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a =sc.nextInt();
        System.out.println("Введите второе число: ");
        int b =sc.nextInt();
        int c = a/b;
        int answer = a-(b*c);
        System.out.println("Остаток от деления = " + answer);
    }
}
