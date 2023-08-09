import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

import  java.lang.Thread.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main2 {
    public static void fetch(int index, String filePath) {
        try {
            System.out.println("Entering : "+index+" "+ Thread.currentThread());
            var count= Files.lines(Paths.get(filePath)).count();
            System.out.println(count);
            System.out.println("Exiting : "+index+" "+ Thread.currentThread());
        }  catch (Exception e) {
            System.out.println(e);
            System.out.println("Catch : "+index+" "+ Thread.currentThread());
        }finally {
            System.out.println("Finally : "+index+" "+ Thread.currentThread());
        }
    }

    public static void main(String[] args)  {

        int MAX = 5;
        for (int i = 0; i < MAX; i++) {
           int index=i;
             Thread.startVirtualThread(
                   ()->fetch(index,"C:\\Dev\\Workspace\\JavaVirtualThreads\\src\\Main.java"));
        }
        System.out.println("Done");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}