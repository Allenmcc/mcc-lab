package proxy.staProxy;

import java.util.Random;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
