package proxy.staProxy;

/**
 * Created by chunchen.meng on 2019/3/15.
 */
public class ProxyTest {
    public static void main(String[] args) {
//        Flyable flyable =  new Bird();
//        Bird flyable =  new Bird();
//        Bird3 bird = new Bird3(flyable);
//        long start = System.currentTimeMillis();
//        bird.fly();
//        long end = System.currentTimeMillis();
//        System.out.println("Fly time = " + (end - start));



        Bird bird = new Bird();
        BirdTimeProxy p2 = new BirdTimeProxy(bird);
        BirdLogProxy p1 = new BirdLogProxy(p2);

        p1.fly();


    }
}
