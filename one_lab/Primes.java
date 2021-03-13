package one_lab;

public class Primes {
    public static void main(String[] args) {
        for (int j = 2; j < 100; j++) {
            if (ISprime(j)) {
                System.out.println(j+"- Простое число");
            }
        }
    }
    public static boolean ISprime(int n){
        boolean ISprime = true;
        for (int i = 2; i < n; i++) {
            if ((n % i == 0)) {
                ISprime = false;
                break;
            }
        }
        return ISprime;
    }
}
