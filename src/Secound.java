import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.lang.System.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Secound {
    public static void main (String[] args) throws InterruptedException {

        int rows = 0;
        ArrayList<MyThread> threads = new ArrayList<MyThread>();
        String [] lul = {"1.txt","2.txt","3.txt"};
        long timeBefore = System.currentTimeMillis();
        for(int i = 0;i<3;i++)
        {
            threads.add(new MyThread(lul[i]));
            threads.get(i).start();
        }
        for(int i = 0;i<3;i++)
        {
           threads.get(i).join();
        }
        long timeAfter= System.currentTimeMillis();
        long time = (timeAfter -  timeBefore);
        System.out.println("Time :" + time);
    }
}


