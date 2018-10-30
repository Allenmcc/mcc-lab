package Executor.lock;

/**
 * Created by chunchen.meng on 2018/10/29.
 */
public class Reader extends Thread {
//    private Buffer buff;
    private BufferInterruptibly buff;

    public Reader(BufferInterruptibly buff) {
        this.buff = buff;
    }

    @Override
    public void run() {

//        buff.read();//这里估计会一直阻塞

        try {

            buff.read();//可以收到中断的异常，从而有效退出

        } catch (InterruptedException e) {
            System.out.println("我不读了");
        }

        System.out.println("读结束");

    }
}
