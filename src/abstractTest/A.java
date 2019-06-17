package abstractTest;

/**
 * Created by chunchen.meng on 2018/5/29.
 */
public class A {

    public static void main(String[] args) {
        B aa = new B("test") {
            @Override
            public void play() {
                System.out.print("B play method");
            }
        };

        aa.play();

        new B("test1") {
            @Override
            public void play() {
                System.out.print("B play method12");
            }
        }.play();

    }

}
