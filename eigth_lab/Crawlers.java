import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Crawlers {
// https://www.nytimes.com
// https://apache.org/
// http://htmlbook.ru/
// http://text-twist2.com 
// https://lk.rt.ru/
    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите ссылку:");
        String firstUrl = scaner.nextLine();
        System.out.println("Введите глубину поиска больше 1:");
        String maxDepthS = scaner.nextLine();
        System.out.println("Введите количество потоков от 1 до 100:");
        String threadsS = scaner.nextLine();
        scaner.close();
        int numThreads;
        int maxDepth;
        try {
            maxDepth = Integer.parseInt(maxDepthS);

        } catch (Exception e) {
            System.out.println("Глубина должна быть числом");
            return;
        }

        if (maxDepth <= 0 || maxDepth > 10) {
            System.out.println("Глубина должна быть от 1 до 100");
            return;
        }

        try {
            numThreads = Integer.parseInt(threadsS);

        } catch (Exception e) {
            System.out.println("Потоки должны быть числом");
            return;
        }

        if (numThreads <= 0 || numThreads > 100) {
            System.out.println("Количество потоков должно быть от 1 до 100");
            System.out.println("Потоки установлены на 50");
            numThreads = 50;
        }
        if (maxDepth < 3){
            numThreads = 10;
        }

        URLPool mainPool = new URLPool(maxDepth);
        LinkedList <Thread> allThreads = new LinkedList<Thread>();;
        URLDepthPair urlDepthPair = new URLDepthPair(firstUrl, 0);
        mainPool.put(urlDepthPair);
        mainPool.putInSeenList(firstUrl);
        
        int initialActive = Thread.activeCount(); //количество активынх потоков
        int dopTime = 0;
        while(mainPool.getWaitThreads() != numThreads && dopTime < 300) {
            int threadCount = Thread.activeCount();
            if (threadCount - initialActive < numThreads) {
                    dopTime = 0;
                    newCrawlers crawler = new newCrawlers(mainPool);
                    allThreads.add(crawler);
                    crawler.start();
            }
            else {
                try {
                    Thread.sleep(100);  // 0.1 second
                    dopTime++;
                }
                catch (InterruptedException ie) {
                    System.out.println("Caught unexpected " +"InterruptedException, ignoring...");
                }

            }

        } 
        mainPool.writeAllIndexed();
        for(Thread thread: allThreads){
            try{
                thread.interrupt();
            }
            catch(Exception e){
                System.out.println("Caught unexpected " + "InterruptedException, ignoring...");
            }
        }
    }

}
