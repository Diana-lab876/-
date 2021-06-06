import java.util.*;
import java.time.*;
public class five_level {
    public static void main(String[] args){
        //System.out.println(sameLetterPattern("ABABC", "CDCDC"));
        //System.out.println(spiderVsFly("H1", "F3") );
        //System.out.println(digitsCount(1289396387328L));
        String[] a1 = {"cat", "create", "sat"};
        System.out.println(totalPoints(a1,"caster"));
        //int[] q1 = {1, 2, 3, 5, 6, 7, 8, 9};
        //System.out.println(longestRun(q1));
        //String[] s1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        //System.out.println(takeDownAverage(s1));
        //System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        //System.out.println(maxPossible(523, 76));
        //System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        //System.out.println(isNew(3));
    }
    /**Создайте функцию, которая возвращает true, если две строки имеют один и тот же
     * буквенный шаблон, и false в противном случае. */
    public static boolean sameLetterPattern(String str1, String str2) {
        if( str1.length()!=str2.length())
			return false;
		int dif = str1.charAt(0)-str2.charAt(0);
		for (int i=0;i<str1.length();++i) {
			if(str1.charAt(i)-str2.charAt(i)!=dif)
				return false;
		}
		return true;
    }
    /** Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и
     * радиалами, помеченными по часовой стрелке сверху как A-H.
     * Создайте функцию, которая принимает координаты паука и мухи и возвращает
     * кратчайший путь для паука, чтобы добраться до мухи.
     * Стоит отметить, что кратчайший путь должен быть рассчитан "геометрически", а не путем
     * подсчета количества точек, через которые проходит этот путь. Мы могли бы это устроить:
     * Угол между каждой парой радиалов одинаков (45 градусов).
     * Расстояние между каждой парой колец всегда одинаково (скажем, "x"). */
	public static String spiderVsFly(String str1, String str2) {
        number2 spider = new number2(str1.charAt(0),Integer.parseInt(Character.toString(str1.charAt(1))));
        number2 fly = new number2(str2.charAt(0),Integer.parseInt(Character.toString(str2.charAt(1))));
        number2.result=spider.getLetter()+Integer.toString(spider.getLevel());//изначаьные значения координат паучка
        int distance=spider.getDistanceAndDir(fly)[0],dir=spider.getDistanceAndDir(fly)[1];
        if(spider.getLevel()==0)
            spider.setLetter(fly.getLetterChar());
        if(fly.getLevel()==0)
            fly.setLetter(spider.getLetterChar());
        if(spider.getLevel()> fly.getLevel() || distance > 2) { //h4 b3
            while(spider.getLevel()>fly.getLevel()) {//пока не окажутся на другом уровне
                spider.changeLevel(-1);
            }
            if(distance>2) {
                while(spider.getLevel()!=0) {
                    if(spider.getLevel()==1)
                        spider.setLetter('A');
                    spider.changeLevel(-1);
                }
                spider.setLetter(fly.getLetterChar());
                while(spider.getLevel()!=fly.getLevel()) {
                    spider.changeLevel(1);
                }
            }else {
                while(spider.getLetterChar()!=fly.getLetterChar()) {//находим нужный результат
                    spider.changeLetter(dir);
                }
            }
        }
        else {
            while(spider.getLetterChar()!=fly.getLetterChar()) {
                spider.changeLetter(dir);
            }
            while(spider.getLevel()!=fly.getLevel()) {
                spider.changeLevel(1);
            }
        }
        return number2.result;
    }

    /**Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
     * числа. Преобразование числа в строку не допускается, поэтому подход является
     * рекурсивным.*/
    public static int digitsCount(Object num){
        int count = 0;
        if (num instanceof Integer){
            int number = (int) num;
            do {
                count++;
                number /= 10;
            } while (number > 0);
        }
        else if (num instanceof Long){
            long number = (long) num;
            do {
                count++;
                number /= 10;
            } while (number > 0);
        }
        else{
            System.out.println("This is not a integer type");
        }
        
        return count;
    }

    /*** В игроки пытаются набрать очки, формируя слова, используя буквы из 6-
     * буквенного скремблированного слова. Они выигрывают раунд, если им удается
     * успешно расшифровать слово из 6 букв.
     * Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
     * буквенное слово и возвращает общее количество очков, набранных игроком в
     * определенном раунде, используя следующую рубрику:
     * 3-буквенные слова-это 1 очко
     * 4-буквенные слова-это 2 очка
     * 5-буквенные слова-это 3 очка
     * 6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
     * Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
     * буквенных расшифрованных слов) считаются 0 очками. */ 
	public static int totalPoints (String[] words, String rightWord) {
        int points = 0;
        for (String word: words){//от 0 до words.size
            boolean isRight = true;
            String wordForTest = rightWord;
            for (int i=0; i < word.length(); i++){
                String chr = Character.toString(word.charAt(i));
                if (wordForTest.contains(chr)){
                    wordForTest = wordForTest.replace(chr, "");
                }
                else{
                    isRight = false;
                    break;
                }
            }
            if (isRight){
                points += word.length() - 2;
                if (word.length() == 6){
                    points += 50;
                }
            }
        }

        return points;
    }

    /** Последовательный прогон-это список соседних последовательных целых чисел.
     * Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
     * функцию, которая принимает массив чисел и возвращает длину самого длинного
     * последовательного запуска. */
    public static int longestRun(int[] arr){
		int current=1, longest=1;
		for (int i=1;i<arr.length;i++) {
			if(arr[i]-1==arr[i-1] || arr[i]+1==arr[i-1]) {
				current++;
			}
			else {
				if(current>longest)
					longest=current;
				current =1;
			}
		}
		if(current>longest)
			longest=current;
		return longest;
	}

    /** Какой процент вы можете набрать на тесте, который в одиночку снижает средний
     * балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
     * функцию, которая возвращает ответ. Округлите до ближайшего процента. */
    public static String takeDownAverage(String[] percents) {
        int sum = 0;
        for (int i = 0; i < percents.length; i ++) {
            int rate = Integer.parseInt(percents[i].substring(0,percents[i].length()-1));
            sum +=rate;
        }
        double avg = sum / (double) percents.length;
        double newAvg = avg - 5;
        return Integer.toString((int) Math.round(newAvg * (percents.length + 1) - sum))+"%";
    }

    /**Учитывая предложение с числами, представляющими расположение слова,
     * встроенного в каждое слово, верните отсортированное предложение. */
    public static String rearrange(String s){
        String[] words = s.split(" ");
        String[] result = new String[words.length];
        for (String word: words){
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++){
                if ('0'<chars[i] && chars[i] <'9') {
                    int index = Integer.parseInt(Character.toString(chars[i]));
                    chars[i] = ' ';
                    String newWord = new String(chars);
                    result[index - 1] = newWord.replace(" ", "");
                }
            }
        }
        return String.join(" ", result);
    }

    /** Напишите функцию, которая делает первое число как можно больше, меняя его
     * цифры на цифры во втором числе. */
    public static int maxPossible(int a, int b){
        String firstNum = Integer.toString(a);
        int[] firstNumbers = new int[firstNum.length()];
        for (int i=0; i <firstNum.length(); i++){
            firstNumbers[i] = Integer.parseInt(firstNum.substring(i, i+1));
        }

        String secondNum = Integer.toString(b);
        int[] secondNumbers = new int[secondNum.length()];
        for (int i=0; i <secondNum.length(); i++){
            secondNumbers[i] = Integer.parseInt(secondNum.substring(i, i+1));
        }
        Arrays.sort(secondNumbers);
        String result = "";
        int i = 0;
        while (i < firstNumbers.length){
            if (firstNumbers[i] < secondNumbers[secondNumbers.length - 1]){
                result += Integer.toString(secondNumbers[secondNumbers.length - 1]);
                secondNumbers[secondNumbers.length - 1] = 0;
                Arrays.sort(secondNumbers);
            }              
            else
                result += Integer.toString(firstNumbers[i]);
            i++;
        }
        return Integer.parseInt(result);
    }

    /** В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух
     * разных городах. Вам дается строка cityA и связанная с ней строка timestamp (time
     * in cityA) с датой, отформатированной в полной нотации США */
    public static String timeDifference(String name1,String time1, String name2) {
		String[] arr = time1.split(" ");
		String mon="";
		if(arr[0].equals("December"))
			mon="12";
		if(arr[0].equals("November"))
			mon="11";
		if(arr[0].equals("October"))
			mon="10";
		if(arr[0].equals("September"))
			mon="9";
		if(arr[0].equals("August"))
			mon="8";
		if(arr[0].equals("July"))
			mon="7";
		if(arr[0].equals("June"))
			mon="6";
		if(arr[0].equals("May")) 
			mon="5";
		if(arr[0].equals("April"))
			mon="4";
		if(arr[0].equals("March")) 
			mon="3";
		if(arr[0].equals("February"))
			mon="2";
		if(arr[0].equals("Jenuary"))
			mon="1";
		String days =arr[1].substring(0,arr[1].length()-1);
		if(mon.length()==1)
			mon="0"+mon;
		if(days.length()==1)
			days="0"+days;
		String timezone="";
		int h=0,m=0;
		switch (name2) {
		case "Los Angeles":{
			timezone="-08:00";
			h=-8;
			break;
		}
		case "New York":{
			timezone="-05:00";
			h=-5;
			break;
		}
		case "Caracas":{
			timezone="-04:30";
			h=-4;
			m=-30;
			break;
		}
		case "Buenos Aires":{
			h=-3;
			timezone="-03:00";
			break;
		}
		case "London":{
			timezone="+00:00";
			break;
		}
		case "Rome":{
			h=1;
			timezone="+01:00";
			break;
		}
		case "Moscow":{
			
			h=3;
			timezone="+03:00";
			break;
		}
		case "Tehran":{
			h=3;
			m=30;
			timezone="+03:30";
			break;
		}
		case "New Delphi":{
			h=5;
			m=30;
			timezone="+05:30";
			break;
		}
		case "Beijing":{
			h=8;
			timezone="+08:00";
			break;
		}
		case "Canberra":{
			h=10;
			timezone="+10:00";
			break;
		}
		}
		switch (name1) {
		case "Los Angeles":{
			timezone="-08:00";
			h+=8;
			break;
		}
		case "New York":{
			h+=5;
		
			timezone="-05:00";
			break;
		}
		case "Caracas":{
			timezone="-04:30";
			h+=4;
			m+=30;
			break;
			
		}
		case "Buenos Aires":{
			timezone="-03:00";
			h+=3;
			break;
		}
		case "London":{
			timezone="+00:00";
			break;
		}
		case "Rome":{
			timezone="+01:00";
			h-=1;
			break;
		}
		case "Moscow":{
			timezone="+03:00";
			h-=3;
			break;
		}
		case "Tehran":{
			h-=3;
			m-=30;
			timezone="+03:30";
			break;
		}
		case "New Delphi":{
			timezone="+05:30";
			h-=5;
			m-=30;
			break;
		}
		case "Beijing":{
			h-=8;
			timezone="+08:00";
			break;
		}
		case "Canberra":{
			timezone="+10:00";
			h-=10;
			break;
		}
	}
	ZonedDateTime big_time = ZonedDateTime.parse(arr[2]+"-"+mon+"-"+days+"T"+arr[3]+timezone);
        int totalMin=h*60+m;
        if(totalMin<0){
            big_time=big_time.minusMinutes(-totalMin);
		}
        else{
            big_time=big_time.plusMinutes(totalMin);
		}
        String pre_result = big_time.toString();
        pre_result = pre_result.substring(0,10)+' '+pre_result.substring(11, 16);
        return pre_result;
}

    /** Новое число-это число, которое не является перестановкой любого меньшего
     * числа. 869-это не новое число, потому что это просто перестановка меньших чисел,
     * 689 и 698. 509-это новое число, потому что оно не может быть образовано
     * перестановкой любого меньшего числа (ведущие нули не допускаются).
     * Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
     * если целое число является новым числом, и false, если это не так.*/
    public static boolean isNew(int number) {
		String str= Integer.toString(number);
		int pos=0;
		for (int i=1;i<str.length();i++) {
			if(str.charAt(i)!='0') {
				pos=i;
				break;
			}
		}
		for (int i=0;i<str.length();i++) {
			for (int j=i;j<str.length();j++) {
				if(j>=pos  && str.charAt(j)<str.charAt(i))
					return false;
			}
		}
		return true;
	}
    
}
class number2 {
    private char letter;
    private int level;
    public static String result;

    public number2 (char letter, int level){
        this.letter = letter;
        this.level = level;
    }

    @Override
    public String toString(){
        return Character.toString(letter)+Integer.toString(level);
    }

    public String getLetter() {
        return Character.toString(letter);
    }
    public char getLetterChar() {
        return letter;
    }
    public int getLevel() {
        return level;
    }

    public void changeLetter(int dir) {
        letter+=dir;
        if(letter-'A'>7)
            letter-=8;
        if(letter-'A'<0)
            letter+=8;
        result+="-"+this.toString();//добавляем следующие буквы
    }

    public void setLetter(char ch) {
        if (ch<='H' && ch>='A') {
            letter=ch;
        }
    }

    public void changeLevel(int fromTo) {// -1 in    1 out
        level+=fromTo;
        result+="-"+this.toString();
    }

    public int[] getDistanceAndDir(number2 dot) {
        int distance=this.getLetterChar()-dot.getLetterChar() ,dir;//вычисляется расстояние
        if(distance>0) {
            if(distance<=4) {
                dir = -1;
            }
            else {
                dir = 1;
                distance=8-distance;
            }
        }
        else {
            if(-distance<=4) {
                distance*=-1;
                dir =1;
            }
            else {
                dir=-1;
                distance = distance+8;
            }
        }
        return new int[] {distance,dir};
    }
}
