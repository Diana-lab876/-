import java.util.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
// https://www.nytimes.com
// https://apache.org/
// http://htmlbook.ru/
// http://text-twist2.com 
// https://lk.rt.ru/
public class Crawler2 {
    public static final String URL_PROTOCOL = "http://";
    public static final String URL_PREFIX = "href=\"";
    public static final String END_URL = "\"";
    

    public static void main(String[] args) throws IOException {

        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите ссылку:");
        String firstUrl = scaner.nextLine();
        System.out.println("Введите глубину поиска от 1 до 1000");
        int maxDepth = 0;
        try {
            maxDepth = Integer.parseInt(scaner.nextLine());
            scaner.close();

        } catch (Exception e) {
            scaner.close();
            writeMessage("Невверное значение глубины поиска");
            return;
        }
        if (maxDepth <= 0) {
            writeMessage("Глубина должна быть > 0");
            return;
        }

        LinkedList<URLDepthPair> indexingSites = new LinkedList<URLDepthPair>(); //индексация сайтов
        LinkedList<URLDepthPair> remainingSites = new LinkedList<URLDepthPair>(); //оставшиеся
        LinkedList<String> urls = new LinkedList<String>();
        String sUrl = URL_PROTOCOL + firstUrl;

        URLDepthPair pairF = new URLDepthPair(sUrl, 0);
        Socket socket = new Socket();
        try{
            socket = new Socket(firstUrl, 80); // создает новый сокет из полученной строки с именем хоста и из целого числа с номером порта, и устанавливает соединение
            socket.setSoTimeout(2000);
            PrintWriter myWriter = new PrintWriter(socket.getOutputStream(), true); //Этот метод позволяет сокету отправлять данные на другую сторонусоединения.
            myWriter.println("GET " + pairF.getUrl() + " HTTP/1.1");
            myWriter.println("Host: " + pairF.getWebHost());
            myWriter.println();
        }
        catch (Exception e){
        }
        URLDepthPair urlDepthPair = new URLDepthPair(firstUrl, 0);
        urls.add(firstUrl);
        remainingSites.add(urlDepthPair);
        while (remainingSites.size() != 0) {
            URLDepthPair currentPair = remainingSites.pop();
            remainingSites.remove(currentPair); // используется для удаления элемента из связанного списка из определенной позиции или индекса.
            if (indexingSites.contains(currentPair)) {
                continue;
            }
            if (currentPair.getParseDeep() == maxDepth) {
                continue;
            }

            indexingSites.add(currentPair);
            writeMessage("Глубина " + currentPair.toString() + " сейчас мы находимся на: "
            + indexingSites.indexOf(currentPair) + " из " 
            + Integer.toString(indexingSites.size() + remainingSites.size()));

            LinkedList<URLDepthPair> newURLDepthPairs = research(currentPair, urls);
            if (!(newURLDepthPairs == null)) {
                for (int i = 0; i < newURLDepthPairs.size(); i++) {
                    URLDepthPair pair = newURLDepthPairs.get(i);
                    if (!remainingSites.contains(pair))
                        remainingSites.add(pair);
                }
            }
        }
                
        socket.close();
        for (int i = 0; i < indexingSites.size(); i++) {
            writeMessage(indexingSites.get(i).getUrl());
        }
        writeMessage("Всего ссылок: " + Integer.toString(indexingSites.size()));
        
    }

    public static void writeMessage(String str) {
        System.out.println(str);
    }

    public static LinkedList<URLDepthPair> research(URLDepthPair currentPair, LinkedList<String> urls) {
        LinkedList<URLDepthPair> newURLDepthPairs = new LinkedList<URLDepthPair>();
        URLConnection connection;
        try {
            connection = new URL(currentPair.getUrl()).openConnection();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return newURLDepthPairs;
        }
        Scanner scanner;
        try {
            scanner = new Scanner(connection.getInputStream());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return newURLDepthPairs;
        }
        
            scanner.useDelimiter("\\Z");
            String line = "";
            if (scanner.hasNext()){
                line = scanner.next();
            }
            scanner.close();
            int startIndex = 0;
            int endIndex = 0;
            while (true){
                startIndex = line.indexOf(URL_PREFIX, endIndex);
                endIndex = line.indexOf(END_URL, startIndex + URL_PREFIX.length());
                if (startIndex == -1 || endIndex == -1){
                    break;
                }
                if (endIndex - startIndex > 200){
                    String temp = line.substring(startIndex, startIndex+URL_PREFIX.length());
                    line.replaceFirst(temp, "");
                    continue;
                }
                String newLink = line.substring(startIndex + 6, endIndex);
                if (!newLink.contains(URL_PROTOCOL)){
                    continue;
                }
                boolean isBadLink = false;
                for (Object urlEnd: WRONG_URL_ENDS){
                    if (newLink.substring(newLink.length() - 4, newLink.length()).equals(urlEnd)){
                        isBadLink = true;
                        break;
                    }
                    
                }
                if (isBadLink){
                    continue;
                }
                if (urls.contains(newLink)){
                    continue;
                }
                urls.add(newLink);
                URLDepthPair newURLDepthPair = new URLDepthPair(newLink, currentPair.getParseDeep() + 1);
                newURLDepthPairs.add(newURLDepthPair);
            }
            return newURLDepthPairs;
            
        
    }
    public static final String[] WRONG_URL_ENDS = {".apk", ".ogv"};
}