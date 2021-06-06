//package first_level;
import java.util.Scanner;
public class nine {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Задайте количество минут:  ");
    int minuts =sc.nextInt();
    System.out.println("Введите FPS:  ");
    int FPS =sc.nextInt();
    int personnel = 60*minuts*FPS;
    System.out.println("Количество кадров = " + personnel);
    }
}
