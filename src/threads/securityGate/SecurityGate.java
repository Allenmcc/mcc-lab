package threads.securityGate;

/**
 * Created by chunchen.meng on 2019/2/13.
 */
public class SecurityGate {
    private int counter = 0;
    public void enter() {
        int currentCounter = counter;

        //让出当前CPU 时间片，让自己和其他线程竞争
        Thread.yield();
        counter = currentCounter + 1;
    }
    public void exit() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }
    public int getCounter() {
        return counter;
    }
}

