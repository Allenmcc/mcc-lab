package proxy.staProxy;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class Bird3 implements Flyable {
    private Bird bird;
//    private Flyable bird;

    public Bird3(Bird bird) {
        this.bird = bird;
    }

//    public Bird3(Flyable bird) {
//        this.bird = bird;
//    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();

        bird.fly();

        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }

}
