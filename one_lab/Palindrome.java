//package one_lab;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Объявляем Scanner
        String sс = in.nextLine();; // читаем строку из консоли
        if (isPalindrome(sс)){
            System.out.println("Палиндром");
        }
        else{
            System.out.println("Не палиндром");
        }
        in.close();
    }
    //метод, который переворачивает строку
    public static String reverseString(String news){
        String s1=news.replaceAll(" ", "");
        String reverseString = "";
        for (int i=s1.length()-1;i>-1;i--){
            reverseString = reverseString + s1.charAt(i);
        }
        return reverseString;
    }
    //метод, который проверяет, является ли строка палендромом
    public static boolean isPalindrome(String s1){
        boolean isPalindrome = false;
        String news2 = reverseString(s1);
        if (s1.equals(news2)) {
            isPalindrome=true;
        }
        return isPalindrome;
    }
}