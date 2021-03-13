package first_level;
import java.util.Scanner;
public class four {
    public static void main(String[] args) {
        boolean b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = sc.nextInt();
        if (number%5==0){
            b=true;
        }
        else {
            b=false;
        }
        System.out.println(b);
    }
}
