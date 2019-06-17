package proxy.staProxy;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class BirdLogProxy implements Flyable {

    private Flyable flyable;

    public BirdLogProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Log Bird fly start...");

        flyable.fly();

        System.out.println("Log Bird fly end...");
    }

}
