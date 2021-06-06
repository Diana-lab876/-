import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class six_level {
    public static void main(String[] args){
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println(nicoChipher("myworldevolvesinhers", "tesh"));
        int[] a1 = {1, 2, 3, 9, 4, 5, 15, 3};
        System.out.println(Arrays.toString(twoProduct(a1, 45)));
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(fractions("0.(6)"));
        System.out.println(pilish_string("33314444"));
        System.out.println(generateNonconsecutive(1));
        System.out.println(isValid("aabbcd"));
		System.out.println(sumsUp(new int[] { 1, 2, 3, 6, 5 }));
    }

    /** Создайте функцию, которая принимает две строки. Первая строка содержит
     * предложение, содержащее буквы второй строки в последовательной
     * последовательности, но в другом порядке. Скрытая анаграмма должна содержать
     * все буквы, включая дубликаты, из второй строки в любом порядке и не должна
     * содержать никаких других букв алфавита.
     * Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в
     * первую строку. Вы должны игнорировать регистр символов, любые пробелы и
     * знаки препинания и возвращать анаграмму в виде строчной строки без пробелов
     * или знаков препинания. */
    public static String hiddenAnagram(String str, String str2) {
        StringBuilder result = new StringBuilder();
        str = str.toLowerCase();
        String[] arr = {".", "!", "?", " ", ",", ";"};
        for (String s : arr) {
            str = str.replace(s, "");
            str2 = str2.replace(s, "");
        }
        for (int i = 0; i < str.length(); i++) {
            String chr = Character.toString(str.charAt(i));
            if (str2.contains(chr)) {//проверяет сожержит ли заданную последовательность
                result.append(chr);//добавляем к результату новые значения
                str2 = str2.replaceFirst(chr, "");//заменяет первую подстроку данной строки, которая соответствует заданному регулярному выражению, с данной заменой, другими словами
            }
            if(str2.isEmpty()) break;//возвращает true, если строка пустая (длина равна 0) 
        }
        for (int i = 0; i < str2.length(); i ++){
            String chr = Character.toString(str2.charAt(i));
            if(!result.toString().contains(chr)){return"noutfond";}
        }
        return result.toString();
    }

    /** Напишите функцию, которая возвращает массив строк, заполненных из срезов
     * символов n-длины данного слова (срез за другим, в то время как n-длина
     * применяется к слову). */
    public static String[] collect(String str, int n){
		String [] arr;
		if (str.length() < n){
            arr = new String[1];
        }
		else {
		arr = new String[str.length() / n];
		int prob=0;
		for (int i=0; i<str.length()/n; i++){
			arr[i]=str.substring(prob, prob+n);
			prob=prob+n;
			}
		}
		Arrays.sort(arr);
			return arr;
		}
    /**В шифре Nico кодирование осуществляется путем создания цифрового ключа и
     * присвоения каждой буквенной позиции сообщения с помощью предоставленного ключа.
     * Создайте функцию, которая принимает два аргумента, message и key, и возвращает
     * закодированное сообщение. */
    public static String nicoChipher(String message, String key){
		ArrayList<Character> chars = new ArrayList<>();
		for (char c : key.toCharArray()) {
			chars.add(c);//заполнение ключом
		}
	
		HashMap<Character, ArrayList<Character>> data = new HashMap<>();
		int counter = 0;
		while (!message.equals("")) {//пока строка не пустая
			counter += 1;
			for (Character chr : chars){
				if (message.equals("")){//если пустая
					data.get(chr).add(' ');
				} else if (!data.containsKey(chr)) {//если в дате нет элемента который совпадает с ключом chr
					data.put(chr, new ArrayList<>());
					data.get(chr).add(message.charAt(0));
				} else {
					data.get(chr).add(message.charAt(0));
				}
	
				if (message.length() == 1){
					message = "";
				} else if (message.length() > 1) {
					message = message.substring(1);
				}
			}
		}
		Collections.sort(chars);
	
		String result = "";
		for (int i = 0; i < counter; i++){
			for (Character chr: chars){
				result += data.get(chr).get(0);
				data.get(chr).remove(0);
			}
		}
		return result;
	}
	

    /**. Создайте метод, который принимает массив arr и число n и возвращает массив и
     * двух целых чисел из arr, произведение которых равно числу n следующего вида:
     * [value_at_lower_index, value_at_higher_index] */
    public static int[] twoProduct(int[] arr, int val) {
        int a=0, b=0;
		int[] answer = new int[2];//создаем массив из двух элементов
		for(int i=arr.length-1;i>0;--i) {
			b=arr[i];
			for(int j=i-1;j>=0;--j) {
				a=arr[j];
				if(a*b==val) {
					answer[0]=a;
					answer[1]=b;
				}
			}
		}
		return answer;
    }

    /**Создайте рекурсивную функцию, которая проверяет, является ли число точной
     * верхней границей факториала n. Если это так, верните массив точной
     * факториальной границы и n, или иначе, пустой массив. */
    public static int[] isExact(int val){
        int[]answer=new int[0];//создаем массив
        int number = isFract(val,2);//обращаемся к функции
        if (number != -1){
            answer = new int[]{val,number};
        }
        return answer;
    }
    public static int isFract(int val,int k){
        if (val == 1) return k-1;//если число =1, возвращаем 1
        if (val%k!=0) return -1;//если остаток от деления на число не равен 0, возвращаем -1
        return isFract(val/k,k+1);
    }


    /**Деление на дробь часто приводит к бесконечно повторяющейся десятичной дроби.
     * Создайте функцию, которая принимает десятичную дробь в строковой форме с
     * повторяющейся частью в круглых скобках и возвращает эквивалентную дробь в
     * строковой форме и в наименьших членах.
     */
    public static String fractions(String numb) {
		String noSmiles="",withoutDotOnly="";
		int power1=0,power2=0,dotIndex=0,firstIndex=0,secondIndex=0;
		for (int i=0;i<numb.length();i++) {
			if(numb.charAt(i)=='.') {//ищем на каком месте стоит точка
				dotIndex=i;
			}else
			if(numb.charAt(i)=='(') {//ищем на каком месте стоит (
				firstIndex=i;
			}else
			if(numb.charAt(i)==')') //ищем на каком месте стоит точка )
				secondIndex=i;
			else
				noSmiles+=numb.charAt(i);//выводим число без этих симовлов
		}
		withoutDotOnly=noSmiles.substring(0,firstIndex-1);//присваиваем подстрочку от первого символа до первой скобки
		int firstNumber,secondNumber;
		power1=secondIndex-dotIndex-2;
		power2=firstIndex-dotIndex-1;
		firstNumber=(int)(Math.pow(10, power1)-Math.pow(10, power2));
		secondNumber=Integer.parseInt(noSmiles)-Integer.parseInt(withoutDotOnly);//остаток от числа
		int[] pair=divide(secondNumber,firstNumber);
		return pair[0]+"/"+ pair[1];
	}
    public static int[] divide(int a, int b) {
		int k=2;
		int t =Math.max(a, b);
		while (k<t) {
			if(a%k==0 && b%k==0) {
				a/=k;
				b/=k;
			}else
			k++;
		}
		return new int[] {a,b};
	}


    /**В этой задаче преобразуйте строку в серию слов (или последовательности
     * символов), разделенных одним пробелом, причем каждое слово имеет одинаковую
     * длину, заданную первыми 15 цифрами десятичного представления числа Пи: 3.14159265358979
     * Если строка содержит больше символов, чем общее количество, заданное суммой цифр
     * Пи, неиспользуемые символы отбрасываются, и вы будете использовать только те,
     * которые необходимы для формирования 15 слов */
    public static String pilish_string(String str) {
		String st="314159265358979";
		String res="";
		int index=0;
		int len=0;
		for (int i=0;i<str.length();i++) {
			len++;
			res+=str.charAt(i);
			if(st.charAt(index)-'0'==len)
			{
				res+=" ";
				len=0;
				index++;
			}
			if(index==15)
				return res;
		}
		if(st.charAt(index)-'0'>len)
			while(st.charAt(index)-'0'>len) {
				res+=res.charAt(res.length()-1);
				len++;
			}
		return res;
	}

    /**Создайте функцию для генерации всех непоследовательных двоичных строк, где
     * непоследовательные определяется как строка, в которой нет последовательных
     * строк, и где n определяет длину каждой двоичной строки. */
    public static String generateNonconsecutive(int n) {		
		return recurse(n,false,"");
	}
	public static String recurse(int n, boolean isOne,String s) {
		if(n == 1) {
			if(isOne){
                return s + "0 ";
            }
			else{
                return s + "0" + " " + s + "1 ";
            }
		}
		if(isOne) {
			return recurse(n - 1, false, s + "0");
		}
        else {
			return recurse(n - 1, false, s + "0") + recurse(n - 1, true, s + "1");
		}	
	}


    /**Шерлок считает строку действительной, если все символы строки встречаются
     * одинаковое количество раз. Также допустимо, если он может удалить только 1
     * символ из 1 индекса в строке, а остальные символы будут встречаться одинаковое
     * количество раз. Для данной строки str определите, действительна ли она. Если да,
     * верните «ДА», в противном случае верните «НЕТ».
     * Например, если str = "abc", строка действительна, потому что частота символов у всех
     * одинакова. Если str = "abcc", строка также действительна, потому что мы можем
     * удалить 1 "c" и оставить по одному символу каждого символа в строке. Однако, если
     * str = "abccc", строка недействительна, поскольку удаление одного символа не приводит
     * к одинаковой частоте символов. */
	public static String isValid(String s){
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i=0; i< s.length(); i++){
			String sym = s.substring(i, i+1);
			if (dictionary.keySet().contains(sym)){
				int old = dictionary.get(sym);
				dictionary.replace(sym, old, old+1);
			}
			else{
				dictionary.put(sym, 1);
			}
		}
		int count = 0;
		int sum = 0;
		int mis = 0;
		String ans = "YES";
		for (int value: dictionary.values()){
			if (count != 0 && Math.abs(sum / count - value) > 1 ){
				ans = "NO";
				break;
			}
			sum+= value;
			count++;
			if ( (double) sum/ count != sum / count){
				mis++;
				sum -= value;
				count--;
				if (mis > 1){
					ans = "NO";
					break;
				}
			}
		}
		return ans;
	}

    /**Создайте функцию, которая получает каждую пару чисел из массива, который
     * суммирует до восьми, и возвращает его как массив пар (отсортированный по
     * возрастанию).  */
    public static List<List<Integer>> sumsUp(int[] input) {
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (j != i && (input[i] + input[j]) == 8) {
                    List<Integer> pair = new ArrayList<>(List.of(input[i], 8 - input[i]));
                    pair.sort(Integer::compare);
                    pairs.add(pair);
                }
            }
        }

        Collections.reverse(pairs);
        return pairs;
    }
}
