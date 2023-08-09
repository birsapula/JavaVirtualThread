import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.currentThread;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void doWork() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)  {
        int MAX = 100_0000;
        for (int i = 0; i < MAX; i++) {
            //new Thread(Main::doWork).start();
           Thread.startVirtualThread(Main::doWork);
        }
        System.out.println("DOne");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}