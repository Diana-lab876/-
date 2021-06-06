//package first_level;
import java.util.Scanner;
public class football {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество побед:");
        int victory = sc.nextInt();
        int victory2 = victory*3;
        System.out.println("Введите количество ничьих:");
        int draw = sc.nextInt();
        int draw2 = draw*1;
        System.out.println("Введите количество поражений:");
        int defeat = sc.nextInt();
        int defeat2 = defeat*0;
        int sum = victory2+draw2+defeat2;
        System.out.println("Количество очков на данный момент = " + sum);
}
}
