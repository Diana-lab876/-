package second_level;

public class second {
    public static void main(String[] args){
        System.out.println(oppositeHouse(3, 5)); //1
        //System.out.println(nameShuffle("Donald Trump")); //2
        //System.out.println(discount(89.0, 20)); //3
        //int[] a = {1, 2, 3, 4, 5}; //4
        //System.out.println(differenceMaxMin(a));//4
        //System.out.println(equal(3, 4, 1)); //5
        //System.out.println(reverse("Hello World"));//6
        //System.out.println(programmers(1, 5, 9));//7
        //System.out.println(getXO("ooxXm"));//8
        //System.out.println(bomb("This goes boom!!!"));//9
        //System.out.println(sameAscii("EdAbIt", "EDABIT"));//10
    }
    public static int oppositeHouse(int a, int b){
        b=b*2;
        int c = b+1;
        int k =c-a;
        return k;

    }
    public static String nameShuffle(String name){
        String[] words = name.split(" ");
        name = words[0];
        words[0] = words[words.length-1];//запоминаем первое слово, заместо него ставим второе
        words[words.length-1] = name;// в последнее слово, которое запомнили
        String words2="";
        for (String word : words) {
        words2 = words2 + word + " "; 
        }
        return (words2); 
    }
    public static double discount(Double a, int b){
        double result = ((100-b)*a)/100;
        System.out.println();
        return result;
    }
    public static int differenceMaxMin(int[] a){
        int max=a[0], min=a[0];
        for (int i=0; i<a.length; i++){
            if (max<a[i]){
                max=a[i];
            }
            if (min>a[i]){
                min=a[i];
            }
        }
        int result = max-min;
        return result;
    }
    public static int equal(int a, int b, int c){
        int i=0;
        if (a==b){
            i=i+2;
            if (b==c){
                i=i+1;
            }
        }
        else {
            if (a==c){
                i=i+2;
            }
            else {
                if (b==c){
                    i=i+2;
                }
            }  
        }
        return i;
    }
    public static String reverse(String a){
        String reverseString = "";
        for (int i=a.length()-1;i>-1;i--){
            reverseString = reverseString + a.charAt(i);
        }
        return reverseString;
    }
    public static int programmers(int a, int b, int c){
        int max, min;
        if (a>b){
            max=a;
            if (c>a){
                max=c;
                min=b;
            }
            else {
                max=a;
                if (c>b){
                min=b;
                }
                else {
                    min=c;
                }
            }
        }
        else {
            max=b;
            if (b>c){
                max=b;
                min=a;
            }
            else{
                max=c;
                if (a<c){
                min=a;
                }
                else{
                    min=c;
                }
            }
        }
        int result = max-min;
        return result;
    }
    public static boolean getXO(String a){
        boolean result=true;
        String line = a.toUpperCase();
        String [] lines = line.split(" ");
        String x ="x";
        String o ="o";
        int count =0;
        int two =0;
        for(int i = 0; i < lines.length; i++){
            if(x.equals(lines[i])){
                count = count+1;
            }
            if(o.equals(lines[i])){
                two=two+1;
            }
        }
        if (two!=count){
            result=false;
        }
        return result;
    }
    public static String bomb(String a){
        String line = a.toLowerCase();
        String b="";
        if (line.contains("bomb")){
            b="DUCK!";
        }
        else{
            b="Relax, there's no bomb.";
        }
        return b;
    }
    public static boolean sameAscii(String a, String b){
        String [] lines = a.split("");
        int ascii=0;
        char a2;
        for (int i=0; i<lines.length; i++){
        a2=a.charAt(i);
        ascii = (int)a2+ascii;
        }
        String [] lines2 = b.split("");
        int ascii2=0;
        char b2;
        for (int i=0; i<lines2.length; i++){
        b2=b.charAt(i);
        ascii2=(int) b2+ascii2;
        }
        boolean result = true;
        if (ascii!=ascii2){
            result=false;
        }
        return result;
    }
}
