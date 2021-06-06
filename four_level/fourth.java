//package four_level;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;

public class fourth {
    public static void main(String[] args){
        //int[] a = {2, 55, 60, 97, 86};
        //System.out.println(sevenBoom(a));
        //int[] c= {5, 6, 7, 8, 9, 9};
        //System.out.println(cons(c));
        //System.out.println(unmix("badce"));
        //System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        //System.out.println(xPronounce("The x ray is excellent"));
        //int[] arr={14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        // System.out.println(largestGap(arr));
        //System.out.println(reversUp(7977));
        //System.out.println(commonLastVowel("hello worlda"));
        //System.out.println(memeSum(26, 46));
        System.out.println(unrepeated("tctctctysiyd!!!!"));
    }
    /** Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
     * массиве появляется цифра 7. В противном случае верните "в массиве нет 7". */
        public static String sevenBoom(int[] a){
            String result ="";
            for (int i : a){
                result+=Integer.toString(i);
            }
            //Java String contains()- метод чтобы проверить, содержит ли String указанную последовательность символов.
            if (result.contains("7")) {
                return "Boom!";
            }
            return "There is no 7 in array";
        }
        /** Создайте функцию, которая определяет, могут ли элементы в массиве быть
         * переупорядочены, чтобы сформировать последовательный список чисел, где
         * каждое число появляется ровно один раз. */
        public static boolean cons(int[] c){
            //String result = "";
            Arrays.sort(c);
            for (int i=1; i<c.length; i++){
                if (c[i]-1!=c[i-1])
                return false;
            }
            return true;
        }
        /** lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
         * помогите мне распутать эти строки!
         * Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
         * Помоги отменить это, чтобы снова понять строки. */
        public static String unmix(String a){
            String result="";
            for (int i=0; i<a.length()/2; i++){
                result+=a.charAt(i*2+1);
                result+=a.charAt(i*2);
            }
            if (a.length()%2!=0){
                result+=a.charAt(a.length()-1);
            }
            return result;
        }
        /** Создать функцию, которая преобразует предложения, заканчивающиеся
         * несколькими вопросительными знаками ? или восклицательными знаками ! в
         * предложение, заканчивающееся только одним, без изменения пунктуации в
         * середине предложений. */
        public static String noYelling(String a){
            int i=a.length()-1;
            while (((a.charAt(i)=='?') && (a.charAt(i-1)=='?')) || ((a.charAt(i)=='!')  && (a.charAt(i-1)=='!')) || ((a.charAt(i)=='?')  && (a.charAt(i-1)=='!')) || ((a.charAt(i)=='!')  && (a.charAt(i-1)=='?'))){
                a=a.substring(0, i);
                i-=1;
            }
            return a;
        }
        /** . Создайте функцию, которая заменяет все x в строке следующими способами:
         * Замените все x на "cks", ЕСЛИ ТОЛЬКО:
         * Слово начинается с "x", поэтому замените его на "z".
         * Слово-это просто буква "х", поэтому замените ее на " cks ". */
        public static String xPronounce(String a){
            String result ="";
            for (int i=0; i<a.length(); i++){
                if (a.charAt(i)=='x'){
                    if (i==a.length()-1 && a.charAt(i-1)==' ' || i==0 && a.charAt(i+1)==' ' || i!=0 && i!=a.length()-1 && a.charAt(i-1)==' ' && a.charAt(i+1)==' '){
                        result +="ecks";
                        continue;
                    }
                    if(i==0 || a.charAt(i-1)==' '){
                        result+="z";
                        continue;
                    }
                    result+="cks";
                    continue;
            }
            if (a.charAt(i)=='X'){
                if (i==a.length()-1 && a.charAt(i-1)==' ' || i==0 && a.charAt(i+1)==' ' || i!=0 && i!=a.length()-1 && a.charAt(i-1)==' ' && a.charAt(i+1)==' '){
                    result +="cks";
                    continue;
                }
                if(i==0 || a.charAt(i-1)==' '){
                    result+="Z";
                    continue;
                }
                result+="cks";
                continue;
        }
        result+=a.charAt(i);
    }
            return result;
        }
        /** Учитывая массив целых чисел, верните наибольший разрыв между
         * отсортированными элементами массива. */
        public static int largestGap(int[] arr) {
            Arrays.sort(arr);
            int ras=0;
            int max=0;
            for (int i=1; i<arr.length; i++){
                ras=Math.abs(arr[i]-arr[i-1]);
                if (ras>max){
                    max=ras;
                }
            }
            return max;
        }
        /** Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
         * создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
         * чтобы удовлетворить соотношение между входами и выходами.
         * Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
         * ниже производит показанные примеры выходных данных. */
        public static int reversUp(int a){
            int result =0;
            int start=a;
            String c = Integer.toString(a);
            int[] arr = new int[c.length()];
            for (int i = c.length() - 1; i >= 0; i--) {
            arr[i] = a % 10;
            a /= 10;
        }
        Arrays.sort(arr);
        int l=0;
        int ten =1;
        for (int j=arr.length-1; j>=0; j--){
            l=l+arr[j]*ten;
            ten*=10;
        }
        result = start-l;
        return result;
        }


        /* Создайте функцию, которая принимает предложение в качестве входных данных и возвращает 
        наиболее распространенную последнюю гласную в предложении в виде одной символьной строки.  */
       public static String commonLastVowel(String at){
           int o =0; 
           int e =0;
           int y =0; 
           int u =0; 
           int i =0; 
           int a =0; 
           String result ="";
           at=at.toLowerCase();
           at=at+" ";
           for (int it=0; it<at.length(); it++){
               if (at.charAt(it)==' '){
                   if (at.charAt(it-1)=='o'){
                    o += 1;
                }
                if (at.charAt(it-1)=='e'){
                    e += 1;
                }
                if (at.charAt(it-1)=='y'){
                    y += 1;
                }
                if (at.charAt(it-1)=='u'){
                    u += 1;
                }
                if (at.charAt(it-1)=='i'){
                    i += 1;
                }
               if (at.charAt(it-1)=='a'){
                    a += 1;
                }
               }
           }
           int[] arr = new int[]{o, e, y, u, i, a};
           int max=0;
           int index =-1;
           for (int jt=0; jt<arr.length; jt++){
               if (arr[jt]>=max){
                   max=arr[jt];
                   index = jt;
               }
           }
           switch (index){
               case -1:
               result="Не заканчивается на гласную";
               break;
               case 0:
               result="o";
               break;
               case 1:
               result="e";
               break;
               case 2:
               result="y";
               break;
               case 3:
               result="u";
               break;
               case 4:
               result="i";
               break;
               case 5:
               result="a";
               break;
           }
           return result;
        }

        /* Для этой задачи забудьте, как сложить два числа вместе. Лучшее объяснение того, 
        что нужно сделать для этой функции, - это этот мем:  */
        public static int memeSum (int a, int b){
            StringBuilder result = new StringBuilder();
            while (a % 10 != 0 || b % 10 != 0) {
                int c = a % 10 + b % 10;
                result.insert(0, c);
                a/=10;
                b/=10;
            }
            return(Integer.parseInt(result.toString()));
        }
    


       /*  Создайте функцию, которая удалит все повторяющиеся символы в слове, 
       переданном этой функции. Не просто последовательные символы, а символы, 
       повторяющиеся в любом месте строки.  */
        public static String unrepeated(String a) {
            String result = "";
            for (int i=0; i<a.length(); i++){
                //В contains() метод проверяет, содержит ли строка последовательность символов
                //Метод character.toString() - возвращает строкоый объект и представляет указанное значение как одну символьную строку
                if (!result.contains(Character.toString(a.charAt(i)))){
                    result += a.charAt(i);
                }
            }
            return result;
        }

}
