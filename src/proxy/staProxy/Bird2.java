package proxy.staProxy;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class Bird2 extends Bird {
    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        super.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }

}
