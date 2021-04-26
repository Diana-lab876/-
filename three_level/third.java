package three_level;
import java.util.Arrays;
public class third {
    public static void main(String[] args){
        Object [][] am ={{"Nice", 942208},{"Abu Dhabi", 1482816},{"Naples", 2186853},{"Vatican City", 572}};
        System.out.println(Arrays.deepToString(millionsRounding(am)));
        System.out.println(Arrays.toString(otherSides(1)));
        System.out.println(rps("scissors", "scissors"));
        int[] a ={2, 8, 7, 5};
        System.out.println(warOfNumbers(a));
        System.out.println(reverseCase("Happy Birthday"));
        System.out.println(inatorInator("EvilClone"));
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        int[] arr = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println(mean(arr));
        System.out.println(parityAnalysis(243));
    }
    /** Учитывая массив городов и населения, верните массив, в котором все население
     * округлено до ближайшего миллиона. */
    public static Object[][] millionsRounding(Object[][] am){
        for (int i=0; i<am.length; i++){
            if ((Integer)am[i][1]%1000000>=500000) {
                am[i][1] = ((Integer)am[i][1] / 1000000 +1)*1000000;
            }
            else{
                am[i][1] = ((Integer)am[i][1] / 1000000)*1000000;
            }
        }
        return am;
    }
     /** Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
      * найти другие 2 стороны (верните самую длинную сторону, сторону средней
      длины). */
    public static String[] otherSides(int a){
        String[] arr = new String[2];
        arr[0]=Double.toString(2.0*a);
        double c = Math.sqrt(2.0*a*2.0*a-a*a);
        arr[1]=Double.toString(Math.ceil(c*100)/100);
        //System.out.println(arr[0]);
        //System.out.println(arr[1]);
        return arr;
    }
    /** Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
     * принимает входные данные обоих игроков (камень, ножницы или бумага), первый
     * параметр от первого игрока, второй от второго игрока. Функция возвращает
     * результат как таковой: */
    public static String rps(String a, String b){
        String result = "";
        if ((a == ("rock") && b=="paper") || (a=="paper" && b=="scissors") || (a=="scissors" && b=="rock")){
            result = "Player 2 wins";
        }
        else{ 
        result = "Player 1 wins";
        }
        if (a==b) {
            result = "TIE";
        }
        return result;
    }
    /** Идет великая война между четными и нечетными числами. Многие уже погибли в
     * этой войне, и ваша задача-положить этому конец. Вы должны определить, какая
     * группа суммируется больше: четная или нечетная. Выигрывает большая группа.
     * Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
     * числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел. */
    public static int warOfNumbers(int[] a) {
        int even = 0; //Счетчик четных чисел
        int odd = 0; //счетчик нечетных чисел
        for (int i=0; i<a.length; i++){
            if (a[i]%2==0){
                even+=a[i];
            }
            else{
                odd+=a[i];
            }
        }
        return Math.abs(even-odd);
    }
    /** Учитывая строку, создайте функцию для обратного обращения. Все буквы в
     * нижнем регистре должны быть прописными, и наоборот. */
    public static String reverseCase(String a) {
        String result = "";
        for (int i=0; i<a.length(); i++){
            if ((a.charAt(i)>=65)&&(a.charAt(i)<=90)){
                result+=(char)(a.charAt(i)+32);
            }
            else{
                if ((a.charAt(i)>=97) && (a.charAt(i)<=122)){
                result+=(char)(a.charAt(i)-32);
                }
                else{
                    result+=a.charAt(i);
                }
            }

            }
            return result;
        }
        /** Создайте функцию, которая принимает строку из одного слова и выполняет
         * следующие действия:
         * Конкатенирует inator до конца, если слово заканчивается согласным, в противном
         * случае вместо него конкатенирует -inator
         * Добавляет длину слова исходного слова в конец, снабженный '000'. */
    public static String inatorInator(String a) {
        String min = a.toLowerCase();
        if ((min.charAt(min.length()-1)=='a') || (min.charAt(min.length()-1)=='e') || (min.charAt(min.length()-1)=='y') || (min.charAt(min.length()-1)=='u') || (min.charAt(min.length()-1)=='i') || (min.charAt(min.length()-1)=='o')){
            a+="-inator";
        }
        else {
            a+="inator";
        }
        a+=" ";
        a+=min.length();
        a+="000";
        return a;
    }
        /** Напишите функцию, которая принимает три измерения кирпича: высоту(a),
         * ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
         * отверстие с шириной(w) и высотой(h). */
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int[] one = {a,b,c};
        int[] two = {w,h};
        Arrays.sort(one);
        Arrays.sort(two);
        if ((one[0]<=two[0]) && (one[1]<=two[1])){
            return true;
        }
        else {
            return false;
        }
    }
        /** Напишите функцию, которая принимает топливо (литры), расход топлива
         * (литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
         * максимальное расстояние, которое может проехать автомобиль.
         * топливо-это количество литров топлива в топливном баке.
         * Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
         * Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
         * Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на
         * 10%. */
    public static double totalDistance(double litr, double ras, int pas, boolean kon ){
        ras+=(ras/100)*5*pas;
        if (kon){
            ras+=(ras/100)*10;
        }
        double result = Math.round((litr/ras*100)*100)/100D;
        return result;
    }
        /** Создайте функцию, которая принимает массив чисел и возвращает среднее
         * значение (average) всех этих чисел. */
    public static double mean(int[] arr) {
        double sum=0;
        int i=0;
        for (i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        sum=sum/i;
        return (Math.round(sum*100)/100D);
    }
        /** . Создайте функцию, которая принимает число в качестве входных данных и
         * возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
         * противном случае верните false. */
    public static boolean parityAnalysis(int a) {
        int sum=0;
        int b = a;
        while(b>0){
            sum+=b%10;
            b=b/10;
        }
        return (sum%2 == a%2);
    }
}
