import org.w3c.dom.ls.LSOutput;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.sql.SQLOutput;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.currentThread;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    public static void doWork() {

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)  {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available CPU cores: " + availableProcessors);
        int MAX = 100_000;
        for (int i = 0; i < MAX; i++) {
            //new Thread(Main::doWork).start();
            //Thread.ofVirtual().start(Main::doWork);
            Thread.ofPlatform().start(Main::doWork);
            //System.out.println(">> i -- "+i%500);
            if(i%500==0){
            Thread.ofVirtual().start(Main::checkCPUInfo);
            }
        }

        System.out.println("Wiat for all Done");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DONE");

    }
public static void checkCPUInfo(){


    // Get the number of live threads and peak thread count
    int liveThreads = threadMXBean.getThreadCount();
    int peakThreads = threadMXBean.getPeakThreadCount();

    System.out.println("Number of live threads: " + liveThreads);
    System.out.println("Peak thread count: " + peakThreads);


}

}
