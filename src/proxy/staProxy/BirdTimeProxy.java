package proxy.staProxy;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class BirdTimeProxy implements Flyable {
    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        flyable.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));

    }

}
