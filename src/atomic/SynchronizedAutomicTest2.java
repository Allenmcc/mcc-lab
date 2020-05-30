package atomic;

import java.util.ArrayList;
import java.util.Objects;

public class SynchronizedAutomicTest2 {


    private static int number = 0;

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (object) {
                        number++;
                    }
                }
            }
        };
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Thread t = new Thread(increment);
            t.start();
            ts.add(t);
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println("number=" + number);
    }

}
