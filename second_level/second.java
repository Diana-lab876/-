//package second_level;

public class second {
    public static void main(String[] args){
        //System.out.println(oppositeHouse(3, 5)); //1
        //System.out.println(nameShuffle("Donald Trump")); //2
        //System.out.println(discount(89.0, 20)); //3
        //int[] a = {1, 2, 3, 4, 5}; //4
        //System.out.println(differenceMaxMin(a));//4
        //System.out.println(equal(3, 4, 1)); //5
        //System.out.println(reverse("Hello World"));//6
        //System.out.println(programmers(1, 5, 9));//7
        //System.out.println(getXO("xoX"));//8
        //System.out.println(bomb("This goes boom!!!"));//9
        //System.out.println(sameAscii("EdAbIt", "EDABIT"));//10
    }
    public static int oppositeHouse(int a, int b){
        return (((b*2)+1)-a);

    }
    public static String nameShuffle(String name){
        int j=0;
        for (int i=0; i<name.length(); i++){
            if (name.charAt(i)==' '){
                j=i;
                break;
            }
        }
        String names= name.substring(0, j);
        String subnames=names.substring(j+1, name.length());
        return (subnames+ ' ' + names);
    }
    public static double discount(Double a, int b){
        return (((100-b)*a)/100);
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
        return (max-min);
    }
    public static boolean getXO(String a){
        int x =0;
        int o =0;
        String a1 = a.toLowerCase();
        for (int i=0; i<a1.length(); i++){
            if (a1.charAt(i) == 'x'){
                x++;
            }
            if (a1.charAt(i) == 'o'){
                o++;
            }
        }
        return(x==o); 
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
        int ascii_1=0;
        int ascii_2=0;
        for (int i=0; i<a.length(); i++){
        ascii_1 += (int)a.charAt(i);
        }
        for (int i=0; i<b.length(); i++){
        ascii_2 +=(int)b.charAt(i);
        }
        return (ascii_1==ascii_2);
    }
}
