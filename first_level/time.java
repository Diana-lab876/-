package first_level;
public class time {
    public static void main(String[] args) {
        //System.out.println(convert(5));
        //System.out.println(points(38,8));
        System.out.println(footballPoints(3, 4, 2));
        //System.out.println(divisibleByFive(5));
        //System.out.println(and(true, false));
        //System.out.println(howManyWalls(54, 1, 43));
        //System.out.println(squared(5));
        //System.out.println(profitableGamble(0.2, 50, 9));
        //System.out.println(frames(1, 1));
        //System.out.println(mod(5, 2));
        }
        public static int convert(int a){
            /*Напишите функцию, которая принимает целое число минут и преобразует его в
            секунды.
            */
            return (60*a);
        }
    public static int points(int a, int b) {
        /*Вы подсчитываете очки за баскетбольный матч, учитывая количество забитых 2-х
        и 3-х очков, находите окончательные очки для команды и возвращаете это
        значение.
        */
        return (a*2+b*3);
    }
    public static int footballPoints(int a, int b, int c ){
        /*Создайте функцию, которая принимает количество побед, ничьих и поражений и
        вычисляет количество очков, набранных футбольной командой на данный момент. 
        */
       return (a*3+b);
    }
    public static boolean  divisibleByFive(int a){
        /*Создайте функцию, которая возвращает true, если целое число равномерно делится
        на 5, и false в противном случае.
        */
        return (a%5 ==0);
    }
    public static boolean and(boolean a, boolean b){
        /*В Java есть логический оператор &&. Оператор && принимает два логических
        значения и возвращает true, если оба значения истинны.
        */
        return (a&&b);
    }
    public static int howManyWalls(int n, int w, int h){
        /*У меня есть ведро с большим количеством темно-синей краски, и я хотел бы
        покрасить как можно больше стен. Создайте функцию, которая возвращает
        количество полных стен, которые я могу покрасить, прежде чем мне нужно будет
        отправиться в магазины, чтобы купить еще.
        */
        return (n/(w*h));
    }
    public static int squared(int b){
        /*Исправьте код, чтобы решить эту задачу (только синтаксические ошибки).
        Посмотрите на приведенные ниже примеры, чтобы получить представление о том,
        что должна делать эта функция.
        */
        return b * b;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        /*Создайте функцию, которая принимает три аргумента prob, prize, pay и возвращает
        true, если prob * prize > pay; в противном случае возвращает false.
        */
        return (prob * prize > pay);
    }
    public static int frames(int minuts, int FPS){
        /*Создайте метод, который возвращает количество кадров, показанных за заданное
        количество минут для определенного FPS.
        */
        return (60*minuts*FPS);
    }
    public static int mod(int a, int b){
        /*Создайте функцию, которая будет работать как оператор модуля % без
        использования оператора модуля. Оператор модуля-это способ определения
        остатка операции деления. Вместо того чтобы возвращать результат деления,
        операция по модулю возвращает остаток целого числа.
        */
        while (a>=b){
            a-=b;
        }
        return a;
    }
}
