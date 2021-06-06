//package first_level;
import java.util.Scanner;
public class six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество квадратных метров: ");
        int n =sc.nextInt();
        System.out.println("Введите ширину стены: ");
        int w = sc.nextInt();
        System.out.println("Введите длину стены: ");
        int h = sc.nextInt();
        int c = n/(w*h);
        System.out.println("Количество полных стен, которые можно покрасить = "+c);
    }
}
